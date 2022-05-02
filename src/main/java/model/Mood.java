package model;


public enum Mood {
    SADNESS("SADNESS"),
    SORROW("SORROW"),
    APATHY("APATHY"),
    RAGE("RAGE");

    private final String name;

    Mood(String name) {
        this.name = name;
    }

    public String get() {
        return name;
    }
}
