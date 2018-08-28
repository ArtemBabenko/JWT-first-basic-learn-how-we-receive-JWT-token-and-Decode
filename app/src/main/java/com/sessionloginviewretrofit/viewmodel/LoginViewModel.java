package com.sessionloginviewretrofit.viewmodel;

import android.content.Context;
import android.widget.Toast;

import com.sessionloginviewretrofit.decode.JWTUtils;
import com.sessionloginviewretrofit.remote.APIService;
import com.sessionloginviewretrofit.remote.RetroClass;
import com.sessionloginviewretrofit.tokenmanager.TokenManager;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginViewModel extends Observable {
    private Context context;
    TokenManager tokenManager;

    public LoginViewModel(Context context) {
        this.context = context;
        tokenManager = new TokenManager(context);
    }

    //В етом методе тоже ничего особенного. Идет обращение к методу ретровфит, который находится в его апи
    //Дынные покизиваются в тосте, потом сохраняются в файл. После етого через JWTUtils парсится токен и выводится в лог.
    public void getRetroLoginData() {
        showToast("Inside Loginviewmodel");

        APIService apiService = RetroClass.getAPIService();

        Call<String> responsecall = apiService.userLogin("vishal", "vishal");
        responsecall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                showToast("" + response.body().toString());
                tokenManager.createLoginSession(response.body().toString(), "vishal");

                try {

                    JWTUtils.decodeJWT(response.body().toString());
                } catch (Exception e) {

                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                showToast("" + t.getMessage());

            }
        });


    }

    void showToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }


}
