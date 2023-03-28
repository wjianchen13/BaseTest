package com.example.test.drawable;

public class ColorUtils {

    // 透明度百分比和十六进制对应关系计算方法：
    public static void toARGB() {
        System.out.println("透明度 | 十六进制");
        System.out.println("---- | ----");
        for (double i = 1; i >= 0; i -= 0.01) {
            i = Math.round(i * 100) / 100.0d;
            int alpha = (int) Math.round(i * 255);
            String hex = Integer.toHexString(alpha).toUpperCase();
            if (hex.length() == 1) hex = "0" + hex;
            int percent = (int) (i * 100);
            System.out.println(String.format("%d%% | %s", percent, hex));
        }
    }

    // 16进制转GRB颜色值方法：
    public static void toRGB(String hex) {
        int color = Integer.parseInt(hex.replace("#", ""), 16);
        int red = (color & 0xff0000) >> 16;
        int green = (color & 0x00ff00) >> 8;
        int blue = (color & 0x0000ff);
        System.out.println("red="+red+"--green="+green+"--blue="+blue);
    }


    // GRB转16进制颜色值方法：
    public static void toHex(int red, int green, int blue){
        String hr = Integer.toHexString(red);
        String hg = Integer.toHexString(green);
        String hb = Integer.toHexString(blue);
        System.out.println("#"+hr + hg + hb);
    }

    // 获取红色颜色
    public static int getRed(String hex) {
        try {
            int color = Integer.parseInt(hex.replace("#", ""), 16);
            return (color & 0xff0000) >> 16;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 255;
    }

    public static int getGreen(String hex) {
        try {
            int color = Integer.parseInt(hex.replace("#", ""), 16);
            return (color & 0x00ff00) >> 8;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 255;
    }
    public static int getBlue(String hex) {
        try {
            int color = Integer.parseInt(hex.replace("#", ""), 16);
            return (color & 0x0000ff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 255;
    }


}
