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

    private boolean existeContacto(String nombreContacto) {
        return this.contactos.containsKey(nombreContacto);
    }

    private boolean existeGrupo(String nombreGrupo) {
        return this.grupos.containsKey(nombreGrupo);
    }

    public int getCantidadDeChatsIndividuales() {
        return cantidadDeChatsIndividuales;
    }

    public int getCantidadDeContactos() {
        return cantidadDeContactos;
    }

    public int getCantidadDeChatsGrupales() {
        return cantidadDeChatsGrupales;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public int getCantidadDeGrupos() {
        return cantidadDeGrupos;
    }

    public int getCantidadDeMensajesEnviados() {
        return cantidadDeMensajesEnviados;
    }

    public int getCantidadTotalMensajesRecibidos() {
        return cantidadTotalMensajesRecibidos;
    }

    public int getCantidadMensajesDe(String contacto) throws UsuarioNoExiste {
        if (!this.existeContacto(contacto)) {
            throw new UsuarioNoExiste();
        }
        return contactos.get(contacto).getCantidadRecibidos();
    }

    public int getCantidadMensajesEnviadosA(String contacto) throws UsuarioNoExiste {
        if (!this.existeContacto(contacto)) {
            throw new UsuarioNoExiste();
        }
        return contactos.get(contacto).getCantidadEnviados();
    }

    public int getCantidadMensajesEnviadosAlGrupo(String grupo) throws GrupoNoExiste {
        if (!existeGrupo(grupo)) {
            throw new GrupoNoExiste();
        }
        return grupos.get(grupo).getCantidadEnviados();
    }

    public int getCantidadMensajesRecibidosDelGrupo(String grupo) throws GrupoNoExiste {
        if (!existeGrupo(grupo)) {
            throw new GrupoNoExiste();
        }
        return this.grupos.get(grupo).getCantidadRecibidos();
    }

    public int getCantidadMiembrosEnGrupo(String grupo) throws GrupoNoExiste {
        if (!existeGrupo(grupo)) {
            throw new GrupoNoExiste();
        }
        return this.grupos.get(grupo).getCantidadMiembros();
    }

    public void agregarContacto(String nombreContacto) throws UsuarioYaExiste {
        if (this.existeContacto(nombreContacto)) {
            throw new UsuarioYaExiste();
        }
        this.contactos.put(nombreContacto, new Contacto(nombreContacto));
        this.cantidadDeContactos++;
    }

    public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo) throws UsuarioNoExiste, GrupoNoExiste, UsuarioYaExiste {
        if (!this.existeContacto(nombreContacto)) {
            throw new UsuarioNoExiste();
        }
        if (!this.existeGrupo(nombreGrupo)) {
            throw new GrupoNoExiste();
        }
        this.grupos.get(nombreGrupo).agregarMiembro(this.contactos.get(nombreContacto));
    }

    private void borrarMensajesDeContacto(String nombreContacto) throws UsuarioNoExiste {
        if (!this.existeContacto(nombreContacto)) {
            throw new UsuarioNoExiste();
        }
        this.cantidadTotalMensajesRecibidos -= this.contactos.get(nombreContacto).getCantidadRecibidos();
        cantidadDeMensajesEnviados -= this.contactos.get(nombreContacto).getCantidadEnviados();
        this.contactos.get(nombreContacto).borrarMensajes();
    }

    private void borrarMensajesDeGupo(String nombreGrupo) throws GrupoNoExiste {
        if (!this.existeGrupo(nombreGrupo)) {
            throw new GrupoNoExiste();
        }
        this.cantidadDeMensajesEnviados -= this.grupos.get(nombreGrupo).getCantidadEnviados();
    }

    public void crearGrupo(String nombreGrupo) throws GrupoYaExiste {
        if (this.existeGrupo(nombreGrupo)) {
            throw new GrupoYaExiste();
        }
        this.grupos.put(nombreGrupo, new Grupo(nombreGrupo));
        this.cantidadDeGrupos++;
    }

    public void enviarMensajeAContacto(String contacto, String mensaje) throws UsuarioNoExiste {
        if (!this.existeContacto(contacto)) {
            throw new UsuarioNoExiste();
        }
        this.contactos.get(contacto).enviarMensaje(mensaje);
    }

    public void enviarMensajeAGrupo(String grupo, String mensaje) throws GrupoNoExiste {
        if (!this.existeGrupo(grupo)) {
            throw new GrupoNoExiste();
        }
        this.grupos.get(grupo).enviarMensaje(mensaje);
        this.cantidadDeMensajesEnviados++;
    }

    public AlgoConversacion obtenerConversacionConContacto(String nombreContacto) throws UsuarioNoExiste {
        if (!this.existeContacto(nombreContacto)) {
            throw new UsuarioNoExiste();
        }
        return this.contactos.get(nombreContacto).obtenerConversacion();
    }

    public AlgoConversacion obtenerConversacionConGrupo(String nombreGrupo) throws GrupoNoExiste {
        if (!this.existeGrupo(nombreGrupo)) {
            throw new GrupoNoExiste();
        }
        return this.grupos.get(nombreGrupo).obtenerConversacion();
    }

    public void recibirMensajeDeContacto(String nombreContacto, String mensaje) throws UsuarioNoExiste {
        if (!this.existeContacto(nombreContacto)) {
            throw new UsuarioNoExiste();
        }
        this.contactos.get(nombreContacto).recibirMensaje(mensaje);
        this.cantidadTotalMensajesRecibidos++;
    }

    public void recibirMensajeDeGrupo(String nombreGrupo, String nombreContacto, String mensaje) throws GrupoNoExiste, UsuarioNoExiste {
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
