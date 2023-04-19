package com.example.tprepaso.ui.musica;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Button;


import androidx.annotation.Nullable;

import com.example.tprepaso.R;


public class MusicaService extends Service {


    private MediaPlayer mp;

    @Override
    public void onCreate() {
        super.onCreate();


       mp = MediaPlayer.create(this, R.raw.musica);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int value) {
        mp.start();
        return  START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {


        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
    }
}
