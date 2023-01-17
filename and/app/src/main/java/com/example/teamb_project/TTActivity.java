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
import com.example.teamb_project.vo.EnrolmentVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class TTActivity extends AppCompatActivity {
    Toolbar tt_toolbar;
    ArrayList<LinearLayout> linearLayouts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tt);
        getSupportActionBar().hide();

        tt_toolbar = findViewById(R.id.tt_toolbar);
        linearLayouts.add(findViewById(R.id.ln_layout0));
        linearLayouts.add(findViewById(R.id.ln_layout1));
        linearLayouts.add(findViewById(R.id.ln_layout2));
        linearLayouts.add(findViewById(R.id.ln_layout3));
        linearLayouts.add(findViewById(R.id.ln_layout4));
        linearLayouts.add(findViewById(R.id.ln_layout5));
        linearLayouts.add(findViewById(R.id.ln_layout6));
        linearLayouts.add(findViewById(R.id.ln_layout7));
        linearLayouts.add(findViewById(R.id.ln_layout8));
        linearLayouts.add(findViewById(R.id.ln_layout9));
        linearLayouts.add(findViewById(R.id.ln_layout10));
        linearLayouts.add(findViewById(R.id.ln_layout11));
        linearLayouts.add(findViewById(R.id.ln_layout12));
        linearLayouts.add(findViewById(R.id.ln_layout13));
        linearLayouts.add(findViewById(R.id.ln_layout14));
        linearLayouts.add(findViewById(R.id.ln_layout15));
        linearLayouts.add(findViewById(R.id.ln_layout16));
        linearLayouts.add(findViewById(R.id.ln_layout17));

        Common common = new Common();
        common.setTempLoginInfo();
        // 상단바
        tt_toolbar.setTitle(common.getLoginInfo().getMember_name()+"의 시간표");

        // 상단바 뒤로가기 버튼
        tt_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        // 타입 정보 출력
        Log.d("로그", "GET TYPE: "+common.getLoginInfo().getType());

        tt_toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                for (int i = 0; i < linearLayouts.size(); i++) {
                    linearLayouts.get(i).removeAllViews();
                }//for()
                if(item.getItemId() == R.id.tt_toolbar_reloading) {
                    if(common.getLoginInfo().getType().equals("STUD")){
                        // 회원 중 학생 일주일 시간표 출력
                        new CommonMethod().setParams("member_code",common.getLoginInfo().getMember_code())
                                .sendPost("st_ttlist.mj", new CommonMethod.CallBackResult() {
                                    @Override
                                    public void result(boolean isResult, String data) {
                                        printTTlist(data);
                                    }
                                });
                    }else if(common.getLoginInfo().getType().equals("TEACH")){
                        // 회원 중 선생 일주일 시간표 출력
                        new CommonMethod().setParams("teacher_code",common.getLoginInfo().getMember_code())
                                .sendPost("ttlist.mj", new CommonMethod.CallBackResult() {
                                    @Override
                                    public void result(boolean isResult, String data) {
                                        printTTlist(data);
                                    }
                                });
                    }
                    return true;
                }//if()
                return false;
            }
        });
    }//onCreate()

    TextView getTextView(String data){
        TextView temp_tv = new TextView(this);
        temp_tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        temp_tv.setText(data);
        temp_tv.setTextColor(Color.BLACK);
        temp_tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, 44);
        return temp_tv;
    }//getTextView()

    void printTTlist(String data){
        ArrayList<EnrolmentVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<EnrolmentVO>>() {}.getType());
        for(int k = 0; k < 3;k++) {
            linearLayouts.get((6*k)).addView(getTextView((k+1) + "교시"));
            for (int i = 0 ; i < list.size() ; i++){
                int index = 0+(6*k);
                if (list.get(i).getvDay().equals("월") && Integer.parseInt(list.get(i).getTimetable_code()) == k+1) {
                    index = 1+(6*k);
                } else if (list.get(i).getvDay().equals("화") && Integer.parseInt(list.get(i).getTimetable_code()) == k+1) {
                    index = 2+(6*k);
                } else if (list.get(i).getvDay().equals("수") && Integer.parseInt(list.get(i).getTimetable_code()) == k+1) {
                    index = 3+(6*k);
                } else if (list.get(i).getvDay().equals("목") && Integer.parseInt(list.get(i).getTimetable_code()) == k+1) {
                    index = 4+(6*k);
                } else if (list.get(i).getvDay().equals("금") && Integer.parseInt(list.get(i).getTimetable_code()) == k+1) {
                    index = 5+(6*k);
                } else {
                    continue;
                }
                linearLayouts.get(index).addView(
                        getTextView(list.get(i).getLecture_name() + "\n" + list.get(i).getRoom_name())
                );
            }//for()
        }//for()
    }//printTTlist()
}