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

import com.example.test.uitls.CommonGsonUtils;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

//        try {
//            length = length + 20 * 1024 * 1024;
//            test = new String[length];
//            System.out.println("======================> test: ");
//        }catch (Exception e) {
//            System.out.println("======================> e: " + e.getMessage());
//        } catch (OutOfMemoryError error) {
//            System.out.println("======================> error: " + error.getMessage());
//        }

//        int arr[] = new int[]{1, 3, 10, 8, 6, 2, 5, 7, 9, 4};
////        for(int i = 0; i < arr.length; i ++) {
////            arr[i]=(int) (Math.random()*100);
////        }
//        System.out.println("排序前的数组：");
//        quickSort(arr, 0, arr.length-1);
//        System.out.println("排序后的数组：");

        // 测试动态数组
        List<String> mPlayerListMusicInfos = new ArrayList<>();
        String mCurrent = "";
        String real;
        String real1 = "";
        if(mPlayerListMusicInfos == null || mPlayerListMusicInfos.size() == 0) {
            real1 = "-3";
        }
        if (mCurrent == null) {
            if (mPlayerListMusicInfos.size() > 0) {
                real = mPlayerListMusicInfos.get(0);
            } else {
                real = "-3";
            }
        } else {
            int index = mPlayerListMusicInfos.indexOf(mCurrent);
            if (index == mPlayerListMusicInfos.size() - 1) {
                index = 0;
            } else {
                index += 1;
            }
            real = mPlayerListMusicInfos.get(index);
        }
        String b = real1;
        System.out.println("====================> real: " + real);

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

    public void onTest3(View v) {
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
    public void onTest2(View v) {
//        StringBuilder sb = new StringBuilder("111");
//        sb.append("222");
//        String c = sb + "";
//        System.out.println("===========================> c: " + (sb + ""));

//        SparseArray<String> wealth = null;
//        if(wealth == null)
//            wealth = new SparseArray<>();
//        if(wealth.indexOfKey(2) < 0)
//            wealth.put(2, "222");
//        String bean = wealth.get(2);
//        if(bean == null)
//            wealth.put(2, bean = "333");
//
//        String bean1 = bean;
//        wealth.put(2, "222");
//
//        wealth.put(2, "333");
//
//        String str = null;
//        boolean is = null instanceof TextView;



        // 待匹配字符串
//        String str = "₹290.00";
//        String str = "2,290.00";
//        //	正则表达式
//        Pattern pattern = Pattern.compile("[0-9]");
//        Matcher matcher = pattern.matcher(str);
//        //	判断字符串中是否包含数字
//        if(matcher.find()){
//            //	获取数字起始位置
//            String real = str.substring(matcher.start());
//            System.out.println("======================> real: " + real);
//            double value = convertToDouble(real);
//            System.out.println("======================> value: " + value);
//        }

//        long price = 291800000;
//        double realPrice = (double) price / 1000000;
//
//        System.out.println("======================> realPrice: " + realPrice);

        Map<String, Object> map = new HashMap<>();
        map.put("skiptype", 1);
        map.put("name", "charge");
        Map<String, Object> map1 = new HashMap<>();
        map1.put("key1", 1);
        map1.put("key2", "hello");
        map.put("map", map1);
        String str = CommonGsonUtils.toJson(map);
        System.out.println("======================> str: " + str);
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        Map<String, Object> map2 = CommonGsonUtils.fromJson(str, new TypeToken<Map<String, Object>>(){});
        System.out.println("======================> map2: " + map2);
    }

    /**
     * 把字符串转成double，如果有千分号，去掉千分号
     */
    private double convertToDouble(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
                df.setGroupingUsed(true);
                double result = df.parse(str).doubleValue();
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    public static void quickSort(int []arr,int low,int high) {
        if(low<high) {
            int pivotpos=partition(arr,low,high);
            quickSort(arr,low,pivotpos-1);
            quickSort(arr,pivotpos+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot=arr[low];
        while(low<high) {
            //起初，一定要从右边指针开始，因为arr[low]的值已经扔给了pivot，arr[low]
            //想象成无数字的空位
            while(low<high&&pivot<=arr[high]) {
                --high;
            }

            //把比pivot的小的数扔到左边指针
            //把arr[high]扔到arr[low]这个空位上
            //然后，high位置可以想象成无数字的空位
            arr[low]=arr[high];

            while(low<high&&arr[low]<=pivot) {
                ++low;
            }
            //把比pivot大的数扔到右边
            //把arr[low]扔到arr[high]这个空位上
            //然后，low位置可以想象成是无数字的空位
            arr[high]=arr[low];
        }
        //此时low==high,return high也一样
        arr[low]=pivot;
        return low;
    }
    
}
