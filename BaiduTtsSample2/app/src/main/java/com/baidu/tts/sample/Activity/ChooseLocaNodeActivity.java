package com.baidu.tts.sample.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.baidu.tts.sample.Funtions.Funs;
import com.baidu.tts.sample.Data.NodeData;
import com.baidu.tts.sample.R;

/**
 * Created by 孙宏伟 on 2016/11/3.
 */
public class ChooseLocaNodeActivity extends Activity {

    //选择路径里的界面的控件定义
    private Button button;
    private Spinner spinnerOne;
    private Spinner spinnerTwo;
    private String items[] = null;
    //选择的路径定义
    private int from;
    private int to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_location);
      //  NodeData.initNodeData();//在单独测试这个页面时，数据一定要记得初始化
        Funs.initData();
        initSpinner();
    }

    //控件的初始化
    public void initSpinner() {

        button = (Button) findViewById(R.id.check);
        spinnerOne = (Spinner) findViewById(R.id.spinnerOne);
        spinnerTwo = (Spinner) findViewById(R.id.spinnerTwo);

        //数据源邦定到spinner
        items = new String[NodeData.getNodeNum()];
        for (int i = 0; i <= NodeData.getNodeNum() - 1; i++) {
            items[i] = NodeData.locations[i + 1].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOne.setAdapter(adapter);
        spinnerTwo.setAdapter(adapter);

        //为spinnerOne与spinnerTwo绑定监听器     //记住这里需要添加AdapterView，否则APP会闪退
        spinnerOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                from = pos + 1; //需要加1，为了考虑0的问题
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
        //为spinnerTwo与spinnerTwo绑定监听器
        spinnerTwo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                to = pos + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
        //???为什么这里总会出现闪退呢?

        //绑定按钮监听器
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(ChooseLocaNodeActivity.this, String.valueOf(from) + "--->" + String.valueOf(to), Toast.LENGTH_SHORT).show();


                //页面的跳转。并且带有参数跳转
                Intent intent = new Intent(ChooseLocaNodeActivity.this, MainActivity.class);
                intent.putExtra("from", String.valueOf(from));
                intent.putExtra("to", String.valueOf(to));

                startActivity(intent);
            }
        });

    }
}

