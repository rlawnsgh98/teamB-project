package com.example.teamb_project.common;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamb_project.R;

public class CommonMethod {




    //스피너 - 검색에서 제목,내용,작성자 <- 이 스피너 한정
    public void setSpinner(Spinner spinner, Context context){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                context, R.array.spinner_category, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //선택됐을때
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //선택x
            }
        });
    }

    //레이아웃 매니저
    static public RecyclerView.LayoutManager getManager(Context context){
        RecyclerView.LayoutManager manager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);

        return manager;
    }

}
