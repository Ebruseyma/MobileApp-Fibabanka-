package com.example.fibabankaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.fibabankaproject.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final int[] imageId = {R.drawable.avatar1,R.drawable.avatar2,R.drawable.avatar3,R.drawable.avatar4,R.drawable.avatar5,R.drawable.avatar6,R.drawable.avatar7,R.drawable.avatar8};
        final String[] name = {"Eda Yılmaz","Ebru Akboyun","Kaan Gök","Ahmet Koçak","Ezgi Sarı","Bartu Yüncü","Aslı Tanyeri","Zeynep Günay"};
        String[] body = {"asdfghjklşi","sdfghjklşi","merhaba bu benim yazım","merhaba bu benim ikinci yazım","Merhaba bu benim üçüncü yazım","sfdghjklş","sdfghjklşş","gfhjklşkjhgffghjklşkjhg"};
        String[] date = {"12/02/2022","12/02/2022","12/02/2022","12/02/2022","12/02/2022","12/02/2022","12/02/2022","12/02/2022"};
        final String[] phoneNo = {"05079345477","05079345477","05079345477","05079345477","05079345477","05079345477","05079345477","05079345477"};
        final String[] country = {"Turkey","USA","Turkey","USA","Turkey","USA","Turkey","USA"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0; i<imageId.length; i++){

            User user = new User(name[i],body[i],date[i],phoneNo[i],country[i],imageId[i]);
            userArrayList.add(user);
        }

        ListAdapter listAdapter = new ListAdapter(MainActivity.this,userArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this,UserActivity.class);
                i.putExtra( "name", name[position]);
                i.putExtra( "phone", phoneNo[position]);
                i.putExtra( "country", country[position]);
                i.putExtra( "imageId", imageId[position]);

                startActivity(i);

            }
        });
    }

}
