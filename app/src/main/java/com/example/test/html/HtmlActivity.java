package com.example.test.html;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Html.fromHtml() 测试
 */
public class HtmlActivity extends AppCompatActivity {
    
    private TextView tvTest1;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);
        tvTest1 = findViewById(R.id.tv_test1);

    }

    /**
     * html
     * @param v
     */
    public void onTest1(View v) {
        String htmlStr = "\n" +
                "<span>\n" +
                "    Send \n" +
                "    <span style='color: #FF509A;'>\n" +
                "        Dating\n" +
                "    </span>  \n" +
                "    <img \n" +
                "        style='height: 11px;\n" +
                "        vertical-align:middle;' \n" +
                "        src='https://timg.kiwii.tv/upload/gift_image/live_gift_thumb_id_13.png?v=20190515'>  \n" +
                "    1 gifts  \n" +
                "    <span style='color: #999999;'>\n" +
                "        (0/1)\n" +
                "    </span>\n" +
                "</span>";
//        String htmlStr = "<span>Watch live for 30 minutes  <span style='color: #999999;'>(0/10)</span></span>";
//        tvTest1.setText(Html.fromHtml(htmlStr, new Html.ImageGetter() {
//                    @Override
//                    public Drawable getDrawable(String source) {
//                        System.out.println("================> getDrawable");
//                        return null;
//                    }
//                }
//                , new Html.TagHandler() {
//            @Override
//            public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {
//                System.out.println("================---------------> handleTag opening: " + opening + "  tag: " + tag + "  output: " + output);
//            }
//        }));

        Document document = Jsoup.parse(htmlStr);

        String title = document.getElementsByTag("a").text();

        String a="11dp";
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(a);
        String b = m.replaceAll("").trim();
        System.out.println( "=========================>  b: " + b);
        int c = 5;
        try {
            c = Integer.valueOf(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println( "=========================>  c: " + c);
    }
    
}
