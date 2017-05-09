package algochat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klaus on 5/5/17.
 */
class Conversacion {

    List<String> conversacion;
    int cantidadEnviados;
    int cantidadRecibidos;

    Conversacion() {
        this.conversacion = new ArrayList<>();
        this.cantidadEnviados = 0;
        this.cantidadRecibidos = 0;
    }

    int getCantidadEnviados() {
        return cantidadEnviados;
    }

    int getCantidadRecibidos() {
        return cantidadRecibidos;
    }

    void borrarMensajes() {
        this.cantidadEnviados = 0;
        this.cantidadRecibidos = 0;
        this.conversacion = new ArrayList<>();
        this.reiniciarContadores();
    }

    void reiniciarContadores() {}

    void enviarMensaje(String mensaje) {
        this.conversacion.add(0, mensaje);
        this.cantidadEnviados++;
    }

    AlgoConversacion obtenerConversacion() {
        return new AlgoConversacion(this);
    }

    String get(int index) throws IndexOutOfBoundsException {
        if (index >= this.cantidadEnviados + this.cantidadRecibidos) {
            throw new IndexOutOfBoundsException();
        }
        return this.conversacion.get(index);
    }

    public void recibirMensaje(String nombreContacto, String mensaje) {
    }
}
