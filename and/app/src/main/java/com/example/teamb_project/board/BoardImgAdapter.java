package com.example.teamb_project.board;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.vo.BoardFileVO;

import java.util.List;

public class BoardImgAdapter extends RecyclerView.Adapter<BoardImgAdapter.ViewHolder>{
    LayoutInflater inflater;
    List<BoardFileVO> list;

    public BoardImgAdapter(LayoutInflater inflater, List<BoardFileVO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    @Override
    public long getItemId(int i){return i;}
    @Override
    public int getItemViewType(int i){return i;}

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(@NonNull View v) {
            super(v);
        }
    }
}
