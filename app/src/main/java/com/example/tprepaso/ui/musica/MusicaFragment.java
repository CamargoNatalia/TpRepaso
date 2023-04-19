package com.example.tprepaso.ui.musica;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.tprepaso.databinding.FragmentMusicaBinding;



public class MusicaFragment extends Fragment {
    private FragmentMusicaBinding binding;



    public static MusicaFragment newInstance() {
        return new MusicaFragment();
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MusicaViewModel musicaViewModel =
                new ViewModelProvider(this).get(MusicaViewModel.class);

        binding = FragmentMusicaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final Button btnPlay = binding.btnPlay;
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicaViewModel.iniciarServicio();
            }
        });


        return root;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}