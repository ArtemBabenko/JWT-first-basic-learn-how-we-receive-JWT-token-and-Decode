package com.sessionloginviewretrofit.decode;

import android.util.Base64;
import android.util.Log;

import com.fasterxml.jackson.databind.ser.Serializers;

import java.io.UnsupportedEncodingException;


public class JWTUtils {

    //Берет строку, я так понимаю закодированый JWT.
    //Через сплит розделяет их по принципу точки. И елементы, используя  getJson, выводит в лог.
    public static void decodeJWT(String EncodeString) throws Exception {

        String[] splitstr = EncodeString.split("\\.");
        Log.d("", "Header " + getJSon(splitstr[0]));
        Log.d("", "Payload " + getJSon(splitstr[1]));


    }

    //Возвращает роскодированую строку.
    public static String getJSon(String EncodeString) throws UnsupportedEncodingException {


        byte[] decodebyte = Base64.decode(EncodeString, Base64.URL_SAFE);
        return new String(decodebyte, "UTF-8");

    }


}
