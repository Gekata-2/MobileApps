package com.example.lab5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    private List<Activity2.Task> tasks = new ArrayList<Activity2.Task>();

    public CustomAdapter(Context applicationContext, List<Activity2.Task> tasks) {
        this.context = context;
        this.tasks = tasks;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.list_view, null);
        TextView task = view.findViewById(R.id.task_txt);
        TextView date = view.findViewById(R.id.date_txt);

        task.setText(tasks.get(i).description);
        date.setText(tasks.get(i).date);

        return view;
    }
}