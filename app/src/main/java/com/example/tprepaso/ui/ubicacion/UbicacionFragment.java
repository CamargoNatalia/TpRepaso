package com.example.tprepaso.ui.ubicacion;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tprepaso.R;
import com.google.android.gms.maps.SupportMapFragment;


public class UbicacionFragment extends Fragment {

    private UbicacionViewModel ubicacionViewModel;
    public static UbicacionFragment newInstance() {
        return new UbicacionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root =  inflater.inflate(R.layout.fragment_ubicacion, container, false);

        ubicacionViewModel=  new ViewModelProvider(this).get(UbicacionViewModel.class);
        ubicacionViewModel.getMutableMapa().observe(getViewLifecycleOwner(), new Observer<LeerMapa>() {
            @Override
            public void onChanged(LeerMapa leerMapa) {
                SupportMapFragment mapFragment =
                        (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapa);
                if (mapFragment != null) {
                    mapFragment.getMapAsync(leerMapa);
                }
            }
        });
        ubicacionViewModel.leerMapa();
        return root;

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }

}

