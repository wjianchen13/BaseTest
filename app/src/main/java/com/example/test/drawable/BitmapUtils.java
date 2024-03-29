package com.example.test.drawable;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.graphics.Canvas;
import android.graphics.ImageFormat;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.YuvImage;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;

import com.example.test.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;

/**
 *
 * @author : Dumplings
 * @version : v1.0.0
 * @ClassName : BitmapUtils.java
 * @Function ：
 * @Description ：
 * @Idea :
 * {@link  }
 * @Encourage ：And the more we try to understand one another, the more exceptional each of us will be.
 * 我们越是努力理解他人，自身也越发变得优秀。
 * @date : 2021/7/6
 */
public final class BitmapUtils {

    public static final String TAG = "BitmapUtil";
    private static int sShotScreenWidth = 480;
    private static int sShotScreenHeight = 720;
    private static int sShotScreenSize = sShotScreenWidth * sShotScreenHeight;

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;
    @SuppressLint("StaticFieldLeak")
    private static Activity mActivity;

    public void init(Context context,Activity ac) {
        mContext=context;
        mActivity=ac;

        DisplayMetrics dm = new DisplayMetrics();
        ac.getWindowManager().getDefaultDisplay().getMetrics(dm);
        //获取屏幕分辨率
        sShotScreenWidth = dm.widthPixels;
        sShotScreenHeight = dm.heightPixels;
        sShotScreenSize = sShotScreenWidth * sShotScreenHeight;
    }

