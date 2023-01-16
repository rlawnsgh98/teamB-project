package com.example.lms_kmj.drawer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.conn.CommonMethod;
import com.example.lms_kmj.LoginActivity;
import com.example.lms_kmj.R;
import com.example.lms_kmj.common.Common;
import com.example.lms_kmj.member.MemberVO;
import com.google.gson.Gson;

import java.io.File;

public class MyInfoActivity extends AppCompatActivity {
    Toolbar top_toolbar;
    TextView member_code_data,id_data,pw_data
            ,member_name_data_tv,email_data_tv,birth_data_tv,phone_data_tv
            ,type_data,modify_btn,cancel_btn,confirm_btn;
    EditText member_name_data_et,email_data_et,birth_data_et,phone_data_et;
    LinearLayout modify_ln1,modify_ln2,modify_ln3,modify_ln4;
    RadioGroup radioGroup;
    RadioButton male_rd, female_rd;
    String modify_gender_info ="남";

    ImageView profile_image_0,profile_image_1;
    Dialog popup_dialog;
    String img_path;
    public final int CAMERA_CODE = 1000;
    public final int GALLERY_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        top_toolbar = findViewById(R.id.top_toolbar);
        member_code_data = findViewById(R.id.member_code_data);
        id_data = findViewById(R.id.id_data);
        pw_data = findViewById(R.id.pw_data);

        member_name_data_tv = findViewById(R.id.member_name_data_tv);
        member_name_data_et = findViewById(R.id.member_name_data_et);

        radioGroup = findViewById(R.id.radioGroup);
        male_rd = findViewById(R.id.male_rd);
        female_rd = findViewById(R.id.female_rd);

        email_data_tv = findViewById(R.id.email_data_tv);
        email_data_et = findViewById(R.id.email_data_et);

        birth_data_tv = findViewById(R.id.birth_data_tv);
        birth_data_et = findViewById(R.id.birth_data_et);

        phone_data_tv = findViewById(R.id.phone_data_tv);
        phone_data_et = findViewById(R.id.phone_data_et);

        type_data = findViewById(R.id.type_data);
        modify_btn = findViewById(R.id.modify_btn);
        cancel_btn = findViewById(R.id.cancel_btn);
        confirm_btn = findViewById(R.id.confirm_btn);

        modify_ln1 = findViewById(R.id.modify_ln1);
        modify_ln2 = findViewById(R.id.modify_ln2);
        modify_ln3 = findViewById(R.id.modify_ln3);
        modify_ln4 = findViewById(R.id.modify_ln4);

        profile_image_0 = findViewById(R.id.profile_image_0);
        profile_image_1 = findViewById(R.id.profile_image_1);

        // 다이얼로그 생성
        popup_dialog = new Dialog(MyInfoActivity.this);
        popup_dialog.setContentView(R.layout.popup_dialog);

        // 상단바
        top_toolbar.setTitle("나의 정보");

        // 상단바 뒤로가기 버튼
        top_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Common common = new Common();

