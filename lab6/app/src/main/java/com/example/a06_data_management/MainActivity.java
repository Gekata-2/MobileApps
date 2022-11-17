package com.example.a06_data_management;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;
import com.jaredrummler.android.colorpicker.ColorShape;

public class MainActivity extends AppCompatActivity implements ColorPickerDialogListener {
    private LinearLayout rect_1;
    private LinearLayout rect_2;
    private LinearLayout rect_3;
    private TextView text_1;
    private TextView text_2;
    private TextView text_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rect_1 = findViewById(R.id.Rectangle_1);
        rect_2 = findViewById(R.id.Rectangle_2);
        rect_3 = findViewById(R.id.Rectangle_3);

        text_1 = findViewById(R.id.Rectangle1);
        text_2 = findViewById(R.id.Rectangle2);
        text_3 = findViewById(R.id.Rectangle3);


        rect_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createColorPickerDialog(view.getId());
            }
        });
        rect_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createColorPickerDialog(view.getId());
            }
        });
        rect_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createColorPickerDialog(view.getId());
            }
        });

    }

    private void createColorPickerDialog(int id) {
        ColorPickerDialog.newBuilder()
                .setColor(Color.RED)
                .setDialogType(ColorPickerDialog.TYPE_PRESETS)
                .setAllowCustom(true)
                .setAllowPresets(false)
                .setColorShape(ColorShape.SQUARE)
                .setDialogId(id)
                .show(this);

    }

    private void setBackgroundColor(LinearLayout rect, int colour, TextView text) {
        rect.setBackgroundColor(colour);
        int r = (int) (Color.valueOf(colour).red() * 255);
        int g = (int) (Color.valueOf(colour).green() * 255);
        int b = (int) (Color.valueOf(colour).blue() * 255);
        text.setText("(" + String.valueOf(r) + "," + String.valueOf(g) + "," + String.valueOf(b) + ")");
        text.setTextColor(Color.BLACK);

    }

    @Override
    public void onColorSelected(int dialogId, int color) {
        switch (dialogId) {
            case R.id.Rectangle_1:
                setBackgroundColor(rect_1, color, text_1);
                // rect_1.setBackgroundColor(color);
                Toast.makeText(this, "Цвет изменён", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Rectangle_2:
                setBackgroundColor(rect_2, color, text_2);
                rect_2.setBackgroundColor(color);
                Toast.makeText(this, "Цвет изменён", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Rectangle_3:
                setBackgroundColor(rect_3, color, text_3);
                //rect_3.setBackgroundColor(color);
                Toast.makeText(this, "Цвет изменён", Toast.LENGTH_SHORT).show();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dialogId);
        }
    }

    @Override
    public void onDialogDismissed(int dialogId) {

    }

    public void NextActivity(View v) {
        startActivity(new Intent(this, SquaresList.class));
    }
}

