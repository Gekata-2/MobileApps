package com.example.a06_data_management;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class CheckBoxState extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_state);
        CheckBox checkBox = findViewById(R.id.checkBox);
        View saveLayout = findViewById(R.id.SaveLayout);
        EditText editText = findViewById(R.id.SaveNote);


        boolean[] checked = {PreferenceManager.getDefaultSharedPreferences(this).getBoolean("checkBox", false)};
        checkBox.setChecked(checked[0]);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checked[0] = checkBox.isChecked();
                PreferenceManager.getDefaultSharedPreferences(CheckBoxState.this).edit().putBoolean("checkBox", checked[0]).commit();
            }
        });


        String[] text = {PreferenceManager.getDefaultSharedPreferences(this).getString("editText", "")};
        editText.setText(text[0]);
        saveLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                text[0] = String.valueOf(editText.getText());
                PreferenceManager.getDefaultSharedPreferences(CheckBoxState.this).edit().putString("editText", text[0]).commit();
            }
        });

    }


    public void NextActivity(View v) {
        startActivity(new Intent(this, Login.class));
    }

    public void PrevActivity(View v) {
        startActivity(new Intent(this, NoteList.class));
    }
}
