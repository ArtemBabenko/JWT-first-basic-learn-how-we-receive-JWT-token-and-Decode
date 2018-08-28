package com.sessionloginviewretrofit.remote;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface APIService {

    //Тик же ничего нового. Типичный запрос Retrofit
    // Анотация @FormUrlEncoded - обозначает, что тело запроса будет использовать форму URL-кодирования.
    // А точнее имена полей и значения будут кодироваться в кодировке UTF-8 до кодирования URI в соответствии с RFC-3986 .
    // @Post - запрос.
    // @Field - начения преобразуются в строки с использованием Retrofit.stringConverter .
    @POST("/hit/logintab.php")
    Call<String> userLogin (@Field("username") String username,@Field("userpass") String userpass);

}
