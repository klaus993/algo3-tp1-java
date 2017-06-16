package algochat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klaus on 5/5/17.
 */
public class Conversacion {

    List<String> conversacion;
    int cantidadEnviados;
    int cantidadRecibidos;

    public Conversacion() {
        this.conversacion = new ArrayList<>();
        this.cantidadEnviados = 0;
        this.cantidadRecibidos = 0;
    }

    public int getCantidadEnviados() {
        return cantidadEnviados;
    }

    public int getCantidadRecibidos() {
        return cantidadRecibidos;
    }

    public void borrarMensajes() {
        this.cantidadEnviados = 0;
        this.cantidadRecibidos = 0;
        this.conversacion = new ArrayList<>();
        this.reiniciarContadores();
    }

    void reiniciarContadores() {}

    public void enviarMensaje(String mensaje) {
        this.conversacion.add(0, "Yo: " + mensaje);
        this.cantidadEnviados++;
    }

    AlgoConversacion obtenerConversacion() {
        return new AlgoConversacion(this);
    }

    public String get(int index) throws IndexOutOfBoundsException {
        if (index > this.cantidadEnviados + this.cantidadRecibidos) {
            throw new IndexOutOfBoundsException();
        }
        return this.conversacion.get(index - 1);
    }

    public void recibirMensaje(String nombreContacto, String mensaje) {
    }
}
