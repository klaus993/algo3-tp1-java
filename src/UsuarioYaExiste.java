/**
 * Created by klaus on 5/5/17.
 */

public class UsuarioYaExiste extends Exception
{
    //Parameterless Constructor
    public UsuarioYaExiste() {}

    //Constructor that accepts a message
    public UsuarioYaExiste(String message)
    {
        super(message);
    }
}