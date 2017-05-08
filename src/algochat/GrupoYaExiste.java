package algochat;

/**
 * Created by klaus on 5/5/17.
 */

public class GrupoYaExiste extends Exception
{
    //Parameterless Constructor
    public GrupoYaExiste() {}

    //Constructor that accepts a message
    public GrupoYaExiste(String message)
    {
        super(message);
    }
}
