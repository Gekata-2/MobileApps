package com.example.lab5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class CustomPager extends PagerAdapter {

    private Context Mcontext;
    private List<Activity2.Task> tasks;

    public CustomPager(Context Mcontext, List<Activity2.Task> tasks) {
        this.Mcontext = Mcontext;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) Mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sliderLayout = inflater.inflate(R.layout.slider_layout, null);

        TextView date = sliderLayout.findViewById(R.id.text_date_lin);
        TextView description = sliderLayout.findViewById(R.id.text_descr);

        date.setText(tasks.get(position).date);
        description.setText(tasks.get(position).description);

        container.addView(sliderLayout);
        return sliderLayout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}