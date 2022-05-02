package command.commands;

import Comarator.SortByCarName;
import collectionManager.CollectionManager;
import collectionManager.CollectionManagerImpl;
import model.Car;
import model.HumanBeing;

import java.util.Collections;
import java.util.Vector;

public class PrintFieldDescendingCarCommand extends Command{
    private final CollectionManager collectionManager;


    public PrintFieldDescendingCarCommand(CollectionManager collectionManager){
        super("print_field_descending_car", ": output the values of the car field of all elements in descending order");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(HumanBeing humanBeing, String[] args) {
        Vector cars = new Vector();
        for (HumanBeing hb: collectionManager.getHumanBeings()){
            cars.addElement(hb.getCar());
        }
        Collections.sort(cars,new SortByCarName());
        System.out.println(cars);
    }

    @Override
    public boolean isHumanBeingRequired() {
        return super.isHumanBeingRequired();
    }
}
