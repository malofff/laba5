package command.commands;

import exception.FileIsNotAvailableException;
import lombok.Getter;
import model.HumanBeing;

@Getter

public abstract class Command {
    private final String name;//название команды
    private final String description;//описание команды


    protected Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract void execute(HumanBeing humanBeing, String[] args) throws FileIsNotAvailableException;


    public boolean isHumanBeingRequired(){
        return false;
    }
}
