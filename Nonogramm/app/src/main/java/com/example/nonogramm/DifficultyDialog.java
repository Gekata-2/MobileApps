package com.example.nonogramm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DifficultyDialog
        extends android.app.DialogFragment {

    private static final String TAG = "DefeatDialog";
    private TextView mNormal, mEasy;
    private Context mContext;

    public DifficultyDialog() {
    }

    @SuppressLint("ValidFragment")
    public DifficultyDialog(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.difficulty_dialog, container, false);


        mNormal = view.findViewById(R.id.diff_normal);
        mEasy = view.findViewById(R.id.diff_easy);

        mNormal.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getDialog().dismiss();


                        Intent intent = new Intent(mContext, LevelNormal.class);
                        intent.putExtra("new game", true);
                        intent.putExtra("Difficulty", EDifficulty.NORMAL.ordinal());

                        mContext.startActivity(intent);
                    }
                });

        mEasy.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        getDialog().dismiss();
                        Intent intent = new Intent(mContext, LevelNormal.class);
                        intent.putExtra("new game", true);
                        intent.putExtra("Difficulty", EDifficulty.EASY.ordinal());

                        mContext.startActivity(intent);

                    }
                });

        return view;
    }


}