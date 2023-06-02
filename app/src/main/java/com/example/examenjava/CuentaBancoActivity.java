package com.example.examenjava;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CuentaBancoActivity extends AppCompatActivity {
    // Declaración de variables
    private TextView lblNombreBanco;
    private TextView lblNombreCliente;
    private TextView lblSaldo;

    private EditText txtCantidad;

    private Button btnDeposito;
    private Button btnRetiro;
    private Button btnRegresar;

    private CuentaBanco cb = new CuentaBanco(0, "", "", 0);;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta_banco);
        iniciarComponentes();
        // Obtener los datos del Main Activity
        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("nombre");
        String banco = datos.getString("banco");
        String saldo = datos.getString("saldo");
        lblNombreCliente.setText(nombre);
        lblNombreBanco.setText(banco);
        lblSaldo.setText(saldo);

        btnDeposito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                depositar();
            }
        });
        btnRetiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retirar();
            }
        });
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresar();
            }
        });
    }

    private void iniciarComponentes() {
        lblNombreBanco = (TextView) findViewById(R.id.lblNombreBanco);
        lblNombreCliente = (TextView) findViewById(R.id.lblNombreCliente);
        lblSaldo = (TextView) findViewById(R.id.lblSaldo);

        txtCantidad = (EditText) findViewById(R.id.txtCantidad);

        btnDeposito = (Button) findViewById(R.id.btnDeposito);
        btnRetiro = (Button) findViewById(R.id.btnRetiro);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);

    }

    private void depositar() {
        if (txtCantidad.getText().toString().isEmpty()) {
            Toast.makeText(this, "Capture la cantidad", Toast.LENGTH_SHORT).show();
        } else {
            float cantidad = Float.parseFloat(txtCantidad.getText().toString()); // 8000
            float resultado = cb.depositar(cantidad); // 8000
            float saldoActualizado = Float.parseFloat(lblSaldo.getText().toString());
            float tot = resultado + saldoActualizado;
            lblSaldo.setText("" + tot);
        }

    }

    private void retirar() {
        if (txtCantidad.getText().toString().isEmpty()) {
            Toast.makeText(this, "Capture la cantidad", Toast.LENGTH_SHORT).show();
        } else {
            float cantidad = Float.parseFloat(txtCantidad.getText().toString());
            float saldoActualizado = Float.parseFloat(lblSaldo.getText().toString());
            float tot;

            tot = saldoActualizado - cantidad;
            lblSaldo.setText("" + tot);
        }

    }

    private void regresar() {
        AlertDialog.Builder confirmar = new AlertDialog.Builder(this);
        confirmar.setTitle("BANCO NACIONAL SOMEX");
        confirmar.setMessage("Regresar al MainActivity");
        confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // No hace nada
            }
        });
        confirmar.show();

    }

}




