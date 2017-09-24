package com.baidu.tts.sample.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.tts.sample.Data.NodeData;
import com.baidu.tts.sample.R;

/**
 * Created by 孙宏伟 on 2016/11/3.
 */
public class ShowInfoActivity extends Activity {

    private TextView title = null;
    private TextView content = null;
    private ImageView image = null;
    private Button button = null;
    private Button show_3d = null;
    private int key;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_main);
        //初始化按钮
        initIt();
        //接受MainActivity页面传递过来的参数
        Intent intent = getIntent();
        key = intent.getIntExtra("key", 1);
        //参数显示
        Toast.makeText(ShowInfoActivity.this, "key" + String.valueOf(key), Toast.LENGTH_SHORT).show();

        title.setText(NodeData.locations[key].getName());
        content.setText(NodeData.locations[key].getInfo());

        show_3d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在这里实现页面的跳转
                Intent intent = new Intent();
                intent.putExtra("key", key); //参数传递
                intent.setClass(ShowInfoActivity.this, WebViewActivity.class);
                ShowInfoActivity.this.startActivity(intent);

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowInfoActivity.this.finish();
            }
        });
    }

    //初始化方法
    public void initIt() {
        title = (TextView) findViewById(R.id.title);
        content = (TextView) findViewById(R.id.content);
      //  image = (ImageView) findViewById(R.id.image);
        show_3d = (Button)findViewById(R.id.show_3d);
        button = (Button) findViewById(R.id.button);
    }
}
