package com.a07_user_interface;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class PageStack extends AppCompatActivity {
    public static TextView pageStackExpand;
    public static TextView pageStackReduced;
    public static TextView Number;
    static TabsPagerAdapter adapter;
    static int added = 0;
    static int deleted = 0;
    static int counter = 0;
    TabLayout tabs;
    ViewPager2 viewpager;
    TextView check;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_stack);

        tabs = findViewById(R.id.tabLayout);
        viewpager = findViewById(R.id.tabs_viewpager);
        adapter = new TabsPagerAdapter(getSupportFragmentManager(), getLifecycle(), 1);
        viewpager.setAdapter(adapter);
        viewpager.setUserInputEnabled(true);

        new TabLayoutMediator(tabs, viewpager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Base");
                    break;
                default:
                    tab.setText("[" + String.valueOf(position) + "]");
                    break;
            }
        }
        ).attach();
    }

    public void addPage(View view) {
        TabLayout.Tab tab = tabs.newTab();
        tab.setText("Tab");
        tabs.addTab(tab, false);
        adapter.setNumberOfTabs(adapter.getItemCount() + 1);
        pageStackExpand.setText("Pages Added: " + Integer.toString(++added));
        adapter.notifyDataSetChanged();
    }

    public void deletePage(View view) {
        if (tabs.getTabCount() > 1) {
            tabs.removeTab(tabs.getTabAt(1));
            adapter.setNumberOfTabs(adapter.getItemCount() - 1);
            pageStackReduced.setText("Pages Deleted: " + Integer.toString(++deleted));
            adapter.notifyDataSetChanged();
        }
    }

    public void PrevActivity(View v) {
        startActivity(new Intent(this, Sekundomer.class));
    }

//    public void previousPage(View view) {
//        Intent intent = new Intent(PageStack.this, Stopwatch.class);
//        startActivity(intent);
//    }

    public static class MainFragment extends Fragment {
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_main, container, false);
            pageStackExpand = v.findViewById(R.id.PageStackExpand);
            pageStackReduced = v.findViewById(R.id.PageStackReduced);
            return v;
        }

    }

    public static class PageFragment extends Fragment {
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.blank_fragment, container, false);
            Number = v.findViewById(R.id.Number);
//            Number.setText("Tab " + Integer.toString(++counter));
            Number.setText("༼ つ ◕_◕ ༽つ");
            return v;
        }
    }

    class TabsPagerAdapter extends FragmentStateAdapter {
        public int numberOfTabs;
        FragmentManager fm;
        Lifecycle lifecycle;

        public TabsPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle _lifecycle, int n) {
            super(fragmentManager, _lifecycle);
            fm = fragmentManager;
            lifecycle = _lifecycle;
            numberOfTabs = n;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0: {
                    Bundle bundle = new Bundle();
                    bundle.putString("fragmentName", "Music Fragment");
                    MainFragment newFragment = new MainFragment();
                    newFragment.setArguments(bundle);
                    return newFragment;
                }
                case 1: {
                    Bundle bundle = new Bundle();
                    bundle.putString("fragmentName", "Movies Fragment");
                    PageFragment newFragment = new PageFragment();
                    newFragment.setArguments(bundle);
                    return newFragment;
                }
                default:
                    return new PageFragment();
            }
        }

        @Override
        public int getItemCount() {
            return numberOfTabs;
        }

        public void setNumberOfTabs(int numberOfTabs) {
            this.numberOfTabs = numberOfTabs;
        }
    }

}