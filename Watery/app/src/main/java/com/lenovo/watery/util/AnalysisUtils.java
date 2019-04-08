package com.lenovo.watery.util;
import android.content.Context;
import android.content.SharedPreferences;

public class AnalysisUtils {
    /**
     * 从SharedPreferences中读取登录用户名
     */
    public  static String readLoginUserName(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginInfo",
                Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("loginUserName","");
        return userName;
    }
}
