package exceptions;

/**
 * Created by klaus on 5/5/17.
 */

public class UsuarioNoExiste extends RuntimeException
{
    //Parameterless Constructor
    public UsuarioNoExiste() {}

    //Constructor that accepts a message
    public UsuarioNoExiste(String message)
    {
        super(message);
    }
}