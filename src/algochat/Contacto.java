package algochat;

/**
 * Created by klaus on 2017-05/09 at 00:49.
 */
public class Contacto {

    private String nombre;
    private ConversacionIndividual conversacion;
    private int cantidadEnviadosGrupo;
    private int cantidadRecibidosGrupo;

    public int getCantidadEnviados() {
        return cantidadEnviadosGrupo + conversacion.getCantidadEnviados();
    }

    public int getCantidadRecibidos() {
        return this.cantidadRecibidosGrupo + this.conversacion.getCantidadRecibidos();
    }

    public Contacto(String nombre) {
        this.nombre = nombre;
        this.cantidadEnviadosGrupo = 0;
        this.cantidadRecibidosGrupo = 0;
        this.conversacion = new ConversacionIndividual(this.getNombre());
    }

    void borrarMensajes() {
        this.conversacion.borrarMensajes();
    }

    public String getNombre() {
        return nombre;
    }

    public void enviarMensaje(String mensaje) {
        conversacion.enviarMensaje(mensaje);
    }

    public AlgoConversacion obtenerConversacion() {
        return this.conversacion.obtenerConversacion();
    }

    public void recibirMensaje(String mensaje) {
        this.conversacion.recibirMensaje(mensaje);
    }

    public void incrementarRecibidos() {
        this.cantidadRecibidosGrupo++;
    }

    public void disminuirRecibidos(int n) {
        this.cantidadRecibidosGrupo -= n;
    }
}
