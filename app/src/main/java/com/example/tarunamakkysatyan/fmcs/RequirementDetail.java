package com.example.tarunamakkysatyan.fmcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class RequirementDetail extends AppCompatActivity {
    EditText editName, editCategory, editAmount;
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
    }
}
