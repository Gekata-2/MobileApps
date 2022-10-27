package com.example.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Activity2 extends AppCompatActivity {

    ListView listView;
    private List<Task> taskList = new ArrayList<Task>();
    private ViewPager page;
    private TabLayout tabLayout;

    private String getDate(Calendar calendar) {
        return DateUtils.formatDateTime(this,
                calendar.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        //ListView
        listView = findViewById(R.id.list_view);

        Calendar dateAndTime = Calendar.getInstance();

        taskList.add(new Task("task1 haha", getDate(dateAndTime)));

        dateAndTime.set(Calendar.YEAR, 2022);
        dateAndTime.set(Calendar.MONTH, 12);
        dateAndTime.set(Calendar.DAY_OF_MONTH, 12);
        taskList.add(new Task("task2 hihi", getDate(dateAndTime)));

        dateAndTime.set(Calendar.YEAR, 2023);
        dateAndTime.set(Calendar.MONTH, 1);
        dateAndTime.set(Calendar.DAY_OF_MONTH, 26);
        taskList.add(new Task("task3 hoho", getDate(dateAndTime)));

        dateAndTime.set(Calendar.YEAR, 2024);
        dateAndTime.set(Calendar.MONTH, 7);
        dateAndTime.set(Calendar.DAY_OF_MONTH, 15);
        taskList.add(new Task("task4 ABOBA", getDate(dateAndTime)));


        CustomAdapter customAdapter = new CustomAdapter(this, taskList);
        listView.setAdapter(customAdapter);

        //Pager + tab

        page = findViewById(R.id.my_pager);
        tabLayout = findViewById(R.id.my_tablayout);


        CustomPager customPager = new CustomPager(this, taskList);
        page.setAdapter(customPager);
        tabLayout.setupWithViewPager(page, true);

        SetTabsText();

    }

    public void NextActivity(View v) {
        startActivity(new Intent(this, Activity3.class));
    }

    public void PrevActivity(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }

    private void SetTabsText() {
        for (int i = 0; i < taskList.size(); i++) {
            tabLayout.getTabAt(i).setText(String.valueOf(i + 1));
        }
    }

    public class Task {

        String date;
        String description;

        public Task(String description, String date) {
            this.description = description;
            this.date = date;
        }
    }
}