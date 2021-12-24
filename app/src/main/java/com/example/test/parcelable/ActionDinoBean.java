package com.example.test.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

/**
 * name: ActionBean 活动信息
 */
public class ActionDinoBean implements Parcelable {
    /**
     * PK游戏参数
     */
    private String data;
    /**
     * 活动id
     */
    private int id;
    /**
     * 活动url
     */
    private String url;
    /**
     * 活动名称
     */
    private String name;
    /**
     * 跳转url
     */
    private String web_url;
    /**
     * type
     */
    private int type;

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public ActionDinoBean() {

    }

    public void setData(String data) {
        this.data = data;
    }

    public int getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
//        dest.writeString(name);
        dest.writeString(url);
    }

    public String getUrl() {
        return url;
    }

    public ActionDinoBean(JSONObject obj) {
        if(obj != null) {
            id = obj.optInt("id");
            name = obj.optString("name");
            url = obj.optString("url");
        }
    }

    public int getId() {
        return id;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ActionDinoBean(int id, String url, String data) {
        this.id = id;
        this.url = url;
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getName() {
        return name;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public static final Creator<ActionDinoBean> CREATOR = new Creator<ActionDinoBean>() {

        @Override
        public ActionDinoBean[] newArray(int size) {
            return new ActionDinoBean[size];
        }

        @Override
        public ActionDinoBean createFromParcel(Parcel source) {
            return new ActionDinoBean(source.readInt(), source.readString(), source.readString());
        }
    };
}
