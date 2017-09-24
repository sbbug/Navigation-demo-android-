package com.baidu.tts.sample.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.baidu.tts.sample.Data.NodeData;

/**
 * Created by 孙宏伟 on 2016/11/3.
 */
public class DrawMap extends View {

    //类里的私有属性
    protected static Paint p = null;
    //存储最短路径的数组
    protected static float paths[]=null;

    //调用构造函数
    public DrawMap(Context context) {
        super(context);
        p = new Paint();
        //p.setShadowLayer(15,10,10,Color.GRAY);
        //调用nodeData类里的方法初始化数据
        NodeData.initData();
        NodeData.initViewMar();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //调用父类构造方法
        super.onDraw(canvas);

        //绘制地点名称
        DrawMap.drawName(canvas);

        //绘制地点
        DrawMap.drawLocation(canvas);

        //绘制路径
        DrawMap.drawPaths(canvas);

        if(paths!=null){
            DrawMap.drawPath(canvas);
        }
    }

    //绘制地点名称的方法
    private static void drawName(Canvas canvas) {
        //设置字体属性
        p.setColor(Color.GREEN);
        p.setTextSize(22);
        //绘制地点名称
        for (int i = 1; i <= NodeData.getNodeNum(); i++) {
            canvas.drawText(NodeData.locations[i].getName(), NodeData.locations[i].getX() - 10, NodeData
                    .locations[i].getY() + 35, p);
        }
    }

    //绘制地点的方法
    private static void drawLocation(Canvas canvas) {

        //设置地点颜色
        p.setColor(Color.parseColor("#FF1493"));
        //设置为空心圆
        p.setStyle(Paint.Style.STROKE);
        //绘制地点
        for (int n = 1; n <= NodeData.getNodeNum(); n++) {
            canvas.drawCircle(NodeData.locations[n].getX(), NodeData.locations[n].getY(), 10, p);
        }

        //绘制实心圆
        p.setStyle(Paint.Style.FILL);
        for (int n = 1; n <= NodeData.getNodeNum(); n++) {
            canvas.drawCircle(NodeData.locations[n].getX(), NodeData.locations[n].getY(), 6, p);
        }
    }

    //绘制两点之间的路径
    private static void drawPaths(Canvas canvas) {

        //设置路径颜色
        p.setColor(Color.parseColor("#00BFFF"));
        p.setStrokeWidth(5);
        for (int a = 1; a <= NodeData.getNodeNum(); a++) {
            for (int b = 1; b <= NodeData.getNodeNum(); b++) {
                //判断两点之间是否可以走通
                if (NodeData.viewMar[a][b] != 0 && NodeData.viewMar[a][b] != 100000) {
                    canvas.drawLine(NodeData.locations[a].getX(), NodeData.locations[a].getY(), NodeData.locations[b].getX(), NodeData.locations[b].getY(), p);
                }
            }
        }
    }


    //绘制最短路径
    public static void  drawPath(Canvas canvas){

        p.setColor(Color.BLUE);
        p.setStrokeWidth(5);

        for(int a=0;a<paths.length-1;a++){
             canvas.drawLine(NodeData.locations[(int)paths[a]].getX(),NodeData.locations[(int)paths[a]].getY(),NodeData.locations[(int)paths[a+1]].getX(),NodeData.locations[(int)paths[a+1]].getY(),p);
        }

    }

    public static void setPath(float nodes[]){
        DrawMap.paths=nodes;
    }
}

