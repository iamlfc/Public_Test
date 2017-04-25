package com.ruanmeng.project_model.myscroll;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.ruanmeng.project_model.R;
import com.ruanmeng.utils.CommonUtil;

public class MyTextScroll extends AppCompatActivity {
    private ImageView img01;
    private ImageView img02;
    private ImageView img03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_scroll);

        initView();
    }

    private void initView() {
        img01 = (ImageView) findViewById(R.id.img_01);
        img02 = (ImageView) findViewById(R.id.img_02);
        img03 = (ImageView) findViewById(R.id.img_03);
        img01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonUtil.showToask(MyTextScroll.this, "图片01");
            }
        });
        img02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonUtil.showToask(MyTextScroll.this, "图片02");

            }
        });
        img03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonUtil.showToask(MyTextScroll.this, "图片03");

            }
        });

    }
}
