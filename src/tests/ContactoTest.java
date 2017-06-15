package tests;

import algochat.AlgoConversacion;
import algochat.Contacto;
import junit.framework.JUnit4TestAdapter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Created by klaus on 2017-06/14 at 15:42.
 */
public class ContactoTest {

    @Test
    public void crearContacto() {
        Contacto contacto = new Contacto("Klaus");

        assertEquals(0, contacto.getCantidadEnviados());
        assertEquals(0, contacto.getCantidadRecibidos());
        assertEquals("Klaus", contacto.getNombre());
    }

    @Test
    public void enviarMensaje() {
        Contacto contacto = new Contacto("Klaus");

        contacto.enviarMensaje("Hola");

        assertEquals(1, contacto.getCantidadEnviados());
        assertEquals(0, contacto.getCantidadRecibidos());

        contacto.enviarMensaje("Qué tal?");

        assertEquals(2, contacto.getCantidadEnviados());
    }

    @Test
    public void recibirMensaje() {
        Contacto contacto = new Contacto("Klaus");

        contacto.recibirMensaje("Buenas.");

        assertEquals(0, contacto.getCantidadEnviados());
        assertEquals(1, contacto.getCantidadRecibidos());

        contacto.recibirMensaje("Hola.");

        assertEquals(2, contacto.getCantidadRecibidos());
    }

    @Test
    public void incrementarRecibidos() {
        Contacto contacto = new Contacto("Klaus");

        contacto.incrementarRecibidos();
        contacto.incrementarRecibidos();

        assertEquals(2, contacto.getCantidadRecibidos());
    }

    @Test
    public void disminuirRecibidos() {
        Contacto contacto = new Contacto("Klaus");

        contacto.incrementarRecibidos();
        contacto.incrementarRecibidos();
        contacto.disminuirRecibidos(2);

        assertEquals(0, contacto.getCantidadRecibidos());
    }

    @Test
    public void conversar() {
        Contacto contacto = new Contacto("Klaus");

        contacto.enviarMensaje("Hola, todo bien?");
        contacto.recibirMensaje("Todo bien, ¿vos?");
        contacto.enviarMensaje("Todo en orden.");
        contacto.recibirMensaje("Que bueno.");

        assertEquals(2, contacto.getCantidadEnviados());
        assertEquals(2, contacto.getCantidadRecibidos());
    }

    @Test
    public void obtenerConversacion() {
        Contacto contacto = new Contacto("Klaus");

        contacto.enviarMensaje("Hola, todo bien?");
        contacto.recibirMensaje("Todo bien, ¿vos?");
        contacto.enviarMensaje("Todo en orden.");
        contacto.recibirMensaje("Que bueno.");

        AlgoConversacion conversacion = contacto.obtenerConversacion();

        assertEquals(2, conversacion.getCantidadEnviados());
        assertEquals(2, conversacion.getCantidadRecibidos());

        assertEquals("Klaus: Que bueno.", conversacion.get(1));
        assertEquals("Yo: Todo en orden.", conversacion.get(2));
        assertEquals("Klaus: Todo bien, ¿vos?", conversacion.get(3));
        assertEquals("Yo: Hola, todo bien?", conversacion.get(4));
    }
}