        // 회원 정보 불러오기
        new CommonMethod().setParams("id",common.getLoginInfo().getId())
            .sendPost("my_info.mj", new CommonMethod.CallBackResult() {
                @Override
                public void result(boolean isResult, String data) {
                    MemberVO my_info = new Gson().fromJson(data, MemberVO.class);

                    // 저장된 프로필 이미지 붙이기
                    Glide.with(MyInfoActivity.this).load(my_info.getProfilepath()).into(profile_image_0);

                    member_code_data.setText(my_info.getMember_code());
                    id_data.setText(my_info.getId());
                    pw_data.setText(my_info.getPw());

                    member_name_data_tv.setText(my_info.getMember_name());

                    if(my_info.getGender().equals("남")){
                        male_rd.setChecked(true);
                        male_rd.setTextColor(Color.parseColor("#000000"));
                        male_rd.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#47628D")));
                    }else{
                        female_rd.setChecked(true);
                        female_rd.setTextColor(Color.parseColor("#000000"));
                        female_rd.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#FF5D82")));
                    }

                    // null 일 수 있는 정보 : 이메일, 생년월일, 전화번호 => 2^3
                    if(my_info.getEmail() != null && my_info.getBirth() != null && my_info.getPhone() != null){
                        email_data_tv.setText(my_info.getEmail());
                        String bitrh_str = my_info.getBirth();
                        birth_data_tv.setText(bitrh_str.substring(0,10));
                        phone_data_tv.setText(my_info.getPhone());
                    } else if(my_info.getEmail() != null && my_info.getBirth() == null && my_info.getPhone() != null){
                        email_data_tv.setText(my_info.getEmail());
                        birth_data_tv.setText("정보가 없습니다.");
                        phone_data_tv.setText(my_info.getPhone());
                    } else if(my_info.getEmail() != null && my_info.getBirth() != null && my_info.getPhone() == null){
                        email_data_tv.setText(my_info.getEmail());
                        String bitrh_str = my_info.getBirth();
                        birth_data_tv.setText(bitrh_str.substring(0,10));
                        phone_data_tv.setText("정보가 없습니다.");
                    } else if(my_info.getEmail() == null && my_info.getBirth() != null && my_info.getPhone() != null){
                        email_data_tv.setText("정보가 없습니다.");
                        String bitrh_str = my_info.getBirth();
                        birth_data_tv.setText(bitrh_str.substring(0,10));
                        phone_data_tv.setText(my_info.getPhone());
                    } else if(my_info.getEmail() == null && my_info.getBirth() == null && my_info.getPhone() != null){
                        email_data_tv.setText("정보가 없습니다.");
                        birth_data_tv.setText("정보가 없습니다.");
                        phone_data_tv.setText(my_info.getPhone());
                    } else if(my_info.getEmail() == null && my_info.getBirth() != null && my_info.getPhone() == null){
                        email_data_tv.setText("정보가 없습니다.");
                        String bitrh_str = my_info.getBirth();
                        birth_data_tv.setText(bitrh_str.substring(0,10));
                        phone_data_tv.setText("정보가 없습니다.");
                    } else if(my_info.getEmail() != null && my_info.getBirth() == null && my_info.getPhone() == null){
                        email_data_tv.setText(my_info.getEmail());
                        birth_data_tv.setText("정보가 없습니다.");
                        phone_data_tv.setText("정보가 없습니다.");
                    } else {
                        email_data_tv.setText("정보가 없습니다.");
                        birth_data_tv.setText("정보가 없습니다.");
                        phone_data_tv.setText("정보가 없습니다.");
                    }
                    type_data.setText(my_info.getType());
                }
            });

        // 수정 버튼
        modify_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modify_ln1.setVisibility(View.GONE);
                modify_ln2.setVisibility(View.VISIBLE);

