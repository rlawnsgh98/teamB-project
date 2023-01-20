package com.example.teamb_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.teamb_project.board.BoardActivity;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.counselling.CounselActivity;
import com.example.teamb_project.databinding.ActivityBoardBinding;
import com.example.teamb_project.databinding.ActivityHomeBinding;
import com.example.teamb_project.notice.NoticeActivity;
import com.example.teamb_project.teacher.TeacherHomeActivity;
import com.example.teamb_project.teacher.mylecture.MyLectureActivity;
import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Common().changeStatusBarColor(this);

        b = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());


        b.navigationDrawer.setAppbarTitleTV("LMS");
        b.imgvMenu.setOnClickListener(v->{
            changeDrawer();
        });
        List<MenuItem> menuItems = new ArrayList<>();
        //서랍 목록 - 내 정보, 학원 일정, 학원 소개, 로그아웃=> 메인화면에서 쓸만한것만 정리 작업해야될듯.ㅡ
        menuItems.add(new MenuItem("LMS 홈", R.drawable.main_cahr));
        menuItems.add(new MenuItem("메뉴1", R.drawable.main_cahr));
        menuItems.add(new MenuItem("메뉴2", R.drawable.main_cahr));
        menuItems.add(new MenuItem("메뉴3", R.drawable.main_cahr));
        menuItems.add(new MenuItem("로그아웃", R.drawable.main_cahr));
        b.navigationDrawer.setMenuItemList(menuItems);


        b.navigationDrawer.setOnMenuItemClickListener(position -> {
           // Intent intent = null ;
            b.tvMenu.setText(menuItems.get(position).getTitle());
            //Fragment로 바꿀 필요가 있을거같음.

//                    switch (position) {
//                        case 0: {
//                            b.tvMenu.setText(menuItems.get(position).getTitle());
//                            break;
//                        }
//                        case 1: {
//                            b.tvMenu.setText(menuItems.get(position).getTitle());
//                            intent = new Intent(this, MyLectureActivity.class);
//                            break;
//                        }
//                        case 2: {
//                            b.tvMenu.setText(menuItems.get(position).getTitle());
//                            intent = new Intent(this, BoardActivity.class);
//                            break;
//                        }
//                        case 3: {
//                            b.tvMenu.setText(menuItems.get(position).getTitle());
//                            intent = new Intent(this, CounselActivity.class);
//                            break;
//                        }
//                    }

 //                   startActivity(intent);
        });

        b.navigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {

            @Override
            public void onDrawerOpened() {
                b.imgvMenu.setImageResource(R.drawable.ic_close_black);
            }

            @Override
            public void onDrawerOpening(){

            }

            @Override
            public void onDrawerClosing(){
                System.out.println("Drawer closed");
            }

            @Override
            public void onDrawerClosed() {
                b.imgvMenu.setImageResource(R.drawable.ic_baseline_menu_24);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                System.out.println("State "+newState);
            }
        });

    }

    public void changeDrawer(){
        if(b.navigationDrawer.isDrawerOpen()){

            b.imgvMenu.setImageResource(R.drawable.ic_baseline_menu_24);
            b.navigationDrawer.closeDrawer();
        }else{
            b.imgvMenu.setImageResource(R.drawable.ic_close_black);
            b.navigationDrawer.openDrawer();
        }
    }
}