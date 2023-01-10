package com.example.teamb_project.teacher.mylecture.lecturehome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.teamb_project.R;
import com.example.teamb_project.common.CommonMethod;
import com.example.teamb_project.vo.MemberVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


public class LectureStudentFragment extends Fragment {
    int Lecture_code;
    public LectureStudentFragment(int lecture_code) {
        Lecture_code = lecture_code;
    }

    ArrayList<MemberVO> student_list;
    ArrayList<MemberVO> search_list = new ArrayList<>();

    RecyclerView recv_student;
    EditText edt_search;
    LectureStudentAdapter adapter;
    //검색할 아이템 목록



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lecture_student, container, false);

        recv_student = v.findViewById(R.id.recv_student);

        new com.example.conn.CommonMethod().setParams("lecture_code", Lecture_code).sendPost("student_list.le", new com.example.conn.CommonMethod.CallBackResult() {
                    @Override
                    public void result(boolean isResult, String data) {
                        student_list = new Gson().fromJson(data, new TypeToken<List<MemberVO>>(){}.getType());
                        Log.d("로그", "onCreateView: " + student_list);

                    }
                });

        Log.d("로그1", "onCreateView: " + student_list);


        edt_search = v.findViewById(R.id.edt_search);
//        edt_search.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                String searchText = edt_search.getText().toString();
//                search_list.clear();
//
//                if(searchText.equals("")){
//                    adapter.setItems(student_list);
//                }
//                else {
//                    // 검색 단어를 포함하는지 확인
////                    for (int a = 0; a < student_list.size(); a++) {
////                        if (student_list.get(a).getMember_name().toLowerCase().contains(searchText.toLowerCase())) {
////                            search_list.add(student_list.get(a));
////                        }
////                        adapter.setItems(search_list);
////                    }
//                }
//            }
//        });


        return v;

    }

    private void selectStudent(){
        new com.example.conn.CommonMethod().setParams("lecture_code", Lecture_code).sendPost("student_list.le", new com.example.conn.CommonMethod.CallBackResult() {
            @Override
            public void result(boolean isResult, String data) {
                student_list = new Gson().fromJson(data, new TypeToken<List<MemberVO>>(){}.getType());

                recv_student.setAdapter(new LectureStudentAdapter(getLayoutInflater(), getContext(), student_list));
                recv_student.setLayoutManager(CommonMethod.getManager(getContext()));
            }
        });

    }
}