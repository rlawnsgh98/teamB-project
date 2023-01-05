package com.example.lms_kmj.tt_recv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lms_kmj.R;

public class TTAdapter extends RecyclerView.Adapter<TTAdapter.ViewHolder>{
    LayoutInflater inflater;

    public TTAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
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
        holder.tt_recv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.tt_recv_date.setText("-월 -일 (-)");
        holder.tt_recv_time.setText("-:-- ~ -:--");
        holder.tt_recv_content.setText("쉽니다-- -- --");
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tt_recv_date, tt_recv_time, tt_recv_content;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tt_recv_date = itemView.findViewById(R.id.tt_recv_date);
            tt_recv_time = itemView.findViewById(R.id.tt_recv_time);
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
