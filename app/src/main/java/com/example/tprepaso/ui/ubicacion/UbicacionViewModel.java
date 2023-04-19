package com.example.tprepaso.ui.ubicacion;


import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


public class UbicacionViewModel extends AndroidViewModel {

     private Context context;
     private MutableLiveData<LeerMapa> mapaMutable;

     public UbicacionViewModel(@NonNull Application application) {
          super(application);
          this.context = application.getApplicationContext();
     }


     public LiveData<LeerMapa> getMutableMapa() {
          if (mapaMutable == null) {
               mapaMutable = new MutableLiveData<>();
          }
          return mapaMutable;
     }

     public void leerMapa(){
          mapaMutable.setValue(new LeerMapa(context));
     }
}


