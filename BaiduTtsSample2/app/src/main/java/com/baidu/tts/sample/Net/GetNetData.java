package com.baidu.tts.sample.Net;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.widget.EditText;

import com.baidu.tts.sample.Bean.Loginer;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import java.io.IOException;

/**
 * Created by 孙宏伟 on 2016/11/3.
 */
public class GetNetData extends AsyncTask<Void, Void, String> {

    private static final String URL = "http://yyandhgforever.pw/getData/ConnMysql.php?username=xyy&password=1204";
    private String name;
    private String password;
    private String result;
    private AndroidHttpClient mClient ;
    private EditText txt;

    public GetNetData(EditText txt){
           this.txt=txt;
    }

    public GetNetData(Loginer loginer) {
         this.name= loginer.getLoginName();
         this.password=loginer.getLoginPassword();
         this.result="";
         this.mClient = AndroidHttpClient.newInstance("");
    }

    @Override
    protected String doInBackground(Void... params) {

       // String url=URL+"?"+"username="+name+"&password="+password;
        HttpGet request = new HttpGet(URL);
        ResponseHandler<String> responseHandler = new BasicResponseHandler();

        try {
            return mClient.execute(request, responseHandler);
        } catch (ClientProtocolException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {

        if (null != mClient)
            mClient.close();

        txt.setText(result.toString());


    }
    public String  getJson(){

        return this.result;
    }
}