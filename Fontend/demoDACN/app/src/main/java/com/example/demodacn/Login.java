package com.example.demodacn;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.demodacn.api.AccountApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    private EditText txtEmail, txtPassword;
    private Button btnLogin, btnSignup;
    List<Account> mList;
    Account mAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnRegister);
        mList = new ArrayList<>();
        getListAccounts();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickLogin();
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Signup.class);
                startActivity(intent);
            }
        });
    }

    private void clickLogin() {
        String email = txtEmail.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();

        if (mList == null || mList.isEmpty()) {
            Toast.makeText(Login.this, "Không có tài khoản nào trong danh sách!", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isHasAccount = false;
        for (Account account : mList){
            if(email.equals(account.getEmail()) && password.equals(account.getPassword())){
                isHasAccount = true;
                mAccount = account;
                break;
            }
        }
        if (isHasAccount == true){
            Intent intent = new Intent(Login.this, MainActivity.class);

            startActivity(intent);
        }else {
            Toast.makeText(Login.this,"Sai thông tin !",Toast.LENGTH_SHORT).show();
        }
    }

    private void getListAccounts(){
       AccountApi.accountApi.getListAccount()
               .enqueue(new Callback<List<Account>>() {
           @Override
           public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
                mList = response.body();
               Log.e("List Accounts",mList.size()+"");
               Toast.makeText(Login.this,"Lấy dữ liệu thành công !",Toast.LENGTH_SHORT).show();

           }

           @Override
           public void onFailure(Call<List<Account>> call, Throwable t) {
               Toast.makeText(Login.this,"Lấy dữ liệu thất bại !",Toast.LENGTH_SHORT).show();
           }
       });
   }

}