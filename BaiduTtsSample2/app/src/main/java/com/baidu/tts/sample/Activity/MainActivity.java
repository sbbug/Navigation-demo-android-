package com.baidu.tts.sample.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.baidu.tts.sample.View.DrawMap;
import com.baidu.tts.sample.Funtions.FindShortestPath;
import com.baidu.tts.sample.Funtions.Funs;
import com.baidu.tts.sample.R;
import com.baidu.tts.sample.Service.SoundService;

/**
 * Created by 孙宏伟 on 2016/11/3.two
 */
public class MainActivity extends Activity {
    private Context context =null;
    private Button btn=null;
    private EditText txt=null;
    private float nodes[] = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_main);

        RelativeLayout canvas = (RelativeLayout)findViewById(R.id.canvas);

        Funs.startDraw(canvas, MainActivity.this);

        //获取数据from ----to.
        Intent it = getIntent();
        String from = it.getStringExtra("from");
        String  to = it.getStringExtra("to");

        Toast.makeText(MainActivity.this, from + "-+++++-->" + to, Toast.LENGTH_SHORT).show();

        nodes = FindShortestPath.findShortestPath(Integer.parseInt(from), Integer.parseInt(to));

        if(nodes!=null){

            //从后台开启语音播报

            String content = Funs.ProductStr(nodes);

            SoundService.content=content;
            SoundService.context=this.getApplicationContext();
            Intent intent = new Intent(MainActivity.this,SoundService.class);
            startService(intent);

            //重绘地图
            DrawMap.setPath(nodes);
            Funs.startDraw(canvas, MainActivity.this);
        }

        /*
        String res="";

        for(int h=0;h<nodes.length;h++){
            res+=(int)nodes[h];
        }
        //对地图进行重绘

        Toast.makeText(MainActivity.this,"paths=====>"+res, Toast.LENGTH_SHORT).show();
*/
       /*
        context = this.getApplicationContext();
        btn = (Button)findViewById(R.id.btn);
        txt= (EditText)findViewById(R.id.txt);
      */

       /*
        获取网络数据接口
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new GetNetData(txt).execute();

            }
        });
        */
        /*
      //获取百度语音接口
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*String content = txt.getText().toString();
                GetVoice broad = new GetVoice();
                broad.startVoice(content,context);
                SoundService.context=MainActivity.this.getApplicationContext();
                Intent intent = new Intent(MainActivity.this,SoundService.class);
                startService(intent);

            }
        });
*/
    }
}
