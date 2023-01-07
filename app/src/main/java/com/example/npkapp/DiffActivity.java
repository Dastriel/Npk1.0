package com.example.npkapp;

import static com.example.npkapp.HomeActivity.getResId;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.npkapp.difftong.DetailCaseActivity;
import com.example.npkapp.utils.FirebaseConnection;

public class DiffActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diff);

        FirebaseConnection.getInstance().initDiffValues();
        for (int i = 0; i < 4; i++){
            int btnId = getResId("btnDiff"+ i, R.id.class);

            if(btnId == -1){
                break;
            }
            Button btnTemp = findViewById(btnId);
            int btnIndex = i;
            btnTemp.setOnClickListener(view -> {
                Intent intent = new Intent(DiffActivity.this, DetailCaseActivity.class);

                intent.putExtra("btnIndex", btnIndex);
                intent.putExtra("typeDetail", "diff");
                startActivity(intent);
            });
        }
    }
}