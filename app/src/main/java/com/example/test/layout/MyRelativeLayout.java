package com.example.test.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class MyRelativeLayout extends RelativeLayout {
    
    public MyRelativeLayout(Context context) {
        super(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), 1800);
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        final int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        final int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        
        System.out.println("=======> widthMode: " + getMode(widthMode) + "  heightMode: " + getMode(heightMode) + "  widthSize: " + widthSize + "  heightSize: " + heightSize);
    }
    
    private String getMode(int mode) {
        if(MeasureSpec.EXACTLY == mode) {
            return "EXACTLY";
        } else if(MeasureSpec.AT_MOST == mode) {
            return "AT_MOST";
        } else {
            return "UNSPECIFIED";
        }
    }
}
