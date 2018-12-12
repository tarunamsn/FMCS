package com.example.tarunamakkysatyan.fmcs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener {
    EditText usernameTxt, passwordTxt;
    Button btnSubmit;
    CheckBox rememberCb;
    SharedPreferences mPreferences;
    String sharedPrefFile = "com.example.android.hellosharedprefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        usernameTxt = findViewById(R.id.usernameTxt);
        passwordTxt = findViewById(R.id.passwordTxt);
        rememberCb = findViewById(R.id.rememberCb);
        if (mPreferences.getBoolean("checked", false)){
            usernameTxt.setText(mPreferences.getString("count",""));
            passwordTxt.setText(mPreferences.getString("count1",""));
            rememberCb.setChecked(true);
        }else{
            usernameTxt.getText().clear();
            usernameTxt.getText().clear();
        }
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
        rememberCb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("a", "onClick: " + usernameTxt.getText().toString() );
        Log.d("b", "onClick: " + passwordTxt.getText().toString() );
        String a = usernameTxt.getText().toString();
        String b = passwordTxt.getText().toString();
        if (v.getId() == R.id.btnSubmit) {
            Log.d("a", "onClick: Clicked" );
            if (a.equalsIgnoreCase("admin") && b.equalsIgnoreCase("admin")) {
                SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                Log.d("b", "onClick: " + usernameTxt.getText().toString());
                mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
                if (rememberCb.isChecked()) {
                    preferencesEditor.putString("count", usernameTxt.getText().toString());
                    preferencesEditor.putString("count1", passwordTxt.getText().toString());
                    preferencesEditor.putBoolean("checked", rememberCb.isChecked());
                    preferencesEditor.commit();
                }else {
                    preferencesEditor.putBoolean("checked", rememberCb.isChecked());
                    preferencesEditor.commit();
                }
                Intent obj = new Intent(this,MainCopy.class);
                startActivity(obj);
            } else  {
                String msg = "Incorrect Password" +
                        "!";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            }
        }
    }
}
