package com.example.npkapp;

import static com.example.npkapp.HomeActivity.getResId;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.npkapp.detail.DetailActivity;
import com.example.npkapp.utils.FirebaseConnection;


public class AlphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alph);

        // init connection
        FirebaseConnection.getInstance().initAlphabetValues();
        for (int i = 0; i < 38; i++){
            int btnId = getResId("btnAlph"+ i, R.id.class);

            if(btnId == -1){
                break;
            }
            Button btnTemp = findViewById(btnId);
            int btnIndex = i;
            btnTemp.setOnClickListener(view -> {
                Intent intent = new Intent(AlphActivity.this, DetailActivity.class);

                intent.putExtra("btnIndex", btnIndex);
                intent.putExtra("typeDetail", "alph");
                startActivity(intent);
            });
        }
    }
}