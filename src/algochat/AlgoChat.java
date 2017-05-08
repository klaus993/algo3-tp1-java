package algochat;

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

    public void agregarContacto(String nombreContacto) throws UsuarioYaExiste {
        if (this.existeContacto(nombreContacto)) {
            throw new UsuarioYaExiste();
        }
        this.contactos.put(nombreContacto, new Contacto(nombreContacto));
        this.cantidadDeContactos++;
    }

    public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo) throws UsuarioNoExiste, GrupoNoExiste{
        if (!this.existeContacto(nombreContacto)) {
            throw new UsuarioNoExiste();
        }
        if (!this.existeGrupo(nombreGrupo)) {
            throw new GrupoNoExiste();
        }
        this.grupos.get(nombreGrupo).agregarMiembro(nombreContacto);
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
        if(!this.existeGrupo(nombreGrupo)) {
            throw new GrupoNoExiste();
        }
        this.cantidadDeMensajesEnviados -= this.grupos.get(nombreGrupo).getCantidadEnviados();
    }

    @Override
    public String toString() {
        return "Chat de " + this.nombreUsuario;
    }
}
