package model;

public enum WeaponType {
    SHOTGUN("SHOTGUN"),
    KNIFE("KNIFE"),
    BAT("BAT");

    private final String name;

    WeaponType(String name) {
        this.name = name;
    }

    public String get() {
        return name;
    }
}
