package com.example.tarunamakkysatyan.fmcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RequirementDetail extends AppCompatActivity implements View.OnClickListener{
    EditText editName, editCategory, editAmount;
    Button btnDelete, btnSave;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.req);
        editName = findViewById(R.id.editName);
        editCategory = findViewById(R.id.editCategory);
        editAmount = findViewById(R.id.editAmount);
        Intent req = getIntent();
        Bundle bundle = req.getExtras();
        editName.setText(bundle.getString("name"));
        editCategory.setText(bundle.getString("category"));
        editAmount.setText(bundle.getString("money"));
        btnDelete=findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);
        btnSave=findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent resultIntent = getIntent();
        Bundle bundle = resultIntent.getExtras();;
        bundle.putString("content",editName.getText().toString());
        bundle.putString("category",editCategory.getText().toString());
        bundle.putString("amount",editAmount.getText().toString());
        Log.d("index : ", ((Integer) bundle.getInt("index")).toString());
        resultIntent.putExtras(bundle);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}