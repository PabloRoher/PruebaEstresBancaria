package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Lanzador {
    public static void main(String[] args) throws InterruptedException {
        Cuenta cuenta = new Cuenta(10000);
        ExecutorService executor = Executors.newFixedThreadPool(10); // 10 hilos en el pool

        // [Depósito de 100 euros (x400), Depósito de 50 euros (x200), Depósito de 20 euros (x600)]
        // [Retiro de 100 euros (x400), Retiro de 50 euros (x200), Retiro de 20 euros (x600)]
        ejecutarOperaciones(cuenta, 100, true, 400, executor);
        ejecutarOperaciones(cuenta, 50, true, 200, executor);
        ejecutarOperaciones(cuenta, 20, true, 600, executor);
        ejecutarOperaciones(cuenta, 100, false, 400, executor);
        ejecutarOperaciones(cuenta, 50, false, 200, executor);
        ejecutarOperaciones(cuenta, 20, false, 600, executor);

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        System.out.println("Saldo final: " + cuenta.getSaldo());
    }

    private static void ejecutarOperaciones(Cuenta cuenta, int euros, boolean esDeposito, int veces, ExecutorService executor) {
        for (int i = 0; i < veces; i++) {
            executor.submit(new HiloCliente(cuenta, euros, esDeposito));
        }
    }
}
