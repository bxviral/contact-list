package com.example.contactlist;

import static com.example.contactlist.MyApplicationClass.s;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerViewHomePage;
    RecyclerViewHomePageAdapter recyclerViewHomePageAdapter;

    String name,number;
    Button dashBoardActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerViewHomePage = findViewById(R.id.rvContactList);

        Intent intent = getIntent();
        Log.e("TAG", "onCreate: of activity2 before "+name);
        Log.e("TAG", "onCreate: of activity2 before "+number);
        name = intent.getStringExtra("key1");
        number = intent.getStringExtra("key2");
        Log.e("TAG", "onCreate: of activity2 after"+name);
        Log.e("TAG", "onCreate: of activity2 after"+number);
        recyclerViewHomePage.setHasFixedSize(true);
        recyclerViewHomePage.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewHomePageAdapter = new RecyclerViewHomePageAdapter(this,s);//static class ka object
        recyclerViewHomePage.setAdapter(recyclerViewHomePageAdapter);

        dashBoardActivity = findViewById(R.id.dashBoardActivity);
        dashBoardActivity.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity2.this,DashBoardActivity.class);
            startActivity(intent1);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerViewHomePageAdapter = new RecyclerViewHomePageAdapter(this,s);//static class ka object
        recyclerViewHomePage.setAdapter(recyclerViewHomePageAdapter);
    }
}