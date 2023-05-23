package com.example.contactlist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewTwoFragmentAdapter extends RecyclerView.Adapter<RecyclerViewTwoFragmentAdapter.ViewHolder> {
    Context context;
    ArrayList<RecyclerViewHomePageData> recyclerViewHomePageData2;

    PassDataAdapterToActivity passDataAdapterToActivity;

    public RecyclerViewTwoFragmentAdapter(Context context, ArrayList<RecyclerViewHomePageData> recyclerViewHomePageData2,PassDataAdapterToActivity passDataAdapterToActivity) {
        this.context = context;
        this.recyclerViewHomePageData2 = recyclerViewHomePageData2;
        this.passDataAdapterToActivity = passDataAdapterToActivity;
    }


    @NonNull
    @Override
    public RecyclerViewTwoFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewTwoFragmentAdapter.ViewHolder holder, int position) {
        RecyclerViewHomePageData r = recyclerViewHomePageData2.get(position);

        holder.txtName.setText(r.getName());
        holder.txtNumber.setText(r.getNumber());
        if (r.isSelected) {
            Log.e("BRO", "the name of the object is in ONCLICK " + r.getName() + r.getNumber());
            holder.imgStudent.setImageResource(R.drawable.star);
        } else {
            Log.e("BRO", "the name of the object is in ONCLICK " + r.getName() + r.getNumber());
            holder.imgStudent.setImageResource(R.drawable.unstar);
        }

        holder.imgStudent.setOnClickListener(view -> passDataAdapterToActivity.DataSend(r, position));

    }

    @Override
    public int getItemCount() {
        return recyclerViewHomePageData2.size();
    }
    public void addItem(RecyclerViewHomePageData r) {
        recyclerViewHomePageData2.add(r);
        int index = recyclerViewHomePageData2.indexOf(r);
        int length = recyclerViewHomePageData2.size();
        Log.e("TAG1", "addItem: index " + index);
        Log.e("TAG1", "addItem: length " + length);
        notifyItemInserted(index);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtNumber;
        ImageView imgStudent;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.name);
            txtNumber = itemView.findViewById(R.id.number);
            imgStudent = itemView.findViewById(R.id.selectionOfStudent);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
