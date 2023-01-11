package com.example.teamb_project.student.chulhuyn;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;

import java.util.ArrayList;

public class CalendarAdapter extends  RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>{
    LayoutInflater inflater;
    ArrayList<String> datList;

    public CalendarAdapter(LayoutInflater inflater, ArrayList<String> datList) {
        this.inflater = inflater;
        this.datList = datList;
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.calendar_cell, parent, false);
        return new CalendarViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        holder.dayText.setText(datList.get(position));
        String day = datList.get(position);

        if( (position + 1) % 7 == 0){ //토요일 파랑
            holder.dayText.setTextColor(Color.BLUE);
        }else if( position == 0 || position % 7 == 0){//일요일 빨강
            holder.dayText.setTextColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        return datList.size();
    }

    class CalendarViewHolder extends RecyclerView.ViewHolder {
        TextView dayText;
        public CalendarViewHolder(@NonNull View v) {
            super(v);

            dayText = v.findViewById(R.id.dayText);
        }
    }
}
