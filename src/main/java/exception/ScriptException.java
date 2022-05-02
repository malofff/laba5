package exception;

public class ScriptException extends RuntimeException{
    public ScriptException() {
        super("error in script");
    }
}
