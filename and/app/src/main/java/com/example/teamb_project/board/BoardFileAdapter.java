package com.example.teamb_project.board;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;
import com.example.teamb_project.vo.BoardFileVO;

import java.util.List;

public class BoardFileAdapter extends RecyclerView.Adapter<BoardFileAdapter.ViewHolder>{
    LayoutInflater inflater;
    List<BoardFileVO> list;

    public BoardFileAdapter(LayoutInflater inflater, List<BoardFileVO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_attached_file, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {

        h.fileName.setText(list.get(i).getFile_name());


        Log.d("log", "onBindViewHolder: ");
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
        TextView fileName;
        public ViewHolder(@NonNull View v) {
            super(v);
            fileName = v.findViewById(R.id.tv_file_name);
        }
    }
}
