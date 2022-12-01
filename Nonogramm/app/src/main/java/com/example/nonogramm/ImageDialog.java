package com.example.nonogramm;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageDialog
        extends android.app.DialogFragment {

    private static final String TAG = "DialogFragment";
    private TextView mActionOk;
    private Context mContext;
    private ImageView victoryImage;

    public ImageDialog() {
    }

    @SuppressLint("ValidFragment")
    public ImageDialog(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.image_dialog, container, false);


        mActionOk = view.findViewById(R.id.action_ok);
        victoryImage = view.findViewById(R.id.victoryImage);
        int id = Levels.currentLevel.background_id;
        victoryImage.setImageResource(id);

        Levels.currentLevel = null;
        mActionOk.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d(TAG, "onClick: capturing input");
                        getDialog().dismiss();
                        Intent intent = new Intent(mContext, MainActivity.class);
                        mContext.startActivity(intent);
                        Levels.currentLevel = null;
                        Levels.currentActivity.finish();

                    }
                });

        return view;
    }


}