package ar.edu.unahur.obj2.command.command;

import ar.edu.unahur.obj2.command.maquina.MaquinaDeCafe;

public class AgregarAzucarCommand implements Ejecutable {
    private final MaquinaDeCafe maquina;
    private Boolean ejecutado = Boolean.FALSE;

    public AgregarAzucarCommand(MaquinaDeCafe maquina) { this.maquina = maquina; }

    @Override
    public void ejecutar() {
        if (!ejecutado) {
            maquina.agregarAzucar();
            ejecutado = Boolean.TRUE;
        }
    }

    @Override
    public void deshacer() {
        if (ejecutado) {
            maquina.deshacer();
            ejecutado = Boolean.FALSE;
        }
    }
}