package exception;

/**
 * Выбрасывается если команда с аргументом или без
 */
public class InvalidCommandType extends RuntimeException{
    public InvalidCommandType(String message){
        super(message);
        }
}
