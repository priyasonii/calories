package com.priya.caloriesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText mEmailAddress, mPassword, mAge, mHeight, mWeight;
    Button mSignInBtn;
    TextView mAlreadyUserBtn;
    Spinner mSex;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mEmailAddress = findViewById(R.id.EmailAddress);
        mPassword = findViewById(R.id.Password);
        mAge = findViewById(R.id.Age);
        mHeight = findViewById(R.id.Height);
        mWeight = findViewById(R.id.Weight);
        mSignInBtn = findViewById(R.id.SignInBtn);
        mAlreadyUserBtn = findViewById(R.id.AlreadyUserBtn);
        mSex = findViewById(R.id.Sex);

        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.activity_register_xml, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        mSex.setAdapter(adapter);

        mSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String EmailAddress = mEmailAddress.getText().toString().trim();
                String Password = mPassword.getText().toString().trim();
                String Age = mAge.getText().toString().trim();
                if (TextUtils.isEmpty(EmailAddress)) {
                    mEmailAddress.setError("Email Address is required!");
                    return;
                }

                if (TextUtils.isEmpty(Password)) {
                    mPassword.setError("Password is required!");
                    return;
                }

                if (Password.length() < 5) {
                    mPassword.setError("Password must be greater than or equal to 5 characters");
                    return;
                }

                if (TextUtils.isEmpty(Age)){
                    mAge.setError("Age is required!");
                }

                fAuth.createUserWithEmailAndPassword(EmailAddress, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(Register.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        mAlreadyUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
        mSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Tutorial.class));
            }
        });
    }
}
