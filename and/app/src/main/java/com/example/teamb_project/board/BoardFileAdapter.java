package com.example.teamb_project.board;

<<<<<<< HEAD
<<<<<<< HEAD
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
=======
>>>>>>> main
=======
>>>>>>> main
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
<<<<<<< HEAD
<<<<<<< HEAD
    Activity activity;

    public BoardFileAdapter(LayoutInflater inflater, List<BoardFileVO> list, Activity activity) {
        this.inflater = inflater;
        this.list = list;
        this.activity = activity;
=======
=======
>>>>>>> main

    public BoardFileAdapter(LayoutInflater inflater, List<BoardFileVO> list) {
        this.inflater = inflater;
        this.list = list;
<<<<<<< HEAD
>>>>>>> main
=======
>>>>>>> main
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_attached_file, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {

        h.fileName.setText(list.get(i).getFile_name());

<<<<<<< HEAD
<<<<<<< HEAD
        //파일 클릭시 다운로드 처리
        h.fileName.setOnClickListener(v -> {
            Log.d("log", "파일명 클릭 : " + list.get(i).getFile_name());
            Log.d("log", "파일 path : " + list.get(i).getPath());

            //다운로드 처리
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(list.get(i).getPath()));
            request.setDescription(list.get(i).getFile_name());
            request.setTitle(list.get(i).getFile_name());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            }
            request.setDestinationInExternalFilesDir(activity, Environment.DIRECTORY_DOWNLOADS, list.get(i).getFile_name());

            DownloadManager manager = (DownloadManager) activity.getSystemService(Context.DOWNLOAD_SERVICE);
            manager.enqueue(request);

        });
=======

        Log.d("log", "onBindViewHolder: ");
>>>>>>> main
=======

        Log.d("log", "onBindViewHolder: ");
>>>>>>> main
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
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> main
=======
>>>>>>> main
}
