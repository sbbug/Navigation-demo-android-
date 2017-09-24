package com.baidu.tts.sample.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.baidu.tts.sample.Bean.Loginer;
import com.baidu.tts.sample.Funtions.Funs;
import com.baidu.tts.sample.R;

/**
 * Created by 孙宏伟 on 2016/11/3.
 */
public class LoginActivity extends Activity {

    private EditText username = null;
    private EditText userpass = null;
    private Button login = null;
    private Button reset = null;
    private Loginer loginer = null;
    private static String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        init();

        //为重置按钮绑定监听事件
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.setText("");
                userpass.setText("");
            }
        });
        //为登录按钮绑定监听事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginer = new Loginer();

                //判断输入是否为空
                if (username.getText().toString().equals("") || userpass.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "输入不得为空", Toast.LENGTH_LONG).show();
                    return;
                }
                //获取用户名与密码
                loginer.setLoginName(username.getText().toString());
                loginer.setLoginPassword(userpass.getText().toString());

               if(loginer.getLoginName().equals(Funs.name)&&loginer.getLoginPassword().equals(Funs.password)){

                   Intent intent = new Intent(LoginActivity.this,ChooseLocaNodeActivity.class);
                   startActivity(intent);
               }else{
                   Toast.makeText(LoginActivity.this,"输入有错",Toast.LENGTH_LONG).show();

               }}
        });


    }

    //控件初始化
    private void init() {

        username = (EditText) findViewById(R.id.useranme);
        userpass = (EditText) findViewById(R.id.userpass);
        login = (Button) findViewById(R.id.login);
        reset = (Button) findViewById(R.id.reset);

    }
}
