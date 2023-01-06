package com.example.teamb_project.student.mylecture.lecturehome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;
import com.example.teamb_project.teacher.mylecture.lecturehome.LectureHomeAdapter;

public class stu_LectureHomeAdapter extends RecyclerView.Adapter<stu_LectureHomeAdapter.ViewHolder> {
    LayoutInflater inflater;
    Context context;

    public stu_LectureHomeAdapter(LayoutInflater inflater, Context context) {
        this.inflater = inflater;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_lecture_notice, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(h.detail.getVisibility() == View.GONE){
                    //닫혀있는 상태
                    h.arrow.setRotationX(180);
                    h.detail.setVisibility(View.VISIBLE);
                }else{
                    //열려있던 상태
                    h.arrow.setRotationX(0);
                    h.detail.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView arrow;
        LinearLayout detail, view_detail;
        public ViewHolder(@NonNull View v) {
            super(v);
            arrow = v.findViewById(R.id.iv_drop_down);
            detail = v.findViewById(R.id.lin_detail);
            view_detail = v.findViewById(R.id.lin_view_detail);
        }
    }

}
