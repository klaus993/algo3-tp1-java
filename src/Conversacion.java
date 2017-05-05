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
}
