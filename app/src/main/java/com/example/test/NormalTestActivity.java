package com.example.test;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

/**
 * 普通测试
 * 全局符号静态变量符号$&改成%!（可提交）
 */
public class NormalTestActivity extends AppCompatActivity {
    
    private TextView tvTest;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_test);
        tvTest = findViewById(R.id.tv_test);
        
    }

    public void onTest1(View v) {
//        SpannableString s = new SpannableString("djjjhhuu[em:48][em:42][em:52][em:53]");
//        s.removeSpan("[em:48]");
//        System.out.println("============> s1: " + s);
//        s.removeSpan(new SpannableString("[em:48]"));
//        System.out.println("============> s2: " + s);
//
//        s.setSpan(new SpannableString(""), 8, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        System.out.println("============> s3: " + s);
//
////        s.setSpan(new ImageSpan(null), 8, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
////        System.out.println("============> s4: " + s);
////        s.
        tvTest.setText("Rs");
        tvTest.setText("₨");
    }

    public void onTest3(View v) {
        try {
            setCDNInfo(new JSONArray("[\n" +
                    "            \"0:1\",\n" +
                    "            \"3:2\", \n" +
                    "            \"5:2\"\n" +
                    "        ]"));
        } catch (Exception e) {
            
        }
    }

    public void setCDNInfo(JSONArray cdn) {
        SparseArray<Integer> mCDNMap = new SparseArray<>();
        if(isNotEmpty(cdn)) {
            for (int i = 0; i < cdn.length(); i++) {
                String obj = cdn.optString(i);
                if(!TextUtils.isEmpty(obj)) {
                    String[] arr = obj.split(":");
                    if(isNotEmpty(arr) && arr.length > 1) {
                        try {
                            int key = Integer.parseInt(arr[0]);
                            Integer value = new Integer(arr[1]);
                            mCDNMap.put(key, value);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        int a = mCDNMap.get(0);
        int b = mCDNMap.get(3);
        int c = mCDNMap.get(5);
        int f = new Integer(7);
        int d = mCDNMap.get(1);
        int e = 0;
    }
    
    private boolean isNotEmpty(Object obj) {
        return true;
    }
    

    /**
     * 
     * @param v
     */
    public void onTest2(View v) {
//        StringBuilder sb = new StringBuilder("111");
//        sb.append("222");
//        String c = sb + "";
//        System.out.println("===========================> c: " + (sb + ""));

        SparseArray<String> wealth = null;
        if(wealth == null)
            wealth = new SparseArray<>();
        if(wealth.indexOfKey(2) < 0)
            wealth.put(2, "222");
        String bean = wealth.get(2);
        if(bean == null)
            wealth.put(2, bean = "333");

        String bean1 = bean;
        wealth.put(2, "222");

        wealth.put(2, "333");
        
        String str = null;
        boolean is = null instanceof TextView;
        
    }
    
}
