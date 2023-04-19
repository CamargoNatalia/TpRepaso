package com.example.tprepaso;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class LoginViewModel extends AndroidViewModel {
private Context context;
private MutableLiveData<Boolean> mutableFalla;


    public LoginViewModel(@NonNull Application application) {
        super(application);
        this.context = application;

    }

    public LiveData<Boolean> getMutableFalla(){
        if (mutableFalla==null){
            mutableFalla= new MutableLiveData<>();

        }
        return mutableFalla;
    }

    public void Validado(String usuario, String contrasenia) {

        if(usuario.equals("usuario") && contrasenia.equals("contrasenia")){
            Intent intent = new Intent(context, MenuNavegable.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
        else{
            mutableFalla.setValue(true);
        }

    }
}