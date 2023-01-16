package com.example.teamb_project.teacher.mylecture.lecturehome.studentinfo;

import android.os.Build;
import android.os.Bundle;


import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.vo.AttendanceVO;
import com.example.teamb_project.vo.MemberVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class StudentAttendanceFragment extends Fragment {
    int lecture_code;
    String member_code;
    AttendanceVO vo;
    TextView tv_ok, tv_no, tv_hf;
    String year, month, start, end;

    RecyclerView recv_attendance_detail;
    ArrayList<AttendanceVO> list;

    public StudentAttendanceFragment(String member_code, int lecture_code) {
        this.member_code = member_code;
        this.lecture_code = lecture_code;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_student_attendance, container, false);


        // Spinner
        Spinner yearSpinner = (Spinner)v.findViewById(R.id.spinner_year);
        ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(getContext(), R.array.date_year, android.R.layout.simple_spinner_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);

        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                year = yearSpinner.getSelectedItem().toString();
                start = year+month+ "01";
                YearMonth yearMonth = YearMonth.from(LocalDate.parse(start, DateTimeFormatter.ofPattern("yyyyMMdd")));
                end= yearMonth.atEndOfMonth().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
                selectAttendanceList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner monthSpinner = (Spinner)v.findViewById(R.id.spinner_month);
        ArrayAdapter monthAdapter = ArrayAdapter.createFromResource(getContext(), R.array.date_month, android.R.layout.simple_spinner_item);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(monthAdapter);

        monthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                month = monthSpinner.getSelectedItem().toString();
                start = year+month+ "01";
                YearMonth yearMonth = YearMonth.from(LocalDate.parse(start, DateTimeFormatter.ofPattern("yyyyMMdd")));
                end= yearMonth.atEndOfMonth().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
                selectAttendanceList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        year = yearSpinner.getSelectedItem().toString();
        month = monthSpinner.getSelectedItem().toString();
        start = year+month+ "01";
        YearMonth yearMonth = YearMonth.from(LocalDate.parse(start, DateTimeFormatter.ofPattern("yyyyMMdd")));
        end= yearMonth.atEndOfMonth().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        recv_attendance_detail=v.findViewById(R.id.recv_attendance_detail);
        tv_ok = v.findViewById(R.id.tv_ok);
        tv_no = v.findViewById(R.id.tv_no);
        tv_hf = v.findViewById(R.id.tv_hf);

        selectAttendance();
        selectAttendanceList();
        return v;
    }

    void selectAttendance(){
        new CommonMethod().setParams("lecture_code", lecture_code)
                .setParams("member_code", member_code)
                .sendPost("student_attendance.le", new CommonMethod.CallBackResult() {
                    @Override
                    public void result(boolean isResult, String data) {
                        vo = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<AttendanceVO>(){}.getType());
                        tv_ok.setText(vo.getOk());
                        tv_no.setText(vo.getNo());
                        tv_hf.setText(vo.getHf());
                    }
                });
    }
    void selectAttendanceList(){
        new CommonMethod().setParams("lecture_code", lecture_code)
                .setParams("member_code", member_code)
                .setParams("start", start)
                .setParams("end", end)
                .sendPost("student_attendance_detail.le", new CommonMethod.CallBackResult() {
                    @Override
                    public void result(boolean isResult, String data) {
                        list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<AttendanceVO>>(){}.getType());

                        recv_attendance_detail.setAdapter(new StudentAttendanceAdapter(getLayoutInflater(), getContext(), list));
                        recv_attendance_detail.setLayoutManager(com.example.teamb_project.common.CommonMethod.getManager(getContext()));

                    }
                });
    }
}