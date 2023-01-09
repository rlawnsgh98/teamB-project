package com.example.teamb_project.common;

import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.teamb_project.R;
import com.example.teamb_project.vo.MemberVO;

public class Common {
    static MemberVO loginInfo;

    public static String BASE;


    //로그인 정보 저장
    public void setLoginInfo(MemberVO vo){
         this.loginInfo = vo;
    }
    //로그인 정보 조회
    public MemberVO getLoginInfo(){
        return loginInfo;
    }

    //임시 로그인 정보 저장
    public void setTempLoginInfo(){
        MemberVO temp = new MemberVO();
        temp.setMember_code("3");
        temp.setMember_name("테스트유저1");
        temp.setGender("남");
        temp.setEmail("user1@gg.com");
        temp.setPhone("12363121");
        temp.setType("S");
        temp.setId("user1");
        temp.setPw("000aA");
        temp.setBirth("23/01/02");
        this.loginInfo = temp;
    }

    //스피너 - 검색에서 제목,내용,작성자 <- 이 스피너 한정임! 재활용시 수정 필요
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


    // 스크롤 내리면 TOP 버튼 보이기
    public void scrollTop(View scroll, View btnTop){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            scroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    if(scroll.getScrollY()>100){
                        btnTop.setVisibility(View.VISIBLE);
                    }else{
                        btnTop.setVisibility(View.GONE);
                    }
                }
            });
        }
    }

    // EditText 입력되어있을때만 지우기(닫기) 버튼 보이기
    // EditText.addTextChangedListener( 여기에 넘겨줄 TextWatcher )
    // TextWatcher
    public TextWatcher getTextWatcher(ImageView close){
        TextWatcher tw = new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //입력 전
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //입력칸 변화시
                if(s.toString().equals("")){
                    //값 없을때
                    close.setVisibility(View.GONE);
                }else{
                    //값 입력시
                    close.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                //입력 끝난 후
            }
        };
        return tw;
    }
    public TextWatcher getTextWatcher(ImageView close, ImageView send){
        TextWatcher tw = new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //입력 전
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //입력칸 변화시
                if(s.toString().equals("")){
                    //값 없을때
                    close.setVisibility(View.GONE);
                    send.setVisibility(View.GONE);
                }else{
                    //값 입력시
                    close.setVisibility(View.VISIBLE);
                    send.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                //입력 끝난 후
            }
        };
        return tw;
    }
}
