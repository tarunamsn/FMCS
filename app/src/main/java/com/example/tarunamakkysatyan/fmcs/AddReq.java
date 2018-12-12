package com.example.tarunamakkysatyan.fmcs;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class AddReq extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    EditText editAmount, editContent;
    Spinner spinner;
    RadioGroup radioGroup;
    RadioButton radioButton;
    boolean expenses;
//    NotificationManager mNotifyManager;
//
//    private BroadcastReceiver rc = new BroadcastReceiver() {
//        @RequiresApi(api = Build.VERSION_CODES.O)
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            NotificationCompat.Builder mNotifyBuilder;
//            Log.d("receivenot", "run");
//            Log.d("Total : ", ((Integer) ListTransFragment.balance).toString());
//            if (ListTransFragment.balance <= 0) {
//                Toast.makeText(context, "The requirement you entered exceeds the budget you have set.",
//                        Toast.LENGTH_LONG).show();
//
//                NotificationChannel mChannel = new NotificationChannel("idn", "fmcs",
//                        NotificationManager.IMPORTANCE_DEFAULT);
//
//                mNotifyBuilder = new NotificationCompat.Builder(context).setContentTitle("FMCS")
//                        .setContentText("REQUIREMENT EXCEEDS YOUR BUDGET.")
//                        .setSmallIcon(R.drawable.awarning)
//                        .setChannelId("idn");
//                if (SettingFragment.notif == true) {
//                    Notification myNotification = mNotifyBuilder.build();
//                    mNotifyManager.notify(0,  myNotification);
//                    mNotifyManager.createNotificationChannel(mChannel);
//                }
//            }
//        }
//    };

//    @Override
//    protected void onResume() {
//        IntentFilter fl = new IntentFilter();
//        fl.addAction("com.cfsuman.RANDOM_NUMBER_INTENT");
//        registerReceiver(rc, fl);
//        super.onResume();
//    }

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
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton2:
                        expenses = true;
                        spinner.setEnabled(true);
                        break;
                    case R.id.radioButton:
                        expenses = false;
                        spinner.setSelection(3);
                        spinner.setEnabled(false);
                        break;
                }
            }
        });
//        mNotifyManager = (NotificationManager)
//                getSystemService(NOTIFICATION_SERVICE);
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
//        Intent in = new Intent();
//        in.setAction("com.cfsuman.RANDOM_NUMBER_INTENT");
//        in.putExtra("data", "The requirement you entered exceeds the budget you have set.");
//        Log.d("receivenot", "send");
//        sendBroadcast(in);
        Bundle bundle = new Bundle();
        bundle.putString("content", editContent.getText().toString());
        bundle.putString("amount", editAmount.getText().toString());
        bundle.putString("date", date);
        bundle.putString("hour", hour);
        bundle.putString("category",spinner.getSelectedItem().toString());
        bundle.putBoolean("expenses",expenses);
        resultIntent.putExtras(bundle);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}