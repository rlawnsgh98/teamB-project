package com.example.teamb_project.student.mylecture.lecturehome.video_board;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.databinding.FragmentVideoBoardBinding;
import com.example.teamb_project.vo.BoardVO;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class VideoBoardFragment extends Fragment implements View.OnClickListener{
    FragmentVideoBoardBinding b;
    VideoBoardAdapter adapter;

    //강의카테고리 - 테스트
    String category = "test";

    int cnt = 1;

    public VideoBoardFragment(int lecture_code) {
        this.lecture_code = lecture_code;
    }

    int lecture_code;
    final String TAG = "log";

    ArrayList<BoardVO> board_list;
    ArrayList<BoardVO> search_list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentVideoBoardBinding.inflate(inflater);

        Common common = new Common();
        CommonMethod commonMethod = new CommonMethod();

        //리사이클러뷰에 들어갈 데이터 List
        ArrayList<BoardVO> tempList = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            tempList.add(new BoardVO());
        }
        //게시글 11개 이상 DB에 있을때만 '더보기' 버튼 보이기
        if(tempList.size() < 11){b.linMore.setVisibility(View.GONE);}
        //어댑터 설정

        adapter = new VideoBoardAdapter(getLayoutInflater(), tempList, getContext());
        b.recvVideoBoard.setAdapter(adapter);
        b.recvVideoBoard.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        // 기본 10개 보이기
        commonMethod.setParams("category", category)
                .setParams("cnt", cnt)
                .sendPost("list.vi", (isResult, data) -> {
                    if(isResult){
                        //리사이클러뷰에 들어갈 데이터 List
                        board_list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<BoardVO>>(){}.getType());

                        //게시글 11개 이상 DB에 있을때만 '더보기' 버튼 보이기
                        if(board_list!=null){
                            if(board_list.size() < 11){
                                b.linMore.setVisibility(View.GONE);
                            }
                        }

                        //검색
                        b.edtSearch.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {

                            }

                            @Override
                            public void afterTextChanged(Editable s) {
                                String searchText = b.edtSearch.getText().toString();
                                search_list.clear();

                                if(searchText.equals("")){
                                    adapter.list = board_list;
                                    adapter.notifyDataSetChanged();
                                }else{
                                    for(int i = 0; i < board_list.size(); i++){
                                        if (board_list.get(i).getTitle().toLowerCase().contains(searchText.toLowerCase())) {
                                            search_list.add(board_list.get(i));
                                        }
                                        adapter.list = search_list;
                                        adapter.notifyDataSetChanged();
                                    }
                                }
                            }
                        });

                        //어댑터 설정
                        adapter = new VideoBoardAdapter(getLayoutInflater(), board_list, getContext());
                        b.recvVideoBoard.setAdapter(adapter);
                        b.recvVideoBoard.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
                    }else{
                        Log.d(TAG, " 실패 ");
                    }
                });

        //'더보기' 클릭시
        b.linMore.setOnClickListener(v -> {
            cnt++;
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            AlertDialog ad = builder.create();
            ad.setMessage("불러오는 중...");
            ad.show();
            commonMethod.setParams("cnt", cnt)
                    .sendPost("cal.vi",(isResult, data) -> {
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

        //스크롤 내리면 아이콘 보이게
        common.scrollTop(b.scrVideo, b.cardGoTop);

        //클릭이벤트
        b.ivSearch.setOnClickListener(this);
        b.cardGoTop.setOnClickListener(this);


        return b.getRoot();
    }

    @Override
    public void onClick(View v) {

        if(v.getId()== R.id.iv_search){
            //검색처리
        }else if(v.getId()==R.id.card_go_top){
            //스크롤 최상단으로 이동
            b.scrVideo.fullScroll(ScrollView.FOCUS_UP);
        }

    }

    //리사이클러뷰 갱신
    public void selectList(){
        new CommonMethod().setParams("cnt", cnt)
                .sendPost("list.bo", (isResult, data) -> {
                    if(isResult){
                        //리사이클러뷰에 들어갈 데이터 List
                        ArrayList<BoardVO> list = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<BoardVO>>(){}.getType());

                        //어댑터 설정
                        adapter.list = list;
                        adapter.notifyDataSetChanged();
                    }else{
                        Log.d(TAG, " 실패 ");
                    }
                });
    }

    //바인딩 비우기
    @Override
    public void onDestroy() {
        super.onDestroy();
        b = null;
    }


}