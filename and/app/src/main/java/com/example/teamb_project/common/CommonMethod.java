package com.example.teamb_project.common;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class CommonMethod {
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> main





    //삭제 처리
//    public void selectList(){
//        new com.example.conn.CommonMethod().sendPost("select.cu", (isResult, data) -> {
//
//            ArrayList<CustomerVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<CustomerVO>>(){}.getType());
//
//            //비동기 영역 (최대 10초 후에 실행될 수도 있음)
//            //데이터가 있어야 할수있는 처리는 모두 이 영역에서
//            b.recvSelect.setAdapter(new CuAdapter(list, getLayoutInflater(), CustomerActivity.this));
//            b.recvSelect.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
//        });
//    }


<<<<<<< HEAD
>>>>>>> main
=======
>>>>>>> main

    //레이아웃 매니저
    static public RecyclerView.LayoutManager getManager(Context context){
        RecyclerView.LayoutManager manager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);

        return manager;
    }

}
