package com.example.testdoan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText etEmail = findViewById(R.id.etRegisterEmail);
        EditText etPassword = findViewById(R.id.etRegisterPassword);
        Button btnRegister = findViewById(R.id.btnRegister);

        // Xử lý sự kiện đăng ký
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    // TODO: Lưu thông tin vào cơ sở dữ liệu
                    Toast.makeText(RegisterActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
