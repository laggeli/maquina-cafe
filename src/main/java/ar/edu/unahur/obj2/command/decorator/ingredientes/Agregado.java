package ar.edu.unahur.obj2.command.decorator.ingredientes;

import ar.edu.unahur.obj2.command.decorator.Decorable;

public abstract class Agregado implements Decorable {
    protected Decorable decorado;

    public Agregado(Decorable decorado) { this.decorado = decorado; }
}