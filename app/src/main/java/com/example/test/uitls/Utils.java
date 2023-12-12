package com.example.test.uitls;

import android.content.Context;
import android.widget.Toast;

public class Utils {

    public static void log(String str) {
        System.out.println("==========================> " + str);
    }

    public static void showToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

}
