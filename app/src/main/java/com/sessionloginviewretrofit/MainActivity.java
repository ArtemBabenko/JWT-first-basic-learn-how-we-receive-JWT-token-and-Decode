package com.sessionloginviewretrofit;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.sessionloginviewretrofit.databinding.ActivityMainBinding;
import com.sessionloginviewretrofit.presenter.Presenter;
import com.sessionloginviewretrofit.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding activityMainBinding;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        // Нахрена он ето сделал для такого кличества кода не понятно.
        // Но здесь используется ActivityMainBinding, генерируемый клас который использует xml для сокращения
        // инициализации view елементов а также их обработчиков. Логично использовать когда елементов пару десятков как минимум.
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        loginViewModel = new LoginViewModel(this);
        activityMainBinding.setPresenter(new Presenter() {
            @Override
            public void logInRetro() {
                showToast("First Command");
                loginViewModel.getRetroLoginData();


            }
        });


    }

    void showToast(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

}
