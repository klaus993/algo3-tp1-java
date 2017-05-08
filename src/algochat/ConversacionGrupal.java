package algochat;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by klaus on 5/5/17.
 */
public class ConversacionGrupal extends Conversacion {

    private Map<String, Integer> cantidades;

    public ConversacionGrupal() {
        super();
        this.cantidades = new HashMap<>();
    }

    @Override
    private void reiniciarContadores() {
        for (Map.Entry<String, Integer> entry : this.cantidades.entrySet()) {
            this.cantidades.put(entry.getKey(), 0);
        }
    }

    @Override
    public int getCantidadDeMensajes(String nombreMiembro) {
        if(this.cantidades.containsKey(nombreMiembro)) {
            return cantidades.get(nombreMiembro);
        }
        return 0;
    }
}
