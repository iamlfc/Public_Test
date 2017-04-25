package com.ruanmeng.project_model.myscroll;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ruanmeng.project_model.R;
import com.ruanmeng.utils.CommonUtil;

public class MyTestScroll2 extends AppCompatActivity {
    private LinearLayout activityMyTestScroll2;
    private LinearLayout layDemo01;
    private LinearLayout layDemo02;
    private LinearLayout layDemo03;
    private LinearLayout layDemo04;
    private LinearLayout layDemo05;
    private ImageView imgText01;
    private ImageView imgText02;
    private ImageView imgText03;
    private ImageView imgText04;
    private ImageView imgText05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_test_scroll2);
        initVIew();
    }

    private void initVIew() {


        activityMyTestScroll2 = (LinearLayout) findViewById(R.id.activity_my_test_scroll);
        layDemo01 = (LinearLayout) findViewById(R.id.lay_demo01);
        layDemo02 = (LinearLayout) findViewById(R.id.lay_demo02);
        layDemo03 = (LinearLayout) findViewById(R.id.lay_demo02);
        layDemo04 = (LinearLayout) findViewById(R.id.lay_demo02);
        layDemo05 = (LinearLayout) findViewById(R.id.lay_demo02);


        imgText01 = (ImageView) findViewById(R.id.img_text_01);
        imgText02 = (ImageView) findViewById(R.id.img_text_02);
        imgText03 = (ImageView) findViewById(R.id.img_text_03);
        imgText04 = (ImageView) findViewById(R.id.img_text_04);
        imgText05 = (ImageView) findViewById(R.id.img_text_05);

        layDemo01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonUtil.showToask(MyTestScroll2.this, "点击一下");
            }
        });
//        layDemo02.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                CommonUtil.showToask(MyTestScroll2.this, "点击一下");
//
//            }
//        });
//        layDemo03.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                CommonUtil.showToask(MyTestScroll2.this, "点击一下");
//
//            }
//        });
//        layDemo04.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                CommonUtil.showToask(MyTestScroll2.this, "点击一下");
//
//            }
//        });
        layDemo05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonUtil.showToask(MyTestScroll2.this, "点击一下");

            }
        });


    }
}
