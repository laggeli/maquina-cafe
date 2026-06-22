package ar.edu.unahur.obj2.command.decorator.ingredientes;

import ar.edu.unahur.obj2.command.decorator.Decorable;

public class Leche extends Agregado {
    private Double costo;

    public Leche(Decorable decorado, Double costo) { 
        super(decorado); 
        this.costo = costo;
    }

    public Leche(Decorable decorado) {
        super(decorado);
    }

    @Override
    public Double precio() { return decorado.precio() + costo; }

    @Override
    public String nombre() { return decorado.nombre() + " - Leche"; }

    public void cambiarCosto(Double costo) { this.costo = costo; }
}