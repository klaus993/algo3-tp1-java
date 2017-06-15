package algochat;

/**
 * Created by klaus on 5/5/17.
 */
public class AlgoConversacion {

    private Conversacion conversacion;

    AlgoConversacion(Conversacion conversacion) {
        this.conversacion = conversacion;
    }

    public int getCantidadEnviados() {
        return this.conversacion.getCantidadEnviados();
    }

    public int getCantidadRecibidos() {
        return this.conversacion.getCantidadRecibidos();
    }

    public String get(int index) {
        return this.conversacion.get(index - 1);
    }
}
