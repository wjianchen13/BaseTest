package com.example.test;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.uitls.Utils;

import org.json.JSONObject;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * url替换操作
 */
public class UrlActivity extends AppCompatActivity {

    private View vsTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);

    }

    /**
     * 测试1
     * @param v
     */
    public void onTest1(View v) {
        try {
            String url = "http://119.91.194.201/ludo/index.html?pl=ayome&mode=test&cfg=%7B%22talk%22%3A0%7D";
            String cfg = URLEncoder.encode(getCfgJson(), "UTF-8");
            String rUrl = replace(url, "cfg", cfg);
            Utils.log("rUrl: " + rUrl);

            String urlDecoder = URLDecoder.decode(url, "UTF-8");
            Utils.log("urlDecoder: " + urlDecoder);

            Uri uri = Uri.parse(url);
            Uri.Builder builder = uri.buildUpon();
            if (builder != null) {
                if (uri.getQueryParameter("cfg") == null) {

                }

            }

            String urlEncoder = URLEncoder.encode(urlDecoder, "UTF-8");
            Utils.log("urlEncoder: " + urlEncoder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getCfgJson() {
        try {
            JSONObject obj = new JSONObject();
            obj.put("top", 90);
            obj.put("talk", 0);
            return obj.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String replace(String url, String key, String value) {
        if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(key)) {
            url = url.replaceAll("(" + key + "=[^&]*)", key + "=" + value);
        }
        return url;
    }

    /**
     * 测试2
     * @param v
     */
    public void onTest2(View v) {
        String url = "http://119.91.194.201/ludo/index.html?pl=ayome&mode=test&cfg=%7B%22talk%22%3A0%7D";
        String url1 = handleUrl(url);
    }

    /**
     * 处理一下url的cfg参数，需要插入top这个参数，表示游戏按钮的偏移，传入负数表示不显示
     * @return
     */
    private String handleUrl(String url) {
        try {
            if (!TextUtils.isEmpty(url)) {
                Uri uri = Uri.parse(url);
                Uri.Builder builder = uri.buildUpon();
                if (builder != null) {
                    String cfg = uri.getQueryParameter("cfg");
                    Utils.log("==================> cfg: " + cfg);
                    if(!TextUtils.isEmpty(cfg)) {
                        JSONObject obj = new JSONObject(cfg);
                        obj.put("top", 0);
                        String newCfg = obj.toString();
                        newCfg = URLEncoder.encode(newCfg, "UTF-8");
                        url = replace(url, "cfg", newCfg);
                        return url;
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    /**
     * 测试3
     * @param v
     */
    public void onTest3(View v) {

    }

    /**
     * 测试4
     * @param v
     */
    public void onTest4(View v) {

    }

    /**
     * 测试5
     * @param v
     */
    public void onTest5(View v) {

    }

    /**
     * 测试6
     * @param v
     */
    public void onTest6(View v) {

    }


}
