package com.example.teamb_project.student.chulhuyn;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.teamb_project.R;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class ChulFragment extends Fragment {

    TextView monText;
    LocalDate selectDate;

    RecyclerView recyclerView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chul, container, false);
        //초기화
        monText = v.findViewById(R.id.monthText);
        ImageButton left = v.findViewById(R.id.ic_left);
        ImageButton ic_right = v.findViewById(R.id.ic_right);
        recyclerView = v.findViewById(R.id.calendar);
        //현재날짜
        selectDate = LocalDate.now();
        //화면설정
        setMonthView();
        //이전 달 버튼
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate = selectDate.minusMonths(1);
                setMonthView();
            }
        });
        //다음 달 버튼
        ic_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate = selectDate.plusMonths(1);
                setMonthView();
            }
        });

        return v;
    }
    //날짜 타입 설정
    @RequiresApi(api = Build.VERSION_CODES.O)
    private  String monthFromDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월");
        return date.format(formatter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setMonthView() {
        monText.setText(monthFromDate(selectDate));
        ArrayList<String> daylist = days(selectDate);
        CalendarAdapter adapter = new CalendarAdapter(getLayoutInflater(), daylist);

        RecyclerView.LayoutManager manager = new GridLayoutManager(getContext(), 7);

        recyclerView.setLayoutManager(manager);

        recyclerView.setAdapter(adapter);
    }

    //날짜 생성 메서드
    @RequiresApi(api = Build.VERSION_CODES.O)
    private ArrayList<String> days(LocalDate date) {
        ArrayList<String> dayList = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(date);
        //해당 월 마지막 날짜 가져오기
        int lastDay = yearMonth.lengthOfMonth();

        //해당 월의 첫번째 날 가져오기
        LocalDate firstDay = selectDate.withDayOfMonth(1);
        //첫번째 날 요일 가져오기
        int dayOfWeek = firstDay.getDayOfWeek().getValue();

        for (int i =1; i <45; i++){
            if (i <= dayOfWeek || i > lastDay + dayOfWeek){
                dayList.add("");
            }else{
                dayList.add(String.valueOf(i - dayOfWeek));
            }
        }

        return dayList;
    }


}