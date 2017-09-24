package com.baidu.tts.sample.Funtions;

import com.baidu.tts.sample.Data.NodeData;

import java.util.Arrays;

/**
 * Created by 孙宏伟 on 2016/11/3.
 */
public class FindShortestPath {

       public static float[] findShortestPath(int start,int end) {

            float dist[] = new float[NodeData.getNodeNum() + 1];
            float path[] = new float[NodeData.getNodeNum() + 1];
            float S[] = new float[NodeData.getNodeNum() + 1];

            float mindis = 100000;
            int i, j, u = 0;

            //对数组初始化
            for (i = 1; i <= NodeData.getNodeNum(); i++) {
                dist[i] = NodeData.viewMar[start][i];
                S[i] = 0;

                if (NodeData.viewMar[start][i] < 100000) {
                    path[i] = start;
                } else {
                    path[i] = -1;
                }
            }

            S[start] = 1;//把访问过的记录下来

            for (i = 1; i < NodeData.getNodeNum(); i++) {
                mindis = 100000;
                for (j = 1; j <= NodeData.getNodeNum(); j++) {

                    if (S[j] == 0 && dist[j] < mindis) {

                        u = j;
                        mindis = dist[j];
                    }

                }
                S[u] = 1;

                for(j=1;j<=NodeData.getNodeNum();j++){
                    if(S[j]==0){
                        if(NodeData.viewMar[u][j]<100000 && dist[u]+NodeData.viewMar[u][j]<dist[j]){
                            dist[j] = dist[u]+NodeData.viewMar[u][j];
                            path[j] = u;
                        }
                    }
                }
            }


            return DispApath(dist,path,S,start,end);
        }

        public static float[] DispApath(float dist[],float path[],float S[],int start,int end ) {

            int j, k;
            float apath[] = new float[NodeData.getNodeNum() + 1];
            int d=1;

            if (S[end] == 1 && end != start) {

                d = 1;
                apath[d] = end;
                k = (int) path[end];

                if (k == -1) {

                } else {

                    while (k != start) {
                        d++;

                        apath[d] = k;
                        k = (int) path[k];
                    }

                    d++;
                    apath[d] = start;
                }999
				
            }

            return Arrays.copyOfRange(apath,1,d+1);
        }
}
