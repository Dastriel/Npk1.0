package com.example.npkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.lang.reflect.Field;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void alph_btn(View view) {
        Intent intent = new Intent(HomeActivity.this, AlphActivity.class);
        startActivity(intent);
    }

    public void num_btn(View view) {
        Intent intent = new Intent(HomeActivity.this, NumsActivity.class);
        startActivity(intent);
    }

    public void case_btn(View view) {
        Intent intent = new Intent(HomeActivity.this, CaseActivity.class);
        startActivity(intent);
    }

    public void diff_btn(View view) {
        Intent intent = new Intent(HomeActivity.this, DiffActivity.class);
        startActivity(intent);
    }

    public static int getResId(String resName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            return -1;
        }
    }
}