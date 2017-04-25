package com.ruanmeng.project_model.gitview.mySuperTextview;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ruanmeng.project_model.CeHuaShanChu.BaseActivity;
import com.ruanmeng.project_model.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyTestTextView extends BaseActivity {

    @BindView(R.id.tv_my_suptertext)
    TextView tvMySuptertext;
    @BindView(R.id.activity_my_test_text_view)
    LinearLayout activityMyTestTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_test_text_view);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {

        String name1 = "我是头";
        String name2 = "我是中间的";
        String name3 = "我是小尾巴";
        String str = name1 + name2 + name3;
        final SpannableStringBuilder sp = new SpannableStringBuilder(str);
        sp.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.App_Zi)), 0, name1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //字体颜色
        sp.setSpan(new AbsoluteSizeSpan(18, true), 0, name1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //字体大小
        sp.setSpan(new ForegroundColorSpan(0xFFFF0000), (name1 + name2).length(), str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //字体颜色
        sp.setSpan(new AbsoluteSizeSpan(10, true), (name1 + name2).length(), str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //字体大小

//        这个 SpannableStringBuilder 如果转为 tostring 就没有作用了！
        tvMySuptertext.setText(sp);

    }
}
