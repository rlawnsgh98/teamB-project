package com.example.teamb_project.teacher.board;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.teamb_project.R;
import com.example.teamb_project.vo.BoardFileVO;

import java.util.ArrayList;

public class NewBoardAdapter extends RecyclerView.Adapter<NewBoardAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<BoardFileVO> list;
    Context context;

    public NewBoardAdapter(LayoutInflater inflater, ArrayList<BoardFileVO> list, Context context) {
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

        Glide.with(context).load( list.get(i).getFilepath() ).into(h.img);

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
