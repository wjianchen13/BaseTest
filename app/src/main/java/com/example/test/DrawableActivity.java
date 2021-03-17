package com.example.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;

/**
 * 动态生成drawable
 */
public class DrawableActivity extends AppCompatActivity {

    private TextView tvTest;

    /**
     * 字体区域信息
     */
    private Rect bLevel = new Rect();
    
    /**
     * 等级背景图片宽度
     */
    private int width;

    /**
     * 等级背景图片高度
     */
    private int height;

    /**
     * 小于11级文字区域左边距 设计稿是16dp
     */
    private int mLowMarginLeft;

    /**
     * 小于11级文字距离右侧和左侧距离差 设计稿是13.5dp - 7.5dp = 6dp
     */
    private int mLowDistance;

    /**
     * 大于等于11级文字区域左边距 设计稿是17dp
     */
    private int mHighMarginLeft;

    /**
     * 大于等于11级文字距离右侧和左侧距离差 设计稿是9dp - 4dp = 5dp
     */
    private int mHighDistance;

    public static final int SIZETYPE_B = 1; // 获取文件大小单位为B的double值
    public static final int SIZETYPE_KB = 2; // 获取文件大小单位为KB的double值
    public static final int SIZETYPE_MB = 3; // 获取文件大小单位为MB的double值
    public static final int SIZETYPE_GB = 4; // 获取文件大小单位为GB的double值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);
        tvTest = findViewById(R.id.tv_test);
        width = dip2px(40);
        height = dip2px(17);
        mLowMarginLeft = dip2px(16);
        mLowDistance = dip2px(6);
        mHighMarginLeft = dip2px(17);
        mHighDistance = dip2px(5);
    }

    /**
     * lambda表达式测试
     * @param v
     */
    public void onTest1(View v) {
        tvTest.setBackground(setTextToImg(10));
    }

    public void onTest2(View v) {
        tvTest.setBackground(getLevelDrawable(12));
    }

    public void onTest3(View v) {
        tvTest.setBackground(drawNewBitmap(56));
    }

    public void onTest4(View v) {
        double fileSizeLong = Double.valueOf(".00");
        System.out.println("===================> fileSizeLong: " + fileSizeLong);
    }

    public void onTest5(View v) {
        double a = FormetFileSize(1, SIZETYPE_MB);
        System.out.println("===================> a: " + a);
    }

    /**
     * 转换文件大小,指定转换的类型
     *
     * @param fileS
     * @param sizeType
     * @return
     */
    private static double FormetFileSize(long fileS, int sizeType) {
        DecimalFormat df = new DecimalFormat("#.00");
        double fileSizeLong = 0;
        switch (sizeType) {
            case SIZETYPE_B:
                fileSizeLong = Double.valueOf(df.format((double) fileS));
                break;
            case SIZETYPE_KB:
                fileSizeLong = Double.valueOf(df.format((double) fileS / 1024));
                break;
            case SIZETYPE_MB:
                fileSizeLong = Double.valueOf(df.format((double) fileS / 1048576));
                break;
            case SIZETYPE_GB:
                fileSizeLong = Double.valueOf(df.format((double) fileS / 1073741824));
                break;
            default:
                break;
        }
        return fileSizeLong;
    }

    /**
     * 获取文字X轴偏移坐标
     * @param level
     * @param textWidth
     * @return
     */
    private int getTextLocationX(int level, int textWidth) {
        return level < 11
                ? (width - mLowMarginLeft - textWidth - mLowDistance) / 2 + mLowMarginLeft
                : (width - mHighMarginLeft - textWidth - mHighDistance) / 2 + mHighMarginLeft;
    }
    
    /**
     * 文字绘制在图片上，并返回bitmap对象、
     * 使用这种方式在不同分辨率上会存在问题，应该要重新生成 一个bitmap，参考下面的实现方式
     */
    private Drawable setTextToImg(int level) {
        BitmapDrawable icon = (BitmapDrawable) getResources().getDrawable(R.drawable.ic_level_1);

        Bitmap bitmap = icon.getBitmap().copy(Bitmap.Config.ARGB_8888, true);
        System.out.println("===============> bitmap width: " + bitmap.getWidth() + "  height: " + bitmap.getHeight());
        String text = String.valueOf(level);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        // 抗锯齿
        paint.setAntiAlias(true);
        // 防抖动
        paint.setDither(true);
        paint.setTextSize(dip2px(10));
        //            paint.setTypeface(Typeface.DEFAULT_BOLD);
        Typeface font = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD);
        paint.setTypeface(font);
        paint.setFakeBoldText(true);
        paint.setColor(Color.parseColor("#ffffff"));
        paint.getTextBounds(text, 0, text.length(), bLevel);
        int xl = getTextLocationX(level, bLevel.width());
        float yl = (float) (height + bLevel.height()) / 2 - dip2px(1.0f);
        canvas.drawText(text, xl, yl, paint);
        Drawable drawable = new BitmapDrawable(getResources(), bitmap);
        Rect rect = drawable.getBounds();
