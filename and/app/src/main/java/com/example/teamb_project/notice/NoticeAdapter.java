package com.example.teamb_project.notice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;
import com.example.teamb_project.vo.BoardVO;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<BoardVO> list;

    public NoticeAdapter(LayoutInflater inflater, ArrayList<BoardVO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_notice, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        final int idx = i;
        h.tv_notice_title.setText(list.get(idx).getTitle());
        h.tv_notice_writedate.setText(list.get(idx).getWritedate().toString());
        h.tv_notice_content.setText(list.get(idx).getContent());

        //공지사항 자세히보기 클릭
        h.view_detail.setOnClickListener(new View.OnClickListener() {
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
        return list.size();
    }
    @Override
    public long getItemId(int i){return i;}
    @Override
    public int getItemViewType(int i){return i;}

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView arrow;
        LinearLayout detail, view_detail;
        TextView tv_notice_title, tv_notice_writedate, tv_notice_content;
        public ViewHolder(@NonNull View v) {
            super(v);
            arrow = v.findViewById(R.id.iv_drop_down);
            detail = v.findViewById(R.id.lin_detail);
            view_detail = v.findViewById(R.id.lin_view_detail);

            tv_notice_title = v.findViewById(R.id.tv_notice_title);
            tv_notice_writedate = v.findViewById(R.id.tv_notice_writedate);
            tv_notice_content = v.findViewById(R.id.tv_notice_content);
        }
    }
}
