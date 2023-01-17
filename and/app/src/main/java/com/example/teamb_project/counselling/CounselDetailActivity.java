package com.example.teamb_project.counselling;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.databinding.ActivityCounselDetailBinding;
import com.example.teamb_project.vo.CounselVO;
import com.example.teamb_project.vo.MemberVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CounselDetailActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityCounselDetailBinding b;
    Common common = new Common();
    CommonMethod commonMethod = new CommonMethod();
    final String TAG = "log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityCounselDetailBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        getSupportActionBar().hide();

        //로그인 확인
        MemberVO member = common.getLoginInfo();


        //상세화면 정보 조회
        commonMethod.setParams("counsel_code", getIntent().getIntExtra("counsel_code", -1))
                .sendPost("info.co", (isResult, data) -> {
                    CounselVO vo = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, CounselVO.class);
                    b.tvTitle.setText(vo.getTitle());
                    b.tvContent.setText(vo.getContent());
                    b.tvWriter.setText(vo.getWriter_name());
                    b.tvWriteDate.setText(vo.getWrite_date().toString());


                    //답변하기 버튼 보이기  -> 수신자(receiver)이고 아직 답변이 없을때
                    b.cardAnswerBtn.setVisibility(View.GONE);
                    int receiver = Integer.parseInt(common.getLoginInfo().getMember_code());
                    int intent_re = vo.getReceiver();
                    if(receiver == intent_re && vo.getAnswer() == null){
                        b.cardAnswerBtn.setVisibility(View.VISIBLE);
                        b.cardAnswer.setVisibility(View.GONE);
                    }
                    //답변이 있으면 답변 보이기
                    if(vo.getAnswer()!=null){
                        b.cardAnswer.setVisibility(View.VISIBLE);
                        b.edtAnswer.setVisibility(View.GONE);
                        b.tvAnswer.setVisibility(View.VISIBLE);
                        b.cardAnswerBtn.setVisibility(View.GONE);
                        b.linAnswer.setVisibility(View.VISIBLE);
                        b.tvAnswer.setText(vo.getAnswer());
                    }
                    //상담 더보기 버튼 보이기
                    if(member.getMember_code().equals(vo.getWriter()+"")){
                        //로그인정보 == 작성자
                        b.ivMore.setVisibility(View.VISIBLE);
                    }else{
                        b.ivMore.setVisibility(View.GONE);
                    }
                    //답변 더보기 버튼 보이기
                    if(member.getMember_name().equals(vo.getReceiver()+"")){
                        //로그인정보 == 수신자
                        b.ivMoreAnswer.setVisibility(View.VISIBLE);
                    }else{
                        b.ivMoreAnswer.setVisibility(View.GONE);
                    }
                });

        //전송버튼 보이기
        b.edtAnswer.addTextChangedListener(common.getTextWatcher(b.ivSend));
        b.edtContent.addTextChangedListener(common.getTextWatcher(b.ivSendContent));


        //클릭
        b.ivBack.setOnClickListener(this);
        b.linMore.setOnClickListener(this);
        b.ivMore.setOnClickListener(this);
        b.tvModify.setOnClickListener(this);
        b.tvDelete.setOnClickListener(this);
        b.ivSend.setOnClickListener(this);
        b.cardAnswerBtn.setOnClickListener(this);
        b.ivMoreAnswer.setOnClickListener(this);
        b.tvModifyAnswer.setOnClickListener(this);
        b.tvDeleteAnswer.setOnClickListener(this);
        b.ivSendContent.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        //임시로 넣을 오늘날짜
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String getTime = sdf.format(date);


        if (v.getId() == R.id.iv_back) {
            //뒤로가기 클릭
            Intent intent = new Intent(CounselDetailActivity.this, CounselActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.iv_more) {
            //더보기(수정/삭제) 클릭
            b.ivMore.setVisibility(View.GONE);
            b.linMore.setVisibility(View.VISIBLE);
        } else if (v.getId() == R.id.tv_modify) {
            //상담 수정
            b.tvContent.setVisibility(View.GONE);
            b.edtContent.setVisibility(View.VISIBLE);
            b.edtContent.setText(b.tvContent.getText());
            b.edtContent.requestFocus();
            common.showKeyBoard(this, b.edtContent);
        } else if (v.getId()==R.id.iv_send_content) {
            //상담 내용 update
            CounselVO vo = new CounselVO();
            vo.setCounsel_code(getIntent().getIntExtra("counsel_code", -1));
            vo.setContent(b.edtContent.getText().toString());
            commonMethod.setParams("vo", new Gson().toJson(vo))
                    .sendPost("update.co", (isResult, data) -> {
                        Log.d(TAG, "상담 내용 update : " + data);
                        b.tvContent.setText(b.edtContent.getText().toString());
                        b.edtContent.setVisibility(View.GONE);
                        b.ivSendContent.setVisibility(View.GONE);
                        b.tvContent.setVisibility(View.VISIBLE);
                        b.tvWriteDate.setText(getTime);
                    });
            common.hideKeyBoard(this);
        }else if(v.getId()==R.id.tv_delete){
            //상담 삭제
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("상담")
                    .setMessage("삭제하시겠습니까?")
                    .setIcon(R.drawable.ic_round_delete);
            builder.setPositiveButton("네", (dialog, which) -> {
                //삭제 확인
                commonMethod.setParams("counsel_code", getIntent().getIntExtra("counsel_code", -1))
                        .sendPost("delete.co", (isResult, data) -> {
                            Log.d(TAG, "상담 삭제 처리 : " + data);
                            Intent intent = new Intent(CounselDetailActivity.this, CounselActivity.class);
                            startActivity(intent);
                        });
            });
            builder.setNegativeButton("아니오", (dialog, which) -> {});
            builder.create().show();
        }else if(v.getId()==R.id.iv_send){
            //답변 insert
            //DB 에 넣을 답변정보
            CounselVO vo = new CounselVO();
            vo.setCounsel_code(getIntent().getIntExtra("counsel_code",-1));
            vo.setAnswer(b.edtAnswer.getText().toString());
            commonMethod.setParams("vo", new Gson().toJson(vo))
                            .sendPost("insert_answer", (isResult, data) -> {
                                //DB 안 거치고 보이기
                                b.tvAnswer.setText(b.edtAnswer.getText().toString());
                                b.tvReceiver.setText(getIntent().getStringExtra("receiver_name"));
                                b.tvAnswerDate.setText(getTime);
                                b.relAnswer.setVisibility(View.GONE);   //EditText
                                b.linAnswer.setVisibility(View.VISIBLE);//TextView
                            });
            common.hideKeyBoard(this);
        }else if(v.getId()==R.id.card_answer_btn){
            //답변하기 버튼
            b.cardAnswerBtn.setVisibility(View.GONE);
            b.linAnswer.setVisibility(View.GONE);
            b.relAnswer.setVisibility(View.VISIBLE);
            b.cardAnswer.setVisibility(View.VISIBLE);
        }else if(v.getId()==R.id.iv_more_answer){
            //더보기_답변
            b.ivMoreAnswer.setVisibility(View.GONE);
            b.linMoreAnswer.setVisibility(View.VISIBLE);
        }else if(v.getId()==R.id.tv_modify_answer){
            //답변 수정
            b.linAnswer.setVisibility(View.GONE);
            b.relAnswer.setVisibility(View.VISIBLE);
            b.edtAnswer.setVisibility(View.VISIBLE);
            b.edtAnswer.setText(getIntent().getStringExtra("answer"));
            //키보드 입력준비
            b.edtAnswer.requestFocus();
            common.showKeyBoard(this, b.edtAnswer);
        }else if(v.getId()==R.id.tv_delete_answer){
            //답변 삭제
            commonMethod.setParams("counsel_code", getIntent().getIntExtra("counsel_code", -1))
                    .sendPost("delete_answer", (isResult, data) -> {
                        //새로고침
                        Log.d("log", "상담 답변 삭제 결과 : " + data);
                        common.refresh(this);
                    });
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }
}