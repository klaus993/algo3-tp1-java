package tests;

import org.junit.Test;
import algochat.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by klaus on 2017-06/15 at 23:51.
 */
public class ConversacionGrupalTest {

    @Test
    public void enviarMensaje() {
        ConversacionGrupal conversacion = new ConversacionGrupal();

        conversacion.enviarMensaje("Hola.");

        assertEquals(1, conversacion.getCantidadEnviados());
        assertEquals(0, conversacion.getCantidadRecibidos());
        assertEquals(0, conversacion.getCantidadDeMensajes("Klaus"));
        assertEquals("Yo: Hola.", conversacion.get(1));
    }

    @Test
    public void recibirMensaje() {
        ConversacionGrupal conversacion = new ConversacionGrupal();

        conversacion.recibirMensaje("Klaus", "Hola.");

        assertEquals(0, conversacion.getCantidadEnviados());
        assertEquals(1, conversacion.getCantidadRecibidos());
        assertEquals(1, conversacion.getCantidadDeMensajes("Klaus"));

        assertEquals("Klaus: Hola.", conversacion.get(1));
    }

    @Test
    public void conversar() {
        ConversacionGrupal conversacion = new ConversacionGrupal();

        conversacion.recibirMensaje("Marcio", "Estas en tu casa?");
        conversacion.enviarMensaje("Hoy no.");

        assertEquals(1, conversacion.getCantidadRecibidos());
        assertEquals(1, conversacion.getCantidadDeMensajes("Marcio"));
        assertEquals(1, conversacion.getCantidadEnviados());

        conversacion.recibirMensaje("Diego", "Paso a las 7");
        conversacion.enviarMensaje("OK");
        conversacion.recibirMensaje("Diego", "Avisame si vas a esar");
        conversacion.enviarMensaje("Te dije que si...");

        assertEquals(3, conversacion.getCantidadRecibidos());
        assertEquals(2, conversacion.getCantidadDeMensajes("Diego"));
        assertEquals(3, conversacion.getCantidadEnviados());

        assertEquals("Yo: Te dije que si...", conversacion.get(1));
        assertEquals("Diego: Avisame si vas a esar", conversacion.get(2));
        assertEquals("Yo: OK", conversacion.get(3));
        assertEquals("Diego: Paso a las 7", conversacion.get(4));
        assertEquals("Yo: Hoy no.", conversacion.get(5));
        assertEquals("Marcio: Estas en tu casa?", conversacion.get(6));
    }

    @Test
    public void contieneMensajesDe() {
        ConversacionGrupal conversacion = new ConversacionGrupal();

        assert(!conversacion.contieneMensajesDe("Klaus"));

        conversacion.recibirMensaje("Klaus", "Hola.");

        assert(conversacion.contieneMensajesDe("Klaus"));
    }

    @Test
    public void getCantidadDeMensajes() {
        ConversacionGrupal conversacion = new ConversacionGrupal();

        assertEquals(0, conversacion.getCantidadDeMensajes("Klaus"));

        conversacion.recibirMensaje("Klaus", "Hola");

        assertEquals(1, conversacion.getCantidadDeMensajes("Klaus"));

        conversacion.recibirMensaje("Klaus", "Cómo va?");

        assertEquals(2, conversacion.getCantidadDeMensajes("Klaus"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void borrarMensajes() {
        ConversacionGrupal conversacion = new ConversacionGrupal();

        conversacion.recibirMensaje("Diego", "Paso a las 7");
        conversacion.enviarMensaje("OK");
        conversacion.recibirMensaje("Diego", "Avisame si vas a esar");
        conversacion.enviarMensaje("Te dije que si...");

        conversacion.borrarMensajes();

        assertEquals(0, conversacion.getCantidadEnviados());
        assertEquals(0, conversacion.getCantidadRecibidos());
        assertEquals(0, conversacion.getCantidadDeMensajes("Diego"));
        assertEquals(0, conversacion.getCantidadDeMensajes("Marcio"));

        conversacion.get(1);
    }
}
