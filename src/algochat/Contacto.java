package algochat;

/**
 * Created by klaus on 2017-05/09 at 00:49.
 */
class Contacto {

    private String nombre;
    private ConversacionIndividual conversacion;
    private int cantidadEnviados;
    private int cantidadRecibidos;

    int getCantidadEnviados() {
        return cantidadEnviados;
    }

    int getCantidadRecibidos() {
        return cantidadRecibidos;
    }

    Contacto(String nombre) {
        this.nombre = nombre;
        this.cantidadEnviados = 0;
        this.cantidadRecibidos = 0;
        this.conversacion = null;
    }

    void borrarMensajes() {
        this.conversacion.borrarMensajes();
    }

    String getNombre() {
        return nombre;
    }

    void enviarMensaje(String mensaje) {
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
