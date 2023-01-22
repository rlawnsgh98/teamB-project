package com.example.teamb_project.drawer;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.applikeysolutions.cosmocalendar.selection.OnDaySelectedListener;
import com.applikeysolutions.cosmocalendar.selection.SingleSelectionManager;
import com.applikeysolutions.cosmocalendar.settings.appearance.ConnectedDayIconPosition;
import com.applikeysolutions.cosmocalendar.settings.lists.connected_days.ConnectedDays;
import com.applikeysolutions.cosmocalendar.view.CalendarView;
import com.example.conn.CommonMethod;

import com.example.teamb_project.R;
import com.example.teamb_project.TTAdapter;
import com.example.teamb_project.databinding.ActivityAcCalendarBinding;
import com.example.teamb_project.vo.BoardVO;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class AcCalendarActivity extends AppCompatActivity {
//    Toolbar top_toolbar;
//    RecyclerView tt_recv_list;
//    CalendarView calendarView;
    ActivityAcCalendarBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityAcCalendarBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        b.calendarView.setWeekendDays(new HashSet(){{
            add(Calendar.SATURDAY);
            add(Calendar.SUNDAY);
        }});
        b.calendarView.setWeekendDayTextColor(Color.parseColor("#FF0000"));

        new CommonMethod().sendPost("dates.mj", new CommonMethod.CallBackResult() {

            @Override
            public void result(boolean isResult, String data) {
                ArrayList<BoardVO> aclist = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<BoardVO>>(){}.getType());
                Set<Long> days = new TreeSet<>();
                for(int i = 0 ; i < aclist.size() ; i ++){

                    Log.d("로그", "onDaySelected: " + new SimpleDateFormat("yyyy-MM-dd").format( aclist.get(i).getWritedate().getTime()));
                    days.add(aclist.get(i).getWritedate().getTime()  );
                }


                int textColor = Color.parseColor("#0040FF");
                int selectedTextColor = Color.parseColor("#0040FF");
                int disabledTextColor = Color.parseColor("#0040FF");
                ConnectedDays connectedDays = new ConnectedDays(days, textColor, selectedTextColor, disabledTextColor);
                b.calendarView.addConnectedDays(connectedDays);
                b.calendarView.setConnectedDayIconRes(R.drawable.selection_date);
                b.calendarView.setConnectedDaySelectedIconRes(R.drawable.selection_date);
                b.calendarView.setConnectedDayIconPosition(ConnectedDayIconPosition.TOP);

                b.calendarView.setCalendarOrientation(ConstraintLayout.LayoutParams.HORIZONTAL);
                b.calendarView.setFirstDayOfWeek(Calendar.SUNDAY);
                b.calendarView.update();
            }
        });
        b.calendarView.setSelectionManager(new SingleSelectionManager(new OnDaySelectedListener() {
            @Override
            public void onDaySelected() {
                Log.d("로그", "onDaySelected: " + b.calendarView.getSelectedDates());
                Log.d("로그", "onDaySelected: " + new SimpleDateFormat("yyyy-MM-dd").format(b.calendarView.getSelectedDays().get(0).getCalendar().getTime()) );
                Date date = b.calendarView.getSelectedDays().get(0).getCalendar().getTime() ;

                new CommonMethod().setParams("writedate",new SimpleDateFormat("yyyy-MM-dd").format(b.calendarView.getSelectedDays().get(0).getCalendar().getTime()))
                        .sendPost("aclist.mj", new CommonMethod.CallBackResult() {
                            @Override
                            public void result(boolean isResult, String data) {
                                ArrayList<BoardVO> aclist = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().fromJson(data, new TypeToken<ArrayList<BoardVO>>(){}.getType());


                                if(aclist != null) {
                                    b.ttRecvList.setAdapter(new TTAdapter(getLayoutInflater(), aclist));
                                    b.ttRecvList.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
                                }
                            }
                        });
            }
        }));
    }
}