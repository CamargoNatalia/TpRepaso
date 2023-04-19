package com.example.tprepaso.ui.musica;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MusicaViewModel extends AndroidViewModel {

    private Context context;

    public MusicaViewModel(@NonNull Application application) {
        super(application);
        this.context= application;
    }


    public void iniciarServicio(){
        Intent intent=new Intent(context, MusicaService.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startService(intent);

    }

}
