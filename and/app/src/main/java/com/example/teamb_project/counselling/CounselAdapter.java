package com.example.teamb_project.counselling;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conn.CommonMethod;
import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.vo.CounselVO;

import java.util.ArrayList;

public class CounselAdapter extends RecyclerView.Adapter<CounselAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<CounselVO> list;
    Context context;
    CommonMethod commonMethod = new CommonMethod();
    Common common = new Common();

    public CounselAdapter(LayoutInflater inflater, ArrayList<CounselVO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_counsel, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {

        //기본 정보 출력
        h.title.setText(list.get(i).getTitle());
        h.writedate.setText(list.get(i).getWrite_date().toString());
        //답변 있으면 빨강 -> 초록
        if(list.get(i).getAnswer() != null){
            h.state.setBackgroundColor(ContextCompat.getColor(context, R.color.view_green));
        }else{
            h.state.setBackgroundColor(ContextCompat.getColor(context, R.color.view_red));
        }

        if(common.getLoginInfo().getType().equals("STUD")){
            //학생
            h.name.setText(list.get(i).getReceiver());
            //프로필 이미지 가져오기 => 병합 후 MemberVO 참조!!
//            commonMethod.setParams("member_code", list.get(i).getReceiver())
//                            .sendPost("info.mb", (isResult, data) -> {
//                                MemberVO vo = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, MemberVO.class);
//                                Glide.with(context).load(vo.getProfilepath()).into(h.profile);
//                            });
        }else{
            //강사
            h.name.setText(list.get(i).getWriter());
        }

        //특정 item 클릭
        h.detail.setOnClickListener(v -> {
            Intent intent  = new Intent(context, CounselDetailActivity.class);
            intent.putExtra("counsel_code", list.get(i).getCounsel_code());   //클릭한 상담의 id값 필요!
            intent.putExtra("receiver", list.get(i).getReceiver());
            intent.putExtra("receiver_name", list.get(i).getReceiver_name());
            intent.putExtra("answer", list.get(i).getAnswer());

            context.startActivity(intent);
        });

        //상담 삭제
        h.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //삭제 알림 띄우기
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }
    @Override
    public long getItemId(int i){return i;}
    @Override
    public int getItemViewType(int i){return i;}

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout detail, lin_more;
        View state;             //답변 상태
        TextView delete, modify, title, name, writedate;
        ImageView iv_more, profile;

        public ViewHolder(@NonNull View v) {
            super(v);
            detail = v.findViewById(R.id.lin_counsel);
            state = v.findViewById(R.id.v_state);
            delete = v.findViewById(R.id.tv_delete);
            modify = v.findViewById(R.id.tv_modify);
            title = v.findViewById(R.id.tv_title);
            name = v.findViewById(R.id.tv_writer);
            writedate = v.findViewById(R.id.tv_writedate);
            iv_more = v.findViewById(R.id.iv_more);
            lin_more = v.findViewById(R.id.lin_more);
            profile = v.findViewById(R.id.iv_profile);
        }
    }

    //삭제시 한번 묻기
    public void checkDelete(int id, Context context){    //<= 네를 누르면 바로 삭제처리
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("삭제")
                .setMessage("삭제하시겠습니까?")
                .setIcon(R.drawable.ic_launcher_foreground);

        builder.setPositiveButton("네", (dialog, which) -> {
            //네 누르면 실행
            new com.example.conn.CommonMethod().setParams("id", id)
                    .sendPost("delete.cu", (isResult, data) -> {
                        Log.d("log", "삭제 처리 : " + data);
                        //삭제 처리 메소드 호출
                    });
        });
        builder.setNegativeButton("아니오", (dialog, which) -> {
            //아니오 누르면 실행

        });
        builder.create().show();
    }

}
