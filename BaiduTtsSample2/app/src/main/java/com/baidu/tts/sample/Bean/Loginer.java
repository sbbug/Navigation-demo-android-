package com.baidu.tts.sample.Bean;

import com.baidu.tts.sample.Net.GetNetData;

/**
 * Created by 孙宏伟 on 2016/11/3.
 */
public class Loginer {
    //用户名
    private String loginName = null;
    //密码
    private String loginPassword = null;

    //获取用户名
    public String getLoginName() {
        return loginName;
    }
    //设置用户名
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    //获取用户密码
    public String getLoginPassword() {
        return loginPassword;
    }
    //设置用户密码
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

  /*  //判断用户是否在数据库里存在
    public static String isExist(Loginer login)  {




    }*/
    //获取json字符串
    public static String sendGet(Loginer login) {
         GetNetData netData = new GetNetData(login);
         netData.execute();

         return netData.getJson();
    }
}
