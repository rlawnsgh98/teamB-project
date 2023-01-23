package com.example.teamb_project.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.student.mylecture.lecturehome.Stu_LectureDetailActivity;
import com.example.teamb_project.teacher.mylecture.lecturehome.LectureDetailActivity;
import com.example.teamb_project.vo.LectureVO;

import java.util.ArrayList;

public class HomeLectureAdapter extends RecyclerView.Adapter<HomeLectureAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<LectureVO> list;
    Activity activity;

    public HomeLectureAdapter(LayoutInflater inflater, ArrayList<LectureVO> list, Activity activity) {
        this.inflater = inflater;
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_popular_courses, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {

        if(list.get(i).getSubject_code().equals("MATH")){
            h.img.setImageResource(R.drawable.math);
        }else if(list.get(i).getSubject_code().equals("KOR")){
            h.img.setImageResource(R.drawable.kor);
        }else if(list.get(i).getSubject_code().equals("ENG")){
            h.img.setImageResource(R.drawable.eng);
        }
        h.title.setText(list.get(i).getLecture_name());

        //강의 상세 화면 이동
        h.lecture.setOnClickListener(v -> {
            Activity toAct = null;
            if(Common.loginInfo.getType().equals("STUD")) toAct = new Stu_LectureDetailActivity();
            else toAct = new LectureDetailActivity();
            Intent intent = new Intent(activity, toAct.getClass());
            intent.putExtra("lecture_code", list.get(i).getLecture_code());
            activity.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        if(list == null) return 0;
        return list.size();
    }
    @Override
    public long getItemId(int i){return i;}
    @Override
    public int getItemViewType(int i){return i;}

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView img;
        CardView lecture;

        public ViewHolder(@NonNull View v) {
            super(v);
            title = v.findViewById(R.id.tv_title);
            img = v.findViewById(R.id.iv_lecture);
            lecture = v.findViewById(R.id.card_lecture);
        }
    }
}
