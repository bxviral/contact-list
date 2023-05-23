package com.example.contactlist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class DashBoardActivity extends AppCompatActivity {

    TabLayout t1;
    ViewPager2 v1;
    MyTabLayoutAdapter myTabLayoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);


        t1 = findViewById(R.id.tabLayoutMain);
        v1 = findViewById(R.id.viewPagerMain);
        myTabLayoutAdapter = new MyTabLayoutAdapter(this);
        v1.setAdapter(myTabLayoutAdapter);

        v1.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Objects.requireNonNull(t1.getTabAt(position)).select();
            }
        });

    }
}