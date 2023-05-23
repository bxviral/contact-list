package com.example.contactlist;


import static com.example.contactlist.MyApplicationClass.s;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class TwoFragment extends Fragment implements PassDataAdapterToActivity {

    static TwoFragment twoFragment;

    public static TwoFragment getFragment() {

        if (twoFragment == null) {
            twoFragment = new TwoFragment();
        }
        return twoFragment;
    }

    RecyclerView recyclerViewOneFrag;
    RecyclerViewTwoFragmentAdapter recyclerViewTwoFragAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        recyclerViewOneFrag = view.findViewById(R.id.rvContactListTwoFrag);
        recyclerViewOneFrag.setHasFixedSize(true);
        recyclerViewOneFrag.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerViewTwoFragAdapter = new RecyclerViewTwoFragmentAdapter(getContext(), new ArrayList<>(), this);//static class ka object banaya
        recyclerViewOneFrag.setAdapter(recyclerViewTwoFragAdapter);
        for (int i = 0; i < s.size(); i++) {
            if (!s.get(i).isSelected()) {
                Log.e("BRO", "the name of the object in TWO FRAGMENT IS " + s.get(i).getName() + s.get(i).getNumber());
                recyclerViewTwoFragAdapter.addItem(s.get(i));
            }
        }
        for (int i = 0; i < s.size(); i++) {
            Log.e("CCC", "INSIDE TWO FRAGMENT onResume ");
            Log.e("CCC", "name is " + s.get(i).getName());
            Log.e("CCC", "getNumber is " + s.get(i).getNumber());
            Log.e("CCC", "getImage is " + s.get(i).getImage());
            Log.e("CCC", "isSelected is " + s.get(i).isSelected());
        }
        return view;
    }

    @Override
    public void DataSend(RecyclerViewHomePageData recyclerViewHomePageData, int position) {
        Log.e("TAGX", "DataSend in Two Fragment: " + recyclerViewHomePageData.getName());
        if (!recyclerViewHomePageData.isSelected()) {
            Log.e("TAGX", "Inside if");
            recyclerViewHomePageData.setImage(R.drawable.star);
            recyclerViewHomePageData.setSelected(true);
        } else {
            Log.e("TAGX", "Inside else");
            recyclerViewHomePageData.setImage(R.drawable.unstar);
            recyclerViewHomePageData.setSelected(false);
        }
        recyclerViewTwoFragAdapter.notifyItemChanged(position);
        Log.e("TAGX", "the image setted is: " + recyclerViewHomePageData.getImage());
        Log.e("TAGX", "the boolean setted is: " + recyclerViewHomePageData.isSelected());

    }

    @Override
    public void onResume() {
        super.onResume();

        for (int i = 0; i < s.size(); i++) {
            Log.e("CCC", "INSIDE TWO FRAGMENT onResume ");
            Log.e("CCC", "name is " + s.get(i).getName());
            Log.e("CCC", "getNumber is " + s.get(i).getNumber());
            Log.e("CCC", "getImage is " + s.get(i).getImage());
            Log.e("CCC", "isSelected is " + s.get(i).isSelected());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("KKK", "onPause:of two frag is called");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("KKK", "onDetach:of two frag is called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("KKK", "onDestroy:of two frag is called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("KKK", "onStop:of two frag is called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("KKK", "onDestroyView:of two frag is called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("KKK", "onStart:of two frag ");
    }
}