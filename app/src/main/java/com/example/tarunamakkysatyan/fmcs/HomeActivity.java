package com.example.tarunamakkysatyan.fmcs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ArrayList<Transaction> TransactionList= new ArrayList<>();
        TransactionList.add(new Transaction("Fried Rice","Food & Drink","21 February","22:59",true,16000));
        TransactionList.add(new Transaction("Ultra Milk","Food & Drink","21 February","23:00",true,6000));
        TransactionList.add(new Transaction("Gym","Health","22 February","12:00",true, 15000));
        TransactionList.add(new Transaction("Pizza","Food & Drink","22 February","15:00",true,40000));
        TransactionList.add(new Transaction("Train to Surabaya","Transportation","22 February","18:00",true,20000));
        TransactionList.add(new Transaction("Earphone","Other","22 February","18:01",true,140000));
        mRecyclerView = findViewById(R.id.RecyclerView);
        mAdapter = new TransactionAdapter(this, TransactionList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
