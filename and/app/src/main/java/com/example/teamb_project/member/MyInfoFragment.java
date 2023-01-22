package com.example.teamb_project.member;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.databinding.FragmentMyInfoBinding;
import com.example.teamb_project.vo.MemberVO;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;

public class MyInfoFragment extends Fragment implements  View.OnFocusChangeListener{
    FragmentMyInfoBinding b;

    Dialog popup_dialog;
    String img_path;
    public final int GALLERY_CODE = 1000;
    public final int CAMERA_CODE = 1002;
    MemberVO my_info;
    MemberVO vo = new MemberVO();
    Calendar myCalendar = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener setDate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateDate();
        }
    };
    Pattern emailPatttern = Patterns.EMAIL_ADDRESS;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentMyInfoBinding.inflate(inflater, container, false);
        popup_dialog = new Dialog(getContext());
        popup_dialog.setContentView(R.layout.popup_dialog);

        checkDangerousPermissions();

        //로그인 정보 가져오기
        my_info = Common.loginInfo;

        // 저장된 프로필 이미지 붙이기
        if(my_info.getProfilepath()==null){
            Glide.with(getContext()).load(R.drawable.user3).into(b.imgvProfile);
        }else{
            Glide.with(getContext()).load(Common.loginInfo.getProfilepath()).into(b.imgvProfile);
        }
        //뒤로가기
//        b.imgvBack.setOnClickListener(v -> {
//            onBackPressed();
//        });

        setMemberInfo();





        b.rdoGender.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId==R.id.male_rd){
                vo.setGender("남");
            }else{
                vo.setGender("여");
            }
        });


        b.imgvProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup_dialog.show();
                popup_dialog.findViewById(R.id.camera).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cameraMethod();
                        popup_dialog.dismiss();
                    }
                });
                popup_dialog.findViewById(R.id.gallery).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        galleryMethod();
                        popup_dialog.dismiss();
                    }
                });
                popup_dialog.findViewById(R.id.cancel_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popup_dialog.dismiss();
                    }
                });
            }
        });


        b.tvBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getContext(),
                        setDate, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        // 저장 버튼
        b.confirmBtn.setOnClickListener(v->{

            vo.setId(Common.loginInfo.getId());

            vo.setMember_name(isNullVoValue(b.edtName.getText().toString() , Common.loginInfo.getMember_name() ));
            vo.setEmail(isNullVoValue(b.edtEmail.getText().toString() , Common.loginInfo.getEmail() ));
            vo.setBirth(isNullVoValue(b.tvBirth.getText().toString()  , Common.loginInfo.getBirth() ));
            vo.setPhone(isNullVoValue(b.edtPhone.getText().toString() , Common.loginInfo.getPhone() ));
            vo.setGender(isNullVoValue(vo.getGender() , Common.loginInfo.getGender() ));
            vo.setProfilepath(img_path);

            new CommonMethod().setParams("param",vo).sendPostFile("modify_my_info.mj", img_path, (isResult, data) -> {
                if(isResult) {
                    Toast.makeText(getContext(), "회원정보수정 완료", Toast.LENGTH_SHORT).show();
                }
            });

        });

        b.cancelBtn.setOnClickListener(v->{
            //finish();
        });
        return b.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        b= null ;
    }


    private void setMemberInfo() {

        b.tvId.setText(my_info.getId());
        b.edtName.setText(my_info.getMember_name());

        if(my_info.getGender().equals("남")){
            RadioButton btn1 = (RadioButton) b.rdoGender.getChildAt(0);
            btn1.setChecked(true);
        }else{
            RadioButton btn2 = (RadioButton) b.rdoGender.getChildAt(1);
            btn2.setChecked(true);
        }

        isNullTextView(my_info.getEmail() , b.edtEmail);
        isNullTextView(my_info.getPhone() , b.edtPhone);
        isNullTextView(my_info.getBirth().substring(0,10) , b.tvBirth);
        if(my_info.getType().equals("STUD")){
            b.tvType.setText("학생");
        }else{
            b.tvType.setText("강사");
        }


    }

    private void checkDangerousPermissions() {
        String[] permissions = {
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_MEDIA_LOCATION,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(getContext(), permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getContext(), "권한 있음", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "권한 없음", Toast.LENGTH_LONG).show();
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), permissions[0])) {
                Toast.makeText(getContext(), "권한 설명 필요함.", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(getActivity(), permissions, 1);
            }
        }
    }//checkDangerousPermissions()

    public void galleryMethod(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        startActivityForResult(Intent.createChooser(intent,"select picture"), GALLERY_CODE);
    }//galleryMethod()

    public void cameraMethod(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        File file = new CommonMethod().createFile(getContext());
        img_path = file.getAbsolutePath();

        if(file != null){
            Uri imgUri = FileProvider.getUriForFile(getContext(),getActivity().getPackageName()+".fileprovider",file);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);
            }else{
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
            }
        }
        startActivityForResult(intent,CAMERA_CODE);
    }//cameraMethod()

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_CODE && resultCode == getActivity().RESULT_OK){
            Glide.with(getContext()).load(img_path).into(b.imgvProfile);
            b.imgvProfile.setScaleType(ImageView.ScaleType.FIT_XY);
        }else if(requestCode == GALLERY_CODE && resultCode == getActivity().RESULT_OK){
            img_path = new CommonMethod().getRealPath(data.getData(),getContext(), 1000);
            Glide.with(getContext()).load(img_path).into(b.imgvProfile);
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
    }//onRequestPermissionsResult()



    public void updateDate(){
        String format = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            simpleDateFormat = new SimpleDateFormat(format, Locale.KOREA);
        }
        b.tvBirth.setText(simpleDateFormat.format(myCalendar.getTime()));
    }//updateDate()

    public void isNullTextView(String value , TextView textView){
        if(value == null || value.trim().length() < 1){
            textView.setText("정보가 없습니다.");
        }else{
            textView.setText(value);
        }
    }

    public String isNullVoValue(String value , String rtnValue){
        if(value == null || value.trim().length() < 1){
            return rtnValue;
        }else{
            return value;
        }
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {



        if(v.getId() == R.id.email_et){
            if(hasFocus){
                if(!b.edtEmail.getText().toString().isEmpty()){
                    b.edtEmail.setText("");
                    b.edtEmail.setHint(b.edtEmail.getText());
                    if(!emailPatttern.matcher(b.edtEmail.getText().toString()).matches()){
                        Toast.makeText(getContext(), "이메일형식이 올바르지 않습니다.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }// ??
//        else if(v.getId() == R.id.edt_name){
//            if(hasFocus){
//                b.edtName.setText("");
//                b.edtName.setHint(b.edtName.getText());
//            }
//        }
    }
}