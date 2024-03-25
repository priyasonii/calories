package com.priya.caloriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Spinner;

public class Calories extends AppCompatActivity {
    TextView mtextView11, mtextView12;
    EditText mEnterFoodItem;
    Spinner mdropdown;
    Button mDoneBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);
        mtextView11 = findViewById(R.id.textView11);
        mtextView12 = findViewById(R.id.textView12);
        mEnterFoodItem = findViewById(R.id.EnterFoodItem);
        mdropdown = findViewById(R.id.dropdown);
        mDoneBtn = findViewById(R.id.DoneBtn);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.activity_calories_xml, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        mdropdown.setAdapter(adapter);

        mDoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}