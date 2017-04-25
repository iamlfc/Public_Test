package com.ruanmeng.project_model.calendar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ruanmeng.calendarview.CalendarCard;
import com.ruanmeng.calendarview.CalendarViewAdapter;
import com.ruanmeng.calendarview.CustomDate;
import com.ruanmeng.project_model.R;
import com.ruanmeng.project_model.ViewPager.ext.navigator.DummyCircleNavigator;
import com.ruanmeng.utils.CommonUtil;

import java.util.ArrayList;
import java.util.List;

public class Calendar5Activity extends AppCompatActivity {
    private DummyCircleNavigator vpCalendar;


    private int month = 7;

    private CalendarViewAdapter<CalendarCard> adapter;
    private SildeDirection mDirection = SildeDirection.NO_SILDE;

    enum SildeDirection {RIGHT, LEFT, NO_SILDE;}
    private int mCurrentIndex = 498;
    private CalendarCard[] mShowViews;
    private List<String> dates = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar5);
        initView();
    }

    private void initView() {
        vpCalendar = (DummyCircleNavigator) findViewById(R.id.vp_calendar);
        CalendarCard[] views = new CalendarCard[3];
        for (int i = 0; i < 3; i++) {
            views[i] = new CalendarCard(this, new CalendarCard.OnCellClickListener() {
                @Override
                public void clickDate(CustomDate date) {
                    CommonUtil.showToask(Calendar5Activity.this, date.year + "年" + date.month + "月" + date.day + "日");
                    getData(date);
                }

                @Override
                public void changeDate(CustomDate date) {

//                    tv_time.setText(date.year + "年" + date.month + "月");
                    month = date.month;
                    if (date.month < 9) {
//                        tv_time.setText(date.year + "年0" + date.month + "月");
                    }

                }
            });
        }

        adapter = new CalendarViewAdapter<>(views);

        /*vpCalendar.setAdapter(adapter);
        vpCalendar.setCurrentItem(mCurrentIndex);
        vpCalendar.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                measureDirection(position);
                updateCalendarView(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });*/

    }
    private void getData(CustomDate date) {
 /*
//        通过固定集合的长度  获取 选择的是 哪一个  并替换

        dates.add(date.year + "-" + date.month + "-" + date.day);

        int page = vpCalendar.getCurrentItem() % 3;
        mShowViews = adapter.getAllItems();
        mShowViews[page].setQiandaoList(dates);*/
    }



    // 更新日历视图
    private void updateCalendarView(int arg0) {
        mShowViews = adapter.getAllItems();
        if (mDirection == SildeDirection.RIGHT) {
            mShowViews[arg0 % mShowViews.length].rightSlide();
        } else if (mDirection == SildeDirection.LEFT) {
            mShowViews[arg0 % mShowViews.length].leftSlide();
        }
        mDirection = SildeDirection.NO_SILDE;
    }

}
