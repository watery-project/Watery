package com.lenovo.watery;

import android.app.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lenovo.watery.view.MyInfoView;

import static com.lenovo.watery.R.id.main_bottom_bar;


public class MainActivity extends Activity implements View.OnClickListener {
    //界面内容
    private FrameLayout mBodyLayout;
    //底部按钮栏
    public LinearLayout mBottomLayout;
    //底部按钮
    private View mCourseBtn;
    private View mExercisesBtn;
    private View mCommunityBtn;
    private View mMyInfoBtn;

    private TextView tv_course;
    private TextView tv_exercises;
    private TextView tv_community;
    private TextView tv_myInfo;

    private ImageView iv_course;
    private ImageView iv_exercises;
    private  ImageView iv_community;
    private ImageView iv_myInfo;

    //标题栏
    private TextView tv_back;
    private TextView tv_main_title;
    private RelativeLayout rl_title_bar;

    private MyInfoView myInfoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initBottomBar();
        setListener();
        setInitStatus();}

       /* if(Build.VERSION.SDK_INT >= 26){
            String channelId = "chat";
            String channelName = "聊天消息";
            int importance =NotificationManager.IMPORTANCE_HIGH;
            createNotificationChannel(channelId,channelName,importance);

            channelId = "subscribe";
            channelName = "订阅消息";
            importance = NotificationManager.IMPORTANCE_DEFAULT;
            createNotificationChannel(channelId,channelName,importance);
        }*/


    /**
     * 设置初始选择
     */
    private void setInitStatus() {
        clearBottomImageState();
        setSelectedStatus(0);
        createView(0);
    }

    /**
     * 为每个按钮设置监听方法
     */
    private void setListener() {
        for (int i = 0; i < mBottomLayout.getChildCount(); i++) {
            mBottomLayout.getChildAt(i).setOnClickListener(this);
        }
    }

    /**
     * 获取底部导航栏上的控件
     */
    private void initBottomBar() {
        mBottomLayout = findViewById(main_bottom_bar);

        mCourseBtn = findViewById(R.id.bottom_bar_course_btn);
        mExercisesBtn = findViewById(R.id.bottom_bar_exercises_btn);
        mCommunityBtn = findViewById(R.id.bottom_bar_community_btn);
        mMyInfoBtn =  findViewById(R.id.bottom_bar_myinfo_btn);

        tv_course = (TextView) findViewById(R.id.bottom_bar_text_course);
        tv_exercises = (TextView) findViewById(R.id.bottom_bar_text_exercises);
        tv_community = (TextView)findViewById(R.id.bottom_bar_text_community);
        tv_myInfo = (TextView) findViewById(R.id.bottom_bar_text_myinfo);

        iv_course = (ImageView) findViewById(R.id.bottom_bar_image_course);
        iv_exercises = (ImageView) findViewById(R.id.bottom_bar_image_exercises);
        iv_community = (ImageView)findViewById(R.id.bottom_bar_image_community);
        iv_myInfo = (ImageView) findViewById(R.id.bottom_bar_image_myinfo);
    }

    /**
     * 获取界面上的UI控件
     */
    private void init() {
        tv_back = (TextView) findViewById(R.id.tv_back);
        tv_main_title = (TextView) findViewById(R.id.tv_main_title);
        tv_main_title.setText("Watery");
        rl_title_bar = (RelativeLayout) findViewById(R.id.title_bar);
        rl_title_bar.setBackgroundColor(Color.parseColor("#30B4FF"));
        tv_back.setVisibility(View.GONE);//不显示返回按钮
        initBodyLayout();

    }

    /**
     * 界面内容
     */
    private void initBodyLayout() {
        mBodyLayout = findViewById(R.id.main_body);
    }

    /**
     * 控件的点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //"今日"的点击事件
            case R.id.bottom_bar_course_btn:
                clearBottomImageState();
                selectDisplayView(0);
                break;
            //统计的点击事件
            case R.id.bottom_bar_exercises_btn:
                clearBottomImageState();
                selectDisplayView(1);
                break;
            //社区的点击事件
            case R.id.bottom_bar_community_btn:
                clearBottomImageState();
                selectDisplayView(2);
            //我的点击事件
            case R.id.bottom_bar_myinfo_btn:
                clearBottomImageState();
                selectDisplayView(3);
                break;
            default:
                break;
        }
    }

    /**
     * 显示对应的页面
     *
     * @param i
     */
    private void selectDisplayView(int i) {
        removeAllView();
        createView(i);
        setSelectedStatus(i);
    }


    /**
     * 设置底部按钮选中状态
     *
     * @param i
     */
    private void setSelectedStatus(int i) {
        switch (i) {
            case 0:
                mCourseBtn.setSelected(true);
                iv_course.setImageResource(R.drawable.today_icon_selected);
                tv_course.setTextColor(Color.parseColor("#0097F7"));
                rl_title_bar.setVisibility(View.VISIBLE);
                tv_main_title.setText("今日饮水");
                break;
            case 1:
                mExercisesBtn.setSelected(true);
                iv_exercises.setImageResource(R.drawable.statistics_selected);
                tv_exercises.setTextColor(Color.parseColor("#0097F7"));
                rl_title_bar.setVisibility(View.VISIBLE);
                tv_main_title.setText("饮水统计");
                break;
            case 2:
                mCommunityBtn.setSelected(true);
                iv_community.setImageResource(R.drawable.community_icon_selected);
                tv_community.setTextColor(Color.parseColor("#0097f7"));
                rl_title_bar.setVisibility(View.VISIBLE);
                tv_main_title.setText("社区交流");
                break;
            case 3:
                mMyInfoBtn.setSelected(true);
                iv_myInfo.setImageResource(R.drawable.main_my_icon_selected);
                tv_myInfo.setTextColor(Color.parseColor("#0097F7"));
                rl_title_bar.setVisibility(View.VISIBLE);
                tv_main_title.setText("我的");
                break;

        }
    }


    /**
     * 选择视图
     *
     * @param viewIndex
     */
    private void createView(int viewIndex) {
        switch (viewIndex) {
            case 0:
                //TODO:主界面
                break;
            case 1:
                //统计界面
                break;
            case 2:
                //社区界面
                break;

            case 3:
                //我的界面
                if(myInfoView == null){
                    myInfoView =new MyInfoView(this);
                    mBodyLayout.addView(myInfoView.getView());
                }else{
                    myInfoView.getView();
                }
                myInfoView.showView();
                break;
        }
    }

    /**
     * 移除不需要的视图
     */
    private void removeAllView() {
        for (int i = 0; i < mBodyLayout.getChildCount(); i++) {
            mBodyLayout.getChildAt(i).setVisibility(View.GONE);
        }
    }

    /**
     * 清除底部按钮的选中状态
     */
    private void clearBottomImageState() {
        tv_course.setTextColor(Color.parseColor("#666666"));
        tv_exercises.setTextColor(Color.parseColor("#666666"));
        tv_community.setTextColor(Color.parseColor("#666666"));
        tv_myInfo.setTextColor(Color.parseColor("#666666"));

        iv_course.setImageResource(R.drawable.today_icon);
        iv_exercises.setImageResource(R.drawable.statistics);
        iv_community.setImageResource(R.drawable.community_icon);
        iv_myInfo.setImageResource(R.drawable.main_my_icon);

        for (int i = 0; i < mBottomLayout.getChildCount(); i++) {
            mBottomLayout.getChildAt(i).setSelected(false);
        }
    }

    protected long exitTime;//记录第一次点击时的时间

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {//按返回键、按下动作
            if ((System.currentTimeMillis() - exitTime) > 2000) {//导入java.lang的包
                Toast.makeText(this, "再按一次退出watery", Toast.LENGTH_LONG).show();
                exitTime = System.currentTimeMillis();
            } else {
                MainActivity.this.finish();
                if (readLoginStatus()) {
                    //如果退出此应用时是登录状态，则需要清除登录状态，同时需清除登录时的用户名
                    clearLoginStatus();
                }
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 清除SharedPreferences中的登录状态
     */
    private void clearLoginStatus() {
        SharedPreferences sp = getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();//获取编辑器
        editor.putBoolean("isLogin", false);//清除登录状态
        editor.putString("loginUserName", "");//清除登录时的用户名
        editor.commit();//提交修改
    }

    /**
     * 获取SharedPreferences中的登录状态
     *
     * @return
     */
    private boolean readLoginStatus() {
        SharedPreferences sp = getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        boolean isLogin = sp.getBoolean("isLogin", false);
        return isLogin;
    }
}

   /* @TargetApi(26)
    private void createNotificationChannel(String channelId,String channelName,int importance)
    {
        NotificationChannel channel = new NotificationChannel(channelId,channelName,importance);
        channel.setShowBadge(true);
        NotificationManager notificationManager = (NotificationManager)getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);

    }

    @TargetApi(Build.VERSION_CODES.O)
    public void sendChatMsg(View view){
        PendingIntent pendingIntent = PendingIntent.getActivities(this, 0, new Intent[]{new Intent(this, MainActivity.class)}, 0);

        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= 26){
            NotificationChannel channel = manager.getNotificationChannel("chat");
            if(channel.getImportance() == NotificationManager.IMPORTANCE_NONE){
                Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
                intent.putExtra(Settings.EXTRA_APP_PACKAGE,getPackageName());
                intent.putExtra(Settings.EXTRA_CHANNEL_ID,channel.getId());
                startActivity(intent);
                Toast.makeText(this,"请手动将通知打开",Toast.LENGTH_SHORT).show();;
            }
        }
        Notification notification = new Notification.Builder(this,"chat")
                .setContentTitle("收到一条聊天消息")
                .setContentText("您该喝水了，亲亲。")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.watery)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.watery))
                .setAutoCancel(true)
                .build();
        manager.notify(1,notification);
    }
    @TargetApi(Build.VERSION_CODES.O)
    public void sendSubscribeMsg(View view){
        PendingIntent pendingIntent = PendingIntent.getActivities(this, 0, new Intent[]{new Intent(this, MainActivity.class)}, 0);
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification.Builder(this,"subscribe")
                .setContentTitle("收到一条订阅消息")
                .setContentText("不喝水的十大危害！震惊！")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.watery)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.watery))
                .setAutoCancel(true)
                .setNumber(2)
                .build();
        manager.notify(2,notification);
    }*/

