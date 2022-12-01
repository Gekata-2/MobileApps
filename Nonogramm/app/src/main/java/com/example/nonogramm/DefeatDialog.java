package com.example.nonogramm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DefeatDialog
        extends android.app.DialogFragment {

    private static final String TAG = "DefeatDialog";
    private TextView mActionOk, mActionCancel;
    private Context mContext;

    public DefeatDialog() {
    }

    @SuppressLint("ValidFragment")
    public DefeatDialog(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.defeat_dialog, container, false);


        mActionOk = view.findViewById(R.id.action_ok_def);
        mActionCancel = view.findViewById(R.id.action_cancel_def);


        mActionOk.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getDialog().dismiss();

                        Intent intent = new Intent(mContext, LevelNormal.class);
                        intent.putExtra("new game", true);
                        intent.putExtra("same level", true);

                        mContext.startActivity(intent);

                    }
                });

        mActionCancel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        getDialog().dismiss();
                        Intent intent = new Intent(mContext, MainActivity.class);
                        Levels.currentLevel = null;
                        Levels.currentActivity.finish();
                        mContext.startActivity(intent);

                    }
                });

        return view;
    }


}