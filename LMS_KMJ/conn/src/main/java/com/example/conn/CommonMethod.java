package com.example.conn;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommonMethod {
    HashMap<String, Object> params = new HashMap<>();
    /*
    public void setParams(String key, String value){
        params.put(key, value);
    }
    */
    public CommonMethod setParams(String key, Object value){
        params.put(key, value);
        return this;    /* 여기서 this 란? */
    }

    //POST 방식
    // 2. 인터페이스 구현 callback.result()
    public void sendPost(String url, CallBackResult callback){
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest = apiInterface.connPost(url, params);
        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.result(true, response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.result(false, "");
                t.printStackTrace(); // <= 어떤 오류인지 로그에 찍히게 처리
            }
        });
    }

    //GET 방식
    // 2. 인터페이스 구현 callback.result()
    public void sendGet(String url, CallBackResult callback){
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest = apiInterface.connGet(url, params);
        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.result(true, response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.result(false, "");
                t.printStackTrace(); // <= 어떤 오류인지 로그에 찍히게 처리
            }
        });
    }
    /*
    public void sendGet(String url, Callback<String> callback){
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest = apiInterface.connGet(url, params);
        apiTest.enqueue(callback);
    }
    */
    // 1. 인터페이스 정의
    public interface CallBackResult{
        // 메인에서 CommonMethod 를 통해서 Callback<String> 인터페이스를 넘겨서 실행할 때마다
        // 두 개의 메소드가 오버라이드 됨. (onResponse, onFailure) => 하나로 합치고 싶음.
        public void result(boolean isResult, String data);
    }

    // 갤러리에서 가져온 이미지 패스가 URI 형태로 실제 물리적인 주소가 x File 로 만들수 없음
    // 해당하는 메소드는 URI 를 통해 실제 이미지 물리적 주소를 얻어오는 메소드
    // 실제 주소를 가져오는 메소드
    public String getRealPath(Uri uri, Context context){
        String rtn = null; // 리턴용
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(uri, proj, null, null,null);
        if(cursor.moveToFirst()){
            int colum_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            rtn = cursor.getString(colum_index);
        }
        cursor.close();

        return rtn;
    }//getRealPath

    public File createFile(Context context){
        String fileName = "LastProject" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        // 사진 파일을 저장하기 위한 경로 [ 버젼마다 바뀜, 따로 공부 x, 공식문서 참고 ]
        File storageDior = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File rtnFile = null; // IO 입출력 Exception 이 발생하기 때문에 try{}catch 블럭킹이 생김

        try {
            rtnFile = File.createTempFile(fileName, ".jpg", storageDior);
        }catch (IOException e){
            e.printStackTrace();
        }

        return rtnFile;
    }

    public void sendPostFile(String url, String filePath, CallBackResult callback){
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest = apiInterface.connFilePost(url, stringToRequest(), pathToPartFile(filePath));


        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.result(true, response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.result(false, "");
                t.printStackTrace(); // <= 어떤 오류인지 로그에 찍히게 처리
            }
        });
    }//sendPostFile

    // multipart 로 데이터도 동시에 보내서 요청
    public RequestBody stringToRequest(){
        RequestBody data = null;
        if(!params.isEmpty()){
            data = RequestBody.create(
                    MediaType.parse("multipart/form-data"), new Gson().toJson(
                            params.get("param")
                    )
            );
        }
        return data;
    }//stringToRequest

    public MultipartBody.Part pathToPartFile(String path){
        if(path != null){
            RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), new File(path));
            MultipartBody.Part filePart = MultipartBody.Part.createFormData("file","img.png", fileBody);
            return filePart;
        }
        return null;
    }
}
