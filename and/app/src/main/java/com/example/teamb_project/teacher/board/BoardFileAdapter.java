package com.example.teamb_project.teacher.board;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;
import com.example.teamb_project.vo.BoardFileVO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BoardFileAdapter extends RecyclerView.Adapter<BoardFileAdapter.ViewHolder>{
    LayoutInflater inflater;
    List<BoardFileVO> list;
    Activity activity;
    DownloadManager manager;

    public BoardFileAdapter(LayoutInflater inflater, List<BoardFileVO> list, Activity activity) {
        this.inflater = inflater;
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_attached_file, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {

        h.fileName.setText(list.get(i).getFile_name());
        h.fileName.setOnClickListener(v -> {
//            activity.unregisterReceiver(mCompleteReceiver);

            Log.d("log", "파일명 클릭 : " + h.fileName);
            Log.d("log", "파일 path : " + list.get(i).getPath());

            manager = (DownloadManager) activity.getSystemService(Context.DOWNLOAD_SERVICE);
            Uri uri = Uri.parse(list.get(i).getPath());
            DownloadManager.Request request = new DownloadManager.Request(uri);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
            long reference = manager.enqueue(request);

//            IntentFilter completeFilter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
//            activity.registerReceiver(mCompleteReceiver, completeFilter);
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
        TextView fileName;
        public ViewHolder(@NonNull View v) {
            super(v);
            fileName = v.findViewById(R.id.tv_file_name);
        }
    }



    private DownloadManager mDownloadManager; //다운로드 매니저.
    private int mDownloadQueueId; //다운로드 큐 아이디..
    private String mFileName ; //파일다운로드 완료후...파일을 열기 위해 저장된 위치를 입력해둔다.

    public void download(String url) {
        if (mDownloadManager == null) {
            mDownloadManager = (DownloadManager) activity.getSystemService(Context.DOWNLOAD_SERVICE);
        }
        DownloadManager.Request request = new DownloadManager.Request( Uri.parse(url) );
        request.setTitle("==타이틀==");
        request.setDescription("==설명==");
        List<String> pathSegmentList = Uri.EMPTY.getPathSegments();
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS + "/temp").mkdirs();  //경로는 입맛에 따라...바꾸시면됩니다.
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS + "/temp/", pathSegmentList.get(pathSegmentList.size()-1) );
        mFileName = pathSegmentList.get(pathSegmentList.size()-1);

        mDownloadQueueId = (int) mDownloadManager.enqueue(request);
    }

    private BroadcastReceiver mCompleteReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
                Toast.makeText(context, "Complete.", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent();
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent1.setAction(android.content.Intent.ACTION_VIEW);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                String localUrl = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                        + "/temp/" + mFileName; //저장했던 경로..
                String extension = MimeTypeMap.getFileExtensionFromUrl(localUrl);
                String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);

                File file = new File(localUrl);
                intent1.setDataAndType(Uri.fromFile(file), mimeType);
                try {
                    activity.startActivity(intent1);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(activity, "Not found. Cannot open file.", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        }
    };








}
