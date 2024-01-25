package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.choreographer.ChoreographerActivity;
import com.example.test.clipchildren.ClipChildrenActivity;
import com.example.test.drawable.CreateDrawableActivity;
import com.example.test.exception.ExceptionActivity;
import com.example.test.gson.GsonActivity;
import com.example.test.half.HalfActivity;
import com.example.test.html.HtmlActivity;
import com.example.test.interfacetest.InterfaceActivity;
import com.example.test.layout.LayoutActivity;
import com.example.test.level.ViewLevelActivity;
import com.example.test.loop.LoopActivity;
import com.example.test.member.DoubleActivity;
import com.example.test.parcelable.ParcelableActivity;
import com.example.test.permission.PermissionActivity;
import com.example.test.reduce.ReduceActivity;
import com.example.test.regular.RegularActivity;
import com.example.test.testclass.ClassActivity;
import com.example.test.vertical.VerticalTestActivity;
import com.example.test.zip.ZipActivity;

/**
 * 时间统计， selector动态生成
 */
public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 时间时长
     * @param v
     */
    public void onTime(View v) {
        startActivity(new Intent(this, TimeActivity.class));
    }

    /**
     * 
     * @param v
     */
    public void onLambda(View v) {
        startActivity(new Intent(this, LambdaActivity.class));
    }

    /**
     *
     * @param v
     */
    public void onLevelList(View v) {
        startActivity(new Intent(this, LevelActivity.class));
    }

    /**
     * 动态生成drawable
     * @param v
     */
    public void onCreateDrawable(View v) {
        startActivity(new Intent(this, DrawableActivity.class));
    }

    /**
     * 普通测试
     * @param v
     */
    public void onNormalTest(View v) {
        startActivity(new Intent(this, NormalTestActivity.class));
    }

    /**
     * Html.fromHtml() 测试
     * @param v
     */
    public void onHtml(View v) {
        startActivity(new Intent(this, HtmlActivity.class));
    }

    /**
     * 屏幕密度测试
     * @param v
     */
    public void onDensity(View v) {
        startActivity(new Intent(this, DensityActivity.class));
    }

    /**
     * RadioButton测试
     * @param v
     */
    public void onRadioButton(View v) {
        startActivity(new Intent(this, RadioButtonActivity.class));
    }

    /**
     * 动态添加控件
     * @param v
     */
    public void onAddLayout(View v) {
        startActivity(new Intent(this, AddLayoutActivity.class));
    }

    /**
     * PopupWindow
     * @param v
     */
    public void onPopupWindow(View v) {
        startActivity(new Intent(this, PopupWindowActivity.class));
    }

    /**
     * 多线程锁机制
     * @param v
     */
    public void onLock(View v) {
        startActivity(new Intent(this, LockActivity.class));
    }

    /**
     * 循环播放
     * @param v
     */
    public void onLoop(View v) {
        startActivity(new Intent(this, LoopActivity.class));
    }

    /**
     * Parcelable 测试
     * @param v
     */
    public void onParcelable(View v) {
        startActivity(new Intent(this, ParcelableActivity.class));
    }

    /**
     * 长按触发事件
     * @param v
     */
    public void onTouch(View v) {
        startActivity(new Intent(this, TouchActivity.class));
    }

    /**
     * Choreographer 测试
     * @param v
     */
    public void onChoreographer(View v) {
        startActivity(new Intent(this, ChoreographerActivity.class));
    }

    /**
     * 普通布局测试
     * @param v
     */
    public void onLayout(View v) {
        startActivity(new Intent(this, LayoutActivity.class));
    }

    /**
     * 常规测试
     * @param v
     */
    public void onTest1(View v) {
        startActivity(new Intent(this, ClipChildrenActivity.class));
    }

    /**
     * Button状态同步
     * @param v
     */
    public void onState(View v) {
        startActivity(new Intent(this, StateActivity.class));
    }

    /**
     * 判断Activity是否在顶层
     * @param v
     */
    public void onTop(View v) {
        startActivity(new Intent(this, TopActivity.class));
    }

    /**
     * 判断Activity是否在顶层
     * @param v
     */
    public void onGson(View v) {
        startActivity(new Intent(this, GsonActivity.class));
    }

    /**
     * 浮点型运算
     * @param v
     */
    public void onDouble(View v) {
        startActivity(new Intent(this, DoubleActivity.class));
    }

    /**
     * Queue测试
     * @param v
     */
    public void onQueue(View v) {
        startActivity(new Intent(this, QueueActivity.class));
    }

    /**
     * String拼接
     * @param v
     */
    public void onString(View v) {
        startActivity(new Intent(this, StringActivity.class));
    }

    /**
     * 动态生成drawable
     * @param v
     */
    public void onDrawable(View v) {
        startActivity(new Intent(this, CreateDrawableActivity.class));
    }

    /**
     * 接口子类类型判断
     * @param v
     */
    public void onInterface(View v) {
        startActivity(new Intent(this, InterfaceActivity.class));
    }

    /**
     * EditText提示问题
     * @param v
     */
    public void onEditText(View v) {
        startActivity(new Intent(this, EditTextActivity.class));
    }

    /**
     * 添加阴影
     * @param v
     */
    public void onShadow(View v) {
        startActivity(new Intent(this, ShadowActivity.class));
    }

    /**
     * 跑马灯
     * @param v
     */
    public void onMarquee(View v) {
        startActivity(new Intent(this, MarqueeActivity.class));
    }

    /**
     * Class测试
     * @param v
     */
    public void onClass(View v) {
        startActivity(new Intent(this, ClassActivity.class));
    }

    /**
     * 减小控件点击区域
     * @param v
     */
    public void onReduce(View v) {
        startActivity(new Intent(this, ReduceActivity.class));
    }

    /**
     * 跳转到权限设置页面
     * @param v
     */
    public void onPermission(View v) {
        startActivity(new Intent(this, PermissionActivity.class));
    }

    /**
     * 正则表达式
     * @param v
     */
    public void onRegular(View v) {
        startActivity(new Intent(this, RegularActivity.class));
    }

    /**
     * TextView
     * @param v
     */
    public void onTextView(View v) {
        startActivity(new Intent(this, TextViewActivity.class));
    }

    /**
     * 垂直显示TextView中间内容
     * @param v
     */
    public void onVerticalTest(View v) {
        startActivity(new Intent(this, VerticalTestActivity.class));
    }

    /**
     * 异常模拟
     * @param v
     */
    public void onException(View v) {
        startActivity(new Intent(this, ExceptionActivity.class));
    }

    /**
     * 半屏Activity
     * @param v
     */
    public void onHalf(View v) {
        startActivity(new Intent(this, HalfActivity.class));
    }

    /**
     * 测试当天是否有操作
     * @param v
     */
    public void onDay(View v) {
        startActivity(new Intent(this, CurrentDayActivity.class));
    }

    /**
     * 改变View的层级
     * @param v
     */
    public void onLevel(View v) {
        startActivity(new Intent(this, ViewLevelActivity.class));
    }

    /**
     * ViewStub判断
     * @param v
     */
    public void onViewStub(View v) {
        startActivity(new Intent(this, ViewStubActivity.class));
    }

    /**
     * url替换操作
     * @param v
     */
    public void onUrl(View v) {
        startActivity(new Intent(this, UrlActivity.class));
    }

    /**
     * zip 压缩
     * @param v
     */
    public void onZip(View v) {
        startActivity(new Intent(this, ZipActivity.class));
    }

    /**
     * 渐变圆环
     * @param v
     */
    public void onRing(View v) {
        startActivity(new Intent(this, RingActivity.class));
    }

}