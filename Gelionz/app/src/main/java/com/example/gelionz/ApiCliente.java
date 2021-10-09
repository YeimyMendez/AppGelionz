package com.example.gelionz;

import com.example.gelionz.interfaces.ApiService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCliente {

    private static Retrofit getRetrofit(){
        HttpLoggingInterceptor HttpLoggingInterceptor = new HttpLoggingInterceptor();
        HttpLoggingInterceptor.setLevel(okhttp3.logging.HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gelionz.herokuapp.com/webservices/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    public  static ApiService getUserService(){
        ApiService ApiService = getRetrofit().create(ApiService.class);

        return ApiService;
    }
}
