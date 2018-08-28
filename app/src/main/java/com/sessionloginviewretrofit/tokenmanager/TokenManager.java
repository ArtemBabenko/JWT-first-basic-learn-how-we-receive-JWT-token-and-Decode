package com.sessionloginviewretrofit.tokenmanager;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;


public class TokenManager {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    Context context;
    int privatemode = 0 ;
    private static final String PREF_NAME="JWTTOKEN";
   // private static final String islogin="ISLOGIN";
    private static final String KeyName= "keyname";
    private static final String Name= "name";

    //Сохраняет файл с дефыолтным именем и значением.
    public TokenManager(Context context)
    {
        this.context =context;
        preferences = context.getSharedPreferences(PREF_NAME,privatemode);
        editor = preferences.edit();


    }


    //Метод сохраняет входящие в него данные.
    public void createLoginSession(String keyname ,String username )
    {
        editor.putString(keyname,keyname);
        editor.putString(username,Name);
        editor.commit();

    }


    public void checkLogin()
    {

    }

    public void logout()
    {


    }



}
