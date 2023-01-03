package com.example.teamb_project.common;

import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;

public class Common {

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
}
