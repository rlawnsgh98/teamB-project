package com.example.teamb_project.counselling;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;

import java.util.ArrayList;

public class CounselAdapter extends RecyclerView.Adapter<CounselAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<Object> list;

    public CounselAdapter(LayoutInflater inflater, ArrayList<Object> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_counsel, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

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

        public ViewHolder(@NonNull View v) {
            super(v);
        }
    }
}
