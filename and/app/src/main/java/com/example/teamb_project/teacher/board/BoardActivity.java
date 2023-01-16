package com.example.teamb_project.teacher.board;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ScrollView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.databinding.ActivityBoardBinding;
import com.example.teamb_project.vo.BoardVO;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class BoardActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityBoardBinding b;
    final String TAG = "log";
    int cnt = 1;
    BoardAdapter adapter = null;
    Common common = new Common();
    CommonMethod commonMethod = new CommonMethod();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityBoardBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        Log.d(TAG, "onCreate: " + ApiClient.getBASEURL());

        //임시로그인
        common.setTempLoginInfo();

        //'더보기' 클릭시
        b.linMore.setOnClickListener(v -> {
            cnt++;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            AlertDialog ad = builder.create();
            ad.setMessage("불러오는 중...");
            ad.show();
            commonMethod.setParams("cnt", cnt)
                    .sendPost("cal.bo",(isResult, data) -> {
                        //댓글 조회
                        selectList();
                        //남은 댓글 수
                        int boardCnt = Integer.parseInt(data.toString());
                        //남은 댓글 수가 0개 이하면 '더보기' 안보이게
                        if(boardCnt <= 0){
                            b.linMore.setVisibility(View.GONE);
                        }else{

                        }
                        ad.dismiss();
                    });
        });

        // 기본 10개 보이기
        commonMethod.setParams("cnt", cnt)
                .sendPost("list.bo", (isResult, data) -> {
            if(isResult){
                //리사이클러뷰에 들어갈 데이터 List
                ArrayList<BoardVO> list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<BoardVO>>(){}.getType());

                if(list != null){
                    if(list.size() == 0){
                        b.linMore.setVisibility(View.GONE);
                    }
                }

                //어댑터 설정
                adapter = new BoardAdapter(getLayoutInflater(), list, this);
                b.recvBoard.setAdapter(adapter);
                b.recvBoard.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
            }else{
                Log.d(TAG, " 실패 ");
            }

        });

        //클릭이벤트
        b.ivSearch.setOnClickListener(this);
        b.cardGoTop.setOnClickListener(this);
        b.ivBack.setOnClickListener(this);
        b.ivWrite.setOnClickListener(this);

        //스피너 설정
        common.setSpinner(b.spinner, this);
        b.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //검색 버튼 눌렀을때
                b.ivSearch.setOnClickListener(v -> {
                    Log.d(TAG, "검색 누름");
                    searchBoard(position, b.edtSearch.getText().toString());
                });
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        //EditText 입력이벤트
//        b.edtSearch.addTextChangedListener(common.getTextWatcher(b.ivTextRemove));

        //스크롤 내리면 아이콘 보이게
        common.scrollTop(b.scrBoard, b.cardGoTop);

    }


    //검색
    public void searchBoard(int position, String search){
        String column = null;
        if(position==0) column = "title";
        else if(position==1) column = "content";
        else if(position==2) column = "member_name";
        commonMethod.setParams("column", column)
                .setParams("search", b.edtSearch.getText().toString())
                .sendPost("search.bo", (isResult, data) -> {
                    Log.d(TAG, "검색 결과 : " + isResult);
                    //검색한 결과 보이기
                    ArrayList<BoardVO> list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<BoardVO>>(){}.getType());
                    b.linMore.setVisibility(View.GONE);
                    adapter.list = list;
                    adapter.notifyDataSetChanged();
//                    selectList();
                });

    }

    //게시글 목록 불러오기
    public void selectList(){
        new CommonMethod().setParams("cnt", cnt)
                .sendPost("list.bo", (isResult, data) -> {
                    if(isResult){
                        //리사이클러뷰에 들어갈 데이터 List
                        ArrayList<BoardVO> list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<BoardVO>>(){}.getType());
                        if(list.size()<11){
                            b.linMore.setVisibility(View.GONE);
                        }
                        //어댑터 설정
                        adapter.list = list;
                        adapter.notifyDataSetChanged();
                    }else{
                        Log.d(TAG, " 실패 ");
                    }
                });
    }

    @Override
    public void onClick(View v) {
        b.edtSearch.clearFocus();

        if(v.getId()==R.id.iv_search){
            //검색처리 --> 위에서 함
        }else if(v.getId()==R.id.card_go_top){
            //스크롤 최상단으로 이동
            b.scrBoard.fullScroll(ScrollView.FOCUS_UP);
        }else if(v.getId()==R.id.iv_back){
            //돌아가기
            onBackPressed();
        }else if(v.getId()==R.id.iv_write){
            //글 작성
            Intent intent = new Intent(BoardActivity.this, NewBoardActivity.class);
            startActivity(intent);
        }
    }

    //onResume?
    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }

}