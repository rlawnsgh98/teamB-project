package com.example.teamb_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.vo.BoardVO;

import java.util.ArrayList;

public class TTAdapter extends RecyclerView.Adapter<TTAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<BoardVO> aclist;

    public TTAdapter(LayoutInflater inflater, ArrayList<BoardVO> aclist) {
        this.inflater = inflater;
        this.aclist = aclist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_tt_recv, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tt_recv_date.setText(aclist.get(position).getWritedate().toString());
        holder.tt_recv_content.setText(aclist.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return (null != aclist ? aclist.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tt_recv_date, tt_recv_content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tt_recv_date = itemView.findViewById(R.id.tt_recv_date);
            tt_recv_content = itemView.findViewById(R.id.tt_recv_content);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
