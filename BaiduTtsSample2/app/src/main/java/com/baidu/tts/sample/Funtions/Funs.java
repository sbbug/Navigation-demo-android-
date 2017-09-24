package com.baidu.tts.sample.Funtions;

import android.graphics.Color;
import android.widget.RelativeLayout;

import com.baidu.tts.sample.Activity.MainActivity;
import com.baidu.tts.sample.View.DrawMap;
import com.baidu.tts.sample.Data.NodeData;
import com.baidu.tts.sample.Monitor.OnHandTouchListener;

/**
 * Created by 孙宏伟 on 2016/11/4.
 */
public class Funs {

    public static String  name="xyy";
    public static String password="19941204";
    /*
    初始化数据的方法
     */
    public static void initData(){
        NodeData.initNodeData();
    }
    /*
   开始绘制函数
    */
    public static void startDraw(RelativeLayout canvas,MainActivity main){

        initData();;
        //获取绘制画布处的ID号
        RelativeLayout box = canvas;
        //创建一个view对象，里面进行绘制
        final DrawMap view = new DrawMap(main);
        //设置view的背景颜色
        view.setBackgroundColor(Color.parseColor("#424242"));
        //为画布绑定监听事件
        view.setOnTouchListener(new OnHandTouchListener(main));

        //设置画布大小
        view.setMinimumHeight(800);
        view.setMinimumWidth(500);
        //将画布添加到布局里
        box.addView(view);
    }
    /*
    通过出入一组最短路径生成一段语音
     */
   public static String ProductStr(float nodes[]){
            String str = "从"+NodeData.locations[(int)nodes[nodes.length-1]].getName()+"到"+NodeData.locations[(int)nodes[0]].getName()+"最短路径是";

            str+=NodeData.locations[(int)nodes[nodes.length-1]].getName();

            for(int j=nodes.length-2;j>=1;j--){
                str+="到"+NodeData.locations[(int)nodes[j]].getName()+" "+NodeData.locations[(int)nodes[j]].getName();
            }

            str+="到"+NodeData.locations[(int)nodes[0]].getName();
       return str;
   }

}
