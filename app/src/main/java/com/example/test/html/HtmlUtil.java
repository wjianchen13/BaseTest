package com.example.test.html;

import android.os.Build;
import android.text.Html;
import android.text.TextUtils;

public class HtmlUtil {

    public static CharSequence fromHtml(String htmlStr) {
        if (TextUtils.isEmpty(htmlStr)) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                CustomHtmlTagHandler tagHandler = new CustomHtmlTagHandler();
                tagHandler.registerTag(CustomSpanTag.SPAN, new CustomSpanTag());
                return Html.fromHtml(htmlStr, Html.FROM_HTML_MODE_LEGACY, null, tagHandler);
            } else {
                return Html.fromHtml(htmlStr);
            }

        } catch (Exception ignore) {

        }
        return htmlStr;
    }


}
