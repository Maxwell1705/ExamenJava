package com.example.examenjava;

import android.widget.Toast;

public class CuentaBanco {
    // Declaración de variables de clase
    private int numCuenta;
    private String nombre;
    private String banco;
    public float saldo;

    // Constructor
    public CuentaBanco(int numCuenta, String nombre, String banco, float saldo) {
        this.numCuenta = numCuenta;
        this.nombre = nombre;
        this.banco = banco;
        this.saldo = saldo;
    }

    // Métodos de clase
    public float depositar(float dinero) { // 8000
        float saldoActualizado = 0; //0
        saldoActualizado = this.saldo + dinero; //0 + 8000
        return saldoActualizado; // 8000

    }

    public boolean retirar(float dinero) {
        boolean bandera = true;
        if (dinero > this.saldo) {
            bandera = false;
        }

        return bandera;
    }
}
