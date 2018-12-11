package com.example.tarunamakkysatyan.fmcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class AddReq extends AppCompatActivity implements View.OnClickListener{
    Button btn;
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
    }

    @Override
    public void onClick(View view) {
        Intent resultIntent = getIntent();
        //Intent resultIntent = new Intent();
        setResult(RESULT_OK, resultIntent); //status ok akan saya respon dengan data di resultIntent
        finish(); // akhiri aktivity ini dan kembali ke activity sebelumnya
    }
}
