package com.baidu.tts.sample.Service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import com.baidu.tts.sample.Net.GetVoice;

/**
 * Created by 孙宏伟 on 2016/11/6.
 */
public class SoundService extends Service{

    public static Context context;
    public static String content=null;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int  onStartCommand(Intent intent, int flags, int startId) {

        GetVoice broad = new GetVoice();
        broad.startVoice(SoundService.content, SoundService.context);

        return START_STICKY;
    }
}
