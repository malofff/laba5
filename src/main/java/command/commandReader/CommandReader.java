package command.commandReader;

import command.commands.Command;
import exception.CommandIsNotExistException;
import exception.FileIsNotAvailableException;
import exception.InvalidFieldException;
import model.HumanBeing;

import java.util.HashMap;

public interface CommandReader {
    void addCommandToMap(String commandName, Command command);


    void executeCommand(String userCommand, HumanBeing studyGroup) throws InvalidFieldException, CommandIsNotExistException, FileIsNotAvailableException;

    HashMap<String, Command> getCommandMap();

    Command getCommandByName(String commandName);
}
