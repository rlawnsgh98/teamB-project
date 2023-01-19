package com.example.teamb_project.board;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.vo.ReplyVO;

import java.util.ArrayList;

public class ReplyAdapter extends RecyclerView.Adapter<ReplyAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<ReplyVO> list;
    BoardDetailActivity activity;

    public ReplyAdapter(LayoutInflater inflater, ArrayList<ReplyVO> list, BoardDetailActivity activity) {
        this.inflater = inflater;
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_reply, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        CommonMethod commonMethod = new CommonMethod();
        Common common = new Common();

        h.writer.setText(list.get(i).getMember_name());
        h.content.setText(list.get(i).getContent());
        h.writedate.setText(list.get(i).getWritedate().toString());
        h.lin_modify_delete.setVisibility(View.GONE);

        Log.d("log", "로그인 정보 member code : "+common.getLoginInfo().getMember_code());
        h.writer.setOnClickListener(v -> {

        });

        //로그인 정보 일치할때만 수정/삭제 보이기
        if( common.getLoginInfo().getMember_code().equals(list.get(i).getWriter()+"") ){
            h.lin_modify_delete.setVisibility(View.VISIBLE);
        }

        //삭제
        h.delete.setOnClickListener(v -> {
            commonMethod.setParams("reply_code", list.get(i).getReply_code())
                    .sendPost("delete.re", (isResult, data) -> {
                        Log.d("log", "댓글 삭제 결과 : " + data);
                        activity.selectList();
                        //새로고침
//                        common.refresh(activity);
//                        this.notifyDataSetChanged();
                    });
        });

        //수정
        h.modify.setOnClickListener(v -> {
            //TextView 안보이게, EditText 보이게
            h.content.setVisibility(View.GONE);
            h.edt_content.setVisibility(View.VISIBLE);
            h.edt_content.setText(h.content.getText().toString());
            h.edt_content.requestFocus();

            common.showKeyBoard(activity, h.edt_content);
        });

        //입력칸 변화시 전송 버튼 보이게
        h.edt_content.addTextChangedListener(common.getTextWatcher(h.send));

        //수정 전송
        h.send.setOnClickListener(v -> {
            commonMethod.setParams("reply_code", list.get(i).getReply_code())
                    .setParams("content", h.edt_content.getText().toString())
                    .sendPost("update.re", (isResult, data) -> {
                        Log.d("log", "댓글 update 결과 : " + data);
                        //새로고침
//                        common.refresh(activity);
                    });
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
        TextView writer, writedate, content, modify, delete;
        LinearLayout item, lin_modify_delete;
        EditText edt_content;
        ImageView send;

        public ViewHolder(@NonNull View v) {
            super(v);
            writer = v.findViewById(R.id.tv_writer);
            writedate = v.findViewById(R.id.tv_writedate);
            content = v.findViewById(R.id.tv_content);
            modify = v.findViewById(R.id.tv_modify);
            delete = v.findViewById(R.id.tv_delete);
            item = v.findViewById(R.id.lin_item_reply);
            edt_content = v.findViewById(R.id.edt_content);
            send = v.findViewById(R.id.iv_send);
            lin_modify_delete = v.findViewById(R.id.lin_modify_delete);
        }
    }
}
