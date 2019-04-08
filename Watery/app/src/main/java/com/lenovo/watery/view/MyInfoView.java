package com.lenovo.watery.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lenovo.watery.R;
import com.lenovo.watery.LoginActivity;
import com.lenovo.watery.util.AnalysisUtils;


public class MyInfoView {
    private Context mContext;
    private final LayoutInflater mInflater;
    private View mCurrentView;
    private LinearLayout ll_head;
    private ImageView iv_head_icon;
    private RelativeLayout rl_course_history;
    private RelativeLayout rl_setting;
    private TextView tv_user_name;

    /**
     * 由于SharedPreferences是通过context读取的，所以从构造方法中传递一个context
     * @param mContext
     */
    public MyInfoView(Context mContext){
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    /**
     * 获取当前在导航栏上方显示对应的View
     */
    public View getView(){
        if (mCurrentView == null) {
            createView();//调用initView()
        }
        return mCurrentView;
    }

    private void createView() {
        initView();
    }

    /**
     * 获取控件填充布局
     * inflater布局填充器
     */
    private void initView() {
        mCurrentView = mInflater.inflate(R.layout.main_view_myinfo, null);
        ll_head = (LinearLayout) mCurrentView.findViewById(R.id.ll_head);
        iv_head_icon = (ImageView) mCurrentView.findViewById(R.id.iv_head_icon);

        rl_course_history = (RelativeLayout) mCurrentView.findViewById(R.id.rl_course_history);
        rl_setting = (RelativeLayout) mCurrentView.findViewById(R.id.rl_setting);
        tv_user_name = (TextView) mCurrentView.findViewById(R.id.tv_user_name);

        //用户名需要根据不同的登录状态进行不同的展示
        setLoginParams(readLoginStatus());//拿到登录状态作为参数传递进去

        //处理控件交互
        ll_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断是否已经登录
                if(readLoginStatus()){
                    //已登录跳转到个人资料界面

                }else{
                    //未登录跳转到登录界面
                    Intent intent=new Intent(mContext,LoginActivity.class);
                    ((Activity)mContext).startActivityForResult(intent,1);
                }
            }
        });

        rl_course_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(readLoginStatus()){
                    //跳转到播放记录界面

                }else{
                    Toast.makeText(mContext, "您还未登录，请先登录", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rl_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(readLoginStatus()){
                    //跳转到设置界面

                }else{
                    Toast.makeText(mContext, "您还未登录，请先登录", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * 登录成功后设置我的界面
     */
    public void setLoginParams(boolean isLogin) {
        if(isLogin){
            tv_user_name.setText(AnalysisUtils.readLoginUserName(mContext));
        }else{
            tv_user_name.setText("点击登录");
        }
    }

    /**
     * 从SharedPreferences中读取登录状态
     * @return
     */
    private boolean readLoginStatus(){
        SharedPreferences sp=mContext.getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        boolean isLogin=sp.getBoolean("isLogin", false);
        return isLogin;
    }

    /**
     * 显示当前导航栏上方所对应的view界面
     */
    public void showView() {
        if (mCurrentView == null){
            createView();
        }
        mCurrentView.setVisibility(View.VISIBLE);
    }
}

