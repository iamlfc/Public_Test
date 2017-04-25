package com.ruanmeng.project_model.calendar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.ruanmeng.calendarview.CalendarCard;
import com.ruanmeng.calendarview.CustomDate;
import com.ruanmeng.project_model.R;
import com.ruanmeng.project_model.mynohttp.myxrev.BaseRecyclerAdapter;
import com.ruanmeng.project_model.mynohttp.myxrev.RecyclerViewHolder;
import com.ruanmeng.utils.CommonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Calendar4Activity extends AppCompatActivity {

    private List<CalendarCard> mlist = new ArrayList<>();
    private List<String> dates = new ArrayList<>();
    private int month = 7;

    private MyAdapter adapter = null;
    CalendarCard[] views = null;
    LinearLayoutManager lm = null;
    private RecyclerView rlvCalendar;

    private Activity bcontext = null;
    int allsize = 3;

    int mfirstvisiible = 0;
    int mlastvisible = 0;
    private SildeDirection mDirection = SildeDirection.NO_SILDE;
    private CalendarCard[] mviews = null;
    private FrameLayout framTest;

    private void initView() {
        framTest = (FrameLayout) findViewById(R.id.fram_test);
    }

    enum SildeDirection {UP, Down, NO_SILDE;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar4);
        bcontext = this;
        initViewe();
        initView();
    }

    private void initViewe() {

//        changeTitle("测试日历", "啥东西");
        rlvCalendar = (RecyclerView) Calendar4Activity.this.findViewById(R.id.rlv_calendar_lfc);
//        rlvCalendar = (RecyclerView) findViewById(R.id.rlv_calendar);
        lm = new LinearLayoutManager(Calendar4Activity.this);
        rlvCalendar.setLayoutManager(lm);
//
        mviews = new CalendarCard[3];
        for (int i = 0; i < 3; i++) {
            mviews[i] = new CalendarCard(this, new CalendarCard.OnCellClickListener() {
                @Override
                public void clickDate(CustomDate date) {
                    CommonUtil.showToask(Calendar4Activity.this, date.year + "年" + date.month + "月" + date.day + "日");
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
        mlist = Arrays.asList(mviews);
        adapter = new MyAdapter(bcontext, mlist);
        rlvCalendar.setAdapter(adapter);
        rlvCalendar.setItemAnimator(new DefaultItemAnimator());
        rlvCalendar.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int firstvisiible = lm.findFirstVisibleItemPosition();
                int lastvisible = lm.findLastVisibleItemPosition();
                if (firstvisiible > mfirstvisiible && lastvisible > mlastvisible) {
//                    向下滑动
                    mDirection = SildeDirection.UP;
                } else if (firstvisiible < mfirstvisiible && lastvisible < mlastvisible) {
//向上滑动
                    mDirection = SildeDirection.Down;

                } else {
                    mDirection = SildeDirection.NO_SILDE;
                }
                mfirstvisiible = firstvisiible;
                mlastvisible = lastvisible;
                updateCalendarView(mfirstvisiible);

            }
        });
    }


    private void getData(CustomDate date) {
        dates.clear();
        dates.add(date.year + "-" + date.month + "-" + date.day);

    }

    public class MyAdapter extends BaseRecyclerAdapter<CalendarCard> {

        public MyAdapter(Context ctx, List<CalendarCard> list) {
            super(ctx, list);
        }

        @Override
        protected int getItemLayoutId(int viewType) {
            return R.layout.item_calendar;
        }

        @Override
        public int getItemCount() {
            return allsize;
        }

        @Override
        protected void bindData(RecyclerViewHolder holder, final int position, CalendarCard item) {

            FrameLayout fm = (FrameLayout) holder.getView(R.id.lay_calendar);
            View view = mlist.get(position);
            if (position == 0) {
                framTest.addView(view);
            }

            if (fm.getChildCount() != 0) {
                fm.removeAllViews();
            }
            fm.addView(view);
          /*  CalendarCard calendarCard = new CalendarCard(bcontext, new CalendarCard.OnCellClickListener() {
                @Override
                public void clickDate(CustomDate date) {
                    CommonUtil.showToask(Calendar4Activity.this, date.year + "年" + date.month + "月" + date.day + "日");
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
            });*/
//            TextView tv = new TextView(bcontext);
//            tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayoutCompat.LayoutParams.WRAP_CONTENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
//            tv.setText("123456");

        }

    }

    // 更新日历视图
    private void updateCalendarView(int arg0) {
//        views = sho;

        if (mDirection == SildeDirection.UP) {
            mviews[arg0 % mviews.length].upSlide();
        } else if (mDirection == SildeDirection.Down) {
            mviews[arg0 % mviews.length].downSlide();
        }
        mDirection = SildeDirection.NO_SILDE;
    }

}
