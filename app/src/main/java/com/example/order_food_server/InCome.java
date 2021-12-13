package com.example.order_food_server;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.order_food_server.Common.Common;

public class InCome extends AppCompatActivity {

    EditText edtDate_Income;
    Button btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_come);

        edtDate_Income  = (EditText) findViewById(R.id.edtDate_Income);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = edtDate_Income.getText().toString();
                Intent intent = new Intent(InCome.this, IncomeDetail.class);
                intent.putExtra(Common.DATETIME, date);
                startActivity(intent);
            }
        });
    }
}