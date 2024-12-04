package com.example.demodacn.api;

import com.example.demodacn.Account;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

public interface AccountApi {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    AccountApi accountApi = new Retrofit.Builder().baseUrl("http://10.0.2.2:8000/api/")
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
            .create(AccountApi.class);

    @GET("accounts")
    Call<List<Account>> getListAccount();

    @POST("accounts")
    @FormUrlEncoded
    Call<Account> createAccount(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("accounts/{id}")
    Call<Account> getAccountById(@Path("id") int id);

    @PUT("accounts/{id}")
    @FormUrlEncoded
    Call<Account> updateAccount(
            @Path("id") int id,
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password
    );

    @DELETE("accounts/{id}")
    Call<Void> deleteAccount(@Path("id") int id);
}

