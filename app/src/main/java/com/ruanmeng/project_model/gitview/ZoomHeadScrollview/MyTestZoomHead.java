package com.ruanmeng.project_model.gitview.ZoomHeadScrollview;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ruanmeng.project_model.CeHuaShanChu.BaseActivity;
import com.ruanmeng.project_model.R;
import com.ruanmeng.utils.CommonUtil;

public class MyTestZoomHead extends BaseActivity {

    private HeadZoomScrollView activityMyTestZoomHead;
    private ImageView imgZoomview;
    private LinearLayout layClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_test_zoom_head);
        initView();
    }

    private void initView() {
        activityMyTestZoomHead = (HeadZoomScrollView) findViewById(R.id.activity_my_test_zoom_head);
        imgZoomview = (ImageView) findViewById(R.id.img_zoomview);
        layClick = (LinearLayout) findViewById(R.id.lay_click);

        activityMyTestZoomHead.setZoomView(imgZoomview);
        layClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonUtil.showToask(MyTestZoomHead.this, "不能点呦！");

            }
        });
    }
}
