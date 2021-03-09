package com.example.test;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test.lambda.InterfaceWithParams;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 时间统计， selector动态生成
 */
public class TimeActivity extends AppCompatActivity {

    private ImageView imgvTest;
    private long nowMills;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        imgvTest = findViewById(R.id.imgv_test);
        nowMills = getRealtime();
        System.out.println("===============> currentMills: " + nowMills);
//        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
//        shapeDrawable.getPaint().setColor(Color.BLACK);
//        Rect rect = new Rect();
//        rect.top = 0;
//        rect.left = 0;
//        rect.bottom = 50;
//        rect.right = 50;
//        shapeDrawable.setBounds(rect);
        
    }
    
    public void onTest(View v) {
//        Drawable drawable = createDrawableSelector(this);
//        imgvTest.setBackground(drawable);

//        onEventValue(nowMills);
//        System.out.println("===============> test: " + Base.class.isAssignableFrom(Impl.class));

        InterfaceWithParams params = new InterfaceWithParams() {
            @Override
            public void run(String s) {
                System.out.println("通过" + s + "实现run(String)");
            }
        };
        InterfaceWithParams params1 = (String s) -> System.out.println("通过" + s + "实现run(String)");

        params.run("匿名类");
        params1.run("Lambda");
        
    }

    /**
     * 统计时长
     * @param time
     */
    public static void onEventValue(long time) {
        System.out.println("===============> time: " + time);
        long nowMills = getRealtime();
        System.out.println("===============> nowMills: " + nowMills);
        double duration = nowMills > time ? (double)(nowMills - time) / 1000 : 0;
        double du = round((double)duration, 0, BigDecimal.ROUND_HALF_UP);
        System.out.println("===============> duration: " + round(duration) + "  duration1: " + du);
    }

    /**
     * 返回开机后，经过的时间，包括深度睡眠的时间
     * @return
     */
    public static long getRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public static double round(double value) {
        return round(value, 2, BigDecimal.ROUND_HALF_UP);
    }
    
    /**
     * 对double数据进行取精度.
     *
     * @param value        double数据.
     * @param scale        精度位数(保留的小数位数).
     * @param roundingMode 精度取值方式.
     * @return 精度计算后的数据.
     */
    public static double round(double value, int scale, int roundingMode) {
        try {
            return new BigDecimal(value)
                    .setScale(scale, roundingMode)
                    .doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * double转换成int，四舍五入
     * @param value
     * @return
     */
    public static int double2Int(double value) {
        try {
            return extNumInt(new DecimalFormat().format(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int extNumInt(String numStr) {
        try {
            return Integer.parseInt(extNumIntStr(numStr));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static @NonNull
    String extNumIntStr(String numStr) {
        if (TextUtils.isEmpty(numStr))
            return "";
        if (numStr.contains("."))
            numStr = numStr.substring(0, numStr.indexOf("."));
        return numStr.replaceAll("\\D", "");
    }
    

    private StateListDrawable createDrawableSelector(Context context) {
        Drawable checked = new ColorDrawable(getResources().getColor(R.color.colorPrimary));
        Drawable unchecked = new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark));
        Drawable disabled = new ColorDrawable(getResources().getColor(R.color.colorAccent));
        StateListDrawable stateList = new StateListDrawable();
        int statePressed = android.R.attr.state_pressed;
        int stateChecked = android.R.attr.state_checked;
        int stateFocused = android.R.attr.state_focused;
        int stateensable = android.R.attr.state_enabled;
        stateList.addState(new int[] {-stateensable}, disabled);
        stateList.addState(new int[] {stateChecked}, checked);
        stateList.addState(new int[] {statePressed}, checked);
        stateList.addState(new int[] {stateFocused}, checked);
        stateList.addState(new int[] {}, unchecked);
        return stateList;
        
        
    }
    
    
    
}