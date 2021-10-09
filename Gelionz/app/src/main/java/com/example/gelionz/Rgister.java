package com.example.gelionz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gelionz.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Rgister extends AppCompatActivity {

    EditText etUsername, etEmail, etPassword;
    Button btnRegister;
    TextView alreadyHaveAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rgister);

        etUsername = findViewById(R.id.inputUsername);
        etEmail = findViewById(R.id.inputEmail);
        //etPassword = findViewById(R.id.inputPassword);//

        btnRegister = (Button) findViewById(R.id.btnRegister);
        alreadyHaveAccount = (TextView) findViewById(R.id.alreadyHaveAccount);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUser(createRequest());
            }
        });
    }

    public UserRequest createRequest() {
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername(etUsername.getText().toString());
        userRequest.setEmail(etEmail.getText().toString());
        //userRequest.setNombres(etPassword.getText().toString());//
        return userRequest;
    }

    public void saveUser(UserRequest userRequest){
        Call<UserResponse> userResponseCall = ApiCliente.getUserService().saveUser(userRequest);
        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(Rgister.this, "Save successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Rgister.this, "Request failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(Rgister.this, "Request failed"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}