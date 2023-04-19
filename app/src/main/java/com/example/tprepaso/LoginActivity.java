package com.example.tprepaso;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tprepaso.ui.musica.MusicaService;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsuario, etContrasenia;
    private Button btIngresar;
    private LoginViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVista();
    }

    private void inicializarVista() {


        etUsuario = findViewById(R.id.etUsuario);
        etContrasenia = findViewById(R.id.etContrasenia);
        btIngresar = findViewById(R.id.btIngresar);

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        viewModel.getMutableFalla().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Toast.makeText(LoginActivity.this, "Usuario y/o Contraseña incorrectos",Toast.LENGTH_SHORT).show();
            }
        });
        btIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = etUsuario.getText().toString();
                String password = etContrasenia.getText().toString();
                viewModel.Validado(username, password);


            }

        });
    }

}
