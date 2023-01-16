package com.example.conn;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiInterface {

    // POST 방식
    @FormUrlEncoded
    @POST
    Call<String> connPost(@Url String url, @FieldMap HashMap<String, Object> params);

    // GET 방식
    @GET("{path}")
    Call<String> connGet(@Path("path") String url, @QueryMap HashMap<String, Object> params);

    @POST("{path}") // localhost/middle/{path}
    @Multipart // <= @FormUrlEncoded 사용 금지, @Path 어노테이션을 써줘야함.
    Call<String> connFilePost(@Path("path") String url
                        , @Part("param")RequestBody param
                        , @Part MultipartBody.Part file);
}
