package com.example.teamb_project.teacher.mylecture;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;
import com.example.teamb_project.teacher.mylecture.lecturehome.LectureDetailActivity;
import com.example.teamb_project.vo.LectureVO;

import java.util.ArrayList;

public class MyLectureAdapter extends RecyclerView.Adapter<MyLectureAdapter.ViewHolder> {

    LayoutInflater inflater;
    Context context;
    ArrayList<LectureVO> list;

    public MyLectureAdapter(LayoutInflater inflater, Context context,ArrayList<LectureVO> list) {
        this.inflater = inflater;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_my_lecture, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        final int idx = i;
        h.tv_lecture_title.setText(list.get(idx).getLecture_name());
        h.tv_teacher_name.setText(list.get(idx).getTimetable_name());
        h.tv_room.setText(list.get(idx).getRoom_code().substring(1)+"호");
        h.tv_cnt.setText(" / "+list.get(idx).getStudent_cnt() + "명");

        h.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LectureDetailActivity.class);
                intent.putExtra("lecture_code", list.get(idx).getLecture_code());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_lecture_title, tv_room, tv_teacher_name, tv_cnt;

        public ViewHolder(@NonNull View v) {
            super(v);
            tv_lecture_title = v.findViewById(R.id.tv_lecture_title);
            tv_room = v.findViewById(R.id.tv_room);
            tv_teacher_name = v.findViewById(R.id.tv_teacher_name);
            tv_cnt = v.findViewById(R.id.tv_cnt);
        }
    }
}
