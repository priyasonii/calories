package com.priya.caloriesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 25;
    ImageButton mSettingsBtn, mAboutMeBtn, mGalleryBtn;
    ImageView mPicture;
    Button mLogoutBtn, mCameraBtn;
    TextView mtextView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSettingsBtn = findViewById(R.id.SettingsBtn);
        mAboutMeBtn = findViewById(R.id.AboutMeBtn);
        mGalleryBtn = findViewById(R.id.GalleryBtn);
        mPicture = findViewById(R.id.Picture);
        mLogoutBtn = findViewById(R.id.LogoutBtn);
        mtextView8 = findViewById(R.id.textView8);
        mCameraBtn = findViewById(R.id.CameraBtn);

        mCameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, REQUEST_CODE);
            }
        });
        mPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Calories.class));
            }
        });
        mSettingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SettingsIcon.class));
            }
        });
        mAboutMeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AboutMeIcon.class));
            }
        });
    }
        @Override
        protected void onActivityResult ( int requestCode, int resultCode, @NonNull Intent data){
            if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                mPicture.setImageBitmap(photo);
            } else {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
                super.onActivityResult(requestCode, resultCode, data);
            }
        }

        public void logout (View v){
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), Login.class));
            finish();
        }
    }
