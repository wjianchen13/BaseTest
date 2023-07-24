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
//        tvTest.setText("Rs");
//        tvTest.setText("₨");
//        int level = 0;
//        int l = 0;
//        if(level > 0 && level < 10) {
//            l = 1;
//        } else if(level >= 60) {
//            l = 60;
//        } else  {
//            l = level / 10 * 10;
//        }
//        System.out.println("======================================> l: " + l);

//        long t1 = 1686621641000l; // 2023-06-13 10:00:41
//        long time = System.currentTimeMillis();
//        long dis = time - t1;
//        if(dis < 86400000) {
//            System.out.println("======================================> 没超过24小时");
//        } else {
//            System.out.println("======================================> 超过24小时: ");
//        }
//
//        try {
//            JSONObject obj = new JSONObject();
//            obj.put("hello", "test1");
//            obj.put("hello1", 1);
//            String s = obj.toString();
//            JSONObject obj1 = new JSONObject(s);
//            String hello = obj1.optString("hello");
//            int hello1 = obj1.optInt("hello1");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        String v1 = "1.1.2";
//        String v2 = "1.1.3";
//        String v3 = "1.1";
//        String v4 = "1.2.1";
//        String v5 = "1.1.2.1";
//        String v6 = "";
//        String v7 = "0";
//        int a1 = compareVersion(v1, v2); // 1
//        int a2 = compareVersion(v2, v3); // -1
//        int a3 = compareVersion(v3, v4); // 1
//        int a4 = compareVersion(v4, v5); // -1
//        int a5 = compareVersion(v1, v5); // 1
//        int a6 =  compareVersion(v1, v1); // 0
//        int a7 =  compareVersion(v6, v7); // 0
//        System.out.println("==================> a1: " + a1 + "  a2: " + a2 + "  a3: " + a3 + "  a4: " + a4 + "  a5: " + a5 + "  a6: " + a6 + "  a7: " + a7);

//        String url = "https://bobilive-com-test.oss-accelerate.aliyuncs.com/game-packages/common/slots/1.1.3/web-mobile.zip";
//        if(!TextUtils.isEmpty(url)) {
//            int start = url.lastIndexOf("/") + 1;
//            int end = url.lastIndexOf(".");
//            if(end > start) {
//                String name = url.substring(start, end);
//                System.out.println("==================> name:" + name);
//            }
//        }

        try {
            length = length + 20 * 1024 * 1024;
            test = new String[length];
            System.out.println("======================> test: ");
        }catch (Exception e) {
            System.out.println("======================> e: " + e.getMessage());
        } catch (OutOfMemoryError error) {
            System.out.println("======================> error: " + error.getMessage());
        }

    }

    String [] test;
    private int length = 0;


    /**
     * 版本号比较
     *
     * @param v2
     * @param v1
     * @return 0代表相等，1代表右边大，-1代表左边大
     * Utils.compareVersion("1.0.358_20180820090554","1.0.358_20180820090553")=1
     */
    private static int compareVersion(String v1, String v2) {
        if(TextUtils.isEmpty(v1)) {
            v1 = "0";
        }
        if(TextUtils.isEmpty(v2)) {
            v2 = "0";
        }
        if (v2.equals(v1)) {
            return 0;
        }
        String[] version1Array = v2.split("[._]");
        String[] version2Array = v1.split("[._]");
        int index = 0;
        int minLen = Math.min(version1Array.length, version2Array.length);
        long diff = 0;

        while (index < minLen
                && (diff = Long.parseLong(version1Array[index])
                - Long.parseLong(version2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            for (int i = index; i < version1Array.length; i++) {
                if (Long.parseLong(version1Array[i]) > 0) {
                    return 1;
                }
            }

            for (int i = index; i < version2Array.length; i++) {
                if (Long.parseLong(version2Array[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }
    }

    public void onTest2(View v) {
        try {
            JSONObject obj = new JSONObject("{\n" +
                    "    \"code\": 200,\n" +
                    "    \"data\": {\n" +
                    "        \"uid\": 310011613,\n" +
                    "        \"goldNum\": 12737,\n" +
                    "        \"chargeGoldNum\": 12737,\n" +
                    "        \"nobleGoldNum\": 0,\n" +
                    "        \"diamondNum\": 12137.0,\n" +
                    "        \"depositNum\": 0\n" +
                    "    },\n" +
                    "    \"message\": \"Success\"\n" +
                    "}\n");
            JSONObject data = obj.optJSONObject("data");
            data.put("uid", "123");
            int uid = obj.optJSONObject("data").optInt("uid");
            int goldNum = obj.optJSONObject("data").optInt("goldNum");
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
    public void onTest3(View v) {
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
