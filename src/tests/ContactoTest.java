package tests;

import algochat.Contacto;
import junit.framework.JUnit4TestAdapter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by klaus on 2017-06/14 at 15:42.
 */
public class ContactoTest {

    public ContactoTest() {

    }

    @Test
    public void crearContacto() {
        Contacto contacto = new Contacto("Klaus");

        assertEquals(0, contacto.getCantidadEnviados());
        assertEquals(0, contacto.getCantidadRecibidos());
        assertEquals("Klaus", contacto.getNombre());
    }
}
