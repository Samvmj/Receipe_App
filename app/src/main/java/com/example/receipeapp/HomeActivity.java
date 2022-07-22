package com.example.receipeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        CardView Recep1 = findViewById(R.id.recep1);
        CardView Recep2 = findViewById(R.id.recep2);
        CardView Recep3 = findViewById(R.id.recep3);
        CardView Recep4 = findViewById(R.id.recep4);
        CardView Recep5 = findViewById(R.id.recep5);
        CardView Recep6 = findViewById(R.id.recep6);

        Recep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeActivity.this,recep1.class));
            }
        });
        Recep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeActivity.this,recep2.class));
            }
        });
        Recep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeActivity.this,recep3.class));
            }
        });
        Recep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeActivity.this,recep4.class));
            }
        });
        Recep5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeActivity.this,recep5.class));
            }
        });
        Recep6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeActivity.this,recep6.class));
            }
        });
    }
}