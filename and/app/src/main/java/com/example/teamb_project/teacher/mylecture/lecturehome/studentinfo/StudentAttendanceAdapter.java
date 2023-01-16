package com.example.teamb_project.teacher.mylecture.lecturehome.studentinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;
import com.example.teamb_project.vo.AttendanceVO;

import java.util.ArrayList;

public class StudentAttendanceAdapter extends RecyclerView.Adapter<StudentAttendanceAdapter.ViewHolder> {

    LayoutInflater inflater;
    Context context;
    ArrayList<AttendanceVO> list;

    public StudentAttendanceAdapter(LayoutInflater inflater, Context context, ArrayList<AttendanceVO> list) {
        this.inflater = inflater;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_student_attendance, parent, false);
        StudentAttendanceAdapter.ViewHolder viewHolder = new StudentAttendanceAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        final int idx = i;
        h.tv_attendance_date.setText(list.get(idx).getAttendance_time().toString());
        h.tv_week.setText(list.get(idx).getWeek());
        if(list.get(idx).getState().equals("OK")){
            h.tv_state.setText("출석");
        }else if(list.get(idx).getState().equals("NO")){
            h.tv_state.setText("결석");
        }else if(list.get(idx).getState().equals("HF")){
            h.tv_state.setText("조퇴");
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_attendance_date, tv_week, tv_state;
        public ViewHolder(@NonNull View v) {
            super(v);
            tv_attendance_date = v.findViewById(R.id.tv_attendance_date);
            tv_week = v.findViewById(R.id.tv_week);
            tv_state = v.findViewById(R.id.tv_state);
        }
    }
}
