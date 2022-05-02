package command.commands;

import collectionManager.CollectionManager;
import model.HumanBeing;

public class RemoveLowerCommand extends Command{
     private final CollectionManager collectionManagerImpl;

     public RemoveLowerCommand(CollectionManager collectionManager){
         super("remove_lower",": remove all items smaller than the specified one from the collection");
         this.collectionManagerImpl = collectionManager;
     }

    @Override
    public void execute(HumanBeing humanBeing, String[] args) {
         collectionManagerImpl.removeLower(humanBeing);

    }

    @Override
    public boolean isHumanBeingRequired() {return false;}
}
