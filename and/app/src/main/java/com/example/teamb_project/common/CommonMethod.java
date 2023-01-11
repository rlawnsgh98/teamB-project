package com.example.teamb_project.common;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CommonMethod {

    //레이아웃 매니저
    static public RecyclerView.LayoutManager getManager(Context context){
        RecyclerView.LayoutManager manager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);

        return manager;
    }

}
