package algochat;

/**
 * Created by klaus on 2017-05/09 at 00:49.
 */
public class Contacto {

    private String nombre;
    private ConversacionIndividual conversacion;
    private int cantidadEnviados;
    private int cantidadRecibidos;

    public int getCantidadEnviados() {
        return cantidadEnviados;
    }

    public int getCantidadRecibidos() {
        return cantidadRecibidos;
    }

    public Contacto(String nombre) {
        this.nombre = nombre;
        this.cantidadEnviados = 0;
        this.cantidadRecibidos = 0;
        this.conversacion = null;
    }

    void borrarMensajes() {
        this.conversacion.borrarMensajes();
    }

    public String getNombre() {
        return nombre;
    }

    public void enviarMensaje(String mensaje) {
        if (this.conversacion == null) {
            this.conversacion = new ConversacionIndividual(this.getNombre());
        }
        conversacion.enviarMensaje(mensaje);
    }

    public AlgoConversacion obtenerConversacion() {
        return this.conversacion.obtenerConversacion();
    }

    public void recibirMensaje(String mensaje) {
        if (this.conversacion == null) {
            this.conversacion = new ConversacionIndividual(this.getNombre());
        }
        this.conversacion.recibirMensaje(mensaje);
    }

    public void incrementarRecibidos() {
        this.cantidadRecibidos++;
    }
}
