package algochat;

import exceptions.UsuarioNoExiste;
import exceptions.UsuarioYaExiste;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * Created by klaus on 5/5/17.
 */
public class Grupo {

    private String nombre;
    private Map<String, Contacto> miembros;
    private ConversacionGrupal conversacion;
    private int cantidadMiembros;

    public Grupo(String nombre) {
        this.nombre = nombre;
        this.miembros = new HashMap<>();
        this.cantidadMiembros = 1;
        this.conversacion = new ConversacionGrupal();
    }

    public void agregarMiembro(Contacto miembro) throws UsuarioYaExiste {
        if(this.existeMiembro(miembro.getNombre())) {
            throw new UsuarioYaExiste();
        }
        this.miembros.put(miembro.getNombre(), miembro);
        this.cantidadMiembros++;
    }

    public boolean existeMiembro(String nombre) {
        return this.miembros.containsKey(nombre);
    }

    public void enviarMensaje(String mensaje) {
        this.conversacion.enviarMensaje(mensaje);
    }

    public int getCantidadDeMensajes(String nombreMiembro) throws UsuarioNoExiste {
        if(!this.existeMiembro(nombreMiembro)) {
            throw new UsuarioNoExiste();
        }
        return this.conversacion.getCantidadDeMensajes(nombreMiembro);
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadMiembros() {
        return cantidadMiembros;
    }

    public int getCantidadEnviados() {
        return this.conversacion.getCantidadEnviados();
    }

    public int getCantidadRecibidos() {
        return this.conversacion.getCantidadRecibidos();
    }

    public AlgoConversacion obtenerConversacion() {
        return this.conversacion.obtenerConversacion();
    }

    public void recibirMensaje(String nombreContacto, String mensaje) throws UsuarioNoExiste {
        if (!this.existeMiembro(nombreContacto)) {
            throw new UsuarioNoExiste();
        }
        this.conversacion.recibirMensaje(nombreContacto, mensaje);
        this.miembros.get(nombreContacto).incrementarRecibidos();
    }

    public void borrarMensajes() {
        for (Map.Entry<String, Contacto> entry : this.miembros.entrySet()) {
            if (this.conversacion.contieneMensajesDe(entry.getKey())) {
                entry.getValue().disminuirRecibidos(this.conversacion.getCantidadDeMensajes(entry.getKey()));
            }
        }
        this.conversacion.borrarMensajes();
    }
}
