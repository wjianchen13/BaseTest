package com.example.test;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

/**
 * Drawable镜像
 */
public class MirrorActivity extends AppCompatActivity {

    private ImageView imgvTest1;
    private ImageView imgvTest2;
    private TextView tv = null;
    private Drawable mDrawable1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mirror);
        imgvTest1 = findViewById(R.id.imgv_test1);
        imgvTest2 = findViewById(R.id.imgv_test2);

    }

    public void onTest1(View v) {
        mDrawable1 = ContextCompat.getDrawable(this, R.drawable.ic_msg_swipe_reply);
        imgvTest1.setImageDrawable(mDrawable1);
        imgvTest2.setImageDrawable(getReversalDrawable(ContextCompat.getDrawable(this, R.drawable.ic_msg_swipe_reply)));
    }

    /**
     * 获取到水平翻转的Drawable
     * @return
     */
    private Drawable getReversalDrawable (Drawable drawable) {
        if(drawable == null)
            return null;
        Drawable originalDrawable = drawable;
        Bitmap flippedBitmap = Bitmap.createBitmap(originalDrawable.getIntrinsicWidth(), originalDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(flippedBitmap);
        Matrix matrix = new Matrix();
        matrix.setScale(-1, 1);
        matrix.postTranslate(flippedBitmap.getWidth(), 0);
        canvas.concat(matrix);
        originalDrawable.setBounds(0, 0, originalDrawable.getIntrinsicWidth(), originalDrawable.getIntrinsicHeight());
        originalDrawable.draw(canvas);

        BitmapDrawable flippedDrawable = new BitmapDrawable(getResources(), flippedBitmap);
        return flippedDrawable;
    }

}
