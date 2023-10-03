package org.example;

public class HiloCliente implements Runnable{

    private Cuenta cuenta;
    private int cantidad;
    private boolean ingreso;

    public HiloCliente(Cuenta cuenta, int cantidad, boolean ingreso) {
        this.cuenta = cuenta;
        this.cantidad = cantidad;
        this.ingreso = ingreso;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isIngreso() {
        return ingreso;
    }

    public void setIngreso(boolean ingreso) {
        this.ingreso = ingreso;
    }

    @Override
    public void run() {
        if (ingreso) {
            cuenta.ingresar(cantidad);
        } else {
            cuenta.retirar(cantidad);
        }
    }
}
