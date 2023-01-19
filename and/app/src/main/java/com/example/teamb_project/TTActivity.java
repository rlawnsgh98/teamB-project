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
import com.example.teamb_project.vo.EnrolmentVO;
import com.example.teamb_project.vo.LectureVO;
import com.example.teamb_project.vo.MemberVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class TTActivity extends AppCompatActivity {
    ArrayList<LinearLayout> linearLayouts = new ArrayList<>();
    ActivityTtBinding b;
    final String TAG = "log";
    Common common = new Common();
    CommonMethod commonMethod = new CommonMethod();
    TextView name, room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityTtBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        MemberVO vo = Common.loginInfo;

        //학생 조회
        if(Common.loginInfo.getType().equals("STUD")){
            commonMethod.setParams("vo", new Gson().toJson(Common.loginInfo))
                    .sendPost("student_timetable",(isResult, data) -> {
                        ArrayList<LectureVO> list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<LectureVO>>(){}.getType());
                        setView(list);
                    });
        }else if(Common.loginInfo.getType().equals("TEACH")){
            commonMethod.setParams("vo", new Gson().toJson(Common.loginInfo))
                    .sendPost("teacher_timetable", (isResult, data) -> {
                        ArrayList<LectureVO> list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<LectureVO>>(){}.getType());
                        setView(list);
                    });
        }



    }//onCreate()

    //리스트 화면에 뿌리기
    public void setView(ArrayList<LectureVO> list){
        if(list != null){
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).getTimetable_code() == 1){
                    //가져온 강의가 1교시일때
                    open1st();
                    setName(b.include1.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                    setName(b.include2.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                    setName(b.include3.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                    setName(b.include4.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                    setName(b.include5.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                }else if(list.get(i).getTimetable_code() == 2){
                    //2교시
                    open2st();
                    setName(b.include6.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                    setName(b.include7.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                    setName(b.include8.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                    setName(b.include9.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                    setName(b.include10.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                }else if(list.get(i).getTimetable_code() == 3){
                    //3교시
                    open3st();
                    setName(b.include11.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                    setName(b.include12.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                    setName(b.include13.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                    setName(b.include14.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                    setName(b.include15.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                }else if(list.get(i).getTimetable_code() == 4){
                    //4교시
                    open4st();
                    setName(b.include16.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                    setName(b.include17.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                    setName(b.include18.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                    setName(b.include19.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                    setName(b.include20.getRoot(), list.get(i).getLecture_name(), list.get(i).getRoom_code());
                }
            }
        }// list null 확인
    }

    //과목, 교실 입력
    public void setName(View v, String input_name, String input_room){
        name = v.findViewById(R.id.name);
        room = v.findViewById(R.id.room);
        name.setText(input_name);
        room.setText(input_room);
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

}