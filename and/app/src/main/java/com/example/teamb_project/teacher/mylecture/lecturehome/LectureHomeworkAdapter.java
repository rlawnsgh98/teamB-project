package com.example.teamb_project.teacher.mylecture.lecturehome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;

public class LectureHomeworkAdapter extends RecyclerView.Adapter<LectureHomeworkAdapter.ViewHolder> {
    LayoutInflater inflater;
    Context context;

    public LectureHomeworkAdapter(LayoutInflater inflater, Context context) {
        this.inflater = inflater;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_lecture_homework_check, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.lin_view_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(h.lin_detail.getVisibility() == View.GONE){
                    //닫혀있는 상태
                    h.lin_detail.setVisibility(View.VISIBLE);
                }else{
                    //열려있던 상태
                    h.lin_detail.setVisibility(View.GONE);
                }
            }
        });
        //선택하면 제출자 명단
        h.lin_homework_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "제출", Toast.LENGTH_SHORT).show();
            }
        });
        //선택하면 미제출자 명단
        h.lin_homework_nosub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "미제출", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout lin_detail, lin_view_detail, lin_homework_sub, lin_homework_nosub;
        public ViewHolder(@NonNull View v) {
            super(v);
            lin_detail = v.findViewById(R.id.lin_detail);
            lin_view_detail = v.findViewById(R.id.lin_view_detail);
            lin_homework_sub = v.findViewById(R.id.lin_homework_sub);
            lin_homework_nosub = v.findViewById(R.id.lin_homework_nosub);
        }
    }

}
