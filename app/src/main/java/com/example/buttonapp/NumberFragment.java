package com.example.buttonapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NumberFragment extends Fragment {

    TextView textView;
    int counter = 0;

    // Default Constructor
    public NumberFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display, container, false);
        textView = view.findViewById(R.id.text_view);
        textView.setText(String.valueOf(counter));

        return view;
    }

    public void setCounter(int counter) {
        this.counter = counter;
        textView.setText(String.valueOf(counter));
    }
}
