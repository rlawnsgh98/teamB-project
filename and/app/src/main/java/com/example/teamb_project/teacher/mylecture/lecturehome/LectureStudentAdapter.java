package com.example.teamb_project.teacher.mylecture.lecturehome;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;
import com.example.teamb_project.teacher.mylecture.lecturehome.studentinfo.StudentDetailActivity;
import com.example.teamb_project.vo.LectureVO;
import com.example.teamb_project.vo.MemberVO;

import java.util.ArrayList;

public class LectureStudentAdapter extends RecyclerView.Adapter<LectureStudentAdapter.ViewHolder> {

    LayoutInflater inflater;
    Context context;
    ArrayList<MemberVO> list = null;



    public LectureStudentAdapter(LayoutInflater inflater, Context context,ArrayList<MemberVO> list) {
        this.inflater = inflater;
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_student, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        final int idx = i;
        h.tv_student_name.setText(list.get(idx).getMember_name());

        h.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, StudentDetailActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_student_name;
        public ViewHolder(@NonNull View v) {
            super(v);
            tv_student_name = v.findViewById(R.id.tv_student_name);
        }
    }
    public void setItems(ArrayList<MemberVO> list){
        this.list = list;
        notifyDataSetChanged();
    }
}
