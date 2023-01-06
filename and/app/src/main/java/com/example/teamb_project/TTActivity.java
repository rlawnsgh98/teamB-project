package com.example.teamb_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class TTActivity extends AppCompatActivity {
    Toolbar top_toolbar;
    RecyclerView tt_recv_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tt);

        // 상단바
        top_toolbar = findViewById(R.id.top_toolbar);
        top_toolbar.setTitle("시간표");
        top_toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.top_toolbar_more:
                        Intent intent = new Intent(TTActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

        // 상단바 뒤로가기 버튼
        top_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // 일정들
        tt_recv_list = findViewById(R.id.tt_recv_list);
        tt_recv_list.setAdapter(new TTAdapter(getLayoutInflater()));
        tt_recv_list.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
    }
}