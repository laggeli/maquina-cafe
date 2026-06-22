package ar.edu.unahur.obj2.command;

import java.util.Scanner;

import ar.edu.unahur.obj2.command.invoker.Invocador;
import ar.edu.unahur.obj2.command.maquina.MaquinaDeCafe;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaquinaDeCafe maquina = new MaquinaDeCafe();
        Invocador invoker = new Invocador(maquina);

        String opcion = "";

        while (!opcion.equalsIgnoreCase("t")) {

            System.out.println("=== MENU MAQUINA DE CAFE ===");
            System.out.println("Pedido Actual: " + maquina.getPedidoActual().nombre());
            System.out.println("a - Agregar Azucar");
            System.out.println("x - Agrandar el Cafe");
            System.out.println("l - Agregar Leche");
            System.out.println("u - Deshacer ultima accion");
            System.out.println("t - Terminar");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextLine();

            invoker.procesarOpcion(opcion);
            System.out.println();
        }

        scanner.close();
    }
}