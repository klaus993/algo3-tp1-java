package tests;

import algochat.Conversacion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by klaus on 2017-06/15 at 23:13.
 */
public class ConversacionTest {

    @Test
    public void conversacionNueva() {
        Conversacion conversacion = new Conversacion();

        assertEquals(0, conversacion.getCantidadEnviados());
        assertEquals(0, conversacion.getCantidadRecibidos());
    }

    @Test
    public void enviarMensaje() {
        Conversacion conversacion = new Conversacion();

        conversacion.enviarMensaje("Hola.");

        assertEquals(1, conversacion.getCantidadEnviados());
        assertEquals(0, conversacion.getCantidadRecibidos());
        assertEquals("Yo: Hola.", conversacion.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get() {
        Conversacion conversacion = new Conversacion();

        conversacion.enviarMensaje("Hola.");

        conversacion.get(2);
    }
}
