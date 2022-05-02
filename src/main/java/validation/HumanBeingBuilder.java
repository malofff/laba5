package validation;

import exception.InvalidFieldException;
import model.Car;
import model.HumanBeing;
import model.Mood;
import model.WeaponType;

import java.time.LocalDate;


public interface HumanBeingBuilder {

    void setId(long id);

    void setIdRandom(long id);

    void setName(String name) throws InvalidFieldException;

    void setCoordinateX(long x) throws InvalidFieldException;

    void setCoordinateY(long y) throws InvalidFieldException;

    void setCreationDate(LocalDate creationDate);

    void setImpactSpeed(int ImpactSpeed) throws InvalidFieldException;

    void setWeaponType(WeaponType weaponType) throws InvalidFieldException;

    void setMood(Mood mood) throws InvalidFieldException;

    void setCar(Car car);

    void setRealHero(String s) throws InvalidFieldException;

    void setHasToothpick(String s) throws InvalidFieldException;

    void askHumanBeing() throws InvalidFieldException;

    HumanBeing getHumanBeing();
}
