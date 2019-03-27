package com.example.androidserviceexample_playingmusicinbackground;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

public class MyService extends Service {
    private  MediaPlayer m;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public MyService() {
        super();
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "onCreate hello", Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "onStartCommand hello", Toast.LENGTH_SHORT).show();
        m = MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        m.setLooping(true);
        m.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "onDestroy bye bye", Toast.LENGTH_SHORT).show();
        super.onDestroy();
        m.stop();
    }
}
