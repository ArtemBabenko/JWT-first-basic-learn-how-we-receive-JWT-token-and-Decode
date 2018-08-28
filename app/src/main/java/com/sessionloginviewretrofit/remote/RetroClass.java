package com.sessionloginviewretrofit.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetroClass {

    //Наш адрес, для примерра он у нас такой
    private static final String BASE_URL="http://192.168.132.2";

    //Метод который исполльзует либу Gson и создает json объект. После етого вохзвращает ретрофит объект и использоваными и заполнеными данными
    private static Retrofit getRetroInstance()
    {

         Gson gson = new GsonBuilder().setLenient().create();

        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();

    }

    //Обычный гетер, к ниму применяется метод класа к которому приминяется метод с API. Короче типичный  Retrofit.
    public static APIService getAPIService()
    {
        return getRetroInstance().create(APIService.class);
    }



}
