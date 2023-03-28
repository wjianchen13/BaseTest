package com.example.test.drawable;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;

import androidx.annotation.ColorInt;

/**
 * 圆角TextView
 */
public class RoundRectTextView extends androidx.appcompat.widget.AppCompatTextView {

    private int alpha = 50; // 10%透明度

    public RoundRectTextView(Context context) {
        this(context, null);
    }

    public RoundRectTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundRectTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initBackground(String color){
        int red = ColorUtils.getRed(color);
        int green = ColorUtils.getGreen(color);
        int blue = ColorUtils.getBlue(color);
        int realColor = Color.argb(255, red, green, blue);
        setTextColor(realColor);
        setBackground(createDrawable(Color.argb(alpha, red, green, blue), realColor, 10));
    }

    /**
     * 创建背景
     * @param contentColor 填充颜色
     * @param strokeColor 边框颜色
     * @param radius 圆角
     * @return
     */
    private GradientDrawable createDrawable(int contentColor, int strokeColor, int radius) {
        GradientDrawable drawable = new GradientDrawable(); // 生成Shape
        drawable.setGradientType(GradientDrawable.RECTANGLE); // 设置矩形
        drawable.setColor(contentColor);// 内容区域的颜色
        drawable.setStroke(6, strokeColor); // 四周描边,描边后四角真正为圆角，不会出现黑色阴影。如果父窗体是可以滑动的，需要把父View设置setScrollCache(false)
        drawable.setCornerRadius(radius); // 设置四角都为圆角
        return drawable;
    }

}
