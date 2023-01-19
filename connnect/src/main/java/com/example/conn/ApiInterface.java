package com.example.conn;

import java.util.HashMap;
import java.util.List;

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

    // get 또는 post 등 여러가지 방식의 요청을 미리 지정해놓고
    // 계속 새로 초기화해서 사용

    @FormUrlEncoded //URL을 가변적으로 바꿔서 요청받게 처리(Mapping)
    @POST   //요청방식 POST
    Call<String> connPost(@Url String url, @FieldMap HashMap<String, Object> params);  // localhost/middle/?? 에서 ?? 부분을 바꿔서 쓸 url

    // url, param 전부 노출되는 형태
    @GET("{path}")
    Call<String> connGet(@Path("path") String url, @QueryMap HashMap<String, Object> params);

    @POST("{path}")     // localhost/middle/{path}
    @Multipart  // <--  @FormUrlEncoded 사용 금지됨, @Path 어노테이션을 써줘야함.
    Call<String> connFilePost(@Path("path") String url
            , @Part("param") RequestBody param  //데이터 부분
            , @Part MultipartBody.Part file //파일부분
                            );


    @POST("{path}")     // localhost/middle/{path}
    @Multipart  // <--  @FormUrlEncoded 사용 금지됨, @Path 어노테이션을 써줘야함.
    Call<String> connFilesPost(@Path("path") String url
            , @Part("param") RequestBody param  //데이터 부분
            , @Part List<MultipartBody.Part> file //파일부분
    );
    //폼 태그 대용으로 Multipart 사용
//    public interface GitHubService {
//        @GET("users/{user}/repos")
//        Call<List<Repo>> listRepos(@Path("user") String user);
//    }
}
