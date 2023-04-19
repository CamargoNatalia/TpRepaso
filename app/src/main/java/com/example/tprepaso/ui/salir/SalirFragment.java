package com.example.tprepaso.ui.salir;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.tprepaso.R;
import com.example.tprepaso.databinding.FragmentSalirBinding;

public class SalirFragment extends Fragment {

        private FragmentSalirBinding binding;


        public static SalirFragment newInstance() {
            return new SalirFragment();
        }



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SalirViewModel sViewModel =
                new ViewModelProvider(this).get(SalirViewModel.class);

        binding = FragmentSalirBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.tvCerrarSesion;
        sViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        Dialogo();

        return root;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

        private void Dialogo() {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Desea Cerrar Sesion?");
            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    System.exit(0);
                }
            });
            builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_menu_navegable).navigate(R.id.nav_ubicacion);

                }
            });
            builder.show();

        }
}