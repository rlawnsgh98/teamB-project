package com.example.teamb_project.counselling;

<<<<<<< HEAD
<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.databinding.ActivityNewCounselBinding;
import com.example.teamb_project.vo.CounselVO;
import com.example.teamb_project.vo.MemberVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class NewCounselActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityNewCounselBinding b;
    Common common = new Common();
    CommonMethod commonMethod = new CommonMethod();
    ArrayList<MemberVO> counsel_list;
    int teacher_code;

=======
=======
>>>>>>> main
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.teamb_project.R;
import com.example.teamb_project.databinding.ActivityNewCounselBinding;

public class NewCounselActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityNewCounselBinding b;
<<<<<<< HEAD
>>>>>>> main
=======
>>>>>>> main
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityNewCounselBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

<<<<<<< HEAD
<<<<<<< HEAD
        //스피너에 들어갈 강사이름 목록 조회
        commonMethod.setParams("member_code", common.getLoginInfo().getMember_code())
                .sendPost("list.te", (isResult, data) -> {
                    //수강중인 강의의 강사목록 불러오기
                    counsel_list = new Gson().fromJson(data, new TypeToken<ArrayList<MemberVO>>(){}.getType());
                    ArrayList<String> name_list = new ArrayList<>();
                    for(int i = 0; i < counsel_list.size(); i++){
                        name_list.add(counsel_list.get(i).getMember_name());
                    }
                    //스피너 어댑터 설정
                    ArrayAdapter mAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, name_list);
                    mAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                    b.spinner.setAdapter(mAdapter);

                    b.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            //선택됐을때 (기본0 선택)
                            b.tvTeacherName.setText(counsel_list.get(position).getMember_name());
                            teacher_code = Integer.parseInt(counsel_list.get(position).getMember_code());
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            //선택x
                        }
                    });

                });


        //클릭이벤트
        b.cardBack.setOnClickListener(this);
        b.ivBack.setOnClickListener(this);
        b.cardInsert.setOnClickListener(this);

=======
        //클릭이벤트
        b.cardBack.setOnClickListener(this);
        b.ivBack.setOnClickListener(this);
>>>>>>> main
=======
        //클릭이벤트
        b.cardBack.setOnClickListener(this);
        b.ivBack.setOnClickListener(this);
>>>>>>> main

    }

    @Override
    public void onClick(View v) {
        //상담목록으로
        Intent intent_counsel = new Intent(NewCounselActivity.this, CounselActivity.class);

        if(v.getId()== R.id.iv_back){
            //뒤로가기 클릭시
            startActivity(intent_counsel);
        }else if(v.getId()==R.id.card_back){
            //취소 클릭시
            startActivity(intent_counsel);
<<<<<<< HEAD
<<<<<<< HEAD
        }else if(v.getId()==R.id.card_insert){
            //상담 등록
            if(!b.edtTitle.getText().toString().isEmpty() && !b.edtContent.getText().toString().isEmpty()){
                //상담 강사 목록이 있을때
                if(counsel_list != null){
                    //insert 처리
                    CounselVO vo = new CounselVO();
                    vo.setTitle(b.edtTitle.getText().toString());
                    vo.setContent(b.edtContent.getText().toString());
                    vo.setWriter(Integer.parseInt(common.getLoginInfo().getMember_code()));
                    vo.setReceiver(teacher_code);
                    commonMethod.setParams("vo", new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(vo))
                            .sendPost("insert.co", (isResult, data) -> {

                                Log.d("log", "상담 등록 결과 : " + data); //0이면 실패
                                Toast.makeText(this, "상담 등록 완료", Toast.LENGTH_SHORT).show();
                                //상담 목록으로 이동
                                Intent intent = new Intent(NewCounselActivity.this, CounselActivity.class);
                                startActivity(intent);
                            });
                }else{
                    Toast.makeText(this, "수강중인 강의가 없습니다", Toast.LENGTH_LONG).show();
                }

            }else{
                Log.d("log", "값 입력 필요");
                Toast.makeText(this, "제목, 내용을 모두 입력하세요", Toast.LENGTH_LONG).show();
            }
=======
>>>>>>> main
=======
>>>>>>> main
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }


}