//        drawable.setBounds(new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()));
        int l = rect.left;
        int t = rect.top;
        int r = rect.right;
        int b = rect.bottom;
        System.out.println("===============> left: " + l + "  top: " + t + "  right: " + r + "  bottom: " + b);
        System.out.println("===============> width: " + (r - l) + "  right: " + (b - t));
        System.out.println("===============> drawable width: " + drawable.getIntrinsicWidth() + "  height: " + drawable.getIntrinsicHeight());
        
        return drawable;
    }
    
    public Drawable getLevelDrawable(int level) {
//        BitmapDrawable icon = (BitmapDrawable) getResources().getDrawable(R.drawable.ic_level_1);
        BitmapDrawable icon = (BitmapDrawable) ContextCompat.getDrawable(this, R.drawable.ic_level_1);

        Bitmap bitmap = icon.getBitmap().copy(Bitmap.Config.ARGB_8888, true);
        String text = String.valueOf(level);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        // 抗锯齿
        paint.setAntiAlias(true);
        // 防抖动
        paint.setDither(true);
        paint.setTextSize(dip2px(10));
        Typeface font = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD);
        paint.setTypeface(font);
        paint.setFakeBoldText(true);
        paint.setColor(Color.parseColor("#ffffff"));
        paint.getTextBounds(text, 0, text.length(), bLevel);
        int xl = getTextLocationX(level, bLevel.width());
        float yl = (float) (height + bLevel.height()) / 2 - dip2px(1.0f);
        canvas.drawText(text, xl, yl, paint);
        Drawable drawable = new BitmapDrawable(getResources(), bitmap);
        drawable.setBounds(new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()));
        return drawable;
    }
    
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dip2px(float dpValue) {
        return (int) (dpValue * getDensity(this) + 0.5f);
    }


    /**
     * 返回屏幕密度
     */
    public float getDensity(Context context) {
        try {
            return context.getResources().getDisplayMetrics().density;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 2.0f;
    }

    /**
     * 使用这种方式可以兼容不同分辨率
     * @param level
     * @return
     */
    private Drawable drawNewBitmap(int level) {
        Bitmap photo = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_level_1);
        System.out.println("===============> bitmap width: " + photo.getWidth() + "  height: " + photo.getHeight());
        int width = dip2px(40);
        int hight = dip2px(17);
        if(photo != null) {
            width = photo.getWidth();
            hight = photo.getHeight();
        }
        Bitmap icon = Bitmap.createBitmap(width, hight, Bitmap.Config.ARGB_8888);
        System.out.println("===============> icon width: " + icon.getWidth() + "  height: " + photo.getHeight());

        Canvas canvas = new Canvas(icon);
        Paint paint = new Paint();
        paint.setDither(true); // 获取更清晰的图像采样，防抖动
        paint.setFilterBitmap(true); // 过滤一下，抗剧齿
        Rect rect = new Rect(0, 0, photo.getWidth(), photo.getHeight());// 创建一个指定的新矩形的坐标
        canvas.drawBitmap(photo, rect, rect, paint);// 将photo 缩放或则扩大到dst使用的填充区photoPaint
        
        String text = String.valueOf(level);
        Paint textPaint = new Paint();;
        textPaint.setAntiAlias(true); // 抗锯齿
        textPaint.setDither(true); // 防抖动
        textPaint.setTextSize(dip2px(10));
        Typeface font = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD);
        textPaint.setTypeface(font);
        textPaint.setFakeBoldText(true);
        textPaint.setColor(Color.parseColor("#ffffff"));
        textPaint.getTextBounds(text, 0, text.length(), bLevel);
        int xl = getTextLocationX(level, bLevel.width());
        float yl = (float) (height + bLevel.height()) / 2 - dip2px(0.5f);
        canvas.drawText(text, xl, yl, textPaint);
        return new BitmapDrawable(getResources(), icon);
    }

    //设置画笔的字体和颜色
    public TextPaint myTextPaint() {
        TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DEV_KERN_TEXT_FLAG);// 设置画笔

        textPaint.setTextSize(dip2px(10));// 字体大小
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);// 采用默认的宽度
        textPaint.setColor(Color.argb(255, 94, 38, 18));// 采用的颜色
        return textPaint;
    }

    //写入文字，自动换行的方法
    public void drawText(Canvas canvas, TextPaint Paint,String textString,int x,int y,int width) {
        //int Width=Math.round(width* getRATIO());
        int start_x=Math.round(x );
        int start_y=Math.round(y );
        StaticLayout staticLayout=new StaticLayout(textString, Paint, width-start_x*2,
                Layout.Alignment.ALIGN_NORMAL, 1.5f, 0.0f, false);

        //绘制的位置  
        canvas.translate(start_x, start_y);
        staticLayout.draw(canvas);
    }
}
