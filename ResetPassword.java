package com.priya.caloriesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {
    EditText mNewPassword, mVerifyPassword;
    Button mChangePasswordBtn, mGoBackBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        mNewPassword = findViewById(R.id.NewPassword);
        mVerifyPassword = findViewById(R.id.VerifyPassword);
        mChangePasswordBtn = findViewById(R.id.ChangePasswordBtn);
        mGoBackBtn = findViewById(R.id.GoBackBtn);
        fAuth = FirebaseAuth.getInstance();

        mChangePasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NewPassword = mNewPassword.getText().toString().trim();
                String VerifyPassword = mVerifyPassword.getText().toString().trim();

                if (TextUtils.isEmpty(NewPassword)) {
                    mNewPassword.setError("Email Address is required!");
                    return;
                }

                if (TextUtils.isEmpty(VerifyPassword)) {
                    mVerifyPassword.setError("Password is required!");
                    return;
                }

                if (NewPassword.length() < 5) {
                    mNewPassword.setError("Password must be greater than or equal to 5 characters");
                    return;
                }
                fAuth.signInWithEmailAndPassword(NewPassword, VerifyPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ResetPassword.this, "Logged in Successfully!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(ResetPassword.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        mChangePasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
        mGoBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
    }
}