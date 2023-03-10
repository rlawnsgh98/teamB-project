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

import java.util.ArrayList;

public class NewBoardActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityNewBoardBinding b;
    final String TAG = "log";
    public final int GALLERY_CODE = 1000;
    public final int FILE_CODE = 1001;

    CommonMethod commonMethod = new CommonMethod();

    ArrayList<String> path_list = null;
    ArrayList<String> name_list = null;
    ArrayList<BoardFileVO> file_list = null;
    NewBoardAdapter adapter = null;
    BoardFileAdapter file_adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityNewBoardBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        checkDangerousPermissions();
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
        Uri uri = Uri.fromParts("package", this.getPackageName(), null);
        intent.setData(uri);
        startActivity(intent);
        Common common = new Common();
        //??????????????? - user1
        common.setTempLoginInfo();

        //??????
        b.cardInsert.setOnClickListener(this);
        b.ivPicture.setOnClickListener(this);
        b.ivFile.setOnClickListener(this);

        //????????????
        b.ivBack.setOnClickListener(this);
        b.cardBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //????????????????????? ???????????? Intent
        Intent board_intent = new Intent(NewBoardActivity.this, BoardActivity.class);
        CommonMethod commonMethod = new CommonMethod();
        Common common = new Common();

        if(v.getId()== R.id.iv_back){
            onBackPressed();
        }else if(v.getId()==R.id.card_back){
            onBackPressed();
        }else if(v.getId()==R.id.card_insert){
            //??? ????????????
            if(!TextUtils.isEmpty(b.edtTitle.getText().toString()) && !TextUtils.isEmpty(b.edtContent.getText().toString())){
                Log.d(TAG, "??? ?????? ??????");

                BoardVO vo = new BoardVO();
                vo.setTitle(b.edtTitle.getText().toString());
                vo.setWriter(Integer.parseInt(common.getLoginInfo().getMember_code()));
                vo.setContent(b.edtContent.getText().toString());
                //====================================================
                //????????? insert ??????
                if(path_list == null){
                    //???????????? ?????? ?????????
                    commonMethod.setParams("param", vo)
                            .sendPost("insert.bo", (isResult, data) -> {
                                if(isResult){
                                    Toast.makeText(this, "??? ?????? ??????", Toast.LENGTH_SHORT).show();
                                    startActivity(board_intent);
                                }else{
                                    Log.d(TAG, " insert ?????? ");
                                }
                            });
                }else{
                    //???????????? ?????? ?????????
                    commonMethod.setParams("param", vo)
                            .sendPostFiles("insert.fi", path_list, name_list, FILE_CODE, (isResult, data) -> {
                                if(isResult){
                                    Toast.makeText(this, "??? ?????? ??????", Toast.LENGTH_SHORT).show();
                                    startActivity(board_intent);
                                }else{
                                    Log.d(TAG, " insert ?????? ");
                                }
                            });
                }
                //====================================================
            }else{
                Log.d(TAG, "??? ?????? ??????");
                Toast.makeText(this, "??????, ????????? ?????? ???????????????", Toast.LENGTH_LONG).show();
            }
        }else if(v.getId()==R.id.iv_file){
            //?????? ??????
            fileMethod();
        }else if(v.getId()==R.id.iv_picture){
            //?????? ??????
            galleryMethod();
        }

    }

    //????????? ????????? ?????? ?????????
    public void galleryMethod(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        //2023-01-11 ?????? ????????? ????????? ????????????
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(Intent.createChooser(intent, "?????? ??????"), GALLERY_CODE);
    }

    //?????? ????????? ?????? ?????????
    public void fileMethod(){
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("*/*");
//        intent.putExtra(Intent.)
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(Intent.createChooser(intent, "?????? ??????"), FILE_CODE);
    }

    //?????? ???????????? startActivityForResult ??? ???????????? ??? ????????? ????????? ???
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == FILE_CODE && resultCode == RESULT_OK){

            allMethod(data, FILE_CODE);

            //?????????
            file_adapter = new BoardFileAdapter(getLayoutInflater(), file_list);
            b.recvFiles.setAdapter(file_adapter);
            b.recvFiles.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
            file_adapter.notifyDataSetChanged();

        }else if(requestCode == GALLERY_CODE && resultCode == RESULT_OK){

            allMethod(data, GALLERY_CODE);

            //?????????
            adapter = new NewBoardAdapter(getLayoutInflater(), file_list, this);
            b.recvImgs.setAdapter(adapter);
            b.recvImgs.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
            adapter.notifyDataSetChanged();
        }
    }

    //????????? ?????? ?????? ??????
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void allMethod(Intent data, int type){
        Log.d(TAG, "data ?????? : " + data.getClipData().getItemAt(0).getUri());

        name_list = new ArrayList<>();
        path_list = new ArrayList<>();  //==> String (path)
        file_list = new ArrayList<>();   // ==> BoardFileVO
        String realPath = null;
        for (int i = 0; i < data.getClipData().getItemCount(); i++){
            BoardFileVO vo = new BoardFileVO();
            if(type==GALLERY_CODE){
                //????????????
                String name = getImageNameToUri(data.getClipData().getItemAt(i).getUri());
                name_list.add( name );
                vo.setFile_name( name );
                realPath = commonMethod.getRealPath(data.getClipData().getItemAt(i).getUri(), this, type);
            }else if(type==FILE_CODE){
                //????????????
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

    //?????? ?????? ??????
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

    // ???????????? - ?????? : ????????? - ?????????????????? ?????????????????? ??????????????? OK
    // ???????????? - ?????? : ????????? - ?????????????????? ?????????????????? ?????? ??? queries ??? ????????? ????????????.
    // ???????????? - ?????? : ?????? , ????????? , ?????????(???????????????) - ?????????????????? ?????????????????? ?????? ??? , ??????????????? ?????? ??? ????????? ??????.
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
            Toast.makeText(this, "?????? ??????", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "?????? ??????", Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Toast.makeText(this, "?????? ?????? ?????????.", Toast.LENGTH_LONG).show();
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
                    Log.d("??????", "?????? ?????? ???: " + permissions[i]);
                }else{
                    Log.d("??????", "?????? ?????? ??????: " + permissions[i]);
                }
            }
        }
    }

    // ????????? ?????? ?????? ????????????
    public String getFileNameToUri(Uri data){
        Cursor returnCursor = getContentResolver().query(data, null, null, null, null);
        int nameIndex = returnCursor.getColumnIndexOrThrow(OpenableColumns.DISPLAY_NAME);
        returnCursor.moveToFirst();
        String fileName = returnCursor.getString(nameIndex);
        return fileName;
    }

    // ????????? ????????? ????????? ????????????
    public String getImageNameToUri(Uri data) {
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(data, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        cursor.moveToFirst();

        String imgPath = cursor.getString(column_index);
        String imgName = imgPath.substring(imgPath.lastIndexOf("/")+1);

        return imgName;
    }

    //????????? ?????????
    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }

}