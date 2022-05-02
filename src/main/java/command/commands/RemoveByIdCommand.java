package command.commands;

import collectionManager.CollectionManager;
import model.HumanBeing;

public class RemoveByIdCommand extends Command{
    private final CollectionManager collectionManagerImpl;

    public RemoveByIdCommand(CollectionManager collectionManagerImpl) {
        super("remove_by_id",": remove element by its id");
        this.collectionManagerImpl = collectionManagerImpl;
    }


    @Override
    public void execute(HumanBeing humanBeing, String[] args) {
        long id = Long.parseLong(args[1]);
        collectionManagerImpl.removeById(id);

    }

    @Override
    public boolean isHumanBeingRequired() {
        return false;
    }
}
