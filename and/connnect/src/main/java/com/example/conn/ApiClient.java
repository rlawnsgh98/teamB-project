package com.example.conn;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    public static String BASEURL = "http://192.168.1.2/middle";
    public static void setBASEURL(String BASEURL) {
        ApiClient.BASEURL = BASEURL;
    }
    public static String getBASEURL(){return BASEURL;}
    public Retrofit getApiClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)         // 톰캣까지(서버까지 접근경로)
                .client(new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).build())
                .addConverterFactory(ScalarsConverterFactory.create())  //json String 사용
                .build();
        return retrofit;
    }
}
