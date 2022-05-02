package exception;

/**
 * Проверяемое класс-исключения
 * Выбрасывается когда невозможно работать с файлом
 */
public class FileIsNotAvailableException extends Exception {
    public FileIsNotAvailableException(String message) {
        super(message);
    }
}
