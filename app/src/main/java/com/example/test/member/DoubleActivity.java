package com.example.test.member;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.gson.UserBean;
import com.google.gson.Gson;

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






}
