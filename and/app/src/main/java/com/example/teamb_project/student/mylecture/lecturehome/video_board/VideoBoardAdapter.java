package com.example.teamb_project.student.mylecture.lecturehome.video_board;

import android.content.Context;
import android.content.Intent;
<<<<<<< HEAD
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
=======
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
>>>>>>> main
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

<<<<<<< HEAD
import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.vo.BoardVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
=======
import com.example.teamb_project.R;
import com.example.teamb_project.vo.BoardVO;
>>>>>>> main

import java.util.ArrayList;

public class VideoBoardAdapter extends RecyclerView.Adapter<VideoBoardAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<BoardVO> list;
    Context context;
<<<<<<< HEAD
    CommonMethod commonMethod = new CommonMethod();
=======
>>>>>>> main

    public VideoBoardAdapter(LayoutInflater inflater, ArrayList<BoardVO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_video_board, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
<<<<<<< HEAD
        //기본정보
        h.tv_date.setText(list.get(i).getWritedate().toString());
        h.tv_name.setText(list.get(i).getMember_name());
        h.tv_title.setText(list.get(i).getTitle());

        //썸네일
        commonMethod.setParams("board_code", list.get(i).getBoard_code())
                .sendPost("selectVideo", (isResult, data) -> {
                    ArrayList<String> path_list = new Gson().fromJson(data, new TypeToken<ArrayList<String>>(){}.getType()); // TypeToken -> Gson import
                    String path = path_list.get(0);
                    Bitmap bitmap = ThumbnailUtils.createVideoThumbnail(path, MediaStore.Video.Thumbnails.FULL_SCREEN_KIND);
                    Bitmap thumbnail = ThumbnailUtils.extractThumbnail(bitmap, 300, 300);
                    h.thumbnail.setImageBitmap(thumbnail);
                });

        //특정 강의영상 클릭
        h.video.setOnClickListener(v -> {
            Log.d("log", "강의영상 code : " + list.get(i).getBoard_code());
            Intent intent = new Intent(context, VideoDetailActivity.class);
            intent.putExtra("board_code", list.get(i).getBoard_code());
            context.startActivity(intent);
=======
        final int idx = i;
        //h.tv_title.setText(list.get(idx).getTitle());

        h.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VideoDetailActivity.class);
                intent.putExtra("board_code", list.get(idx).getBoard_code());
                context.startActivity(intent);
            }
>>>>>>> main
        });

    }

    @Override
    public int getItemCount() {
<<<<<<< HEAD
        return list.size();
=======
        return 10;
>>>>>>> main
    }
    @Override
    public long getItemId(int i){return i;}
    @Override
    public int getItemViewType(int i){return i;}

    public class ViewHolder extends RecyclerView.ViewHolder {
<<<<<<< HEAD
        LinearLayout video;
        ImageView thumbnail;
        TextView tv_title, tv_name, tv_date;
        public ViewHolder(@NonNull View v) {
            super(v);
            video = v.findViewById(R.id.lin_video);
            thumbnail = v.findViewById(R.id.iv_thumbnail);
            tv_date = v.findViewById(R.id.tv_date);
            tv_name = v.findViewById(R.id.tv_name);
            tv_title = v.findViewById(R.id.tv_title);
        }

=======
        TextView tv_title, tv_writer, tv_writedate;
        public ViewHolder(@NonNull View v) {
            super(v);
            tv_title = v.findViewById(R.id.tv_title);
            tv_writer = v.findViewById(R.id.tv_writer);
            tv_writedate = v.findViewById(R.id.tv_writedate);

        }
>>>>>>> main
    }
}
