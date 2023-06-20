package com.example.test.member;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 数值型测试
 */
public class DoubleActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double);
        tvTest = findViewById(R.id.tv_test);
    }

    public void onTest1(View v) {
//        double a = 8.99f;
//        double b = Arith.div(a, 30f);
//        System.out.println("===============> b: " +  b);
//        double c = Arith.div(a, 30f, 2, BigDecimal.ROUND_DOWN);
//        System.out.println("===============> c: " +  c);

//        DecimalFormat df1 = new DecimalFormat("0.0");
//        DecimalFormat df2 = new DecimalFormat("#.#");
//        DecimalFormat df3 = new DecimalFormat("000.000");
//        DecimalFormat df4 = new DecimalFormat("#######.#####");
//        System.out.println(df1.format(12.34)); //12.3
//        System.out.println(df2.format(12.34)); //12.3
//        System.out.println(df3.format(12.34)); //012.340
//        System.out.println(df4.format(12.34)); //12.34
//        System.out.println(df4.format(1111112.0304005)); //12.34

        int a = 192868336;
        tvTest.setText(Arith.tryCutNumber(getAmount(a)));

    }

    public double getAmount(int value) {
        BigDecimal decimal = new BigDecimal(Double.valueOf(value));
        BigDecimal result = decimal.setScale(2, RoundingMode.HALF_UP);
        return result.doubleValue();
    }

    /**
     * DecimalFormat基本用法
     * https://blog.csdn.net/weixin_42721317/article/details/115675707
     * @param v
     */
    public void onTest2(View v) {
        //0 一个数字 ; # 一个数字，不包括 0
        //保留两位小数，如果不足两位小数则自动补零
        DecimalFormat df1 = new DecimalFormat("###0.00") ;
        df1.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println(df1.format(124.3));
        System.out.println(df1.format(124.315));  //费解  没有四舍五入
        System.out.println(df1.format(124.325));  //费解  实现四舍五入

        //保留两位小数，不足两位则不补零
        DecimalFormat df2 = new DecimalFormat("###0.##") ;
        System.out.println(df2.format(124.6));
        System.out.println(df2.format(124));

        //保留两位小数，哪里不足位则补零
        DecimalFormat df3 = new DecimalFormat("000.00");
        System.out.println(df3.format(24));

        //添加千位分隔符,保留3位小数，不足的补0
        DecimalFormat df4 = new DecimalFormat("#,##0.000");
        System.out.println(df4.format(new BigDecimal(3613.61)));
        System.out.println(df4.format(new BigDecimal(3613.613)));
        System.out.println(df4.format(new BigDecimal(3613.6135)));
        System.out.println(df4.format(new BigDecimal(3613.6136)));

        double a = 1.2350113708E8;
        double b = 1235.069;
        double c = 23.6;
        double d = 23;
        System.out.println("a: " + a);
        System.out.println(df2.format(a));

        DecimalFormat df5 = new DecimalFormat("#,##0.##");
        df5.setRoundingMode(RoundingMode.DOWN);
        System.out.println(df5.format(a));
        System.out.println(df5.format(b));
        System.out.println(df5.format(c));
        System.out.println(df5.format(d));
    }




}
