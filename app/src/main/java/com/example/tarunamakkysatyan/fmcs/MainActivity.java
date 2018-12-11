package com.example.tarunamakkysatyan.fmcs;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    TextView expenses, total,income;
    FloatingActionButton btnAdd;
    Intent a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Transaction> TransactionList= new ArrayList<>();
        TransactionList.add(new Transaction("Fried Rice","Food & Drink","21 February","22:59",true,16000));
        TransactionList.add(new Transaction("Ultra Milk","Food & Drink","21 February","23:00",true,6000));
        TransactionList.add(new Transaction("Gym","Health","22 February","12:00",true, 15000));
        TransactionList.add(new Transaction("Pizza","Food & Drink","22 February","15:00",true,40000));
        TransactionList.add(new Transaction("Train to Surabaya","Transportation","22 February","18:00",true,20000));
        TransactionList.add(new Transaction("Earphone","Other","22 February","18:01",true,140000));
        int a=0;
        for (int i  =0;i<TransactionList.size();i++){
            Transaction temp = TransactionList.get(i);
            a += temp.money;
        }
        expenses = findViewById(R.id.textView5);
        expenses.setText(("Rp. "+ (Integer) a).toString());
        income = findViewById(R.id.textView4);
        income.setText("Rp. 0 ");
        int temp = 0-a;
        total = findViewById(R.id.textView6);
        total.setText(("Rp. "+ (Integer) temp).toString());
        mRecyclerView = findViewById(R.id.RecyclerView);
        mAdapter = new TransactionAdapter(this, TransactionList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent pop = new Intent(this, AddReq.class);
        startActivity(pop);
    }
}
