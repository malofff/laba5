package command.commands;

import collectionManager.CollectionManager;
import command.commandReader.CommandReader;
import model.HumanBeing;

public class InfoCommand extends Command{
    private final CollectionManager collectionManagerImpl;

    public InfoCommand(CollectionManager collectionManager){
        super("info", ": output information about the  collection to the standard output stream" +
                "(type, initialization date, number of elements, etc.)");
        this.collectionManagerImpl = collectionManager;
    }

    @Override
    public void execute(HumanBeing humanBeing, String[] args) {
        collectionManagerImpl.info();
    }

    @Override
    public boolean isHumanBeingRequired() {
        return super.isHumanBeingRequired();
    }
}
