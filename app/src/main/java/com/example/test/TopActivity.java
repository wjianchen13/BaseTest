package com.example.test;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

/**
 * 判断某个Activity是否在顶层
 */
public class TopActivity extends AppCompatActivity {

    protected ActivityManager mActivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        mActivityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
    }

    public void onTest1(View v) {
//        boolean isTop = isTopActivity(getTopTask(), "com.example.test", "TopActivity");
//        if (isTop) {
//
//        } else {
//
//        }

//        boolean isTop = isShowCallDialog(this);
//        System.out.println("==================> isTop: " + isTop);



    }

    private static String [] topActs = new String[]{"com.example.test.TopActivity"};

    /**
     * 判断是否显示拨入对话框
     * 用户在【充值/订阅界面】、【profile】、【聊天界面】显示
     * @param context
     * @return
     */
    public static boolean isShowCallDialog(Context context) {
        if(topActs != null && topActs.length > 0) {
            for(int i = 0; i < topActs.length; i++) {
                String act = topActs[i];
                if(!TextUtils.isEmpty(act)) {
                    String an = act;
                    if(isTopActivity(context, an)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     *
     * @param context
     * @return
     */
    public static boolean isTopActivity(Context context, String activityName) {
        if(context == null)
            return false;
        ActivityManager mActivityManager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = mActivityManager.getRunningTasks(1);
        if (tasks != null && !tasks.isEmpty()) {
            ActivityManager.RunningTaskInfo topTask =  tasks.get(0);
            if (topTask != null) {
                ComponentName topActivity = topTask.topActivity;
                if (topActivity.getClassName().equals(activityName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public ActivityManager.RunningTaskInfo getTopTask() {
        List<ActivityManager.RunningTaskInfo> tasks = mActivityManager.getRunningTasks(1);
        if (tasks != null && !tasks.isEmpty()) {
            return tasks.get(0);
        }
        return null;
    }

    public boolean isTopActivity(ActivityManager.RunningTaskInfo topTask, String packageName, String activityName) {
        if (topTask != null) {
            ComponentName topActivity = topTask.topActivity;
            if (topActivity.getPackageName().equals(packageName) && topActivity.getClassName().equals(activityName)) {
                return true;
            }
        }
        return false;
    }

}
