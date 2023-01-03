package com.example.teamb_project.common;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CommonMethod {
    //매번 화면에서 Layout매니저를 직접 만드는 행위가 불편
    //재사용이 가능한 메소드 하나를 이용해서 코드를 줄여보고자 한다

    static public RecyclerView.LayoutManager getManager(Context context){
        RecyclerView.LayoutManager manager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);

        return manager;
    }


}
