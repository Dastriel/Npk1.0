package com.example.npkapp.detail;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.npkapp.utils.FirebaseConnection;
import com.example.npkapp.data.Detail;

import java.util.Objects;

public class DetailAdapter extends FragmentStateAdapter {
    private int typeCount;
    private String type;
    FirebaseConnection fireCon;

    public DetailAdapter(Context context, @NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        fireCon = FirebaseConnection.getInstance();

        DetailActivity activity = (DetailActivity) context;
        typeCount = activity.getItemTypeCount();
        type = activity.getDetailType();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new DetailFragment();
        Bundle args = new Bundle();

        // default names
        String name = "Err";
        String type = "Error";

        Detail obj = getDetailObject(position);
        if(obj != null){
            name = obj.getName();
            type = obj.getType();
        }

        args.putString("name", name);
        args.putString("type", type);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return typeCount;
    }

    private Detail getDetailObject(int position){
        if(Objects.equals(type, "alph")) {
            return fireCon.alphGetByIndex(position);
        }else if(Objects.equals(type, "num")) {
            return fireCon.numGetByIndex(position);
        }
        return null;
    }
}
