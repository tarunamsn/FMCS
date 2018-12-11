package com.example.tarunamakkysatyan.fmcs;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainCopy extends AppCompatActivity {

    FragmentManager fm;
    BottomNavigationView bottomNavigationView;
    ArrayList<Transaction> TransactionList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_copy);
        bottomNavigationView = findViewById(R.id.btmNavView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        TransactionList.add(new Transaction("Fried Rice","Food & Drink","21 February","22:59",true,16000));
        TransactionList.add(new Transaction("Ultra Milk","Food & Drink","21 February","23:00",true,6000));
        TransactionList.add(new Transaction("Gym","Health","22 February","12:00",true, 15000));
        TransactionList.add(new Transaction("Pizza","Food & Drink","22 February","15:00",true,40000));
        TransactionList.add(new Transaction("Train to Surabaya","Transportation","22 February","18:00",true,20000));
        TransactionList.add(new Transaction("Earphone","Other","22 February","18:01",true,140000));
        loadFragment(ListTransFragment.newInstance(TransactionList,"0"));
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_setting:
                    fragment= SettingFragment.newInstance("0","0");
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_transaction:
                    fragment= ListTransFragment.newInstance(TransactionList,"0");
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try{
            TransactionList.remove(data.getExtras().getInt("index"));
            loadFragment(ListTransFragment.newInstance(TransactionList,"0"));
            Log.d("req code activity : ", ((Integer) requestCode).toString());
        }catch (Exception e){

        }

    }
}
