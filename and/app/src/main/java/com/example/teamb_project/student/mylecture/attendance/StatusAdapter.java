package com.example.teamb_project.student.mylecture.attendance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;

import java.util.ArrayList;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.StatusViewHolder>{

    ArrayList<String> datList;

    public StatusAdapter(ArrayList<String> datList) {
        this.datList = datList;
    }

    @NonNull
    @Override
    public StatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View v = inflater.inflate(R.layout.fragment_status, parent, false);

        return new StatusViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StatusViewHolder holder, int position) {
        holder.datText.setText(datList.get(position));
    }

    @Override
    public int getItemCount() {
        return datList.size();
    }

    class StatusViewHolder extends RecyclerView.ViewHolder{
        TextView datText;
        public StatusViewHolder(@NonNull View v) {
            super(v);

            datText = v.findViewById(R.id.dayText);
        }
    }
}
