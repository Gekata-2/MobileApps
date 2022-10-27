package com.example.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Activity3 extends AppCompatActivity implements Dialog2.OnInputListener {

    final int MENU_1 = 1;
    final int MENU_2 = 2;
    final int MENU_3 = 3;
    public String mInput;
    public int mID;
    private Toolbar mToolbar;
    private TextView mToolbarText;
    private TextView mTextList;
    private TextView mTextID;
    private Button mOpenDialog;

    @Override
    public void sendInput(String input, int pos) {

        mInput = input;
        mID = pos;

        setInputToTextView();
    }

    private void setInputToTextView() {
        mTextList.setText(mInput);
        mTextID.setText(String.valueOf(mID));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        mToolbarText = findViewById(R.id.text_toolbar);

        mToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(mToolbar);

        mTextList = findViewById(R.id.text_list_dialog);
        mTextID = findViewById(R.id.text_id);
        mOpenDialog = findViewById(R.id.open_dialog);
        mOpenDialog.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Dialog2 dialog
                                = new Dialog2();
                        dialog.show(getFragmentManager(),
                                "MyCustomDialog");
                    }
                });

        registerForContextMenu(findViewById(R.id.context_menu));

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0, MENU_1, 0, "ABOBA");
        menu.add(0, MENU_2, 0, "AMOGUS");
        menu.add(0, MENU_3, 0, "1000-7");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        mTextList.setText(item.getTitle().toString());
        mTextID.setText(String.valueOf(item.getItemId()));
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        mToolbarText.setText(item.getTitle());

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);

        mToolbar.setTitle("Hi!");
        return true;
    }

    public void NextActivity(View v) {
        startActivity(new Intent(this, Activity3.class));
    }

    public void PrevActivity(View v) {
        startActivity(new Intent(this, Activity2.class));
    }
}