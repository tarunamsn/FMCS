package com.example.tarunamakkysatyan.fmcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class RequirementDetail extends AppCompatActivity implements View.OnClickListener{
    EditText editName,  editAmount, editType;
    Button btnDelete, btnSave;
    Spinner spinner;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.req);
        editName = findViewById(R.id.editName);
        editAmount = findViewById(R.id.editAmount);
        Intent req = getIntent();
        Bundle bundle = req.getExtras();
        editName.setText(bundle.getString("name"));
        editAmount.setText(bundle.getString("money"));
        btnDelete=findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);
        btnSave=findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        editType= findViewById(R.id.editType);
        spinner = findViewById(R.id.spinner);
        if (bundle.getBoolean("expenses")==true){
            editType.setText("Expenses");
        }else {
            editType.setText("Income");
        }
        for (int i = 0;i<spinner.getAdapter().getCount();i++){
            spinner.setSelection(i);
            if (bundle.getString("category").equalsIgnoreCase(spinner.getSelectedItem().toString())){
                break;
            }
            Log.d("Bundle : ",bundle.getString("category"));
            Log.d("Spinner : ",spinner.getSelectedItem().toString());
        }
    }

    @Override
    public void onClick(View view) {
        boolean delete = true;
        if (view.getId()== R.id.btnDelete){
            delete = true ;
        }else if (view.getId()==R.id.btnSave){
            delete = false ;
        }
        Intent resultIntent = getIntent();
        Bundle bundle = resultIntent.getExtras();
        bundle.putBoolean("button",delete);
        bundle.putString("content",editName.getText().toString());
//        bundle.putString("category",editCategory.getText().toString());
        bundle.putString("amount",editAmount.getText().toString());
        Log.d("index : ", ((Integer) bundle.getInt("index")).toString());
        resultIntent.putExtras(bundle);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}