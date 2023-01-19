package com.example.teamb_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.conn.CommonMethod;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.databinding.ActivityTtBinding;
import com.example.teamb_project.student.mylecture.lecturehome.Stu_LectureDetailActivity;
import com.example.teamb_project.vo.EnrolmentVO;
import com.example.teamb_project.vo.LectureVO;
import com.example.teamb_project.vo.MemberVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class TTActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityTtBinding b;
    final String TAG = "log";
    Common common = new Common();
    CommonMethod commonMethod = new CommonMethod();
    TextView name, code;
    ArrayList<LectureVO> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityTtBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        //상세정보 카드뷰
        b.cardDetail.setVisibility(View.GONE);

        //학생 조회
        if(Common.loginInfo.getType().equals("STUD")){
            commonMethod.setParams("vo", new Gson().toJson(Common.loginInfo))
                    .sendPost("student_timetable",(isResult, data) -> {
                        list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<LectureVO>>(){}.getType());
                        setView(list);
                    });
        }else if(Common.loginInfo.getType().equals("TEACH")){
            commonMethod.setParams("vo", new Gson().toJson(Common.loginInfo))
                    .sendPost("teacher_timetable", (isResult, data) -> {
                        list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<LectureVO>>(){}.getType());
                        setView(list);
                    });
        }

        //클릭
        b.tvLink.setOnClickListener(this);  //해당 강의로 이동
        b.imgvBack.setOnClickListener(this); //뒤로가기
        b.lnLayout1.setOnClickListener(this);
        b.lnLayout2.setOnClickListener(this);
        b.lnLayout3.setOnClickListener(this);
        b.lnLayout4.setOnClickListener(this);
        b.lnLayout5.setOnClickListener(this);
        b.lnLayout7.setOnClickListener(this);
        b.lnLayout8.setOnClickListener(this);
        b.lnLayout9.setOnClickListener(this);
        b.lnLayout10.setOnClickListener(this);
        b.lnLayout11.setOnClickListener(this);
        b.lnLayout13.setOnClickListener(this);
        b.lnLayout14.setOnClickListener(this);
        b.lnLayout15.setOnClickListener(this);
        b.lnLayout16.setOnClickListener(this);
        b.lnLayout17.setOnClickListener(this);
        b.lnLayout19.setOnClickListener(this);
        b.lnLayout20.setOnClickListener(this);
        b.lnLayout21.setOnClickListener(this);
        b.lnLayout22.setOnClickListener(this);
        b.lnLayout23.setOnClickListener(this);

    }//onCreate()

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.imgv_back){
            //뒤로가기
            onBackPressed();
        }else if(v.getId()==R.id.tv_link){
            //해당 강의로 이동
            Intent intent = new Intent(TTActivity.this, Stu_LectureDetailActivity.class);
            intent.putExtra("lecture_code", Integer.parseInt(b.tvCode.getText().toString()));
            startActivity(intent);
        }else if(v.getId()==R.id.ln_layout1){
            onCheck(b.lnLayout1);
            selectOne(Integer.parseInt(b.include1.code.getText().toString()));
        }else if(v.getId()==R.id.ln_layout2){
            onCheck(b.lnLayout2);
            selectOne(Integer.parseInt(b.include2.code.getText().toString()));
        }else if(v.getId()==R.id.ln_layout3){
            onCheck(b.lnLayout3);
            selectOne(Integer.parseInt(b.include3.code.getText().toString()));
        }else if(v.getId()==R.id.ln_layout4){
            onCheck(b.lnLayout4);
            selectOne(Integer.parseInt(b.include4.code.getText().toString()));
        }else if(v.getId()==R.id.ln_layout5){
            onCheck(b.lnLayout5);
            selectOne(Integer.parseInt(b.include5.code.getText().toString()));
        }else if(v.getId()==R.id.ln_layout7){
            onCheck(b.lnLayout7);
            selectOne(Integer.parseInt(b.include6.code.getText().toString()));
        }else if(v.getId()==R.id.ln_layout8){
            onCheck(b.lnLayout8);
            selectOne(Integer.parseInt(b.include7.code.getText().toString()));
        }else if(v.getId()==R.id.ln_layout9){
            onCheck(b.lnLayout9);
            selectOne(Integer.parseInt(b.include8.code.getText().toString()));
        }else if(v.getId()==R.id.ln_layout10){
            onCheck(b.lnLayout10);
            selectOne(Integer.parseInt(b.include9.code.getText().toString()));
        }else if(v.getId()==R.id.ln_layout11){
            onCheck(b.lnLayout11);
            selectOne(Integer.parseInt(b.include10.code.getText().toString()));
        }else if(v.getId()==R.id.ln_layout13){
            onCheck(b.lnLayout13);
            selectOne(Integer.parseInt(b.include11.code.getText().toString()));
        }else if(v.getId()==R.id.ln_layout14){
            onCheck(b.lnLayout14);
            selectOne(Integer.parseInt(b.include12.code.getText().toString()));
        }else if(v.getId()==R.id.ln_layout15){
            onCheck(b.lnLayout15);
            selectOne(Integer.parseInt(b.include13.code.getText().toString()));
        }else if(v.getId()==R.id.ln_layout16){
            onCheck(b.lnLayout16);
            selectOne(Integer.parseInt(b.include14.code.getText().toString()));
        }else if(v.getId()==R.id.ln_layout17){
            onCheck(b.lnLayout17);
            selectOne(Integer.parseInt(b.include15.code.getText().toString()));
        }else if(v.getId()==R.id.ln_layout19){
            onCheck(b.lnLayout19);
            selectOne(Integer.parseInt(b.include16.code.getText().toString()));
        }else if(v.getId()==R.id.ln_layout20){
            onCheck(b.lnLayout20);
            selectOne(Integer.parseInt(b.include17.code.getText().toString()));
        }else if(v.getId()==R.id.ln_layout21){
            onCheck(b.lnLayout21);
            selectOne(Integer.parseInt(b.include18.code.getText().toString()));
        }else if(v.getId()==R.id.ln_layout22){
            onCheck(b.lnLayout22);
            selectOne(Integer.parseInt(b.include19.code.getText().toString()));
        }else if(v.getId()==R.id.ln_layout23){
            onCheck(b.lnLayout23);
            selectOne(Integer.parseInt(b.include20.code.getText().toString()));
        }
    }

    //강의 정보 조회
    public void selectOne(int lecture_code){
        if(lecture_code != 0){
            commonMethod.setParams("lecture_code", lecture_code)
                    .sendPost("lecture_info", (isResult, data) -> {
                        LectureVO vo = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, LectureVO.class);
                        b.tvLectureName.setText(vo.getLecture_name());
                        b.tvRoomName.setText(vo.getRoom_code().substring(1)+"호");
                        b.tvTeacherName.setText(vo.getTeacher_name());
                        b.tvStartDate.setText(vo.getStartdate().toString());
                        b.tvCode.setText(vo.getLecture_code()+"");
                        b.cardDetail.setVisibility(View.VISIBLE);
                    });
        }else{
            b.cardDetail.setVisibility(View.GONE);
        }
    }


    //리스트 화면에 뿌리기
    public void setView(ArrayList<LectureVO> list){
        if(list != null){
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).getTimetable_code() == 1){
                    //강의 1교시
                    open1st();
                    setName(b.include1.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                    setName(b.include2.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                    setName(b.include3.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                    setName(b.include4.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                    setName(b.include5.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                }else if(list.get(i).getTimetable_code() == 2){
                    //2교시
                    open2st();
                    setName(b.include6.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                    setName(b.include7.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                    setName(b.include8.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                    setName(b.include9.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                    setName(b.include10.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                }else if(list.get(i).getTimetable_code() == 3){
                    //3교시
                    open3st();
                    setName(b.include11.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                    setName(b.include12.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                    setName(b.include13.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                    setName(b.include14.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                    setName(b.include15.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                }else if(list.get(i).getTimetable_code() == 4){
                    //4교시
                    open4st();
                    setName(b.include16.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                    setName(b.include17.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                    setName(b.include18.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                    setName(b.include19.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                    setName(b.include20.getRoot(), list.get(i).getLecture_name(), list.get(i).getLecture_code());
                }
            }
        }// list null 확인
    }

    //리니어 뷰 체크
    public void onCheck(View v){
        int gray = getResources().getColor(R.color.white2);
        int white = getResources().getColor(R.color.white);
        b.lnLayout1.setBackgroundColor(white);
        b.lnLayout2.setBackgroundColor(white);
        b.lnLayout3.setBackgroundColor(white);
        b.lnLayout4.setBackgroundColor(white);
        b.lnLayout5.setBackgroundColor(white);
        b.lnLayout7.setBackgroundColor(white);
        b.lnLayout8.setBackgroundColor(white);
        b.lnLayout9.setBackgroundColor(white);
        b.lnLayout10.setBackgroundColor(white);
        b.lnLayout11.setBackgroundColor(white);
        b.lnLayout13.setBackgroundColor(white);
        b.lnLayout14.setBackgroundColor(white);
        b.lnLayout15.setBackgroundColor(white);
        b.lnLayout16.setBackgroundColor(white);
        b.lnLayout17.setBackgroundColor(white);
        b.lnLayout19.setBackgroundColor(white);
        b.lnLayout20.setBackgroundColor(white);
        b.lnLayout21.setBackgroundColor(white);
        b.lnLayout22.setBackgroundColor(white);
        b.lnLayout23.setBackgroundColor(white);
        v.setBackgroundColor(gray);
    }

    //과목, 강의코드 입력
    public void setName(View v, String input_name, int lecture_code){
        name = v.findViewById(R.id.name);
        code = v.findViewById(R.id.code);
        name.setText(input_name);
        code.setText(lecture_code+"");
    }

    //1교시 전부 보이기
    public void open1st(){
        b.f1Data1.setVisibility(View.VISIBLE);
        b.f1Data2.setVisibility(View.VISIBLE);
        b.f1Data3.setVisibility(View.VISIBLE);
        b.f1Data4.setVisibility(View.VISIBLE);
        b.f1Data5.setVisibility(View.VISIBLE);
    }
    //2교시 전부 보이기
    public void open2st(){
        b.f2Data1.setVisibility(View.VISIBLE);
        b.f2Data2.setVisibility(View.VISIBLE);
        b.f2Data3.setVisibility(View.VISIBLE);
        b.f2Data4.setVisibility(View.VISIBLE);
        b.f2Data5.setVisibility(View.VISIBLE);
    }
    //3교시 전부 보이기
    public void open3st(){
        b.f3Data1.setVisibility(View.VISIBLE);
        b.f3Data2.setVisibility(View.VISIBLE);
        b.f3Data3.setVisibility(View.VISIBLE);
        b.f3Data4.setVisibility(View.VISIBLE);
        b.f3Data5.setVisibility(View.VISIBLE);
    }
    //4교시 전부 보이기
    public void open4st(){
        b.f4Data1.setVisibility(View.VISIBLE);
        b.f4Data2.setVisibility(View.VISIBLE);
        b.f4Data3.setVisibility(View.VISIBLE);
        b.f4Data4.setVisibility(View.VISIBLE);
        b.f4Data5.setVisibility(View.VISIBLE);
    }

    TextView getTextView(String data){
        TextView temp_tv = new TextView(this);
        temp_tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        temp_tv.setText(data);
        temp_tv.setTextColor(Color.BLACK);
        temp_tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, 44);
        return temp_tv;
    }//getTextView()

    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }
}