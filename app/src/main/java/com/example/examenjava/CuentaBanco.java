package com.example.examenjava;

import android.widget.Toast;

public class CuentaBanco {
    // Declaración de variables de clase
    private int numCuenta;
    private String nombre;
    private String banco;
    private float saldo;

    public CuentaBanco(int numCuenta, String nombre, String banco, float saldo) {
        this.numCuenta = numCuenta;
        this.nombre = nombre;
        this.banco = banco;
        this.saldo = saldo;
    }

    public void depositar(float dinero) {
        float saldoActualizado = 0;
        this.saldo = this.saldo + dinero;
    }

    public boolean retirar(float dinero) {
        boolean bandera = true;
        if (dinero > this.saldo) {
            bandera = false;
        }

        return bandera;
    }
}
