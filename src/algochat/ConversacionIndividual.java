package algochat;

/**
 * Created by klaus on 5/5/17.
 */
public class ConversacionIndividual extends Conversacion {

    private String contacto;

    public ConversacionIndividual(String nombreContacto) {
        super();
        this.contacto = nombreContacto;
    }

    public String getContacto() {
        return contacto;
    }

    public void recibirMensaje(String mensaje) {
        this.conversacion.add(0, this.contacto + ": " + mensaje);
        this.cantidadRecibidos++;
    }

    @Override
    void reiniciarContadores() {
    }
}
