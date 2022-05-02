package command.commands;

import collectionManager.CollectionManager;
import model.HumanBeing;

public class UpdateCommand extends Command{
    private final CollectionManager collectionManagerImpl;

    public UpdateCommand(CollectionManager collectionManager) {
        super("update id", ": update the value of a collection item whose id is equal to the specified one");
        this.collectionManagerImpl = collectionManager;
    }

    @Override
    public void execute(HumanBeing humanBeing, String[] args) {
        long id = Long.parseLong(args[1]);
        collectionManagerImpl.update(id,humanBeing);
    }

    @Override
    public boolean isHumanBeingRequired() {return true;}
}
