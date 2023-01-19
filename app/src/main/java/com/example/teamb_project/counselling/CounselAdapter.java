package com.example.teamb_project.counselling;

import android.app.Activity;
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
import com.example.teamb_project.vo.MemberVO;

import java.util.ArrayList;

public class CounselAdapter extends RecyclerView.Adapter<CounselAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<CounselVO> list;
    Activity activity;
    CommonMethod commonMethod = new CommonMethod();
    Common common = new Common();

    public CounselAdapter(LayoutInflater inflater, ArrayList<CounselVO> list, Activity activity) {
        this.inflater = inflater;
        this.list = list;

        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_counsel, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {

        MemberVO vo = common.getLoginInfo();

        //기본 정보 출력
        h.title.setText(list.get(i).getTitle());
        h.write_date.setText(list.get(i).getWrite_date()+"");
        //답변 있으면 빨강 -> 초록
        if(list.get(i).getAnswer() != null){
            h.state.setBackgroundColor(ContextCompat.getColor(activity, R.color.view_green));
        }else{
            h.state.setBackgroundColor(ContextCompat.getColor(activity, R.color.view_red));
        }
        //로그인정보 == 작성자 --> 더보기 보이기
        if(list.get(i).getWriter()==Integer.parseInt(vo.getMember_code())){
            h.iv_more.setVisibility(View.VISIBLE);
        }else{
            h.iv_more.setVisibility(View.GONE);
        }

        if(common.getLoginInfo().getType().equals("STUD")){
            //학생
            h.name.setText(list.get(i).getReceiver_name());
            //프로필 이미지 가져오기 => 병합 후 MemberVO 참조!!
//            commonMethod.setParams("member_code", list.get(i).getReceiver())
//                            .sendPost("info.mb", (isResult, data) -> {
//                                MemberVO vo = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, MemberVO.class);
//                                Glide.with(context).load(vo.getProfilepath()).into(h.profile);
//                            });
        }else{
            //강사
            h.name.setText(list.get(i).getWriter_name());
        }

        //특정 item 클릭
        h.detail.setOnClickListener(v -> {
            Intent intent  = new Intent(activity, CounselDetailActivity.class);
            intent.putExtra("counsel_code", list.get(i).getCounsel_code());   //클릭한 상담의 id값 필요!
            intent.putExtra("receiver", list.get(i).getReceiver());
            intent.putExtra("receiver_name", list.get(i).getReceiver_name());
            intent.putExtra("answer", list.get(i).getAnswer());
            intent.putExtra("writer_name", list.get(i).getWriter_name());
            intent.putExtra("writer", list.get(i).getWriter());


            activity.startActivity(intent);
        });

        //상담 삭제
        h.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //삭제 알림 띄우기
            }
        });

        //더보기 클릭
        h.iv_more.setOnClickListener(v -> {
            h.iv_more.setVisibility(View.GONE);
            h.lin_more.setVisibility(View.VISIBLE);
        });

        h.delete.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle("상담")
                    .setMessage("삭제하시겠습니까?")
                    .setIcon(R.drawable.ic_round_delete);
            builder.setPositiveButton("네", (dialog, which) -> {
                //삭제 확인
                commonMethod.setParams("counsel_code", list.get(i).getCounsel_code())
                        .sendPost("delete.co", (isResult, data) -> {
                            Log.d("log", "상담 삭제 처리 : " + data);
                            Intent intent = new Intent(activity, CounselActivity.class);
                            activity.startActivity(intent);
                        });
            });
            builder.setNegativeButton("아니오", (dialog, which) -> {});
            builder.create().show();
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    @Override
    public long getItemId(int i){return i;}
    @Override
    public int getItemViewType(int i){return i;}

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout detail, lin_more;
        View state;             //답변 상태
        TextView delete, modify, title, name, write_date;
        ImageView iv_more, profile;

        public ViewHolder(@NonNull View v) {
            super(v);
            detail = v.findViewById(R.id.lin_counsel);
            state = v.findViewById(R.id.v_state);
            delete = v.findViewById(R.id.tv_delete);
            modify = v.findViewById(R.id.tv_modify);
            title = v.findViewById(R.id.tv_title);
            name = v.findViewById(R.id.name);
            write_date = v.findViewById(R.id.tv_write_date);
            iv_more = v.findViewById(R.id.iv_more);
            lin_more = v.findViewById(R.id.lin_more);
            profile = v.findViewById(R.id.iv_profile);
        }
    }


}
