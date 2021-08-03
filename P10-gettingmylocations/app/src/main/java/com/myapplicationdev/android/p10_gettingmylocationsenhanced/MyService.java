package com.myapplicationdev.android.p10_gettingmylocationsenhanced;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

import java.io.File;

public class MyService extends Service {
    private MediaPlayer player = new MediaPlayer();

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try{
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "music.mp3");
            Log.d("TAG", "onStartCommand: ");
            player.setDataSource(file.getPath());
            player.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
        player.setLooping(true);
        player.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}