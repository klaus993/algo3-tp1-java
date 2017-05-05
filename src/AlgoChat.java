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
        this.grupos = HashMap<>();
        this.cantidadDeChatsGrupales = 0;
        this.cantidadDeChatsIndividuales = 0;
        this.cantidadDeContactos = 0;
        this.cantidadDeGrupos = 0;
        this.cantidadDeMensajesEnviados = 0;
        this.cantidadTotalMensajesRecibidos = 0;
    }

    public void agregarContacto(String nombreContacto) throws UsuarioYaExiste {
        if (this.existeContacto(nombreContacto)) {
            throw new UsuarioYaExiste();
        }
        contactos[nombreContacto] = new Contacto(nombreContacto);
        cantidadDeContactos++;
    }

    public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo) {
        
    }
}
