package com.example.teamb_project.counselling;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;

import java.util.ArrayList;

public class CounselAdapter extends RecyclerView.Adapter<CounselAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<Object> list;
    Context context;

    public CounselAdapter(LayoutInflater inflater, ArrayList<Object> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_counsel, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {

        //특정 상담 클릭
        h.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(context, CounselDetailActivity.class);
                intent.putExtra("counsel_id", 1);   //클릭한 상담의 id값 필요!
                context.startActivity(intent);
            }
        });

        //상담 삭제
        h.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //삭제 알림 띄우기

            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }
    @Override
    public long getItemId(int i){return i;}
    @Override
    public int getItemViewType(int i){return i;}

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout detail;
        View state;
        TextView delete;

        public ViewHolder(@NonNull View v) {
            super(v);
            detail = v.findViewById(R.id.lin_counsel);
            state = v.findViewById(R.id.v_state);
            delete = v.findViewById(R.id.tv_delete);
        }
    }

    //삭제시 한번 묻기
    public void checkDelete(int id, Context context){    //<= 네를 누르면 바로 삭제처리
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("삭제")
                .setMessage("삭제하시겠습니까?")
                .setIcon(R.drawable.ic_launcher_foreground);

        builder.setPositiveButton("네", (dialog, which) -> {
            //네 누르면 실행
            new com.example.conn.CommonMethod().setParams("id", id)
                    .sendPost("delete.cu", (isResult, data) -> {
                        Log.d("log", "삭제 처리 : " + data);
                        //삭제 처리 메소드 호출
                    });
        });
        builder.setNegativeButton("아니오", (dialog, which) -> {
            //아니오 누르면 실행

        });
        builder.create().show();
    }

}
