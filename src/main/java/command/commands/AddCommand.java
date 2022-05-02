package command.commands;

import collectionManager.CollectionManager;
import model.HumanBeing;




public class AddCommand extends Command {
    private final CollectionManager collectionManagerImpl;

    public AddCommand(CollectionManager collectionManager) {
        super("add", ": add new element to collection");
        this.collectionManagerImpl = collectionManager;
    }


    @Override
    public void execute(HumanBeing humanBeing, String[] args) {
        collectionManagerImpl.addElement(humanBeing);
    }

    @Override
    public boolean isHumanBeingRequired() {
        return true;
    }
}
