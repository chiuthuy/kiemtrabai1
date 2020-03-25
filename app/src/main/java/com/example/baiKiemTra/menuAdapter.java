package com.example.baiKiemTra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class menuAdapter extends RecyclerView.Adapter<menuAdapter.ViewHolder> {
    ArrayList<model> models;
    Context context;

    public menuAdapter(ArrayList<model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View itemView=layoutInflater.inflate(R.layout.iteam_row,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTen.setText(models.get(position).getMname());
        holder.txtGia.setText(models.get(position).getMgia());
        holder.image.setImageResource(models.get(position).getMimg());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }
    public void remove(int position){
        models.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTen;
        TextView txtGia;
        ImageView image;
        ImageButton nut;
       public ViewHolder(@NonNull View itemView) {
           super(itemView);
           txtTen=(TextView)itemView.findViewById(R.id.ten);
           txtGia=(TextView)itemView.findViewById(R.id.gia);
           image=(ImageView)itemView.findViewById(R.id.img);
           nut=(ImageButton)itemView.findViewById(R.id.btndot);
           nut.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   //Creating the instance of PopupMenu
                   PopupMenu popup = new PopupMenu(context,nut);
                   //Inflating the Popup using xml file
                   popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                   //registering popup with OnMenuItemClickListener
                   popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                       public boolean onMenuItemClick(MenuItem item) {
                           Toast.makeText(context,"Bạn chọn : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                           return true;
                       }
                   });

                   popup.show();//showing popup menu
               }
           });
       }
   }
}
