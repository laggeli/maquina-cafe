package ar.edu.unahur.obj2.command.decorator.cafe;

import ar.edu.unahur.obj2.command.decorator.Decorable;

public class Cafe implements Decorable {
    @Override
    public Double precio() { return 2.5; }

    @Override
    public String nombre() { return "Café"; }
}