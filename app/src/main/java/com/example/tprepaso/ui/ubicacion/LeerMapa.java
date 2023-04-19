package com.example.tprepaso.ui.ubicacion;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class LeerMapa implements OnMapReadyCallback {
    static final LatLng CASA = new LatLng(-32.898877, -66.109481);
    private GoogleMap mapa;
    private Context context;

    public LeerMapa(Context context){
        this.context = context;
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mapa = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        obtenerUltimaUbicacion();
    }



    private void obtenerUltimaUbicacion() {
        FusedLocationProviderClient fl = LocationServices.getFusedLocationProviderClient(context);
        Log.d("salida", "Entrando");
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;

        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            fl.getLastLocation().addOnSuccessListener(context.getMainExecutor(), new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    Log.d("salida", "En el if");
                    if (location != null) {
                        LatLng CASA = new LatLng(location.getLatitude(),location.getLongitude());
                        mapa.addMarker(new MarkerOptions().position(CASA))
                                .setTitle("Ubicacion Actual");
                        Log.d("salida", "Salida");

                        CameraPosition cam = new CameraPosition.Builder()
                                .target(CASA)
                                .zoom(17)
                                .bearing(8)
                                .build();
                        CameraUpdate caU = CameraUpdateFactory.newCameraPosition(cam);
                        mapa.animateCamera(caU);
                    }

                }

            });
        }


    }
}
