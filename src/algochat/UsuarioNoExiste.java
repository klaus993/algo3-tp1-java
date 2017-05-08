package algochat;

/**
 * Created by klaus on 5/5/17.
 */

public class UsuarioNoExiste extends Exception
{
    //Parameterless Constructor
    public UsuarioNoExiste() {}

    //Constructor that accepts a message
    public UsuarioNoExiste(String message)
    {
        super(message);
    }
}