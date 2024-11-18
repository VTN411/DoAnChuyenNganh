package com.example.testdoan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    ImageButton imbBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        RecyclerView recyclerView = findViewById(R.id.rvCartItems);
        Button btnCheckout = findViewById(R.id.btnCheckout);

        // Thiết lập RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CartAdapter(getCartItems()));

        // Xử lý sự kiện thanh toán
        btnCheckout.setOnClickListener(v -> {
            // TODO: Chuyển sang màn hình thanh toán
        });
        imbBack = findViewById(R.id.imbBack);
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this, MainActivity.class));
            }
        });
    }

    private ArrayList<String> getCartItems() {
        ArrayList<String> items = new ArrayList<>();
        items.add("Sản phẩm 1");
        items.add("Sản phẩm 2");
        items.add("Sản phẩm 3");
        return items;
    }
}