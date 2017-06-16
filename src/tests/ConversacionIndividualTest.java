package tests;

import algochat.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by klaus on 2017-06/15 at 23:28.
 */
public class ConversacionIndividualTest {

    @Test
    public void crear() {
        ConversacionIndividual conversacion = new ConversacionIndividual("Klaus");

        assertEquals("Klaus", conversacion.getContacto());
    }

    @Test
    public void recibirMensaje() {
        ConversacionIndividual conversacion = new ConversacionIndividual("Klaus");

        conversacion.recibirMensaje("Hola, cómo va?");

        assertEquals("Klaus: Hola, cómo va?", conversacion.get(1));
    }

    @Test

    public void conversar() {
        ConversacionIndividual conversacion = new ConversacionIndividual("Klaus");

        conversacion.enviarMensaje("Hola, todo bien?");
        conversacion.recibirMensaje("Todo bien, ¿vos?");
        conversacion.enviarMensaje("Todo en orden.");
        conversacion.recibirMensaje("Que bueno.");

        assertEquals(2, conversacion.getCantidadEnviados());
        assertEquals(2, conversacion.getCantidadRecibidos());

        assertEquals("Klaus: Que bueno.", conversacion.get(1));
        assertEquals("Yo: Todo en orden.", conversacion.get(2));
        assertEquals("Klaus: Todo bien, ¿vos?", conversacion.get(3));
        assertEquals("Yo: Hola, todo bien?", conversacion.get(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void borrarMensajes() {
        ConversacionIndividual conversacion = new ConversacionIndividual("Klaus");

        conversacion.enviarMensaje("Hola, todo bien?");
        conversacion.recibirMensaje("Todo bien, ¿vos?");
        conversacion.enviarMensaje("Todo en orden.");
        conversacion.recibirMensaje("Que bueno.");

        conversacion.borrarMensajes();

        assertEquals(0, conversacion.getCantidadRecibidos());
        assertEquals(0, conversacion.getCantidadEnviados());

        conversacion.get(1);
    }
}
