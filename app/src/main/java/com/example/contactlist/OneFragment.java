package com.example.contactlist;

import static com.example.contactlist.MyApplicationClass.s;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;


public class OneFragment extends Fragment implements PassDataAdapterToActivity{

    RecyclerView recyclerViewOneFrag;
    RecyclerViewOneFragAdapter recyclerViewOneFragAdapter;


    static OneFragment oneFragment;
    public static OneFragment getFragment() {

        if (oneFragment == null) {
            oneFragment = new OneFragment();
        }
        return oneFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        Log.e("KKK", "onCreateView is called ");

        recyclerViewOneFrag = view.findViewById(R.id.rvContactListOneFrag);
        recyclerViewOneFrag.setHasFixedSize(true);
        recyclerViewOneFrag.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewOneFragAdapter = new RecyclerViewOneFragAdapter(requireActivity(),new ArrayList<>(), this);
        recyclerViewOneFrag.setAdapter(recyclerViewOneFragAdapter);
        for(int i=0;i<s.size();i++){
            if(s.get(i).isSelected()){
                recyclerViewOneFragAdapter.addItem(s.get(i));
            }
        }
        for(int i=0;i<s.size();i++){
            Log.e("CCC", "INSIDE ONE FRAGMENT OnCreate ");
            Log.e("CCC", "name is "+s.get(i).getName());
            Log.e("CCC", "getNumber is "+s.get(i).getNumber());
            Log.e("CCC", "getImage is "+s.get(i).getImage());
            Log.e("CCC", "isSelected is "+s.get(i).isSelected());
        }
        return view;
    }

    @Override
    public void DataSend(RecyclerViewHomePageData recyclerViewHomePageData, int position) {
        Log.e("TAGX", "DataSend: " + recyclerViewHomePageData.getName());
        if(!recyclerViewHomePageData.isSelected()){
            Log.e("TAGX", "Inside if");
            recyclerViewHomePageData.setImage(R.drawable.star);
            recyclerViewHomePageData.setSelected(true);
        }
        else{
            Log.e("TAGX", "Inside else");
            recyclerViewHomePageData.setImage(R.drawable.unstar);
            recyclerViewHomePageData.setSelected(false);
        }
        recyclerViewOneFragAdapter.notifyItemChanged(position);
        Log.e("TAGX", "the image setted is: " + recyclerViewHomePageData.getImage());
        Log.e("TAGX", "the boolean setted is: " + recyclerViewHomePageData.isSelected());

    }
    @Override
    public void onResume() {
        super.onResume();
        Log.e("KKK", "onResume: is called");
        for(int i=0;i<s.size();i++){
            Log.e("CCC", "INSIDE ONE FRAGMENT onResume ");
            Log.e("CCC", "name is "+s.get(i).getName());
            Log.e("CCC", "getNumber is "+s.get(i).getNumber());
            Log.e("CCC", "getImage is "+s.get(i).getImage());
            Log.e("CCC", "isSelected is "+s.get(i).isSelected());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("KKK", "onPause: is called");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("KKK", "onDetach: is called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("KKK", "onDestroy: is called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("KKK", "onStop: is called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("KKK", "onDestroyView: is called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("KKK", "onStart: ");
    }
}