    /**
     * 图片合成
     * @return Bitmap
     */
    public static Bitmap createBet(Context context, int bet) {
        try {
            String snum = String.valueOf(bet);
            if (bet < 0 || TextUtils.isEmpty(snum) || context == null)
                return null;
            int size = snum.length();
            int num[] = new int[size];
            for (int i = 0; i < snum.length(); i++) {
                Character ch = snum.charAt(i);
                num[i] = Integer.parseInt(ch.toString());
            }

            Bitmap bitmap = getBetBitmap(context, size);
            Bitmap bitmaps[] = new Bitmap[size];
            int totalWidth = 0;
            int totalHeight = 0;
            for(int i = 0; i < size; i ++) {
                Bitmap b = getBitmapNum(context, num[i]);
                if (b != null) {
                    bitmaps[i] = b;
                    totalWidth += b.getWidth();
                    totalHeight = b.getHeight();
                }
            }
            
            int w = bitmap.getWidth();
            int h = bitmap.getHeight();
            
            System.out.println("=====> w: " + w + "  h: " + h);
            
            Bitmap newbitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);// 创建一个长宽一样的位图
            Canvas cv = new Canvas(newbitmap);
            cv.drawARGB(255,255,0,0);
            cv.drawBitmap(bitmap, 0, 0, null);// 在 0，0坐标开始画入bitmap
            int drawWidth = 0;
            for(int i = 0; i < bitmaps.length; i ++) {
                Bitmap bNum = bitmaps[i];
                if(bNum != null) {
                    int x = (w - totalWidth) / 2 + drawWidth;
                    int y = (w - totalHeight) / 2;
                    drawWidth += bNum.getWidth();
                    cv.drawBitmap(bNum, x , y , null);// 在右下角画入水印mark
                }

            }
            cv.save();// 保存 Canvas.ALL_SAVE_FLAG
            cv.restore();// 存储
            return newbitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private static Bitmap getBetBitmap(Context context, int num) {
        if(context == null || num < 1)
            return null;
        Bitmap b = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        if(num == 1) {
            b = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_bet, options);
        } else if(num == 2) {
            b = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_bet, options);
        } else if(num == 3) {
            b = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_bet, options);
        } else if(num == 4) {
            b = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_bet, options);
        }
        return b;
    }
    
    private static Bitmap getBitmapNum(Context context, int num) {
        if(context == null || num < 0)
            return null;
        Bitmap b = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        if(num == 0) {
            b = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_bet_0, options);
        } else if(num == 1) {
            b = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_bet_1, options);
        } else if(num == 2) {
            b = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_bet_2, options);
        } else if(num == 3) {
            b = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_bet_3, options);
        } else if(num == 4) {
            b = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_bet_4, options);
        } else if(num == 5) {
            b = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_bet_5, options);
        } else if(num == 6) {
            b = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_bet_6, options);
        } else if(num == 7) {
            b = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_bet_7, options);
        } else if(num == 8) {
            b = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_bet_8, options);
        } else if(num == 9) {
            b = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_bet_9, options);
        }
        return b;
    }

    /**
     * 图片合成
     *
     * @param bitmap 位图1
     * @param mark 位图2
     * @return Bitmap
     */
    public static Bitmap createBitmap(Bitmap bitmap, Bitmap mark) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        int mW = mark.getWidth();
        int mH = mark.getHeight();
        Bitmap newbitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);// 创建一个长宽一样的位图

        Canvas cv = new Canvas(newbitmap);
        cv.drawBitmap(bitmap, 0, 0, null);// 在 0，0坐标开始画入bitmap
        cv.drawBitmap(mark, w - mW , h - mH , null);// 在右下角画入水印mark
        cv.save();// 保存 Canvas.ALL_SAVE_FLAG
        cv.restore();// 存储
        return newbitmap;
    }

    /**
     * 放大缩小图片
     * @param bitmap 位图
     * @param w 新的宽度
     * @param h 新的高度
     * @return Bitmap
     */
    public static Bitmap zoomBitmap(Bitmap bitmap, int w, int h) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float scaleWidht = ((float) w / width);
        float scaleHeight = ((float) h / height);
        matrix.postScale(scaleWidht, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    /**
     * 旋转图片
     * @param bitmap 要旋转的图片
     * @param angle 旋转角度
     * @return bitmap
     */
    public static Bitmap rotate(Bitmap bitmap,int angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                bitmap.getHeight(), matrix, true);
    }

    /**
     * 圆形图片
     *@param source 位图
     * @param strokeWidth 裁剪范围 0表示最大
     * @param bl 是否需要描边
     * @param bl 画笔粗细
     * @param bl 颜色代码
     *  @return bitmap
     */
    public static Bitmap createCircleBitmap(Bitmap source, int strokeWidth, boolean bl,int edge,int color) {

        int diameter = source.getWidth() < source.getHeight() ? source.getWidth() : source.getHeight();
        Bitmap target = Bitmap.createBitmap(diameter, diameter, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(target);//创建画布

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawCircle(diameter / 2, diameter / 2, diameter / 2, paint);//绘制圆形
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));//取相交裁剪
        canvas.drawBitmap(source, strokeWidth, strokeWidth, paint);
        if(bl) {
            if (color == 0) color = 0xFFFEA248;//默认橘黄色
            paint.setColor(color);
            paint.setStyle(Paint.Style.STROKE);//描边
            paint.setStrokeWidth(edge);
            canvas.drawCircle(diameter / 2, diameter / 2, diameter / 2, paint);
        }
        return target;
    }

    /**
     * 圆角图片
     * @param bitmap 位图
     * @param rx x方向上的圆角半径
     * @param ry y方向上的圆角半径
     * @param bl 是否需要描边
     * @param bl 画笔粗细
     * @param bl 颜色代码
     * @return bitmap
     */
    public static Bitmap createCornerBitmap(Bitmap bitmap,int rx,int ry,boolean bl,int edge,int color) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);//创建画布

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        canvas.drawRoundRect(rectF, rx, ry, paint);//绘制圆角矩形
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));//取相交裁剪
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if(bl) {
            if (color == 0) color = 0xFFFEA248;//默认橘黄色
            paint.setColor(color);
            paint.setColor(color);
            paint.setStyle(Paint.Style.STROKE);//描边
            paint.setStrokeWidth(edge);
            canvas.drawRoundRect(rectF, rx, ry, paint);
        }
        return output;
    }

    /**
     *  按比例裁剪图片
     *  @param bitmap 位图
     *  @param wScale 裁剪宽 0~100%
     *  @param hScale 裁剪高 0~100%
     * @return bitmap
     */
    public static Bitmap cropBitmap(Bitmap bitmap, float wScale, float hScale) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        int wh = (int) (w * wScale);
        int hw = (int) (h * hScale);

        int retX = (int) (w * (1 - wScale) / 2);
        int retY = (int) (h * (1 - hScale) / 2);

        return Bitmap.createBitmap(bitmap, retX, retY, wh, hw, null, false);
    }

    /**
     * 获得带倒影的图片方法
     * @param bitmap 位图
     * @param region 倒影区域 0.1~1
     * @return bitmap
     */
    public static Bitmap createReflectionBitmap(Bitmap bitmap,float region) {

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(1, -1);//镜像缩放
        Bitmap reflectionBitmap = Bitmap.createBitmap(
                bitmap,0
                , (int)(height*(1-region))//从哪个点开始绘制
                , width
                ,(int) (height*region)//绘制多高
                , matrix, false);

        Bitmap reflectionWithBitmap = Bitmap.createBitmap(width,height+ (int) (height*region),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(reflectionWithBitmap);
        canvas.drawBitmap(bitmap, 0, 0, null);
        canvas.drawBitmap(reflectionBitmap, 0, height , null);

        LinearGradient shader = new LinearGradient(0, bitmap.getHeight(), 0,
                reflectionWithBitmap.getHeight()
                , 0x70ffffff, 0x00ffffff, Shader.TileMode.CLAMP);

        Paint paint = new Paint();
        paint.setShader(shader);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));//取两层绘制交集。显示下层。
        canvas.drawRect(0, height, width, reflectionWithBitmap.getHeight() , paint);
        return reflectionWithBitmap;
    }

    /**
     * 图片质量压缩
     * @param bitmap
     * @param many 百分比
     * @return
     */
    public static Bitmap compressBitmap(Bitmap bitmap, float many){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, (int)many*100, baos);
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
        return BitmapFactory.decodeStream(isBm, null, null);
    }

    /**
     * 高级图片质量压缩
     *@param bitmap 位图
     * @param maxSize 压缩后的大小，单位kb
     */
    public static Bitmap imageZoom(Bitmap bitmap, double maxSize) {
        // 将bitmap放至数组中，意在获得bitmap的大小（与实际读取的原文件要大）
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 格式、质量、输出流
        bitmap.compress(Bitmap.CompressFormat.PNG, 70, baos);
        byte[] b = baos.toByteArray();
        // 将字节换成KB
        double mid = b.length / 1024;
        // 获取bitmap大小 是允许最大大小的多少倍
        double i = mid / maxSize;
        // 判断bitmap占用空间是否大于允许最大空间 如果大于则压缩 小于则不压缩
        doRecycledIfNot(bitmap);
        if (i > 1) {
            // 缩放图片 此处用到平方根 将宽带和高度压缩掉对应的平方根倍
            // （保持宽高不变，缩放后也达到了最大占用空间的大小）
            return scaleWithWH(bitmap,bitmap.getWidth() / Math.sqrt(i),
                    bitmap.getHeight() / Math.sqrt(i));
        }
        return null;
    }

    /***
     * 图片缩放
     *@param bitmap 位图
     * @param w 新的宽度
     * @param h 新的高度
     * @return Bitmap
     */
    public static Bitmap scaleWithWH(Bitmap bitmap, double w, double h) {
        if (w == 0 || h == 0 || bitmap == null) {
            return bitmap;
        } else {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();

            Matrix matrix = new Matrix();
            float scaleWidth = (float) (w / width);
            float scaleHeight = (float) (h / height);

            matrix.postScale(scaleWidth, scaleHeight);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height,
                    matrix, true);
        }
    }

    /**
     * YUV视频流格式转bitmap
     * @param data YUV视频流格式
     * @return width 设置宽度
     * @return width 设置高度
     */
    public static Bitmap getBitmap(byte[] data, int width, int height) {
        Bitmap bitmap;
        YuvImage yuvimage = new YuvImage(data, ImageFormat.NV21, width, height, null);
        //data是onPreviewFrame参数提供
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        yuvimage.compressToJpeg(new Rect(0, 0, yuvimage.getWidth(), yuvimage.getHeight()), 100, baos);//
        // 80--JPG图片的质量[0-100],100最高
        byte[] rawImage = baos.toByteArray();
        BitmapFactory.Options options = new BitmapFactory.Options();
        SoftReference<Bitmap> softRef = new SoftReference<Bitmap>(BitmapFactory.decodeByteArray(rawImage, 0, rawImage
                .length, options));
        bitmap = softRef.get();
        return bitmap;
    }

    /**
     * 图片资源文件转bitmap
     * @param resId 图片的绝对路径
     * @return bitmap
     */
    public static Bitmap getBitmapResources(Context context,int resId){
        return BitmapFactory.decodeResource(context.getResources(),resId);
    }

    /**
     * 将图片路径转Bitmap
     * @Param path 图片路径
     * @return Bitmap
     */
    public static Bitmap getBitmapPath(String path){
        return BitmapFactory.decodeFile(path);
    }

    /**
     * bitmap保存到指定路径
     * @param file 图片的绝对路径
     * @param file 位图
     * @return bitmap
     */
    public static boolean saveFile(String file, Bitmap bmp) {
        if(TextUtils.isEmpty(file) || bmp == null) {
            return false;
        }

        File f = new File(file);
        if (f.exists()) {
            f.delete();
        }else {
            File p = f.getParentFile();
            if(!p.exists()) {
                p.mkdirs();
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(f);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 回收一个未被回收的Bitmap
     *@param bitmap
     */
    public static void doRecycledIfNot(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }
    /**
     * 将图片转换成Base64编码的字符串
     */
    public static String imageToBase64(String path){
        if(TextUtils.isEmpty(path)){
            return null;
        }
        InputStream is = null;
        byte[] data = null;
        String result = null;
        try{
            is = new FileInputStream(path);
            //创建一个字符流大小的数组。
            data = new byte[is.available()];
            //写入数组
            is.read(data);
            //用默认的编码格式进行编码
            result = Base64.encodeToString(data,Base64.DEFAULT);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null !=is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return result;
    }
}


