package com.example.conn;

import android.app.appsearch.StorageInfo;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.MediaStore;
import android.provider.OpenableColumns;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommonMethod {
    private HashMap<String, Object> params = new HashMap<>();

    public CommonMethod setParams(String key, Object value){
        params.put(key, value);
        return this;
    }

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
                t.printStackTrace(); // 어떤 오류인지 로그에 찍히게 처리
            }
        });
    }
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
                t.printStackTrace(); // 어떤 오류인지 로그에 찍히게 처리
            }
        });
    }

    // 1. 정의
    public interface CallBackResult{
        // 메인에서 CommonMethod를 통해서 CallBack<String> 인터페이스를 넘겨서 실행할때마다
        // 두 개의 메소드가 오버라이드 됨 ==> 하나로 합치기
        public void result(boolean isResult, String data);
    }

    //갤러리에서 가져온 이미지 패스가 URI 형태로 실제 물리적인 주소가 x -> file로 만들수 없ㅇ므
    //해당하는 메소드는 URI 를 통해 실제 이미지 물리적 주소를 얻어오는 메소드
    // 2022.12.26 kwh 만듬 (협업 tip)
    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getRealPath(Uri uri, Context context, int type){
        String rtn = null; //리턴용
        //이미지
        if(type == 1000){
            String[] proj = {MediaStore.Images.Media.DATA};
            Cursor cursor = context.getContentResolver().query(uri, proj, null, null);
            if(cursor.moveToFirst()){
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                rtn = cursor.getString(column_index);
            }
            cursor.close();
        }else if(type == 1001){
            //파일
            String[] proj = {OpenableColumns.DISPLAY_NAME};
            Cursor cursor = context.getContentResolver().query(uri, proj, null, null, null);
            if(cursor.moveToFirst()){
                int column_index = cursor.getColumnIndexOrThrow(OpenableColumns.DISPLAY_NAME);
                rtn = cursor.getString(column_index);
            }
        }

        return rtn;
    }

    //카메라로 찍은 사진을 우리가 만든 임시파일로 가져오기 위한 처리
    public File createFile(Context context) {
        String fileName = "Project" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        //사진파일을 저장하기 위한 경로 == 해당 메소드 부분은 계속 바뀌므로 따로 공부x
        File storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File rtnFile = null; //IO Exception 발생함

        try {
            rtnFile = File.createTempFile(fileName, ".jpg", storageDir);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rtnFile;
    }


    public void sendPostFile(String url, String filepath, String filename, int type, CallBackResult callback){

        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest = apiInterface.connFilePost(url, stringToRequest(), pathToPartFile(filepath, filename, type));

        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.result(true, response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.result(false, "");
                t.printStackTrace(); // 어떤 오류인지 로그에 찍히게 처리
            }
        });

    }

    public void sendPostFiles(String url, ArrayList<String> filepath, ArrayList<String> name_list, int type, CallBackResult callback) {
        List<MultipartBody.Part> list  = new ArrayList<>();
        for (int i = 0; i < filepath.size(); i++) {
            list.add( pathToPartFile(filepath.get(i), name_list.get(i), type));
        }
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest = apiInterface.connFilesPost(url, stringToRequest(), list);

        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.result(true, response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.result(false, "");
                t.printStackTrace(); // 어떤 오류인지 로그에 찍히게 처리
            }
        });

    }

    public MultipartBody.Part pathToPartFile(String filepath, String filename, int type){
        String ss = filename.substring(filename.indexOf(".") , filename.length());
        if( filepath != null ){
            RequestBody fileBody = null;
            if(type==1000){
                fileBody = RequestBody.create(MediaType.parse("image/jpeg"), new File(filepath));
            }else if(type==1001){
                fileBody = RequestBody.create(MediaType.parse("application/"+filename.substring(filename.indexOf(".")+1 , filename.length())), new File(filepath));
            }
            MultipartBody.Part filePart
                    = MultipartBody.Part.createFormData("file", filename, fileBody);
            return filePart;
        }
        return null;
    }

    //Multipart로 데이터 동시에 보내서 요청
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
    }


}
