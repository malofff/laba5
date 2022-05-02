package command.commands;

import collectionManager.CollectionManager;
import model.HumanBeing;

public class RemoveAllByWeaponTypeCommand extends Command{
     private final CollectionManager collectionManagerImpl;

     public RemoveAllByWeaponTypeCommand(CollectionManager collectionManager){
         super("remove_all_by_weapon_type",": remove from the collection all items whose"  +
                 " value of the weapon Type field is equivalent to the specified");
         this.collectionManagerImpl = collectionManager;
     }

    @Override
    public void execute(HumanBeing humanBeing, String[] args) {
         collectionManagerImpl.removeAllByWeaponType(args[1]);
    }

    @Override
    public boolean isHumanBeingRequired() {
        return false;
    }
}
