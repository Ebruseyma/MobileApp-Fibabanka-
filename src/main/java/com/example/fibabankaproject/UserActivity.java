package com.example.fibabankaproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fibabankaproject.databinding.ActivityUserBinding;

class UserActivity extends AppCompatActivity {

    ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if(intent != null) {
            String name = intent.getStringExtra("name");
            String phone = intent.getStringExtra("phone");
            String country = intent.getStringExtra("country");
            String body = intent.getStringExtra("body");
            int imageid = intent.getIntExtra("imageid", R.drawable.avatar1);

            binding.nameProfile.setText(name);
            binding.phoneProfile.setText(phone);
            binding.countryProfile.setText(country);
            binding.ProfileImage.setText(imageid);
            binding.ProfileBody.setText(body);
        }
    }
}
