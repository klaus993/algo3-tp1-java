package tests;

import algochat.*;
import exceptions.*;
import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.assertEquals;

/**
 * Created by klaus on 2017-06/15 at 21:53.
 */
public class GrupoTest {

    public static Contacto[] crearContactos() {
        Contacto[] contactos = {
               new Contacto("Klaus"),
               new Contacto("Daniela"),
               new Contacto("Martín")
               };
        return contactos;
    }

    @Test
    public void crearGrupo() {
        Grupo grupo = new Grupo("Grupo1");

        assertEquals(1, grupo.getCantidadMiembros());
        assertEquals(0, grupo.getCantidadRecibidos());
        assertEquals(0, grupo.getCantidadEnviados());
    }

    @Test
    public void agregarMiembros() {
        Contacto[] contactos = GrupoTest.crearContactos();
        Grupo grupo = new Grupo("Grupo1");

        for (Contacto contacto : contactos) {
            grupo.agregarMiembro(contacto);
        }

        assertEquals(4, grupo.getCantidadMiembros());
    }

    @Test(expected = UsuarioYaExiste.class)
    public void agregarMiembroRepetido() {
        Grupo grupo = new Grupo("Grupo1");

        Contacto contacto = new Contacto("Klaus");

        grupo.agregarMiembro(contacto);
        grupo.agregarMiembro(contacto);
    }

    @Test
    public void existeMiembro() {
        Contacto[] contactos = GrupoTest.crearContactos();

        Grupo grupo = new Grupo("Grupo1");

        for (Contacto contacto : contactos) {
            grupo.agregarMiembro(contacto);
        }

        assert(grupo.existeMiembro("Klaus"));
        assert(grupo.existeMiembro("Daniela"));
        assert(grupo.existeMiembro("Martín"));
    }

    @Test
    public void enviarMensaje() {
        Grupo grupo = new Grupo("Grupo1");

        grupo.enviarMensaje("Hole");

        assertEquals(1, grupo.getCantidadEnviados());
        assertEquals(0, grupo.getCantidadRecibidos());
    }

    @Test
    public void recibirMensajeMiembro() {
        Contacto contacto = new Contacto("Klaus");

        Grupo grupo = new Grupo("Grupo1");

        grupo.agregarMiembro(contacto);

        grupo.recibirMensaje("Klaus", "Hola.");

        assertEquals(1, grupo.getCantidadRecibidos());
        assertEquals(0, grupo.getCantidadEnviados());
        assertEquals(2, grupo.getCantidadMiembros());
    }

    @Test(expected = UsuarioNoExiste.class)
    public void recibirMensajeNoMiembro() {
        Grupo grupo = new Grupo("Grupo1");

        grupo.recibirMensaje("Klaus", "Hola.");
    }

    @Test
    public void conversar() {
        Contacto[] contactos = GrupoTest.crearContactos();

        Grupo grupo = new Grupo("Grupo1");

        for (Contacto contacto : contactos) {
            grupo.agregarMiembro(contacto);
        }

        grupo.recibirMensaje("Daniela", "Buenas.");
        grupo.recibirMensaje("Klaus", "Buenas!");
        grupo.recibirMensaje("Klaus", "Todo bien?");
        grupo.recibirMensaje("Martín", "Cómo va, gente?");
        grupo.enviarMensaje("Hola, grupo!");

        assertEquals(1, grupo.getCantidadDeMensajes("Daniela"));
        assertEquals(2, grupo.getCantidadDeMensajes("Klaus"));
        assertEquals(1, grupo.getCantidadDeMensajes("Martín"));

        assertEquals(4, grupo.getCantidadRecibidos());
        assertEquals(1, grupo.getCantidadEnviados());
    }

    @Test
    public void borrarMensajes() {
        Contacto[] contactos = GrupoTest.crearContactos();

        Grupo grupo = new Grupo("Grupo1");

        for (Contacto contacto : contactos) {
            grupo.agregarMiembro(contacto);
        }

        grupo.recibirMensaje("Daniela", "Buenas.");
        grupo.recibirMensaje("Klaus", "Buenas!");
        grupo.recibirMensaje("Klaus", "Todo bien?");
        grupo.recibirMensaje("Martín", "Cómo va, gente?");
        grupo.enviarMensaje("Hola, grupo!");

        grupo.borrarMensajes();

        assertEquals(0, grupo.getCantidadDeMensajes("Daniela"));
        assertEquals(0, grupo.getCantidadDeMensajes("Klaus"));
        assertEquals(0, grupo.getCantidadDeMensajes("Martín"));

        assertEquals(0, grupo.getCantidadRecibidos());
        assertEquals(0, grupo.getCantidadEnviados());
    }

    @Test(expected = UsuarioNoExiste.class)
    public void getCantidadDeMensajesNoMiembro() {
        Grupo grupo = new Grupo("Grupo1");

        grupo.getCantidadDeMensajes("Klaus");
    }
}
