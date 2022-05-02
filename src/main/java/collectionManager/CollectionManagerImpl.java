package collectionManager;

import model.HumanBeing;
import model.WeaponType;

import java.time.LocalDate;
import java.util.Vector;

/**
 * класс, который хранит коллекцию и совершает опреации с ней
 */

public final class CollectionManagerImpl implements CollectionManager {
    private final Vector<HumanBeing> humanBeings;
    private final LocalDate creationDate;

    public CollectionManagerImpl() {
        humanBeings = new Vector<>();
        creationDate = LocalDate.now();
    }


    /**
     * добавить элемемент в коллекцию
     */
    @Override
    public void addElement(HumanBeing humanBeing) {
        humanBeings.addElement(humanBeing);
    }

    /**
     * очистить коллекцию
     */
    @Override
    public void clear() {
        humanBeings.clear();
    }

    /**
     * обновить элемент коллеции, имеющий определённый id
     *
     * @param id
     * @param humanBeing
     */
    @Override
    public void update(long id, HumanBeing humanBeing) {
        for (HumanBeing hb : humanBeings) {
            if (hb.getId() == id) {
                hb.setName(humanBeing.getName());
                hb.setCoordinates(humanBeing.getCoordinates());
                hb.setCreationDate(humanBeing.getCreationDate());
                hb.setHasToothpick(humanBeing.isHasToothpick());
                hb.setMood(humanBeing.getMood());
                hb.setCar(humanBeing.getCar());
                hb.setImpactSpeed(humanBeing.getImpactSpeed());
                hb.setWeaponType(humanBeing.getWeaponType());
                hb.setRealHero(humanBeing.isRealHero());
            }
        }

    }

    /**
     * метод, удаляющий элемент по id
     *
     * @param id
     */
    @Override
    public void removeById(long id) {
        humanBeings.removeIf(hb -> hb.getId() == id);
    }

    /**
     * удалить элемент, находящийся в заданной позиции коллекции
     *
     * @param index
     */
    @Override
    public void removeAtIndex(int index) {
        humanBeings.removeElementAt(index);

    }

    /**
     * удалить последний элемент из коллекции
     *
     * @param humanBeing
     */
    @Override
    public void removeLast(HumanBeing humanBeing) {
        humanBeings.removeElementAt(humanBeings.size() - 1);

    }

    /**
     * удалить элемент коллекции, если значение его ID меньше, чем заданный
     *
     * @param humanBeing
     */
    @Override
    public void removeLower(HumanBeing humanBeing) {
        for (HumanBeing hb : humanBeings) {
            if (hb.getId() < humanBeing.getId()) humanBeings.remove(hb);
        }

    }

    /**
     * удалить элемент коллекции, если его weaponType отличен от данного
     *
     * @param s
     */
    @Override
    public void removeAllByWeaponType(String s) {
        humanBeings.removeIf(hb -> s.equalsIgnoreCase(hb.getWeaponType().get()));

    }

    /**
     * вывести все элементы, значение поля car которых равно заданному
     *
     * @param humanBeing
     * @param args
     */
    @Override
    public void filterByCar(HumanBeing humanBeing, String[] args) {
        for (HumanBeing hb : humanBeings) {
            if (hb.getCar().getName().equals(args[1])) {
                System.out.println(hb.getId() + " " + hb.getName());
            }
        }
    }


    /**
     * вывод всей информации о коллекции
     */
    @Override
    public void info() {
        String info = "Collection initialisation time: " + getInitializationTime() + "\n" +
                "Elements count in collection: " + humanBeings.size() + "\n" +
                "Collection type: " + humanBeings.getClass().getSimpleName();
        System.out.println(info);

    }

    public LocalDate getInitializationTime() {
        return creationDate;
    }

    /**
     * вывести все элементы коллекции
     */
    @Override
    public void show() {
        for (HumanBeing hb : humanBeings) {
            System.out.println(hb);
        }
    }

    @Override
    public Vector<HumanBeing> getHumanBeings() {
        return humanBeings;
    }
}
