package com.alenave.airplaneseating;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alenave.airplaneseating.activity.SeatDisplay;
import com.alenave.airplaneseating.model.Bay;
import com.alenave.airplaneseating.util.InputFilterMinMax;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextView.OnEditorActionListener {
    private Button submit;
    private EditText numberOfBays;
    private EditText numberOfColumns;
    private EditText numberOfRows;
    private TextView bayMessage;

    private int bayCounter = 0;
    public static List<Bay> bays = new ArrayList<>();
    private Bay bay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewAndSetListeners();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit:
                onClickSubmit();
                break;
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            submit.performClick();
            return true;
        }
        return false;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        bays.clear();
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    private void initViewAndSetListeners() {
        numberOfRows = (EditText) findViewById(R.id.bay_row);
        numberOfColumns = (EditText) findViewById(R.id.bay_column);
        numberOfBays = (EditText) findViewById(R.id.number_of_bays);
        numberOfBays.setFilters(new InputFilter[]{new InputFilterMinMax(2, 4)});
        bayMessage = (TextView) findViewById(R.id.bay_message);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);
        numberOfColumns.setOnEditorActionListener(this);
    }


    private void onClickSubmit() {
        if (!numberOfBays.getText().toString().equals("") && !numberOfRows.getText().toString().equals("") && !numberOfColumns.getText().toString().equals("")) {
            if (bayCounter < Integer.valueOf(numberOfBays.getText().toString())) {
                bayDetails();
                if (++bayCounter == Integer.valueOf(numberOfBays.getText().toString())) {
                    Intent intent = new Intent(this, SeatDisplay.class);
                    startActivity(intent);
                } else {
                    numberOfRows.setText("");
                    numberOfColumns.setText("");
                    numberOfRows.requestFocus();
                    bayMessage.setText("enter size of bay " + (bayCounter + 1));
                }
            }
        } else {
            Toast.makeText(getApplicationContext(), "Enter number of bays", Toast.LENGTH_SHORT).show();
        }
    }

    private void bayDetails() {
        bay = new Bay();
        if (!numberOfRows.getText().toString().equals("") && !numberOfColumns.getText().toString().equals("")) {
            bay.setRow(Integer.valueOf(numberOfRows.getText().toString()));
            bay.setColumn(Integer.valueOf(numberOfColumns.getText().toString()));
            bays.add(bay);
        } else {
            Toast.makeText(getApplicationContext(), "Please enter bay values", Toast.LENGTH_SHORT).show();
        }
    }
}
