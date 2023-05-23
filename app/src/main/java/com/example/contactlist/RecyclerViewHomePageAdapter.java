package com.example.contactlist;


import static com.example.contactlist.MyApplicationClass.s;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewHomePageAdapter extends RecyclerView.Adapter<RecyclerViewHomePageAdapter.ViewHolder> {

    Context context;
    ArrayList<RecyclerViewHomePageData> recyclerViewHomePageData;
    String name1="",number1="";

    public RecyclerViewHomePageAdapter(Context context, ArrayList<RecyclerViewHomePageData> recyclerViewHomePageData) {
        this.context = context;
        this.recyclerViewHomePageData = recyclerViewHomePageData;
    }

    @NonNull
    @Override
    public RecyclerViewHomePageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHomePageAdapter.ViewHolder holder, int position) {
        RecyclerViewHomePageData r = recyclerViewHomePageData.get(position);
        int index = holder.getAdapterPosition();
        holder.txtName.setText(r.getName());
        holder.txtNumber.setText(r.getNumber());

        if(r.isSelected){
            Log.e("BRO", "onBindViewHolder: inside if 1" );
            holder.imgStudent.setImageResource(R.drawable.star);

        }
        else{
            Log.e("BRO", "onBindViewHolder: inside else 1" );
            holder.imgStudent.setImageResource(R.drawable.unstar);
        }

            holder.imgStudent.setOnClickListener(view -> {
                if(!r.isSelected){
                    holder.imgStudent.setImageResource(R.drawable.star);
                    s.get(index).setSelected(true);
                    notifyItemChanged(index);
                    s.get(index).setImage(R.drawable.star);
                    Log.e("VVV", "FIRST ADAPTER: "+s.get(index).getImage());
                }
                else{
                    Log.e("BRO", "onBindViewHolder: inside onclick else " );
                    holder.imgStudent.setImageResource(R.drawable.unstar);
                    s.get(index).setSelected(false);
                    s.get(index).setImage(R.drawable.unstar);
                }
            });

        holder.cardView.setOnClickListener(view -> {
            Dialog dialog = new Dialog(context,android.R.style.Theme_Black_NoTitleBar_Fullscreen);
            dialog.setContentView(R.layout.custom_dailog_box);
            Button ok = dialog.findViewById(R.id.ok);

            EditText edName = dialog.findViewById(R.id.edNameChange);
            EditText edNumber = dialog.findViewById(R.id.edNumberChange);

            edName.setText(s.get(index).getName());
            edNumber.setText(s.get(index).getNumber());

            ok.setOnClickListener(v -> {
                name1 = String.valueOf(edName.getText());
                number1 = String.valueOf(edNumber.getText());
                Log.e("TAG", "onClick1: " + name1);
                Log.e("TAG", "onClick2: " + number1);
                s.get(index).setName(name1);
                Log.e("TAG", "Changed: " + s.get(index).getName());
                s.get(index).setNumber(number1);
                Log.e("TAG", "Changed: " + s.get(index).getNumber());
                notifyItemChanged(index);
                dialog.dismiss();
            });
            dialog.show();
        });
        holder.cardView.setOnLongClickListener(view -> {
            Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.custom_dailog_box_delete);

            Button yes = dialog.findViewById(R.id.YES);
            Button no = dialog.findViewById(R.id.NO);

            yes.setOnClickListener(view1 -> {
                s.remove(index);
                notifyItemRemoved(index);
                dialog.dismiss();
            });
            no.setOnClickListener(view12 -> dialog.dismiss());
            dialog.show();
            return true;
        });


    }

    @Override
    public int getItemCount() {
        return recyclerViewHomePageData.size();
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
