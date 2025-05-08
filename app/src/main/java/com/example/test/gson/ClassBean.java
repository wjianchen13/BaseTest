package com.example.test.gson;

import android.graphics.drawable.Drawable;

public class ClassBean {

    private String name ;

    private Drawable mDrawable;

    private UserBean mUserBean;

    public ClassBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserBean getUserBean() {
        return mUserBean;
    }

    public void setUserBean(UserBean userBean) {
        this.mUserBean = userBean;
    }
}
