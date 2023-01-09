package com.example.teamb_project.teacher.board;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;
import com.example.teamb_project.vo.ReplyVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReplyAdapter extends RecyclerView.Adapter<ReplyAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<ReplyVO> list;

    public ReplyAdapter(LayoutInflater inflater, ArrayList<ReplyVO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_reply, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {

//        gson.toJson(list);
        h.writer.setText(list.get(i).getMember_name());
        h.content.setText(list.get(i).getContent());
        h.writedate.setText(list.get(i).getWritedate().toString());

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
        TextView writer, writedate, content;

        public ViewHolder(@NonNull View v) {
            super(v);
            writer = v.findViewById(R.id.tv_writer);
            writedate = v.findViewById(R.id.tv_writedate);
            content = v.findViewById(R.id.tv_content);
        }
    }
}
