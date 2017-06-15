package exceptions;

/**
 * Created by klaus on 5/5/17.
 */

public class GrupoNoExiste extends RuntimeException
{
    //Parameterless Constructor
    public GrupoNoExiste() {}

    //Constructor that accepts a message
    public GrupoNoExiste(String message)
    {
        super(message);
    }
}
