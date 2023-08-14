package com.example.test.regular;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.permission.PermissionUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 *
 * Java 正则表达式（深度长文）
 * https://blog.csdn.net/senxu_/article/details/126109760
 *
 */
public class RegularActivity extends AppCompatActivity {
    
    private TextView tvTest;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regular);
        tvTest = findViewById(R.id.tv_test);
        
    }

    public void onTest1(View v) {
       String content = "😃";
       String binary = stringToBinary(content);
       String hex = stringToHex(content);
        System.out.println("==================> binary: " + binary);
       boolean isEmoji = isEmoji(content);
       System.out.println("==================> isEmoji: " + isEmoji);
    }

    /**
     * Emoji表情检测
     */
    private boolean isEmoji(String content) {
        Pattern pattern = Pattern.compile(
                "[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
                Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    /**
     * 字符串转二进制
     * @param str
     * @return
     */
    public String stringToBinary(String str) {
        StringBuilder result= new StringBuilder();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            result.append(String.format("%8s", Integer.toBinaryString(ch)).replaceAll(" ", "0"));
        }
        return result.toString();
    }

    /**
     * 字符串转16进制
     * @param input
     * @return
     */
    public String stringToHex(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = input.toCharArray();

        for (char character : chars) {
            String hex = Integer.toHexString((int) character);
            stringBuilder.append(hex);
        }

        return stringBuilder.toString();
    }

    public void onTest2(View v) {

    }
    
}
