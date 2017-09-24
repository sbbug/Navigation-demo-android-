package com.baidu.tts.sample.Data;

import com.baidu.tts.sample.Bean.LocationNode;

/**
 * Created by 孙宏伟 on 2016/11/3.
 */
public class NodeData {
    //定义一个存储地图节点数据的数组
    public static LocationNode locations[]=null;
    //地图上的节点个数
    private static int nodeNum=30;
    //地图点与点之间的邻接矩阵
    public static float [][]viewMar=null;
    //存放地图图片资源的数组
    public static int images[]=null;

    //数据的初始化
    public static void initNodeData(){

        initViewMar();
        initData();
    }
    //地图邻接矩阵关系的初始化
    public static void initViewMar() {
        //创建数组里的数据元素
        viewMar = new float[nodeNum + 1][nodeNum + 1];
        //数据元素初始化
        for (int a = 1; a <= nodeNum; a++) {
            for (int b = 1; b <= nodeNum; b++) {
                if (a == b) {
                    viewMar[a][b] = 0;
                } else {
                    viewMar[a][b] = 100000;
                }
            }
        }

        //数组里面存储对应的矩阵权重
        viewMar[1][2] = 1000;
        viewMar[1][6] = 500;
        viewMar[1][8] = 100;
        viewMar[1][9] = 1500;
        viewMar[2][3] = 450;

        viewMar[3][4] = 100;
        viewMar[4][5] = 150;
        viewMar[4][11] = 1700;
        viewMar[5][11] = 1800;
        viewMar[6][7] = 50;

        viewMar[7][12] = 300;
        viewMar[8][14] = 800;
        viewMar[9][10] = 200;
        viewMar[10][14] = 400;
        viewMar[11][16] = 150;

        viewMar[11][17] = 600;
        viewMar[11][12] = 200;
        viewMar[12][13] = 200;
        viewMar[12][14] = 300;
        viewMar[14][21] = 800;

        viewMar[15][22] = 300;
        viewMar[16][17] = 500;
        viewMar[16][18] = 200;
        viewMar[17][24] = 1200;
        viewMar[18][19] = 50;

        viewMar[19][20] = 60;
        viewMar[21][22] = 50;
        viewMar[21][23] = 300;
        viewMar[22][23] = 200;
        viewMar[24][26] = 600;

        viewMar[25][27] = 100;
        viewMar[25][28] = 300;
        viewMar[27][29] = 200;
        viewMar[29][30] = 600;
        viewMar[23][30] = 1200;

        viewMar[26][30] = 400;
        viewMar[10][15] = 600;
        viewMar[18][21] = 400;
        viewMar[23][28] = 600;
        viewMar[16][25] = 300;

        for (int n = 1; n <= nodeNum; n++) {
            for (int m = 1; m <= nodeNum; m++) {
                viewMar[m][n] = viewMar[n][m];
            }
        }
    }
    //地图的初始数据载入

    public static void initData() {
        locations = new LocationNode[nodeNum+1]; //把0那个位置自动忽略
        locations[1] = new LocationNode(1,"学府苑","教职工居住地，风景秀丽",380,50);
        locations[2] = new LocationNode(2,"檀香苑","女生居住宿舍",50,100);
        locations[3] = new LocationNode(3,"象山苑","男生居住宿舍",60,180);
        locations[4] = new LocationNode(4,"象山食堂","环境舒适，小吃居多的美食广场",130,210);
        locations[5] = new LocationNode(5,"亚青村","曾为青奥会运动员居住地，设施齐全，环境优美",20,270);

        locations[6] = new LocationNode(6,"仁智楼","教学楼",240,120);
        locations[7] = new LocationNode(7,"同和楼","教学楼",240,200);
        locations[8] = new LocationNode(8,"工大小书房","可供聚餐，娱乐",370,160);
        locations[9] = new LocationNode(9,"江苏省工业技术创新中心","设备齐全，环境优雅",430,110);
        locations[10] = new LocationNode(10,"国家生化技术研究中心","设备齐全，环境舒适",520,190);

        locations[11] = new LocationNode(11,"北苑","学生宿舍",140,310);
        locations[12] = new LocationNode(12,"逸夫图书馆","外观宏伟，环境优雅，藏书丰富",300,300);
        locations[13] = new LocationNode(13,"天工楼","教学楼",320,210);
        locations[14] = new LocationNode(14,"垒球场","标准垒球场地",390,240);
        locations[15] = new LocationNode(15,"重点实验室","设备齐全，环境优雅",500,250);

        locations[16] = new LocationNode(16,"东苑","男生宿舍",220,380);
        locations[17] = new LocationNode(17,"西苑","女生宿室",70,390);
        locations[18] = new LocationNode(18,"生物与制药学院","学院大楼",300,400);
        locations[19] = new LocationNode(19,"研究院","研究生大楼",410,500);
        locations[20] = new LocationNode(20,"能源学院","学院大楼",430,400);

        locations[21] = new LocationNode(21,"田径场","标准田径场",430,320);
        locations[22] = new LocationNode(22,"浦江宿舍","研究生宿舍",570,310);
        locations[23] = new LocationNode(23,"体育馆","设施齐全，环境舒适",600,360);
        locations[24] = new LocationNode(24,"南苑","男生宿舍",50,460);
        locations[25] = new LocationNode(25,"笃行楼","教学楼",220,470);

        locations[26] = new LocationNode(26,"文科图书馆","藏书丰富，环境优雅",60,530);
        locations[27] = new LocationNode(27,"沉毅广场","娱乐活动场所",310,580);
        locations[28] = new LocationNode(28,"浦江教学楼","教学楼",440,550);
        locations[29] = new LocationNode(29,"药物研究所","设备齐全，环境优美",450,620);
        locations[30] = new LocationNode(30,"工大校门","南京工业大学正大门",440,750);

    }
    //图片路径的载入
    public static void initImages(){
        images = new int[nodeNum+1];
        // images[1]  = R.drawable.a1;
        // images[12] = R.drawable.a2;
        // images[30] = R.drawable.a3;
       /* images[]  = ;
        images[]  = ;


        images[]  = ;
        images[]  = ;
        images[]  = ;
        images[]  = ;
        images[]  = ;

        images[]  = ;
        images[]  = ;
        images[]  = ;
        images[]  = ;
        images[]  = ;

        images[]  = ;
        images[]  = ;
        images[]  = ;
        images[]  = ;
        images[]  = ;

        images[]  = ;
        images[]  = ;
        images[]  = ;
        images[]  = ;
        images[]  = ;

        images[]  = ;
        images[]  = ;
        images[]  = ;
        images[]  = ;
        images[]  = ;
        */
    }

    public static int getNodeNum() {
        return nodeNum;
    }

    public static void setNodeNum(int nodeNum) {
        NodeData.nodeNum = nodeNum;
    }

}

