package com.example.test.clipchildren;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.test.R;

/**
 * 扑克开奖指引
 */
public class TestView extends RelativeLayout {
    
    private Context mContext;
    
    ImageView imgvLight;
    
    Button imgvGuide;
    
    private TopGuideCallBack mCallBack;

    public void setCallBack(TopGuideCallBack mCallBack) {
        this.mCallBack = mCallBack;
    }

    public TestView(Context context) {
        super(context);
        initView(context);
    }

    public TestView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    public void reset() {
        if(imgvLight != null) {
            imgvLight.clearAnimation();
            imgvLight.setVisibility(View.GONE);
        }
        setVisibility(View.GONE);
    }

    /**
     * 高亮
     */
    public void showLight() {
        if(imgvLight != null) {
            imgvLight.clearAnimation();
            AlphaAnimation alphaAnim = new AlphaAnimation(0.3f, 1.0f);
            alphaAnim.setDuration(300);
            alphaAnim.setRepeatMode(Animation.REVERSE);
            alphaAnim.setRepeatCount(2);
            alphaAnim.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                    imgvLight.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    if(mCallBack != null)
                        mCallBack.onLight();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            imgvLight.startAnimation(alphaAnim);
        }
    }

    private void initView(Context context) {
        inflate(context, R.layout.view_test, this);
        this.mContext = context;
        imgvLight = findViewById(R.id.imgv_light);
        imgvGuide = findViewById(R.id.imgv_guide);
        
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(imgvGuide != null)
            imgvGuide.clearAnimation();
    }

    public interface TopGuideCallBack {
        void onLight();
    }
    
}
