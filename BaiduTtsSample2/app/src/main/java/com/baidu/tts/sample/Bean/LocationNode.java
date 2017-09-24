package com.baidu.tts.sample.Bean;

/**
 * Created by 孙宏伟 on 2016/11/4.
 */
public class LocationNode {

    private int id;
    private String name;
    private String info;
    private float x;
    private float y;

    public LocationNode(int id,String name,String info,float x,float y){
        this.id=id;
        this.name=name;
        this.info=info;
        this.x=x;
        this.y=y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
