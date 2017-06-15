package algochat;

import exceptions.GrupoNoExiste;
import exceptions.GrupoYaExiste;
import exceptions.UsuarioNoExiste;
import exceptions.UsuarioYaExiste;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by klaus on 5/5/17.
 */
public class AlgoChat {

    private Map<String, Contacto> contactos;
    private Map<String, Grupo> grupos;
    private int cantidadDeChatsIndividuales;
    private int cantidadDeContactos;
    private int cantidadDeChatsGrupales;
    private int cantidadDeGrupos;
    private int cantidadDeMensajesEnviados;
    private int cantidadTotalMensajesRecibidos;
    private String nombreUsuario;

    public AlgoChat (String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contactos = new HashMap<>();
        this.grupos = new HashMap<>();
        this.cantidadDeChatsGrupales = 0;
        this.cantidadDeChatsIndividuales = 0;
        this.cantidadDeContactos = 0;
        this.cantidadDeGrupos = 0;
        this.cantidadDeMensajesEnviados = 0;
        this.cantidadTotalMensajesRecibidos = 0;
    }

    public boolean existeContacto(String nombreContacto) {
        return this.contactos.containsKey(nombreContacto);
    }

    public boolean existeGrupo(String nombreGrupo) {
        return this.grupos.containsKey(nombreGrupo);
    }

    public int cantidadDeChatsIndividuales() {
        return cantidadDeChatsIndividuales;
    }

    public int cantidadDeContactos() {
        return cantidadDeContactos;
    }

    public int cantidadDeChatsGrupales() {
        return cantidadDeChatsGrupales;
    }

    public String nombreUsuario() {
        return nombreUsuario;
    }

    public int cantidadDeGrupos() {
        return cantidadDeGrupos;
    }

    public int cantidadDeMensajesEnviados() {
        return cantidadDeMensajesEnviados;
    }

    public int cantidadTotalMensajesEnviados() {
        return cantidadDeMensajesEnviados;
    }

    public int cantidadTotalMensajesRecibidos() {
        return cantidadTotalMensajesRecibidos;
    }

    public int cantidadMensajesDe(String contacto) {
        if (!this.existeContacto(contacto)) {
            throw new UsuarioNoExiste();
        }
        return contactos.get(contacto).getCantidadRecibidos();
    }

    public int cantidadMensajesEnviadosA(String contacto) {
        if (!this.existeContacto(contacto)) {
            throw new UsuarioNoExiste();
        }
        return contactos.get(contacto).getCantidadEnviados();
    }

    public int cantidadMensajesEnviadosAlGrupo(String grupo) {
        if (!existeGrupo(grupo)) {
            throw new GrupoNoExiste();
        }
        return grupos.get(grupo).getCantidadEnviados();
    }

    public int cantidadMensajesRecibidosDelGrupo(String grupo) {
        if (!existeGrupo(grupo)) {
            throw new GrupoNoExiste();
        }
        return this.grupos.get(grupo).getCantidadRecibidos();
    }

    public int cantidadMiembrosEnGrupo(String grupo) {
        if (!existeGrupo(grupo)) {
            throw new GrupoNoExiste();
        }
        return this.grupos.get(grupo).getCantidadMiembros();
    }

    public void agregarContacto(String nombreContacto) {
        if (this.existeContacto(nombreContacto)) {
            throw new UsuarioYaExiste();
        }
        this.contactos.put(nombreContacto, new Contacto(nombreContacto));
        this.cantidadDeContactos++;
    }

    public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo) {
        if (!this.existeContacto(nombreContacto)) {
            throw new UsuarioNoExiste();
        }
        if (!this.existeGrupo(nombreGrupo)) {
            throw new GrupoNoExiste();
        }
        this.grupos.get(nombreGrupo).agregarMiembro(this.contactos.get(nombreContacto));
    }

    public void borrarMensajesDelContacto(String nombreContacto) {
        if (!this.existeContacto(nombreContacto)) {
            throw new UsuarioNoExiste();
        }
        this.cantidadTotalMensajesRecibidos -= this.contactos.get(nombreContacto).getCantidadRecibidos();
        cantidadDeMensajesEnviados -= this.contactos.get(nombreContacto).getCantidadEnviados();
        this.contactos.get(nombreContacto).borrarMensajes();
    }

    public void borrarMensajesDelGrupo(String nombreGrupo)  {
        if (!this.existeGrupo(nombreGrupo)) {
            throw new GrupoNoExiste();
        }
        this.cantidadDeMensajesEnviados -= this.grupos.get(nombreGrupo).getCantidadEnviados();
    }

    public void crearGrupo(String nombreGrupo) {
        if (this.existeGrupo(nombreGrupo)) {
            throw new GrupoYaExiste();
        }
        this.grupos.put(nombreGrupo, new Grupo(nombreGrupo));
        this.cantidadDeGrupos++;
    }

    public void enviarMensajeA(String contacto, String mensaje) {
        if (!this.existeContacto(contacto)) {
            throw new UsuarioNoExiste();
        }
        this.contactos.get(contacto).enviarMensaje(mensaje);
    }

    public void enviarMensajeAGrupo(String grupo, String mensaje) {
        if (!this.existeGrupo(grupo)) {
            throw new GrupoNoExiste();
        }
        this.grupos.get(grupo).enviarMensaje(mensaje);
        this.cantidadDeMensajesEnviados++;
    }

    public AlgoConversacion obtenerConversacionCon(String nombreContacto) {
        if (!this.existeContacto(nombreContacto)) {
            throw new UsuarioNoExiste();
        }
        return this.contactos.get(nombreContacto).obtenerConversacion();
    }

    public AlgoConversacion obtenerConversacionConGrupo(String nombreGrupo) {
        if (!this.existeGrupo(nombreGrupo)) {
            throw new GrupoNoExiste();
        }
        return this.grupos.get(nombreGrupo).obtenerConversacion();
    }

    public void recibirMensajeDe(String nombreContacto, String mensaje) {
        if (!this.existeContacto(nombreContacto)) {
            throw new UsuarioNoExiste();
        }
        this.contactos.get(nombreContacto).recibirMensaje(mensaje);
        this.cantidadTotalMensajesRecibidos++;
    }

    public void recibirMensajeDeGrupo(String nombreGrupo, String nombreContacto, String mensaje) {
        if (!this.existeGrupo(nombreGrupo)) {
            throw new GrupoNoExiste();
        }
        this.grupos.get(nombreGrupo).recibirMensaje(nombreContacto, mensaje);
        this.cantidadTotalMensajesRecibidos++;
    }

    @Override
    public String toString() {
        return "Chat de " + this.nombreUsuario;
    }
}
