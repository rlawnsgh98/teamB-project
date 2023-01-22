package com.example.teamb_project.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.teamb_project.R;
import com.example.teamb_project.common.Common;
import com.example.teamb_project.counselling.CounselFragment;
import com.example.teamb_project.databinding.ActivityHomeBinding;
import com.example.teamb_project.drawer.AcCalenarFragment;
import com.example.teamb_project.member.LoginActivity;
import com.example.teamb_project.member.MyInfoFragment;
import com.example.teamb_project.teacher.MyLectureFragment;
import com.example.teamb_project.timetable.TimeTableFragment;
import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding b;
    boolean isHomeFragment = true;
    List<MenuItem> menuItems ;
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

        //2023 - 01 - 22 : 메뉴 분기가 필요하다면 해당 로직 사용.
        if(Common.loginInfo.getType().equals("STUD")){

            menuItems= setMenuStudent();
        }else{
            menuItems= setMenuTeacher();
        }

        b.navigationDrawer.setMenuItemList(menuItems);

        changeFragment(new HomeFragment(), "홈");
        //2023 - 01 - 22 : 메뉴 분기가 필요하다면 해당 로직 사용.
        b.navigationDrawer.setOnMenuItemClickListener(position -> {

            if(Common.loginInfo.getType().equals("STUD")){
                setMenuClickStudent(position ,menuItems.get(position).getTitle());
            }else{
                setMenuClickTeacher(position , menuItems.get(position).getTitle());
            }
        });

        b.navigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {

            @Override
            public void onDrawerOpened() {
                b.imgvMenu.setImageResource(R.drawable.ic_close_white);
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

        b.imgvBack.setOnClickListener(v->{
            onBackPressed();
        });
    }
    public List<MenuItem>  setMenuTeacher(){
        List<MenuItem> menuItems = new ArrayList<>();
        //서랍 목록 - 내 정보, 학원 일정, 학원 소개, 로그아웃=> 메인화면에서 쓸만한것만 정리 작업해야될듯.ㅡ
        menuItems.add(new MenuItem("LMS 홈", R.drawable.main_cahr));
        menuItems.add(new MenuItem("내 정보", R.drawable.main_cahr));
        menuItems.add(new MenuItem("학원 일정", R.drawable.main_cahr));
        menuItems.add(new MenuItem("내 강의 조회", R.drawable.main_cahr));
        menuItems.add(new MenuItem("내 상담", R.drawable.main_cahr));
        menuItems.add(new MenuItem("로그아웃", R.drawable.main_cahr));

        return menuItems;
    }
    public List<MenuItem>  setMenuStudent(){
        List<MenuItem> menuItems = new ArrayList<>();
        //서랍 목록 - 내 정보, 학원 일정, 학원 소개, 로그아웃=> 메인화면에서 쓸만한것만 정리 작업해야될듯.ㅡ
        menuItems.add(new MenuItem("LMS 홈", R.drawable.main_cahr));
        menuItems.add(new MenuItem("내 정보", R.drawable.main_cahr));
        menuItems.add(new MenuItem("학원 일정", R.drawable.main_cahr));
        menuItems.add(new MenuItem("시간표", R.drawable.main_cahr));
        menuItems.add(new MenuItem("로그아웃", R.drawable.main_cahr));

        return menuItems;
    }
    public void setMenuClickTeacher(int position , String title){
        Intent intent = null;
        Fragment fragment = null;
        if(position == 0){
            isHomeFragment = true;
            b.imgvBack.setVisibility(View.INVISIBLE);
            changeFragment( new HomeFragment() , title);
        }else if ( position == 1){
            changeFragment( new MyInfoFragment(), title);
        }else if (position == 2){
            changeFragment(  new AcCalenarFragment(), title);
        }else if (position == 3){
            changeFragment(  new MyLectureFragment(), title);
        }else if (position == 4){
            changeFragment(  new CounselFragment(), title);
        }else if (position == 5){
            intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }



    }
    public void setMenuClickStudent(int position , String title){
        Intent intent = null;
        Fragment fragment = null;
        if(position == 0){
            isHomeFragment = true;
            b.imgvBack.setVisibility(View.INVISIBLE);
            changeFragment( new HomeFragment() , title);
        }else if ( position == 1){
            changeFragment( new MyInfoFragment(), title);
        }else if (position == 2){
            changeFragment(  new AcCalenarFragment(), title);
        }else if (position == 3){
            changeFragment(  new TimeTableFragment(), title);
        }else if (position == 4){
            intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }



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
    private long backpressedTime = 0;

    @Override
    public void onBackPressed() {
        if(isHomeFragment) {
            if (System.currentTimeMillis() > backpressedTime + 2000) {
                backpressedTime = System.currentTimeMillis();
                Toast.makeText(this, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
            } else if (System.currentTimeMillis() <= backpressedTime + 2000) {
                finish();
            }
        }else{
            changeFragment(new HomeFragment() , "홈");
        }
    }

    public void changeFragment(Fragment fragment , String title){

            b.tvMenu.setText(title);
        if(fragment instanceof HomeFragment){
            isHomeFragment = true;
            b.container.setBackgroundColor(Color.parseColor("#123456"));
            b.imgvBack.setVisibility(View.INVISIBLE);
        }else{
            isHomeFragment = false;
            b.imgvBack.setVisibility(View.VISIBLE);
            b.container.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container , fragment).commit();
    }

    public void changeActivity(Class activity){
        Intent intent = new Intent(HomeActivity.this , activity);
        startActivity(intent);
    }
}