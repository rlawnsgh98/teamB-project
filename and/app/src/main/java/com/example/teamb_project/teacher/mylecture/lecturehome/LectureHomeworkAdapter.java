package com.example.teamb_project.teacher.mylecture.lecturehome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.vo.HomeworkSubmitVO;
import com.example.teamb_project.vo.HomeworkVO;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class LectureHomeworkAdapter extends RecyclerView.Adapter<LectureHomeworkAdapter.ViewHolder> {
    LayoutInflater inflater;
    Context context;
    ArrayList<HomeworkVO> list;
    HomeworkSubmitVO vo;

    public LectureHomeworkAdapter(LayoutInflater inflater, Context context, ArrayList<HomeworkVO> list) {
        this.inflater = inflater;
        this.context = context;
        this.list = list;
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
        final int idx = i;
        h.tv_title.setText(list.get(idx).getTitle());
        h.tv_writedate.setText(list.get(idx).getWritedate().toString());
        h.tv_duedate.setText(list.get(idx).getDuedate().toString());


        h.lin_view_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(h.lin_detail.getVisibility() == View.GONE){
                    //닫혀있는 상태
                    h.lin_detail.setVisibility(View.VISIBLE);
                    new CommonMethod().setParams("homework_code", list.get(idx).getHomework_code())
                            .sendPost("homework_subcnt.le", new CommonMethod.CallBackResult() {
                                @Override
                                public void result(boolean isResult, String data) {
                                    vo = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<HomeworkSubmitVO>(){}.getType());
                                    h.tv_subcnt.setText(vo.getSubcnt()+"명");
                                    h.tv_notcnt.setText(vo.getNotcnt()+"명");
                                }
                            });


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
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout lin_detail, lin_view_detail, lin_homework_sub, lin_homework_nosub;
        TextView tv_title, tv_writedate, tv_duedate, tv_subcnt, tv_notcnt;

        public ViewHolder(@NonNull View v) {
            super(v);
            tv_title = v.findViewById(R.id.tv_title);
            tv_writedate = v.findViewById(R.id.tv_writedate);
            tv_duedate = v.findViewById(R.id.tv_duedate);

            tv_subcnt=v.findViewById(R.id.tv_subcnt);
            tv_notcnt=v.findViewById(R.id.tv_notcnt);

            lin_detail = v.findViewById(R.id.lin_detail);
            lin_view_detail = v.findViewById(R.id.lin_view_detail);
            lin_homework_sub = v.findViewById(R.id.lin_homework_sub);
            lin_homework_nosub = v.findViewById(R.id.lin_homework_nosub);
        }
    }

}
