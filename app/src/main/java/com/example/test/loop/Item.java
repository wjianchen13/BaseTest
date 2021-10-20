package com.example.test.loop;

public class Item {

    /**
     * 显示信息
     */
    private String name;

    /**
     * 是否已经显示过了
     * 1:没有
     * 0:显示过了
     */
    private int isShow;

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int isShow) {
        this.name = name;
        this.isShow = isShow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsShow() {
        return isShow;
    }

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }
}
