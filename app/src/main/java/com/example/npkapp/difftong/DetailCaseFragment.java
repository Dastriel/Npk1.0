package com.example.npkapp.difftong;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.npkapp.R;

import java.util.ArrayList;

public class DetailCaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_diff, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        LinearLayout linearLayout = view.findViewById(R.id.llDetailDiff);
        TextView tvTitle = view.findViewById(R.id.tvDetailDiffTitle);

        Bundle args = getArguments();
        if (args != null) {

            String title = args.getString("title");
            ArrayList<String> content = args.getStringArrayList("content");
            tvTitle.setText(title);

            Log.d("npkapp", content.toString());
            content.forEach(text -> {
                TextView tv = getTextView(text);
                linearLayout.addView(tv);
            });
        }
    }

    private TextView getTextView(String text){
        TextView tv = new TextView(getActivity());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,0,0,16);
        tv.setLayoutParams(params);

        tv.setShadowLayer(8, 1, 4, Color.parseColor("#7F000000"));
        tv.setTextColor(Color.parseColor("#FFFFFF"));

        tv.setTextSize(24f);
        tv.setTypeface(null, Typeface.BOLD);
        tv.setText(text);
        return tv;
    }

}
