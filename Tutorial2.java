package com.priya.caloriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tutorial2 extends AppCompatActivity {
    TextView mstep2, mtextView5, mtextView6, mFoodItem, mtextView7, mPortionSize;
    Button mFinishBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial2);
        mstep2 = findViewById(R.id.step2);
        mtextView5 = findViewById(R.id.textView5);
        mtextView6 = findViewById(R.id.textView6);
        mFoodItem = findViewById(R.id.FoodItem);
        mtextView7 = findViewById(R.id.textView7);
        mPortionSize = findViewById(R.id.PortionSize);
        mFinishBtn = findViewById(R.id.FinishBtn);

        mFinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}