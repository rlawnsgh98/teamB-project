package com.example.teamb_project.teacher.board;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;
import com.example.teamb_project.vo.BoardVO;

import java.util.ArrayList;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<BoardVO> list;
    Context context;

    public BoardAdapter(LayoutInflater inflater, ArrayList<BoardVO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_board, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {

        h.id.setText(list.get(i).getBoard_code());
        h.title.setText(list.get(i).getTitle());
        h.writedate.setText(list.get(i).getWritedate().toString());

        //특정 게시글 클릭시 해당 게시글 상세 Act 이동
        h.board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BoardDetailActivity.class);
                //intent 에 해당 게시글 id 값 담기
                context.startActivity(intent);
            }
        });

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
        LinearLayout board;
        TextView id, title, writer, writedate;

        public ViewHolder(@NonNull View v) {
            super(v);

            board = v.findViewById(R.id.lin_board);
            id = v.findViewById(R.id.tv_id);
            writer = v.findViewById(R.id.tv_writer);
            title = v.findViewById(R.id.tv_title);
            writedate = v.findViewById(R.id.tv_writedate);

        }
    }
}
