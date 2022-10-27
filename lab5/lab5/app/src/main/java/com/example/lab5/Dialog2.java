package com.example.lab5;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Dialog2
        extends android.app.DialogFragment {


    public OnInputListener mOnInputListener;
    private TextView mActionOk, mActionCancel;
    private Spinner mSpinner;
    private String input;
    private int _position;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.dialog2, container, false);
        mActionCancel
                = view.findViewById(R.id.action_cancel);
        mActionOk = view.findViewById(R.id.action_ok);

//Spinner
        mSpinner = view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.animals));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);


        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                input = (String) parent.getItemAtPosition(position);
                _position = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        mSpinner.setOnItemSelectedListener(itemSelectedListener);
//

        mActionCancel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        getDialog().dismiss();
                    }
                });

        mActionOk.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mOnInputListener.sendInput(input, _position);
                        getDialog().dismiss();
                    }
                });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mOnInputListener
                = (OnInputListener) getActivity();

    }

    public interface OnInputListener {
        void sendInput(String input, int pos);
    }
}
