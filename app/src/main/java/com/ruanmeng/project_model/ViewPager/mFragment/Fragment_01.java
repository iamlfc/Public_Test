package com.ruanmeng.project_model.ViewPager.mFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ruanmeng.project_model.R;

/**
 * Created by Administrator on 2016/11/2.
 */
public class Fragment_01 extends BaseFragment {
    /**
     * 预加载标志，默认值为false，设置为true，表示已经预加载完成，可以加载数据
     */
    private boolean isPrepared;

    /**
     * Fragment生命周期方法，此view可改为自定义的布局
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lay_frag_01, container, false);
        Log.d("--lfc","onCreateView");


        //TODO 此处初始化view中各个控件
        isPrepared = true;
        setlazyLoad();
        return view;

    }

    /**
     * 加载数据的方法，只要保证isPrepared和isVisible都为true的时候才往下执行开始加载数据
     */
    @Override
    protected void setlazyLoad() {
        super.setlazyLoad();
        if (!isPrepared || !isVisible) {
            return;
        }
        //TODO 此处填充view中各个控件的数据
    }
    //调用这个方法切换时不会释放掉Fragment
    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (this.getView() != null)
            if (menuVisible) {
                this.getView().setVisibility(View.VISIBLE);
//                layoutEditview.setVisibility(View.GONE);
            } else {
                this.getView().setVisibility(View.GONE);

            }
//            this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
        Log.d("--lfc","setMenuVisibility");

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("--lfc","onCreateView");

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("--lfc","onCreateView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("--lfc","onCreateView");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("--lfc","onCreateView");

    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d("--lfc","onCreateView");
    }

}
