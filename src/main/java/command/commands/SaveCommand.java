package command.commands;

import Application.Application;
import collectionManager.CollectionManager;
import exception.FileIsNotAvailableException;
import model.HumanBeing;

public class SaveCommand extends Command{
    private final Application application;

    public SaveCommand(Application application){
        super("save",": save collection to file");
        this.application = application;
    }

    @Override
    public void execute(HumanBeing humanBeing, String[] args) throws FileIsNotAvailableException {
        application.save();
    }

    @Override
    public boolean isHumanBeingRequired() {
        return false;
    }
}
