package com.example.nonogramm;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

enum EHintType {
    UPPER,
    LEFT
}

public class HintAdapter extends BaseAdapter {
    public ArrayList<String> hints;

    private Context mContext;

    private EHintType type;

    public HintAdapter(Context c, ArrayList<String> hints, EHintType type) {
        mContext = c;
        this.hints = hints;
        this.type = type;
    }


    @Override
    public int getCount() {
        return hints.size();
    }

    @Override
    public String getItem(int i) {
        return hints.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView hint;
        hint = new TextView(mContext);

        switch (type) {
            case UPPER:
                hint.setBackgroundResource(R.drawable.upper_hint);
                hint.setHeight(10);
                hint.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
                hint.setPadding(1, 1, 1, 5);
                switch (hints.get(i).length()) {
                    case 5:
                        hint.setTextSize(12);
                        break;
                    case 7:
                        hint.setTextSize(11);
                    case 9:
                        hint.setTextSize(10);
                        break;
                    default:
                        hint.setTextSize(15);
                        break;
                }
                break;
            case LEFT:
                hint.setBackgroundResource(R.drawable.left_hint);
                hint.setWidth(100);
                hint.setPadding(1, 1, 12, 1);
                hint.setGravity(Gravity.END | Gravity.CENTER_VERTICAL);
                hint.setMaxLines(1);
                switch (hints.get(i).length()) {
                    case 5:
                        hint.setTextSize(16);
                        break;
                    case 7:
                        hint.setTextSize(15);
                    case 9:
                        hint.setTextSize(14);
                        break;
                    default:
                        hint.setTextSize(17);
                        break;
                }
                break;
            default:
                break;
        }

        hint.setText(
                // hints.get(i).length()+" "+
                hints.get(i));

        hint.setTextColor( Color.parseColor("#FF1178"));

        return hint;
    }
}