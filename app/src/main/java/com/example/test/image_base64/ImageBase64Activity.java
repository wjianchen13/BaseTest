package com.example.test.image_base64;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.uitls.Utils;

import java.io.ByteArrayOutputStream;

/**
 * android 图片和base64相互转换
 */
public class ImageBase64Activity extends AppCompatActivity {

    private ImageView imgvTest;
    private static String mString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_base64);
        imgvTest = (ImageView)findViewById(R.id.imgv_test);

    }

    /**
     * 图片转base64
     * @param v
     */
    public void onTest1(View v) {
        Resources res=getResources();

        Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.bg_rule_test);
        mString = convertImageToBase64(bmp);
    }

    public String convertImageToBase64(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }

    /**
     * base64转图片
     * @param v
     */
    public void onTest2(View v) {
        if(!TextUtils.isEmpty(mString)) {
            Bitmap decodedImage = convertBase64ToImage(mString);
            Utils.log("=============================> width: " + decodedImage.getWidth() + "  height: " + decodedImage.getHeight());
            imgvTest.setImageBitmap(decodedImage);
        }
    }

    public Bitmap convertBase64ToImage(String base64String) {
        byte[] imageBytes = Base64.decode(base64String, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
    }

}
