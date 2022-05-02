package exception;

/**
 * Проверяемый класс-исключения
 * Выбрасывается, когда данные в файле не соответствуют формату или не могут быть распаршены
 */
public class BrokenDataException extends Exception{
    public BrokenDataException() {
        super("Файл не соответствует формату или данные не могут быть распаршены");
    }
}
