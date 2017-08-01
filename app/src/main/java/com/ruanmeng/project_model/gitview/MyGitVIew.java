package com.ruanmeng.project_model.gitview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ruanmeng.project_model.R;
import com.ruanmeng.project_model.gitview.ZoomHeadScrollview.MyTestZoomHead;
import com.ruanmeng.project_model.gitview.badgeview.TestBadgeView;
import com.ruanmeng.project_model.gitview.myRulerview.RulerView_Activity;
import com.ruanmeng.project_model.gitview.mySuperTextview.MyTestTextView;
import com.ruanmeng.project_model.gitview.mycheckbox.MyCheckBox;
import com.ruanmeng.project_model.gitview.myflashtv.MyFlashTextView;
import com.ruanmeng.project_model.gitview.myprogress.MyTestProgress;
import com.ruanmeng.project_model.gitview.web_progress.MyProgress_WebView;
import com.ruanmeng.utils.CircularAnimUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyGitVIew extends AppCompatActivity {

    @BindView(R.id.btn_my_probar)
    Button btnMyProbar;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn_my_flashtv)
    Button btnMyFlashtv;
    @BindView(R.id.btn_my_box)
    Button btnMyBox;
    @BindView(R.id.btn_my_rulerview)
    Button btnMyRulerview;
    @BindView(R.id.btn_my_pro_web)
    Button btnMyProWeb;
    @BindView(R.id.btn_my_textview)
    Button btnMyTextview;
    @BindView(R.id.btn_my_zoomscroll)
    Button btnMyZoomscroll;
    @BindView(R.id.btn_badge)
    Button btnBadge;


    private Activity bContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_git_view);
        bContext = this;
        ButterKnife.bind(this);

//        initView();
    }

    private void initView() {
        CircularAnimUtil.show(btnMyProbar);
        CircularAnimUtil.show(btn2);
        CircularAnimUtil.show(btnMyFlashtv);
    }

    @OnClick({R.id.btn_my_probar, R.id.btn2, R.id.btn_my_flashtv, R.id.btn_my_box, R.id.btn_my_rulerview, R.id.btn_my_pro_web, R.id.btn_my_textview, R.id.btn_my_zoomscroll,R.id.btn_badge})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_my_probar:

//                startActivity(new Intent(bContext, MyTestProgress.class));
//                转圈启动动画
                //                      bContext： Context                      btnMyProbar 动画的初始控件
                CircularAnimUtil.startActivity(bContext, new Intent(bContext, MyTestProgress.class), btnMyProbar, R.color.material_blue);
//                CircularAnimUtil.startActivity(bContext, new Intent(bContext, MyTestProgress.class), btnMyProbar, R.drawable.icon2);
                break;
            case R.id.btn_my_flashtv:
//                initView();
                startActivity(new Intent(bContext, MyFlashTextView.class));
                break;
            case R.id.btn_my_box:

                startActivity(new Intent(bContext, MyCheckBox.class));
                break;
            case R.id.btn_my_rulerview:

                startActivity(new Intent(bContext, RulerView_Activity.class));
                break;
            case R.id.btn_my_pro_web:

                startActivity(new Intent(bContext, MyProgress_WebView.class));
                break;
            case R.id.btn_my_textview:
                startActivity(new Intent(bContext, MyTestTextView.class));

                break;
            case R.id.btn_my_zoomscroll:
                startActivity(new Intent(bContext, MyTestZoomHead.class));
                break;
            case R.id.btn_badge:
                startActivity(new Intent(bContext, TestBadgeView.class));
                break;
            case R.id.btn2:
                break;
        }
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.shake, R.anim.trans_center_2_right);
    }

}
