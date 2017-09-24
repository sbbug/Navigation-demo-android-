package com.baidu.tts.sample.Monitor;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.baidu.tts.sample.Activity.MainActivity;
import com.baidu.tts.sample.Activity.ShowInfoActivity;
import com.baidu.tts.sample.Data.NodeData;

/**
 * Created by 孙宏伟 on 2016/11/3.
 */
public class OnHandTouchListener implements View.OnTouchListener {

    //手指触点坐标定义
    private double x;
    private double y;

    //activity的定义
    private MainActivity main;

    //构造方法
    public OnHandTouchListener(MainActivity main) {

        this.x = 0;
        this.y = 0;
        this.main = main;
    }

    //重载触摸平的方法
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int index = 0;
        this.x = event.getX();
        this.y = event.getY();
        index = findShortestNode(this.x, this.y);
        if (index != 0) {
            Toast.makeText(main, "x:" + String.valueOf(NodeData.locations[index].getX()) + "Y:" + String.valueOf(NodeData.locations[index].getY()), Toast.LENGTH_SHORT).show();
            //在这里实现页面的跳转
            Intent intent = new Intent();
            intent.putExtra("key", index); //参数传递
            intent.setClass(main, ShowInfoActivity.class);
            this.main.startActivity(intent);
        }

        return false;
    }

    //遍历地图里的所有点，寻找最近的点
    public int findShortestNode(double x, double y) {
        int key = 0;
        double dis = 0;
        for (int i = 1; i <= NodeData.getNodeNum(); i++) {
            dis = calDistance(x, y, NodeData.locations[i].getX(), NodeData.locations[i].getY());
            if (dis >= 0 && dis <= 30) {
                key = i;
                break;
            }
        }

        return key;
    }

    //计算机两点之间的距离的方法
    public double calDistance(double x1, double y1, double x2, double y2) {

        //两点之间的距离
        double distance = 0;
        distance = Math.sqrt((Math.abs(x1 - x2) * Math.abs(x1 - x2) + Math.abs(y1 - y2) * Math.abs(y1 - y2)));

        return distance;
    }
}