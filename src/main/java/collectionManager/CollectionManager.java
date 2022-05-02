package collectionManager;

import model.HumanBeing;
import model.WeaponType;

import java.util.Vector;


public interface CollectionManager {
    void addElement(HumanBeing humanBeing);

    void clear();

    void update(long id,HumanBeing humanBeing);

    void removeById(long id);

    void removeAtIndex(int index);

    void removeLast(HumanBeing humanBeing);

    void removeLower(HumanBeing humanBeing);

    void removeAllByWeaponType(String s);

    void info();

    void show();

    void filterByCar(HumanBeing humanBeing, String[] args);

    Vector<HumanBeing> getHumanBeings();
}
