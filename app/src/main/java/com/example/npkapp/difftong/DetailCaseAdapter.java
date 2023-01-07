package com.example.npkapp.difftong;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.npkapp.data.DetailCase;
import com.example.npkapp.utils.FirebaseConnection;

import java.util.ArrayList;
import java.util.Objects;

public class DetailCaseAdapter extends FragmentStateAdapter {
    private final int typeCount;
    private final String type;
    FirebaseConnection fireCon;

    public DetailCaseAdapter(Context context, @NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        fireCon = FirebaseConnection.getInstance();

        DetailCaseActivity activity = (DetailCaseActivity) context;
        typeCount = activity.getItemTypeCount();
        type = activity.getDetailType();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        DetailCaseFragment fragment = new DetailCaseFragment();
        Bundle args = new Bundle();

        String title = "Err";
        ArrayList<String> content = new ArrayList<>();

        DetailCase obj = getDetailObject(position);
        if(obj != null){
            title = obj.getTitle();
            content = obj.getContent();
        }

        args.putString("title", title);
        args.putStringArrayList("content", content);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return typeCount;
    }

    private DetailCase getDetailObject(int position){
        if(Objects.equals(type, "case")) {
            return fireCon.caseGetByIndex(position);
        }else if(Objects.equals(type, "diff")) {
            return fireCon.diffGetByIndex(position);
        }
        return null;
    }
}
