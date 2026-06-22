package ar.edu.unahur.obj2.command.maquina;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.command.AgregarAzucarCommand;
import ar.edu.unahur.obj2.command.command.Ejecutable;
import ar.edu.unahur.obj2.command.invoker.Invocador;

public class MaquinaDeCafeTest {
    private MaquinaDeCafe maquina;
    private Invocador invocador;

    @BeforeEach
    void setUp() {
        maquina = new MaquinaDeCafe();
        invocador = new Invocador(maquina);
    }

    @Test
    void dadoUnCafeBase_cuandoObtenesElPedido_entoncesConfirmoQueTieneElPrecioCorrecto() {
        assertEquals(2.5, maquina.getPedidoActual().precio());
    }

    @Test
    void dadoUnCafeBase_cuandoObtenesElPedido_entoncesConfirmasQueTieneNombreCorrecto() {
        assertEquals("Café", maquina.getPedidoActual().nombre());
    }

    @Test
    void dadoUnCafeBase_cuandoAgregasAzucar_entoncesAumentaElPrecio() {
        maquina.agregarAzucar();

        assertEquals(3.0, maquina.getPedidoActual().precio());
    }

    @Test
    void dadoUnCafeBase_cuandoAgregasLeche_entoncesAumentaElPrecio() {
        maquina.agregarLeche();

        assertEquals(3.65, maquina.getPedidoActual().precio());
    }

    @Test
    void dadoUnCafeBase_cuandoAgrandasElCafe_entoncesAumentaElPrecio() {
        maquina.agrandar();

        assertEquals(4.0, maquina.getPedidoActual().precio());
    }

    @Test
    void dadoUnCafeBase_cuandoAgregoDecoradores_entoncesConfirmoQueElNombreEsCorrecto() {
        maquina.agregarAzucar();
        maquina.agregarLeche();
        maquina.agrandar();

        assertEquals(5.65, maquina.getPedidoActual().precio());
        assertEquals("Café - Azucar - Leche - Tamaño XL", maquina.getPedidoActual().nombre());
    }

    @Test
    void dadoUnPedidoDeCafe_cuandoDeshagoUnaAccion_entoncesVuelveAlEstadoAnterior() {
        maquina.agregarAzucar();
        maquina.agregarLeche();

        maquina.deshacer();

        assertEquals("Café - Azucar", maquina.getPedidoActual().nombre());
    }

    @Test
    void dadoUnPedidoDeCafe_cuandoNoTieneAgregados_entoncesDeshacerNoHaceNada() {
        maquina.deshacer();

        assertEquals("Café",maquina.getPedidoActual().nombre());
    }

    @Test
    void dadoUnComandoDeAgregarAzucar_cuandoSeEjecuta_entoncesVerificoQueFunciona() {
        Ejecutable comando = new AgregarAzucarCommand(maquina);

        comando.ejecutar();

        assertEquals("Café - Azucar", maquina.getPedidoActual().nombre());
    }

    @Test
    void dadoUnComandoDeAgregarAzucar_cuandoSeEjecuta_entoncesVerificoQuePuedeDeshacerse() {
        Ejecutable comando =new AgregarAzucarCommand(maquina);

        comando.ejecutar();
        comando.deshacer();

        assertEquals("Café", maquina.getPedidoActual().nombre());
    }

    @Test
    void dadoUnInvocador_cuandoProcesaLaOpcionA_entoncesSeLeAgregaAzucarAUnCafe() {
        invocador.procesarOpcion("a");

        assertEquals("Café - Azucar",maquina.getPedidoActual().nombre());
    }

    @Test
    void dadoUnInvocador_cuandoProcesaLasOpciones_entoncesPuedeDeshacerlas() {
        invocador.procesarOpcion("a");
        invocador.procesarOpcion("l");
        invocador.procesarOpcion("u");

        assertEquals("Café - Azucar", maquina.getPedidoActual().nombre());
    }
}