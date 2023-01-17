package com.example.teamb_project.board;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.databinding.ActivityNewBoardBinding;
import com.example.teamb_project.vo.BoardFileVO;
import com.example.teamb_project.vo.BoardVO;
import com.google.gson.Gson;

import java.util.ArrayList;

public class NewBoardActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityNewBoardBinding b;
    final String TAG = "log";
    public final int GALLERY_CODE = 1000;
    public final int FILE_CODE = 1001;

    CommonMethod commonMethod = new CommonMethod();

    ArrayList<String> path_list;
    ArrayList<String> name_list;
    ArrayList<BoardFileVO> file_list;
    NewBoardAdapter adapter;
    BoardFileAdapter file_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityNewBoardBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

//        checkDangerousPermissions();
//        Intent intent = new Intent();
//        intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
//        Uri uri = Uri.fromParts("package", this.getPackageName(), null);
//        intent.setData(uri);
//        startActivity(intent);
        Common common = new Common();
        //임시로그인 - user1
        common.setTempLoginInfo();

        //클릭
        b.cardInsert.setOnClickListener(this);
        b.ivPicture.setOnClickListener(this);
        b.ivFile.setOnClickListener(this);

        //뒤로가기
        b.ivBack.setOnClickListener(this);
        b.cardBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //자유게시판으로 이동하는 Intent
        Intent board_intent = new Intent(NewBoardActivity.this, BoardActivity.class);
        CommonMethod commonMethod = new CommonMethod();
        Common common = new Common();

        if(v.getId()== R.id.iv_back){
            onBackPressed();
        }else if(v.getId()==R.id.card_back){
            onBackPressed();
        }else if(v.getId()==R.id.card_insert){
            //글 등록처리
            if(!TextUtils.isEmpty(b.edtTitle.getText().toString()) && !TextUtils.isEmpty(b.edtContent.getText().toString())){
                Log.d(TAG, "글 등록 가능");

                BoardVO vo = new BoardVO();
                vo.setTitle(b.edtTitle.getText().toString());
                vo.setWriter(Integer.parseInt(common.getLoginInfo().getMember_code()));
                vo.setContent(b.edtContent.getText().toString());
                //====================================================
                //게시글 insert 처리
                if(path_list == null){
                    //첨부파일 없는 게시글
                    commonMethod.setParams("param", new Gson().toJson(vo))
                            .sendPost("insert.bo", (isResult, data) -> {
                                if(isResult){
                                    Toast.makeText(this, "글 등록 완료", Toast.LENGTH_SHORT).show();
                                    startActivity(board_intent);
                                }else{
                                    Log.d(TAG, " insert 실패 ");
                                }
                            });
                }else{
                    //첨부파일 있는 게시글
                    commonMethod.setParams("param", vo)
                            .sendPostFiles("insert.fi", path_list, name_list, FILE_CODE, (isResult, data) -> {
                                if(isResult){
                                    Toast.makeText(this, "글 등록 완료", Toast.LENGTH_SHORT).show();
                                    startActivity(board_intent);
                                }else{
                                    Log.d(TAG, " insert 실패 ");
                                }
                            });
                }
                //====================================================
            }else{
                Log.d(TAG, "값 입력 필요");
                Toast.makeText(this, "제목, 내용을 모두 입력하세요", Toast.LENGTH_LONG).show();
            }
        }else if(v.getId()==R.id.iv_file){
            //파일 첨부
            fileMethod();
        }else if(v.getId()==R.id.iv_picture){
            //사진 첨부
            galleryMethod();
        }

    }

    //갤러리 선택시 실행 메소드
    public void galleryMethod(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        //2023-01-11 사진 선택을 여러개 할수있게
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(Intent.createChooser(intent, "사진 선택"), GALLERY_CODE);
    }

    //파일 선택시 실행 메소드
    public void fileMethod(){
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("*/*");
//        intent.putExtra(Intent.)

        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(Intent.createChooser(intent, "파일 선택"), FILE_CODE);
    }

    //어떤 인텐트로 startActivityForResult 를 실행하든 그 결과는 무조건 ↓
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        checkDangerousPermissions();
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
        Uri uri = Uri.fromParts("package", this.getPackageName(), null);
        intent.setData(uri);
        startActivity(intent);

        if(requestCode == FILE_CODE && resultCode == RESULT_OK){

            allMethod(data, FILE_CODE);

            //어댑터
            file_adapter = new BoardFileAdapter(getLayoutInflater(), file_list, this);
            b.recvFiles.setAdapter(file_adapter);
            b.recvFiles.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
            file_adapter.notifyDataSetChanged();

        }else if(requestCode == GALLERY_CODE && resultCode == RESULT_OK){

            allMethod(data, GALLERY_CODE);

            //어댑터
            adapter = new NewBoardAdapter(getLayoutInflater(), file_list, this);
            b.recvImgs.setAdapter(adapter);
            b.recvImgs.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
            adapter.notifyDataSetChanged();
        }
    }

    //내보낼 파일 정보 담기
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void allMethod(Intent data, int type){
//        Log.d(TAG, "data 확인 : " + data.getClipData().getItemAt(0).getUri());

        name_list = new ArrayList<>();
        path_list = new ArrayList<>();  //==> String (path)
        file_list = new ArrayList<>();   // ==> BoardFileVO
        String realPath = null;
        if( data.getClipData() == null ){
            //한개 선택시 바로 mData 로 접근
            BoardFileVO vo = new BoardFileVO();
            if(type==FILE_CODE){
                //파일처리
                realPath = getFilePath(data.getData());
                String name = getFileNameToUri(data.getData());
                name_list.add( name );
                vo.setFile_name( name );
            }
            path_list.add( realPath );
            vo.setPath( realPath );
            file_list.add(vo);
        }else{
            //여러개 선택시 clipData 있음
            for (int i = 0; i < data.getClipData().getItemCount(); i++){
                BoardFileVO vo = new BoardFileVO();
                if(type==GALLERY_CODE){
                    //사진처리
                    String name = getImageNameToUri(data.getClipData().getItemAt(i).getUri());
                    name_list.add( name );
                    vo.setFile_name( name );
                    realPath = commonMethod.getRealPath(data.getClipData().getItemAt(i).getUri(), this, type);
                }else if(type==FILE_CODE){
                    //파일처리
                    realPath = getFilePath(data.getClipData().getItemAt(i).getUri());
                    String name = getFileNameToUri(data.getClipData().getItemAt(i).getUri());
                    name_list.add( name );
                    vo.setFile_name( name );
                }
                path_list.add( realPath );
                vo.setPath( realPath );

                file_list.add(vo);
            }
        }
    }

    //파일 경로 찾기
    public String getFilePath(Uri uri){
        final String docId = DocumentsContract.getDocumentId(uri);
        final String[] split = docId.split(":");
        final String type= split[0];
        String path = null;
        if ("primary".equalsIgnoreCase(type)) {
            path = Environment.getExternalStorageDirectory() + "/" + (split.length > 1 ? split[1] : ""); //split[1];
        } else if ("home".equalsIgnoreCase(type)) {
            path = Environment.getExternalStorageDirectory() + "/Documents/" + (split.length > 1 ? split[1] : ""); //split[1];
        }
        return path;
    }

    // 권한레벨 - 낮음 : 인터넷 - 사용하겠다고 메니페스트에 명시만하면 OK
    // 권한레벨 - 중간 : 유튜브 - 사용하겠다고 메니페스트에 명시 후 queries 로 재명시 해줘야함.
    // 권한레벨 - 높음 : 위치 , 카메라 , 갤러리(파일저장소) - 사용하겠다고 메니페스트에 명시 후 , 쿼리스로도 명시 후 사용자 동의.
    private void checkDangerousPermissions() {
        String[] permissions = {
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_MEDIA_LOCATION,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.MANAGE_DOCUMENTS,
                Manifest.permission.MANAGE_MEDIA,
                Manifest.permission.MANAGE_EXTERNAL_STORAGE
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Toast.makeText(this, "권한 설명 필요함.", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1){
            for (int i = 0 ; i< permissions.length ; i++){
                if ( grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    Log.d("로그", "권한 승인 됨: " + permissions[i]);
                }else{
                    Log.d("로그", "권한 승인 안됨: " + permissions[i]);
                }
            }
        }
    }

    // 선택된 파일 이름 가져오기
    public String getFileNameToUri(Uri data){
        Cursor returnCursor = getContentResolver().query(data, null, null, null, null);
        int nameIndex = returnCursor.getColumnIndexOrThrow(OpenableColumns.DISPLAY_NAME);
        returnCursor.moveToFirst();
        String fileName = returnCursor.getString(nameIndex);
        return fileName;
    }

    // 선택된 이미지 파일명 가져오기
    public String getImageNameToUri(Uri data) {
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(data, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        cursor.moveToFirst();

        String imgPath = cursor.getString(column_index);
        String imgName = imgPath.substring(imgPath.lastIndexOf("/")+1);

        return imgName;
    }

    //바인딩 비우기
    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }

}