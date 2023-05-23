package com.example.contactlist;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyTabLayoutAdapter extends FragmentStateAdapter {
    public MyTabLayoutAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return OneFragment.getFragment();
        } else {
            return TwoFragment.getFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
