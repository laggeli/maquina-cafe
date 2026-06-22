package ar.edu.unahur.obj2.command.invoker;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.command.AgrandarCommand;
import ar.edu.unahur.obj2.command.command.AgregarAzucarCommand;
import ar.edu.unahur.obj2.command.command.AgregarLecheCommand;
import ar.edu.unahur.obj2.command.command.Ejecutable;
import ar.edu.unahur.obj2.command.maquina.MaquinaDeCafe;

public class Invocador {
    private MaquinaDeCafe maquina;
    private List<Ejecutable> historial = new ArrayList<>();

    public Invocador(MaquinaDeCafe maquina) { this.maquina = maquina; }

    public void procesarOpcion(String opcion) {
        switch (opcion.toLowerCase()) {
            case "a": ejecutar(new AgregarAzucarCommand(maquina));
            break;

            case "l": ejecutar(new AgregarLecheCommand(maquina));
            break;

            case "x":ejecutar(new AgrandarCommand(maquina));
            break;

            case "u":deshacer();
            break;

            case "t":terminarPedido();
            break;

            default: System.out.println("Opción inválida.");
        }
    }

    private void ejecutar(Ejecutable comando) {
        comando.ejecutar();
        historial.add(comando);
    }

    public void deshacer() {
        if (!historial.isEmpty()) {
            Ejecutable ultimo = historial.getLast();
            ultimo.deshacer();
            historial.remove(historial.size() - 1);
        }
    }

    public void terminarPedido() { System.out.println("Importe a pagar: $" + maquina.getPedidoActual().precio()); }
}