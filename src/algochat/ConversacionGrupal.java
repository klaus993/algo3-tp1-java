package algochat;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by klaus on 5/5/17.
 */
class ConversacionGrupal extends Conversacion {

    private Map<String, Integer> cantidades;

    public ConversacionGrupal() {
        super();
        this.cantidades = new HashMap<>();
    }

    @Override
    void reiniciarContadores() {
        for (Map.Entry<String, Integer> entry : this.cantidades.entrySet()) {
            this.cantidades.put(entry.getKey(), 0);
        }
    }

    int getCantidadDeMensajes(String nombreMiembro) {
        if(this.cantidades.containsKey(nombreMiembro)) {
            return cantidades.get(nombreMiembro);
        }
        return 0;
    }

    @Override
    public void recibirMensaje(String nombreContacto, String mensaje) {
        this.conversacion.add(0, nombreContacto + ": " + mensaje);
        if (!this.cantidades.containsKey(nombreContacto)) {
            this.cantidades.put(nombreContacto, 0);
        }
        this.cantidades.put(nombreContacto, this.cantidades.get(nombreContacto) + 1);
        this.cantidadRecibidos++;
    }
}
