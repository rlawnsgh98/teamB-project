package com.example.teamb_project.teacher.mylecture.lecturehome.studentinfo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;
import com.example.teamb_project.vo.HomeworkVO;

import java.util.ArrayList;

public class StudentHomeworkAdapter extends RecyclerView.Adapter<StudentHomeworkAdapter.ViewHolder> {

    LayoutInflater inflater;
    Context context;
    ArrayList<HomeworkVO> list;

    public StudentHomeworkAdapter(LayoutInflater inflater, Context context, ArrayList<HomeworkVO> list) {
        this.inflater = inflater;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_student_homework, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        final int idx = i;
        h.tv_homework_title.setText(list.get(idx).getTitle());
        h.tv_homework_writedate.setText(list.get(idx).getWritedate().toString());
        h.tv_homework_duedate.setText(list.get(idx).getDuedate().toString());
        if(list.get(idx).getState()==1){
            h.tv_state.setText("제출");
            h.tv_state.setTextColor(Color.parseColor("#0D2135"));
        }else if(list.get(idx).getState()==0){
            h.tv_state.setText("미제출");
            h.tv_state.setTextColor(Color.parseColor("#ff0000"));

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_homework_title, tv_homework_writedate, tv_homework_duedate, tv_state;
        public ViewHolder(@NonNull View v) {
            super(v);
            tv_homework_title = v.findViewById(R.id.tv_homework_title);
            tv_homework_writedate = v.findViewById(R.id.tv_homework_writedate);
            tv_homework_duedate = v.findViewById(R.id.tv_homework_duedate);
            tv_state = v.findViewById(R.id.tv_state);

        }
    }
}
