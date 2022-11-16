package com.example.a06_data_management;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;
import com.jaredrummler.android.colorpicker.ColorShape;

public class MainActivity extends AppCompatActivity implements ColorPickerDialogListener {
    private LinearLayout rect_1;
    private LinearLayout rect_2;
    private LinearLayout rect_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rect_1 = findViewById(R.id.Rectangle_1);
        rect_2 = findViewById(R.id.Rectangle_2);
        rect_3 = findViewById(R.id.Rectangle_3);


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
                .setAllowPresets(true)
                .setColorShape(ColorShape.CIRCLE)
                .setDialogId(id)
                .show(this);
    }

    @Override
    public void onColorSelected(int dialogId, int color) {
        switch (dialogId) {
            case R.id.Rectangle_1:
                rect_1.setBackgroundColor(color);
                break;
            case R.id.Rectangle_2:
                rect_2.setBackgroundColor(color);
                break;
            case R.id.Rectangle_3:
                rect_3.setBackgroundColor(color);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dialogId);
        }
    }

    @Override
    public void onDialogDismissed(int dialogId) {
        Toast.makeText(this, "Цвет изменён", Toast.LENGTH_SHORT).show();
    }

    public void NextActivity(View v) {
        startActivity(new Intent(this, SquaresList.class));
    }
}

