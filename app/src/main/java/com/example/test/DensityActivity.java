package com.example.test;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 测试不同屏幕面对对应的资源问题
 */
public class DensityActivity extends AppCompatActivity {
    
    TextView tvTest1;
    TextView tvTest2;
    TextView tvTest3;
    TextView tvTest4;
    TextView tvTest5;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_density);
        tvTest1 = findViewById(R.id.tv_test_1);
        tvTest2 = findViewById(R.id.tv_test_2);
        tvTest3 = findViewById(R.id.tv_test_3);
        tvTest4 = findViewById(R.id.tv_test_4);
        tvTest5 = findViewById(R.id.tv_test_5);
        tvTest1.setText(getResources().getDimension(R.dimen.dino_test) + "");
        getAndroiodScreenProperty();
    }
    
    public void onTest(View v) {
        getAndroiodScreenProperty();
    }


    public void getAndroiodScreenProperty(){
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;// 屏幕宽度（像素）  
        int height= dm.heightPixels; // 屏幕高度（像素） 
        tvTest2.setText("像素 width: " + width + "  height: " + height);
        float density = dm.density;//屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = dm.densityDpi;//屏幕密度dpi（120 / 160 / 240） 
        tvTest3.setText("density: " + density + "  densityDpi: " + densityDpi);
        //屏幕宽度算法:屏幕宽度（像素）/屏幕密度
        int screenWidth = (int) (width/density);//屏幕宽度(dp)
        int screenHeight = (int)(height/density);//屏幕高度(dp)
        System.out.println("========================>  getAndroiodScreenProperty screenWidth=" + screenWidth + "; screenHeight=" + screenHeight);
        String dp = "screenWidth=" + screenWidth + "; screenHeight=" + screenHeight;
        tvTest4.setText("dp 值: " + dp);
        
        
        
    }
    
    private void density() {
        // 获取屏幕密度（方法1）
        int screenWidth  = getWindowManager().getDefaultDisplay().getWidth();		// 屏幕宽（像素，如：480px）
        int screenHeight = getWindowManager().getDefaultDisplay().getHeight();		// 屏幕高（像素，如：800p）

        System.out.println("========================>  getDefaultDisplay screenWidth=" + screenWidth + "; screenHeight=" + screenHeight);


        // 获取屏幕密度（方法2）
        DisplayMetrics dm = new DisplayMetrics();
        dm = getResources().getDisplayMetrics();

        float density  = dm.density;		// 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
        int densityDPI = dm.densityDpi;		// 屏幕密度（每寸像素：120/160/240/320）
        float xdpi = dm.xdpi;
        float ydpi = dm.ydpi;

        switch (getResources().getDisplayMetrics().densityDpi) {
            case DisplayMetrics.DENSITY_LOW:
                // ...
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                // ...
                break;
            case DisplayMetrics.DENSITY_HIGH:
                // ...
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                // ...
                break;
        }


        System.out.println("========================>  DisplayMetrics xdpi=" + xdpi + "; ydpi=" + ydpi);
        System.out.println("========================>  DisplayMetrics density=" + density + "; densityDPI=" + densityDPI);

        screenWidth  = dm.widthPixels;		// 屏幕宽（像素，如：480px）
        screenHeight = dm.heightPixels;		// 屏幕高（像素，如：800px）

        System.out.println("========================>  DisplayMetrics(111) screenWidth=" + screenWidth + "; screenHeight=" + screenHeight);



        // 获取屏幕密度（方法3）
        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        density  = dm.density;		// 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
        densityDPI = dm.densityDpi;		// 屏幕密度（每寸像素：120/160/240/320）
        xdpi = dm.xdpi;
        ydpi = dm.ydpi;

        System.out.println("========================>  DisplayMetrics xdpi=" + xdpi + "; ydpi=" + ydpi);
        System.out.println("========================>  DisplayMetrics density=" + density + "; densityDPI=" + densityDPI);

        int screenWidthDip = dm.widthPixels;		// 屏幕宽（dip，如：320dip）
        int screenHeightDip = dm.heightPixels;		// 屏幕宽（dip，如：533dip）

        System.out.println("========================>  DisplayMetrics(222) screenWidthDip=" + screenWidthDip + "; screenHeightDip=" + screenHeightDip);

        screenWidth  = (int)(dm.widthPixels * density + 0.5f);		// 屏幕宽（px，如：480px）
        screenHeight = (int)(dm.heightPixels * density + 0.5f);		// 屏幕高（px，如：800px）

        System.out.println("========================>  DisplayMetrics(222) screenWidth=" + screenWidth + "; screenHeight=" + screenHeight);
    }
}