package com.example.teamb_project.drawer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conn.CommonMethod;

import com.example.teamb_project.R;
import com.example.teamb_project.TTAdapter;
import com.example.teamb_project.vo.BoardVO;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class AcCalendarActivity extends AppCompatActivity {
    Toolbar top_toolbar;
    RecyclerView tt_recv_list;
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_calendar);
        getSupportActionBar().hide();

        top_toolbar = findViewById(R.id.top_toolbar);
        tt_recv_list = findViewById(R.id.tt_recv_list);

        // 상단바
        top_toolbar.setTitle("학원 일정");

        // 상단바 뒤로가기 버튼
        top_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // 캘린더
        calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Log.d("로그", "year: " + year);
                Log.d("로그", "month: " + (month+1));
                Log.d("로그", "dayOfMonth: " + dayOfMonth);
                String writedate = "";
                if(month<10 && dayOfMonth<10){
                    writedate = year+"-"+"0"+(month+1)+"-"+"0"+dayOfMonth;
                }else{
                    writedate = year+"-"+(month+1)+"-"+dayOfMonth;
                }
                Log.d("로그", "writedate: "+writedate);
                new CommonMethod().setParams("writedate",writedate)
                        .sendPost("aclist.mj", new CommonMethod.CallBackResult() {
                            @Override
                            public void result(boolean isResult, String data) {
                                //ArrayList<BoardVO> aclist = new Gson().fromJson(data, new TypeToken<ArrayList<BoardVO>>(){}.getType());
                                ArrayList<BoardVO> aclist = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<BoardVO>>(){}.getType());
                                Log.d("로그", "aclist: "+aclist);
                                //Log.d("로그", "getWritedate: "+aclist.get(1).getWritedate());
                                if(aclist != null) {
                                    tt_recv_list.setAdapter(new TTAdapter(getLayoutInflater(), aclist));
                                    tt_recv_list.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
                                }
                            }
                        });
            }
        });
    }//onCreate()
}