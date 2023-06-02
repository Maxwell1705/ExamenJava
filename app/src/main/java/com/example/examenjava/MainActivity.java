package com.example.examenjava;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    // Declaracion de variables
    private EditText txtNumeroCuenta;
    private EditText txtNombre;
    private EditText txtNombreBanco;
    private EditText txtSaldo;
    private Button btnEnviar;
    private Button btnSalir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviar();
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salir();
            }
        });
    }

    private void iniciarComponentes() {
        // Cajas de Texto
        txtNumeroCuenta = (EditText) findViewById(R.id.txtNumeroCuenta);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtNombreBanco = (EditText) findViewById(R.id.txtNombreBanco);
        txtSaldo = (EditText) findViewById(R.id.txtSaldo);

        // Botones
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnSalir = (Button) findViewById(R.id.btnSalir);

    }
    private void enviar() {
        String numCuenta;
        String nombre;
        String banco;
        String saldo;

        banco = getApplicationContext().getResources().getString(R.string.strBanco);


        // Hacer el paquete para enviar información
        Bundle bundle = new Bundle();
        bundle.putString("nombre", txtNombre.getText().toString());
        bundle.putString("banco", txtNombreBanco.getText().toString());
        bundle.putString("saldo", txtSaldo.getText().toString());

        // Crear el intent para llamar a otra actividad
        Intent intent = new Intent(MainActivity.this, CuentaBancoActivity.class);
        intent.putExtras(bundle);

        // Iniciar la actividad esperando o no respuesta
        startActivity(intent);

    }

    private void salir() {
        finish();
    }


}
