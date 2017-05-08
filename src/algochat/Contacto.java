package algochat;

/**
 * Created by klaus on 5/5/17.
 */
public class Contacto {

    private String nombre;
    private Conversacion conversacion;
    private int cantidadEnviados;
    private int cantidadRecibidos;

    public int getCantidadEnviados() {
        return cantidadEnviados;
    }

    public int getCantidadRecibidos() {
        return cantidadRecibidos;
    }

    public Contacto(String nombreContacto) {
    }

    protected void borrarMensajes() {
        this.conversacion.borrarMensajes();
    }

    public String getNombre() {
        return nombre;
    }
}
