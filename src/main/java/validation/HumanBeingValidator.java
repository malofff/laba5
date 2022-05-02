package validation;

import exception.InvalidFieldException;
import model.Car;
import model.Mood;
import model.WeaponType;

public interface HumanBeingValidator {
    void validateId(long id) throws InvalidFieldException;

    void validateName(String name) throws InvalidFieldException;

    void validateCoordinateX(Long x) throws InvalidFieldException;

    void validateCoordinateY(Long y) throws InvalidFieldException;

    void validateWeaponType(WeaponType weaponType) throws InvalidFieldException;

    void validateMood(Mood mood) throws InvalidFieldException;

    void validateRealHero(String s)throws InvalidFieldException;

    void validateHasToothpick(String s) throws InvalidFieldException;
}

