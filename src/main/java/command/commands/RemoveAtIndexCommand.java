package command.commands;

import collectionManager.CollectionManager;
import model.HumanBeing;

public class RemoveAtIndexCommand extends Command{
    private final CollectionManager collectionManagerImpl;

    public RemoveAtIndexCommand(CollectionManager collectionManagerImpl) {
        super("remove_at",": remove collection element by its index");
        this.collectionManagerImpl = collectionManagerImpl;
    }

    @Override
    public void execute(HumanBeing humanBeing, String[] args) {
        int index = Integer.parseInt(args[1]);
        collectionManagerImpl.removeAtIndex(index);
    }

    @Override
    public boolean isHumanBeingRequired() {
        return false;
    }
}
