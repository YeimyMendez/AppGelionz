package com.example.gelionz.interfaces;

import com.example.gelionz.UserRequest;
import com.example.gelionz.UserResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {



    @POST("usuario/")
    Call<UserResponse> saveUser(@Body UserRequest UserRequest);
}
