package com.example.order_food_server.ViewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.order_food_server.Interface.ItemClickListener;
import com.example.order_food_server.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ShipperViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView shipper_name,  shipper_phone;
    public Button btn_edit, btn_remove;
    private ItemClickListener itemClickListener;

    public ShipperViewHolder(@NonNull View itemView) {
        super(itemView);
        shipper_name = (TextView) itemView.findViewById(R.id.shipper_name);
        shipper_phone = (TextView) itemView.findViewById(R.id.shipper_phone);

        btn_edit = (Button) itemView.findViewById(R.id.btnEdit_Shipper);
        btn_remove = (Button) itemView.findViewById(R.id.btnRemove_Shipper);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);
    }
}
