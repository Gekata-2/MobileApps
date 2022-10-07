package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    boolean buttonPressed = false;
    boolean switcherOn = false;
    int counter = 0;

    private DatePicker mDatePicker;
    private TextView mInfoDateTextView;


    private TimePicker mTimePicker;
    private TextView mInfoTimeTextView;

    private Spinner spinner;
    private TextView mInfoSpinnerTextView;

    private SeekBar seekBar;
    private TextView mInfoSeekbarTextView;
    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            mInfoSeekbarTextView.setText(String.valueOf(progress));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //---------Date Picker---------//
        mInfoDateTextView = (TextView) findViewById(R.id.date_txt);
        mDatePicker = (DatePicker) findViewById(R.id.date_picker);

        Calendar today = Calendar.getInstance();

        mDatePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

                    @Override
                    public void onDateChanged(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                        mInfoDateTextView.setText(
                                year + "."
                                        + ((monthOfYear + 1) > 9 ? String.valueOf(monthOfYear + 1) : "0" + String.valueOf(monthOfYear + 1)) + "."
                                        + ((dayOfMonth) > 9 ? String.valueOf(dayOfMonth) : "0" + String.valueOf(dayOfMonth))
                        );
                    }
                });
        int curYear = mDatePicker.getYear();
        int curMonth = mDatePicker.getMonth();
        int curDay = mDatePicker.getDayOfMonth();
        mInfoDateTextView.setText(
                curYear + "."
                        + ((curMonth + 1) > 9 ? String.valueOf(curMonth + 1) : "0" + String.valueOf(curMonth + 1)) + "."
                        + ((curDay) > 9 ? String.valueOf(curDay) : "0" + String.valueOf(curDay))
        );
        //---------Time Picker---------//
        mInfoTimeTextView = findViewById(R.id.time_txt);
        mTimePicker = findViewById(R.id.timePicker);

        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                mInfoTimeTextView.setText(
                        (hourOfDay > 9 ? String.valueOf(hourOfDay) : "0" + String.valueOf(hourOfDay)) + ":"
                                + ((minute) > 9 ? String.valueOf(minute) : "0" + String.valueOf(minute))

                );
            }
        });
        int curHour = mTimePicker.getHour();
        int curMinute = mTimePicker.getMinute();
        mInfoTimeTextView.setText(
                (curHour > 9 ? String.valueOf(curHour) : "0" + String.valueOf(curHour)) + ":"
                        + ((curMinute) > 9 ? String.valueOf(curMinute) : "0" + String.valueOf(curMinute)));

        //---------Spinner---------//
        spinner = findViewById(R.id.spinner);
        mInfoSpinnerTextView = (TextView) findViewById(R.id.spinner_txt);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.animals));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                mInfoSpinnerTextView.setText(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);

        seekBar = findViewById(R.id.seekBar);
        mInfoSeekbarTextView = findViewById(R.id.seekbar_txt);
        seekBar.setOnSeekBarChangeListener(seekBarChangeListener);

    }

    public void NextActivity(View v) {
        startActivity(new Intent(this, Activity2.class));
    }

    public void onButtonPressed(View v) {
        TextView txt = findViewById(R.id.button_pressed_txt);
        if (!buttonPressed) {
            v.setBackground(getDrawable(R.drawable.button_back_pressed));
            buttonPressed = true;
            txt.setText("Нажата");
        } else {
            v.setBackground(getDrawable(R.drawable.button_back_not_pressed));
            buttonPressed = false;
            txt.setText("Отпущена");
        }
    }

    public void onSwitcherPressed(View v) {
        if (!switcherOn) {
            switcherOn = true;
            ((Switch) v).setText("Включен");
        } else {
            switcherOn = false;
            ((Switch) v).setText("Выключен");
        }
    }

    public void onButtonCounterPressed(View v) {
        ((Button) v).setText((String.valueOf(++counter)));
    }

}