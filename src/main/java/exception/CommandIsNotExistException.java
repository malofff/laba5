package exception;

/**
 * Если введенная пользователем команда не сущестует
 */
public class CommandIsNotExistException extends Exception{
    public CommandIsNotExistException(String message) {
        super(message);
    }
}
