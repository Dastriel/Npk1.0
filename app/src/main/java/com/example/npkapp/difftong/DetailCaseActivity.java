package com.example.npkapp.difftong;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.npkapp.utils.CircularViewPagerHandler;
import com.example.npkapp.R;

import java.util.Objects;

public class DetailCaseActivity extends AppCompatActivity {
    ViewPager2 viewPager;
    String detailType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        int btnIndex = -1;
        if (extras != null) {
            btnIndex = extras.getInt("btnIndex");
            detailType = extras.getString("typeDetail");
        }

        FragmentManager manager = getSupportFragmentManager();
        DetailCaseAdapter detailAdapter = new DetailCaseAdapter(this, manager, getLifecycle());
        viewPager = findViewById(R.id.detailPager);
        viewPager.setAdapter(detailAdapter);
        viewPager.registerOnPageChangeCallback(new CircularViewPagerHandler(viewPager));

        if(btnIndex != -1){
            viewPager.setCurrentItem(btnIndex);
        }
    }

    public String getDetailType(){
        return detailType;
    }
    public int getItemTypeCount(){
        if(Objects.equals(detailType, "case")){
            return 8;
        }
        if(Objects.equals(detailType, "diff")){
            return 4;
        }
        return 0;
    }
}