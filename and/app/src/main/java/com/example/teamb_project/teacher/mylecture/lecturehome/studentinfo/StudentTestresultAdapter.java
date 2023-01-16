package com.example.teamb_project.teacher.mylecture.lecturehome.studentinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;
import com.example.teamb_project.vo.ExamVO;

import java.util.ArrayList;

public class StudentTestresultAdapter extends RecyclerView.Adapter<StudentTestresultAdapter.ViewHolder> {

    LayoutInflater inflater;
    Context context;
    ArrayList<ExamVO> list;

    public StudentTestresultAdapter(LayoutInflater inflater, Context context, ArrayList<ExamVO> list) {
        this.inflater = inflater;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_student_testresult, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        final int idx = i;
        h.tv_lecture_title.setText(list.get(idx).getExam_title());
        h.tv_score.setText(list.get(idx).getTotal_score() + "점");

       }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_lecture_title, tv_score;

        public ViewHolder(@NonNull View v) {
            super(v);
            tv_lecture_title = v.findViewById(R.id.tv_lecture_title);
            tv_score = v.findViewById(R.id.tv_score);
        }
    }
}
