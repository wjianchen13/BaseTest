package com.example.test.imagespan;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;

import androidx.core.content.ContextCompat;

import com.example.test.R;

/**
 * Created by Administrator on 2018/3/5 0005.
 */

public class KiwiiScreenUtils {

    /**
     * 居中对齐
     */
    public static final int KIWII_ALIGN_CENTER = 1;

    public static final int INTER_IMG_CHAT_NORMAL_HEIGHT = 17; //图标高度
    
    private static Context mContext;

    /**
     * 返回粉丝团徽章
     */
    public static SpannableString getFansBadgeImageSpan(Context context, String sid, String badge, int size, int verticalAlignment) {
        SpannableString spanStr = null;
        if (context != null && null != sid && !TextUtils.isEmpty(badge)) {
            spanStr = new SpannableString("img ");
            Drawable img = ContextCompat.getDrawable(context, R.drawable.bg_fans_group_badge);
            ImageSpan fansImageSpan = new KiwiiFansBadgeImageSpan(context, img, sid, badge, verticalAlignment, img.getIntrinsicWidth(), Math.max(size, img.getIntrinsicHeight()));
            spanStr.setSpan(fansImageSpan, 0, spanStr.length() - 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        }
        return spanStr == null ? new SpannableString("") : spanStr;
    }
    
    public static void setContext(Context context) {
        mContext = context;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        return (int) (dpValue * getDensity(mContext) + 0.5f);
    }

    /**
     * 返回屏幕密度
     */
    public static float getDensity(Context context) {
        try {
            return context.getResources().getDisplayMetrics().density;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 2.0f;
    }
    
    


}

