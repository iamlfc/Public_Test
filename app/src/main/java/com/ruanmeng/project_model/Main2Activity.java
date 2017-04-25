package com.ruanmeng.project_model;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ruanmeng.project_model.mycrash.CrashManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    String errorInformation = "";
    @BindView(R.id.tv_boom_test)
    TextView tvBoomTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        errorInformation = CrashManager.getAllErrorDetailsFromIntent(Main2Activity.this, getIntent());
        tvBoomTest.setText(errorInformation);

    }
}
