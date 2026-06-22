package ar.edu.unahur.obj2.command.decorator.ingredientes;

import ar.edu.unahur.obj2.command.decorator.Decorable;

public class Azucar extends Agregado {
    private final Double costo;

    public Azucar(Decorable decorado, Double costo) { 
        super(decorado); 
        this.costo = costo;
    }

    @Override
    public Double precio() { return decorado.precio() + costo; }

    @Override
    public String nombre() { return decorado.nombre() + " - Azucar"; }
}