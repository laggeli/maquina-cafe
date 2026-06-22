package ar.edu.unahur.obj2.command.maquina;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.decorator.Decorable;
import ar.edu.unahur.obj2.command.decorator.cafe.Cafe;
import ar.edu.unahur.obj2.command.decorator.ingredientes.Azucar;
import ar.edu.unahur.obj2.command.decorator.ingredientes.Leche;
import ar.edu.unahur.obj2.command.decorator.ingredientes.TamañoXL;

public class MaquinaDeCafe {
    private Decorable pedidoActual = new Cafe();
    private List<Decorable> historial = new ArrayList<>();

    public MaquinaDeCafe() {}

    public Decorable getPedidoActual() { return pedidoActual; }

    public void setPedidoActual(Decorable pedido) { pedidoActual = pedido; }

    public void agregarLeche() { 
        historial.add(pedidoActual);
        pedidoActual = new Leche(pedidoActual, 1.15); 
    }

    public void agregarAzucar() { 
        historial.add(pedidoActual);
        pedidoActual = new Azucar(pedidoActual, 0.50); 
    }

    public void agrandar() { 
        historial.add(pedidoActual);
        pedidoActual = new TamañoXL(pedidoActual); 
    }

    public void deshacer() { 
        if (!historial.isEmpty()) {
            pedidoActual = historial.getLast();
            historial.remove(historial.size() - 1);
        }
    }
}