                // 회원 이름 정보 텍스트 뷰를 에디트 뷰로 교체
                member_name_data_tv.setVisibility(View.GONE);
                member_name_data_et.setVisibility(View.VISIBLE);
                member_name_data_et.setText(member_name_data_tv.getText());
                member_name_data_et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(hasFocus){
                            member_name_data_et.setText("");
                            member_name_data_et.setHint(member_name_data_tv.getText());
                        }
                    }
                });

                // 회원 성별 정보 텍스트 뷰를 에디트 뷰로 교체
                male_rd.setEnabled(true);
                female_rd.setEnabled(true);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if(checkedId == R.id.male_rd){
                            modify_gender_info = male_rd.getText().toString();
                        }else if(checkedId == R.id.female_rd){
                            modify_gender_info = female_rd.getText().toString();
                        }
                    }
                });

                // 회원 이메일 정보 텍스트 뷰를 에디트 뷰로 교체
                email_data_tv.setVisibility(View.GONE);
                email_data_et.setVisibility(View.VISIBLE);
                email_data_et.setText(email_data_tv.getText());
                email_data_et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(hasFocus){
                            email_data_et.setText("");
                            email_data_et.setHint(email_data_tv.getText());
                        }
                    }
                });

                // 회원 생일 정보 텍스트 뷰를 에디트 뷰로 교체
                birth_data_tv.setVisibility(View.GONE);
                birth_data_et.setVisibility(View.VISIBLE);
                //birth_data_et.setHint(birth_data_tv.getText());
                birth_data_et.setHint("yyyy-MM-dd");
                birth_data_et.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MyInfoActivity.this, "생일 정보 변경", Toast.LENGTH_SHORT).show();
                    }
                });
                /*
                birth_data_et.setText(birth_data_tv.getText());
                birth_data_et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(hasFocus){
                            birth_data_et.setText("");
                            birth_data_et.setHint(birth_data_tv.getText());
                            birth_data_et.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(MyInfoActivity.this, "생일 정보 변경", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                });*/

                // 회원 전화번호 정보 텍스트 뷰를 에디트 뷰로 교체
                phone_data_tv.setVisibility(View.GONE);
                phone_data_et.setVisibility(View.VISIBLE);
                phone_data_et.setText(phone_data_tv.getText());
                phone_data_et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(hasFocus){
                            phone_data_et.setText("");
                            phone_data_et.setHint(phone_data_tv.getText());
                        }
                    }
                });

                // 프로필 이미지 정보 레이아웃 교체
                modify_ln3.setVisibility(View.GONE);
                modify_ln4.setVisibility(View.VISIBLE);

                // 프로필 이미지 클릭 시 이미지 변경 가능하게
                profile_image_1.setOnClickListener(new View.OnClickListener() {
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
                checkDangerousPermissions();
            }
        });

        // 취소 버튼
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 레이아웃 교체 : 버튼, 프로필 이미지
                modify_ln1.setVisibility(View.VISIBLE);
                modify_ln2.setVisibility(View.GONE);
                modify_ln3.setVisibility(View.VISIBLE);
                modify_ln4.setVisibility(View.GONE);

                // 회원 이름 정보
                member_name_data_tv.setVisibility(View.VISIBLE);
                member_name_data_et.setVisibility(View.GONE);

                // 회원 성별 정보


                // 회원 이메일 정보
                email_data_tv.setVisibility(View.VISIBLE);
                email_data_et.setVisibility(View.GONE);

                // 회원 생일 정보
                birth_data_tv.setVisibility(View.VISIBLE);
                birth_data_et.setVisibility(View.GONE);

                // 회원 전화번호 정보
                phone_data_tv.setVisibility(View.VISIBLE);
                phone_data_et.setVisibility(View.GONE);
            }
        });

        // 저장 버튼
        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CommonMethod().sendPostFile("modify_my_info.mj", img_path, new CommonMethod.CallBackResult() {
                    @Override
                    public void result(boolean isResult, String data) {
                        MemberVO vo = new MemberVO();
                        vo.setId(common.getLoginInfo().getId());
                        vo.setMember_name(member_name_data_et.getText().toString());
                        vo.setGender(modify_gender_info);

                        if(email_data_et.getText().toString().equals("정보가 없습니다.")){
                            vo.setEmail("");
                        }else{
                            vo.setEmail(email_data_et.getText().toString());
                        }
                        if(birth_data_et.getText().toString().equals("정보가 없습니다.")){
                            vo.setBirth("");
                        }else{
                            vo.setBirth(birth_data_et.getText().toString());
                        }
                        if(phone_data_et.getText().toString().equals("정보가 없습니다.")){
                            vo.setPhone("");
                        }else{
                            vo.setPhone(phone_data_et.getText().toString());
                        }

                        /*
                            vo.setEmail(email_data_et.getText().toString());
                            vo.setBirth(birth_data_et.getText().toString());
                            vo.setPhone(phone_data_et.getText().toString());
                        */
                        if(img_path == null){
                            vo.setProfilepath(common.getLoginInfo().getProfilepath());
                        }else {
                            vo.setProfilepath(img_path);
                        }
                        new CommonMethod().setParams("param",vo).sendPostFile("modify_my_info.mj",img_path,(isResult1, data1) -> {
                            if(isResult1) {
                                Toast.makeText(MyInfoActivity.this, "회원정보수정 완료! 다시 로그인해주세요.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MyInfoActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                        });
                    }
                });
            }
        });
    }//onCreate()

    private void checkDangerousPermissions() {
        String[] permissions = {
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_MEDIA_LOCATION,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
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
    }//checkDangerousPermissions()

    public void galleryMethod(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        startActivityForResult(Intent.createChooser(intent,"select picture"), GALLERY_CODE);
    }//galleryMethod()

    public void cameraMethod(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        File file = new CommonMethod().createFile(this);
        img_path = file.getAbsolutePath();

        if(file != null){
            Uri imgUri = FileProvider.getUriForFile(this,getPackageName()+".fileprovider",file);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);
            }else{
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
            }
        }
        startActivityForResult(intent,CAMERA_CODE);
    }//cameraMethod()

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_CODE && resultCode == RESULT_OK){
            Glide.with(this).load(img_path).into(profile_image_1);
            profile_image_1.setScaleType(ImageView.ScaleType.FIT_XY);
        }else if(requestCode == GALLERY_CODE && resultCode == RESULT_OK){
            img_path = new CommonMethod().getRealPath(data.getData(),this);
            Glide.with(this).load(img_path).into(profile_image_1);
        }
    }//onActivityResult()
}