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
    // 해당하는 getData라는 메소드를 여러 액티비티와 프래그먼트에서 재활용을 통해
    // Spring에 연결 후 데이터를 가지고 오는 처리를 해야함.
    // 어떤식으로 바뀌면 재활용이 편할까???
    private HashMap<String , Object> params = new HashMap<>();
    public CommonMethod setParams(String key , Object value){
        params.put(key,value);
        return this;
    }

    public void sendPost(String url , CallBackResult callback){
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest =  apiInterface.connPost(url , params);
        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.result(true , response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.result(false , "");
                t.printStackTrace();//<=어떤오류인지 로그에 찍히게 처리.
            }
        });
    }

    public void sendGet(String url , CallBackResult callback){
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest =  apiInterface.connGet(url , params);
        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.result(true , response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.result(false , "");
                t.printStackTrace();//<=어떤오류인지 로그에 찍히게 처리.
            }
        });
    }

    // 갤러리에서 가져온 이미지 패스가 URI형태로 실제 물리적인 주소가 x File로 만들수없음
    // ↓ 해당하는 메소드는 URI를 통해 실제 이미지 물리적 주소를 얻어오는 메소드
    //2022. 12. 26 PHB 만듬.
    //2022. 12. 29 CSM 오류발견 : uri=>aaa로 수정
    public String getRealPath(Uri uri, Context context){
        String rtn = null;  //리턴용
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(uri, proj, null, null, null);
        if(cursor.moveToFirst()){
            int colum_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            rtn = cursor.getString(colum_index);
        }
        cursor.close();

        return rtn;
    }

    public void sendPostFile(String url , String filePath, CallBackResult callback){

        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest =  apiInterface.connFilePost(url , stringToRequest(),pathToPartFile(filePath));


        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.result(true , response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.result(false , "");
                t.printStackTrace();//<=어떤오류인지 로그에 찍히게 처리.
            }
        });
    }

    public MultipartBody.Part pathToPartFile(String path) {
        if (path != null) {
            RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), new File(path));
            MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "img.png", fileBody);
            return filePart;
        }
        return null;
    }

    //MultiPart로 데이터도 동시에 보내서 요청.
    public RequestBody stringToRequest(){
        RequestBody data = null;
        if(!params.isEmpty()){
            data = RequestBody.create(
                    MediaType.parse("multipart/form-data"),new Gson().toJson(
                            params.get("param")
                    )
            );
        }
        return data;
    }

    //카메라로 찍은 사진을 우리가 만든 임시파일로 가져오기위한 처리
    public File createFile(Context context){
        String fileName = "LastProject" + new SimpleDateFormat("yyyyMMddd_HHmmss").format(new Date());
        //사진파일을 저장하기 위한 경로 (=== 해당 메소드 부분은 따로 공부x, 버전이 업되면 계속해서 바뀜.
        File storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File rtnFile = null;    //IO 입출력 Exception이 발생하기 때문에 try{}catch블럭킹이 생김.

        try {
            rtnFile = File.createTempFile(fileName, ".jpg", storageDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  /storage/emualted/0...
        return rtnFile;
    }

    //1.정의
    public interface CallBackResult{
        // 메인에서 CommonMethod를 통해서 Callback<String> 인터페이스를 넘겨서 실행할때마다
        // 두개의 메소드가 오버라이드가 됨. ( onResponse , onFailure )==> 하나로 합치고싶음.
        public void result(boolean isResult , String data);
    }

}
