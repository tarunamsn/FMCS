package com.example.tarunamakkysatyan.fmcs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

public class Warning extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.warning);
        DisplayMetrics pop = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(pop);
        int w = pop.widthPixels;
        int h = pop.heightPixels;
        getWindow().setLayout((int)(w*.6), (int)(h*.5));
    }
}
