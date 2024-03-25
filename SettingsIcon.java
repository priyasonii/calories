package com.priya.caloriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingsIcon extends AppCompatActivity {
    TextView mSettings;
    ImageView mBackButton, mprofile;
    Button mAboutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_icon);
        mSettings = findViewById(R.id.Settings);
        mBackButton = findViewById(R.id.BackButton);
        mprofile = findViewById(R.id.profile);
        mAboutBtn = findViewById(R.id.AboutBtn);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        mAboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), About.class));
            }
        });
    }
}