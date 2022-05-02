package model;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
public class HumanBeing {
    protected long id = -1; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private boolean realHero;
    private boolean hasToothpick;
    private int impactSpeed;
    private WeaponType weaponType; //Поле не может быть null
    private Mood mood; //Поле не может быть null
    private Car car; //Поле может быть null

    public HumanBeing(long id,String name, Coordinates coordinates, boolean realHero, boolean hasToothpick, int impactSpeed, WeaponType weaponType, Mood mood, Car car) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDate.now();
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.weaponType = weaponType;
        this.mood = mood;
        this.car = car;
    }
}
