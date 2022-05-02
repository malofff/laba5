package command.commands;

import collectionManager.CollectionManager;
import model.HumanBeing;


public class ShowCommand extends Command {
    private final CollectionManager collectionManagerImpl;

    public ShowCommand(CollectionManager collectionManager) {
        super("show",": show all elements in string representation");
        this.collectionManagerImpl = collectionManager;
    }

    @Override
    public boolean isHumanBeingRequired() {
        return false;
    }

    @Override
    public void execute(HumanBeing humanBeing, String[] args) {collectionManagerImpl.show();}
}
