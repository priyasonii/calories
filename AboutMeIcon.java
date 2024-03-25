package com.priya.caloriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutMeIcon extends AppCompatActivity {
    TextView meditTextTextPersonName, mtextView15, mtextView14, mtextView16, mtextView17, mtextView18, mtextView19;
    ImageView mbackArrow;
    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me_icon);

        meditTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        mtextView14 = findViewById(R.id.textView14);
        mtextView15 = findViewById(R.id.textView15);
        mtextView16 = findViewById(R.id.textView16);
        mtextView17 = findViewById(R.id.textView18);
        mtextView18 = findViewById(R.id.textView18);
        mtextView19 = findViewById(R.id.textView19);
        mbackArrow = findViewById(R.id.backArrow);

        Intent data = getIntent();
        String EmailAddress = data.getStringExtra("Email Address");
        String Password = data.getStringExtra("Password");
        String Age = data.getStringExtra("Age");
        String Height = data.getStringExtra("Height");
        String Weight = data.getStringExtra("Weight");
        String Sex = data.getStringExtra("Sex");

        Log.d(TAG, "onCreate:" + EmailAddress + "" + Password + "" + Age + "" + Height + "" + Weight + "" + Sex);

        mbackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });
    }
}
