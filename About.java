package com.priya.caloriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class About extends AppCompatActivity {
    TextView mAbout;
    ImageView marrowBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        mAbout = findViewById(R.id.About);
        marrowBackBtn = findViewById(R.id.arrowBackBtn);

        marrowBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SettingsIcon.class));
            }
        });
    }
}
