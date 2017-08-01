package com.ruanmeng.project_model.gitview.badgeview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ruanmeng.project_model.CeHuaShanChu.BaseActivity;
import com.ruanmeng.project_model.R;
import com.ruanmeng.utils.CommonUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class TestBadgeView extends BaseActivity {

    @BindView(R.id.tv_test)
    TextView tvTest;
    @BindView(R.id.btn_test)
    Button btnTest;
    @BindView(R.id.img_test)
    ImageView imgTest;
    @BindView(R.id.lay_test)
    LinearLayout layTest;
    @BindView(R.id.btn_normal)
    Button btnNormal;
    @BindView(R.id.activity_test_badge_view)
    LinearLayout activityTestBadgeView;

    Activity context = null;
    List<Badge> badges;
    Badge badge_tv, badge_img, badge_lay, badge_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_badge_view);
        ButterKnife.bind(this);
        context = TestBadgeView.this;
        initView();
        initBadge();
    }

    private void initView() {
        // TODO: 2017/8/1   布吉岛为什么  添加了 tagview之后   点击事件就不能用了    用原始的方式好像可以！
        // TODO: 2017/8/1     源码上写了  QBadgeView --> lien 150  中   获取 便签view的父布局  移除 该view 并新建一个  view(包含原view和 添加的角标！ 并设置 id 为 -1)  因此 onViewClicked  view.getid()不被触发！
        // TODO: 2017/8/1       targetView.setId(targetView.getId());
//      // TODO: 2017/8/1       targetView.setId(View.NO_ID);


        tvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonUtil.showToask(context, "badge_tv");
                badge_tv.hide(true);
            }
        });
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                CommonUtil.showToask(context, "badge_tv");
                badge_btn.hide(true);
            }
        });
        imgTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                CommonUtil.showToask(context, "badge_tv");
                badge_img.hide(true);
            }
        });
        layTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                badge_lay.hide(true);
            }
        });
    }

    private void initBadge() {
        badges = new ArrayList<>();
        badge_tv = new QBadgeView(this).bindTarget(tvTest).setBadgeNumber(5);
        badge_img = new QBadgeView(this).bindTarget(imgTest).setBadgeText("PNG").setBadgeTextColor(0x00000000)
                .setBadgeGravity(Gravity.BOTTOM | Gravity.END).setBadgeBackgroundColor(0xff03a9f4)
                .setBadgeBackground(getResources().getDrawable(R.drawable.shape_round_rect));
        badge_lay = new QBadgeView(this).bindTarget(layTest).setBadgeNumber(5);
        badge_btn = new QBadgeView(this).bindTarget(btnTest).setBadgeText("新").setBadgeTextSize(13, true)
                .setBadgeBackgroundColor(0xffffeb3b).setBadgeTextColor(0xff000000)
                .stroke(0xff000000, 1, true);
        badges.add(badge_tv);
        badges.add(badge_img);
        badges.add(badge_lay);
        badges.add(badge_btn);

        for (Badge badge : badges) {
            badge.setBadgeGravity(Gravity.END | Gravity.CENTER);  //设置Badge相对于TargetView的位置   位置 调整
            badge.setGravityOffset(10, 20, true); //     设置外边距   位置精确调整 上下左右间隔
            badge.setExactMode(true);    //   设置是否显示精确模式数值  超过99 显示 99+
            badge.setShowShadow(true);   //设置是否显示阴影
            badge.setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                @Override
                public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                    switch (dragState) {
                        case STATE_START:
                            Log.d("badge", "开始状态");

                            break;
                        case STATE_DRAGGING:
                            Log.d("badge", "拖拽ing");
                            break;
                        case STATE_DRAGGING_OUT_OF_RANGE:
                            Log.d("badge", "拖拽越界了");
                            break;
                        case STATE_SUCCEED:
                            Log.d("badge", "成功");
                            break;
                        case STATE_CANCELED:
                            Log.d("badge", "取消");
                            break;
                    }
                }
            });
        }
    }

    @OnClick({R.id.tv_test, R.id.btn_test, R.id.img_test, R.id.lay_test, R.id.btn_normal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
          /*  case R.id.tv_test:
                CommonUtil.showToask(context, "badge_tv");
                badge_tv.hide(true);
                break;
            case R.id.btn_test:
                CommonUtil.showToask(context, "btn_test");
                badge_btn.hide(true);
                break;
            case R.id.img_test:
                CommonUtil.showToask(context, "img_test");
                badge_img.hide(true);
                break;
            case R.id.lay_test:
                CommonUtil.showToask(context, "lay_test");
                badge_lay.hide(true);
                break;*/
            case R.id.btn_normal:
                for (Badge badge : badges) {
                    badge.hide(true);
                }
                break;
        }
    }

  /*  @OnClick({R.id.tv_test, R.id.btn_test, R.id.img_test, R.id.lay_test, R.id.btn_normal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_test:
                CommonUtil.showToask(context, "badge_tv");
                badge_tv.hide(true);

                break;
            case R.id.btn_test:
                CommonUtil.showToask(context, "btn_test");
                badge_btn.hide(true);

                break;
            case R.id.img_test:
                CommonUtil.showToask(context, "img_test");
                badge_img.hide(true);
                break;
            case R.id.lay_test:
                CommonUtil.showToask(context, "lay_test");
                badge_lay.hide(true);
                break;
            case R.id.btn_normal:
                for (Badge badge : badges) {
                    badge.hide(true);
                }
                break;
        }
    }*/
}
