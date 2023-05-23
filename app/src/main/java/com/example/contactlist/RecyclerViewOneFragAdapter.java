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

public class RecyclerViewOneFragAdapter extends RecyclerView.Adapter<RecyclerViewOneFragAdapter.ViewHolder> {

    Context context;
    ArrayList<RecyclerViewHomePageData> recyclerViewHomePageData;

    PassDataAdapterToActivity passDataAdapterToActivity;

    public RecyclerViewOneFragAdapter(Context context, ArrayList<RecyclerViewHomePageData> recyclerViewHomePageData, PassDataAdapterToActivity passDataAdapterToActivity) {
        this.context = context;
        this.recyclerViewHomePageData = recyclerViewHomePageData;
        this.passDataAdapterToActivity = passDataAdapterToActivity;
    }

    @NonNull
    @Override
    public RecyclerViewOneFragAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewOneFragAdapter.ViewHolder holder, int position) {
        RecyclerViewHomePageData r = recyclerViewHomePageData.get(position);

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
        return recyclerViewHomePageData.size();
    }


    public void addItem(RecyclerViewHomePageData r) {
        recyclerViewHomePageData.add(r);
        int index = recyclerViewHomePageData.indexOf(r);
        int length = recyclerViewHomePageData.size();
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
