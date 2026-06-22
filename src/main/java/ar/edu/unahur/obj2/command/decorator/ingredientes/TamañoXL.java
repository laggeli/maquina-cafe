package ar.edu.unahur.obj2.command.decorator.ingredientes;

import ar.edu.unahur.obj2.command.decorator.Decorable;

public class TamañoXL extends Agregado {
    public TamañoXL(Decorable decorado) { super(decorado); }

    @Override
    public Double precio() { return decorado.precio() + 1.5; }

    @Override
    public String nombre() { return decorado.nombre() + " - Tamaño XL"; }
}