package com.example.contactlist;


import static com.example.contactlist.MyApplicationClass.s;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewHomePage;
    RecyclerViewHomePageAdapter recyclerViewHomePageAdapter;
    EditText edName, edNumber;

    Button addButton, nextPage;
    String a;
    String b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerViewHomePage = findViewById(R.id.rvContactList);
        edName = findViewById(R.id.edName);
        edNumber = findViewById(R.id.edNumber);

        recyclerViewHomePage.setHasFixedSize(true);
        recyclerViewHomePage.setLayoutManager(new LinearLayoutManager(this));
        for(int i=0;i<s.size();i++){
            Log.e("CCC", "INSIDE FIRST ACTIVITY "+s.get(i).getName());
            Log.e("CCC", "name is "+s.get(i).getName());
            Log.e("CCC", "getNumber is "+s.get(i).getNumber());
            Log.e("CCC", "getImage is "+s.get(i).getImage());
            Log.e("CCC", "isSelected is "+s.get(i).isSelected());
        }

        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(view -> {
            a = edName.getText().toString();
            b = edNumber.getText().toString();
            ArrayList<String> n = new ArrayList<>();
            ArrayList<String> m = new ArrayList<>();
            for (int i=0;i<s.size();i++){
                n.add(s.get(i).getName());
                m.add(s.get(i).getNumber());
            }
            if(n.contains(a) && m.contains(b)){
                Toast.makeText(this, "Contact already exists", Toast.LENGTH_SHORT).show();
            }
            else{
                s.add(new RecyclerViewHomePageData(a,b,R.drawable.unstar,false));
                recyclerViewHomePageAdapter.notifyItemInserted(s.size() - 1);  //this is the main thing
            }

        });


        recyclerViewHomePageAdapter = new RecyclerViewHomePageAdapter(this, s);
        recyclerViewHomePage.setAdapter(recyclerViewHomePageAdapter);


        //nextPage
        nextPage = findViewById(R.id.nextPage);
        nextPage.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("key1", a);
            intent.putExtra("key2",b);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        Log.e("BRO", "onResume: "  );
        super.onResume();
        recyclerViewHomePageAdapter = new RecyclerViewHomePageAdapter(this, s);
        recyclerViewHomePage.setAdapter(recyclerViewHomePageAdapter);
        for(int i=0;i<s.size();i++) {
            Log.e("CCC", "INSIDE TWO FRAGMENT onResume ");
            Log.e("CCC", "name is " + s.get(i).getName());
            Log.e("CCC", "getNumber is " + s.get(i).getNumber());
            Log.e("CCC", "getImage is " + s.get(i).getImage());
            Log.e("CCC", "isSelected is " + s.get(i).isSelected());
        }
    }

    @Override
    protected void onRestart() {
        Log.e("BRO", "onRestart: "  );
        super.onRestart();
    }

    @Override
    protected void onPause() {
        Log.e("BRO", "onPause: "  );
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e("BRO", "onStop: "  );
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("BRO", "onDestroy: "  );
    }
}