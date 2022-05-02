package command.commands;

import collectionManager.CollectionManager;
import model.HumanBeing;


public class ClearCommand extends Command {
    public final CollectionManager collectionManagerImpl;

    public ClearCommand(CollectionManager collectionManagerImpl){
        super("clear", ": clear collection");
        this.collectionManagerImpl = collectionManagerImpl;
    }

    @Override
    public void execute(HumanBeing humanBeing, String[] args) {
        collectionManagerImpl.clear();
    }

    @Override
    public boolean isHumanBeingRequired() {
        return false;
    }
}
