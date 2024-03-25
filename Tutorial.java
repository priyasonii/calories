package com.priya.caloriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Tutorial extends AppCompatActivity {

    TextView mstep1, mtextView4;
    ImageView mrectanlge, mhand, mNextBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        mstep1 = findViewById(R.id.step1);
        mtextView4 = findViewById(R.id.textView4);
        mhand = findViewById(R.id.hand);
        mrectanlge = findViewById(R.id.rectangle);
        mNextBtn = findViewById(R.id.NextBtn);

        mhand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharesIntent = new Intent(Tutorial.this, Tutorial2.class);
                startActivity(sharesIntent);
            }
        });
        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Tutorial2.class));
            }
        });
    }
}