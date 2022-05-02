package Comarator;

import model.Car;

import java.util.Comparator;

public class SortByCarName implements Comparator<Car> {
    @Override
    public int compare(Car a, Car b) {
        return a.getName().compareToIgnoreCase(b.getName());
    }
}
