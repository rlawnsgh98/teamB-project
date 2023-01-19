package com.example.teamb_project.board;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.databinding.ActivityBoardDetailBinding;
import com.example.teamb_project.vo.BoardFileVO;
import com.example.teamb_project.vo.BoardVO;
import com.example.teamb_project.vo.ReplyVO;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class BoardDetailActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityBoardDetailBinding b;
    final String TAG = "log";
    ReplyAdapter adapter = null;
    int cnt = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityBoardDetailBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        b.linModify.setVisibility(View.GONE);   //수정,삭제 가리기
        Common common = new Common();
        CommonMethod commonMethod = new CommonMethod();
        Intent intent = getIntent();

        b.ivMore.setVisibility(View.GONE);
        //로그인정보 일치시에만 보이기
//        if(common.getLoginInfo().getMember_code().equals(intent.getIntExtra("writer", -1)+"")){
//            b.ivMore.setVisibility(View.VISIBLE);
//        }

        Log.d(TAG, "getIntent" + getIntent().getStringExtra("id"));


        //해당 게시판 정보 조회
        commonMethod.setParams("board_code", intent.getIntExtra("board_code", -1))
                .sendPost("info.bo", (isResult, data) -> {
                    if(isResult){
                        Log.d(TAG, "data : " + data);
                        BoardVO vo = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, BoardVO.class);
                        b.tvTitle.setText(vo.getTitle());
                        b.tvContent.setText(vo.getContent());
                        b.tvWriter.setText(vo.getMember_name());
                        b.tvWritedate.setText(vo.getWritedate().toString());
                        b.tvReadcnt.setText(vo.getReadcnt()+"");

                        //이미지 ArrayList
                        List<BoardFileVO> img_list = vo.getFileList();

                        //첨부파일 ArrayList
                        List<BoardFileVO> file_list =  vo.getFileList();

                        //이미지 어댑터 설정
                        b.recvImgs.setAdapter(new BoardDetailAdapter(getLayoutInflater(), img_list, this));
                        b.recvImgs.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

                        //첨부파일 어댑터 설정
                        b.recvFiles.setAdapter(new BoardFileAdapter(getLayoutInflater(), file_list, this));
                        b.recvFiles.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

                    }else{
                        Log.d(TAG, "조회 실패");
                    }
                });

        //'더보기' 클릭시
        b.linMore.setOnClickListener(v -> {
            cnt++;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            AlertDialog ad = builder.create();
            ad.setMessage("불러오는 중...");
            ad.show();
            commonMethod.setParams("board_code", getIntent().getIntExtra("board_code", -1))
                    .setParams("cnt", cnt)
                    .sendPost("cal.re",(isResult, data) -> {
                        //게시글 조회
                        selectList();
                        //남은 게시글 수
                        int boardCnt = Integer.parseInt(data.toString());

                        //남은 게시글 수가 0개 이하면 '더보기' 안보이게
                        if(boardCnt <= 0){
                            b.linMore.setVisibility(View.GONE);
                        }
                        ad.dismiss();
                    });
        });

        //해당 게시판 댓글 목록 조회
        commonMethod.setParams("cnt", cnt)
                .setParams("board_code", getIntent().getIntExtra("board_code", -1))
                .sendPost("list.re", (isResult, data) -> {
                    if(isResult){
                        Log.d(TAG, "댓글 data : " + data);
                        //댓글 리스트 ArrayList
                        ArrayList<ReplyVO> list = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create().fromJson(data, new TypeToken<ArrayList<ReplyVO>>(){}.getType());

                        //댓글 11개 이상일 경우 더보기 보이게 하기
                        if(list.size()<10){
                            b.linMore.setVisibility(View.GONE);
                        }
                        //어댑터 설정 - 댓글
                        adapter = new ReplyAdapter(getLayoutInflater(), list, BoardDetailActivity.this);
                        b.recvReply.setAdapter(adapter);
                        b.recvReply.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
                    }else{
                        Log.d(TAG, "댓글 목록 조회 실패");
                    }
                });

        //클릭이벤트
        b.ivBack.setOnClickListener(this);
        b.ivMore.setOnClickListener(this);
        b.tvDelete.setOnClickListener(this);
        b.tvModify.setOnClickListener(this);
        b.ivSend.setOnClickListener(this);

        //edt 값 입력시
        b.edtReply.addTextChangedListener(common.getTextWatcher(b.ivSend));

    }

    //댓글 목록 불러오기
    public void selectList(){
        new CommonMethod().setParams("cnt", cnt)
                .setParams("board_code", getIntent().getIntExtra("board_code", -1))
                .sendPost("list.re", (isResult, data) -> {
                    if(isResult){
                        ArrayList<ReplyVO> list = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create().fromJson(data, new TypeToken<ArrayList<ReplyVO>>(){}.getType());
                        //어댑터 설정 - 댓글
                        adapter.list = list;
                        adapter.notifyDataSetChanged();
                    }else{
                        Log.d(TAG, "댓글 목록 갱신 실패");
                    }

                });
    }

    //클릭
    @Override
    public void onClick(View v) {
        CommonMethod commonMethod = new CommonMethod();
        Common common = new Common();
        Intent intent = getIntent();    //BoardActivity 에서 받은 intent
        Intent board_intent = new Intent(BoardDetailActivity.this, BoardActivity.class);
        b.linModify.setVisibility(View.GONE);

        if(v.getId()== R.id.iv_back){
            onBackPressed();
        }else if(v.getId()==R.id.iv_more) {
            b.linModify.setVisibility(View.VISIBLE);
        }else if(v.getId()==R.id.tv_delete){
            //삭제 처리 --> Dialog 써서 한번 더 묻기
            commonMethod.setParams("board_code", intent.getIntExtra("board_code", -1))
                    .sendPost("delete.bo", (isResult, data) -> {
                        if(isResult){
                            Log.d(TAG, "data : " + data);
                        }else{
                            Log.d(TAG, " 삭제 실패 ");
                        }
                    });
        }else if(v.getId()==R.id.tv_modify){
            //수정할 페이지로 이동
            Intent modify_intent = new Intent(BoardDetailActivity.this, BoardModifyActivity.class);
            modify_intent.putExtra("title", b.tvTitle.getText().toString());
            modify_intent.putExtra("content", b.tvContent.getText().toString());
            modify_intent.putExtra("board_code", intent.getIntExtra("board_code", -1));
            startActivity(modify_intent);
        }else if(v.getId()==R.id.iv_send){
            //댓글 작성
            commonMethod.setParams("writer", common.getLoginInfo().getMember_code())
                    .setParams("board_code", intent.getIntExtra("board_code", -1))
                    .setParams("content", b.edtReply.getText().toString())
                    .sendPost("insert.re", (isResult, data) -> {
                        Log.d(TAG, "댓글 입력 결과 : " + data);
                        //어댑터 다시 불러오기
                        selectList();
                        b.edtReply.setText("");
                        //키패드 숨기기
                        common.hideKeyBoard(this);
                    });
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }

}