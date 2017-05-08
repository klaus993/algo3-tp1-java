package algochat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klaus on 5/5/17.
 */
public class Conversacion {

    private List<String> conversacion;
    private int cantidadEnviados;
    private int cantidadRecibidos;

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

    protected void reiniciarContadores() {}

    public void enviarMensaje(String mensaje) {
        this.conversacion.addAll(0, mensaje);
        this.cantidadEnviados++;
    }

    public int getCantidadDeMensajes(String nombreMiembro) {
    }
}
