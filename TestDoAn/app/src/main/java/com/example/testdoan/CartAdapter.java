package com.example.testdoan;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private final ArrayList<String> cartItems; // Danh sách sản phẩm trong giỏ hàng

    public CartAdapter(ArrayList<String> cartItems) {
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout cho từng item trong RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        // Gán dữ liệu vào các thành phần giao diện của item
        String item = cartItems.get(position);
        holder.tvProductName.setText(item);

        // Xử lý sự kiện khi nhấn nút "Xóa"
        holder.btnDelete.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Xóa: " + item, Toast.LENGTH_SHORT).show();
            cartItems.remove(position);
            notifyItemRemoved(position);
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    // ViewHolder cho từng item trong RecyclerView
    public static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView tvProductName;
        Button btnDelete;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}

