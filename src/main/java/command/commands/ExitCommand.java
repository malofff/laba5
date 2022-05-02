package command.commands;

import Application.Application;
import model.HumanBeing;

public class ExitCommand extends Command{
    private final Application application;

    public ExitCommand(Application application){
        super("exit",": terminate the program (without saving to a file)");
        this.application = application;
    }

    @Override
    public void execute(HumanBeing humanBeing, String[] args) {
        application.exit();
    }

    @Override
    public boolean isHumanBeingRequired() {
        return super.isHumanBeingRequired();
    }
}
