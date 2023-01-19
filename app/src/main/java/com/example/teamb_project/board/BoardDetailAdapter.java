package com.example.teamb_project.board;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.teamb_project.R;
import com.example.teamb_project.vo.BoardFileVO;

import java.util.List;

public class BoardDetailAdapter extends RecyclerView.Adapter<BoardDetailAdapter.ViewHolder>{
    LayoutInflater inflater;
    List<BoardFileVO> list;
    Context context;

    public BoardDetailAdapter(LayoutInflater inflater, List<BoardFileVO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_board_img, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {

        String name = list.get(i).getFile_name().toLowerCase();
//        Log.d("log", "file_name : " + name);
        if(name.contains("jpg") || name.contains("png")){
            Log.d("log", "이미지 Glide");
            Glide.with(context).load(list.get(i).getPath()).into(h.img);
        }else{
            h.img.setVisibility(View.GONE);
        }

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
        ImageView img;
        public ViewHolder(@NonNull View v) {
            super(v);
            img = v.findViewById(R.id.iv_img);
        }
    }
}
