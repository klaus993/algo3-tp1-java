package algochat;

/**
 * Created by klaus on 5/5/17.
 */
class ConversacionIndividual extends Conversacion {

    private String contacto;

    ConversacionIndividual(String nombreContacto) {
        super();
        this.contacto = nombreContacto;
    }

    String getContacto() {
        return contacto;
    }

    void recibirMensaje(String mensaje) {
        this.conversacion.add(0, this.contacto + ": " + mensaje);
    }
}
