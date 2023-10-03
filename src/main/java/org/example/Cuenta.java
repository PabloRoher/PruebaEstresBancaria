package org.example;

public class Cuenta {
    int saldo;

    public Cuenta(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public int setSaldo(int saldo) {
        this.saldo = saldo;
        return saldo;
    }

    //Synchronized para evitar condiciones de carrera
    public synchronized void ingresar(int cantidad) {
        saldo += cantidad;
    }

    public synchronized void retirar(int cantidad) {
        saldo -= cantidad;
    }


}
