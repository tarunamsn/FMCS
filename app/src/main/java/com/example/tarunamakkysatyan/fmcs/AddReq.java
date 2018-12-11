package com.example.tarunamakkysatyan.fmcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class AddReq extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    EditText editAmount, editContent;
    Spinner spinner;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addreq);
        DisplayMetrics pop = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(pop);
        int w = pop.widthPixels;
        int h = pop.heightPixels;
        getWindow().setLayout((int)(w*.9), (int)(h*.8));
        btn = findViewById(R.id.buttonSave);
        btn.setOnClickListener(this);
        editAmount = findViewById(R.id.editAmount);
        editContent = findViewById(R.id.editContent);
        spinner = findViewById(R.id.spinner);
    }

    @Override
    public void onClick(View view) {
        Intent resultIntent = getIntent();
        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM");
        String date = format.format(curDate);
        Date curDate1 = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm");
        String hour = format1.format(curDate1);
        Log.d("date :",date);
        Log.d("hour :",hour);
        Bundle bundle = new Bundle();
        bundle.putString("content", editContent.getText().toString());
        bundle.putString("amount", editAmount.getText().toString());
        bundle.putString("date", date);
        bundle.putString("hour", hour);
        bundle.putString("category",spinner.getSelectedItem().toString());
        resultIntent.putExtras(bundle);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}