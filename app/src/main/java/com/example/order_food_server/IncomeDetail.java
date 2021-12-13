package com.example.order_food_server;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.example.order_food_server.Common.Common;
import com.example.order_food_server.Model.Request;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class IncomeDetail extends AppCompatActivity {

    String date = "";

    BarChart barChart;
    DatabaseReference mData;

    int totalMaxDate = 0;
    ArrayList<BarEntry> visitors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_detail);

        barChart = (BarChart) findViewById(R.id.BarChart);

        if(getIntent() != null) {
            date = getIntent().getStringExtra(Common.DATETIME);
        }




        Toast.makeText(this, "total: "+totalMaxDate, Toast.LENGTH_SHORT).show();



        mData = FirebaseDatabase.getInstance().getReference();
        mData.child("Requests").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Request request = snapshot.getValue(Request.class);
                float f = Float.parseFloat(request.getTotal().trim());
               if(request.getDate().equals(date)) {

                   // totalMaxDate += f;
                   Toast.makeText(IncomeDetail.this, "totalMaxDate: "+totalMaxDate, Toast.LENGTH_SHORT).show();

               }
                visitors.add(new BarEntry(100,f));

                BarDataSet barDataSet = new BarDataSet(visitors, "Visitors");
                barDataSet.setColor(Color.RED);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(16f);

                BarData barData = new BarData(barDataSet);
                barChart.setFitBars(true);
                barChart.setData(barData);
                barChart.getDescription().setText("Income");
                barChart.animateY(2000);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }
}