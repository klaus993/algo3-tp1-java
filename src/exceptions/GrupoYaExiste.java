package exceptions;

/**
 * Created by klaus on 5/5/17.
 */

public class GrupoYaExiste extends RuntimeException
{
    //Parameterless Constructor
    public GrupoYaExiste() {}

    //Constructor that accepts a message
    public GrupoYaExiste(String message)
    {
        super(message);
    }
}
