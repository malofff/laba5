package command.commandReader;

import command.commands.Command;
import exception.CommandIsNotExistException;
import exception.FileIsNotAvailableException;
import model.HumanBeing;

import java.util.HashMap;

public class CommandReaderImpl implements CommandReader {
    private final HashMap<String, Command> commandMap;

    public CommandReaderImpl() {
        commandMap = new HashMap<>();
    }

    /**
     * метод, обеспечиывающий добавление команды в commandMap
     *
     * @param commandName имя команды
     * @param command исполняемая команда
     */
    @Override
    public void addCommandToMap(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    /**
     * метод, обеспечивающий чтение команды в строке
     *
     * @param userCommand - Input command
     * @param humanBeing  - is instance of Human Being
     * @throws CommandIsNotExistException - если команды не существует
     */
    @Override
    public void executeCommand(String userCommand, HumanBeing humanBeing) throws CommandIsNotExistException, FileIsNotAvailableException {
        String[] split_str = userCommand.trim().toLowerCase().split("\\s+", 2);
        if (split_str.length > 1) throw new CommandIsNotExistException("Данной команды не существует");
        Command command = commandMap.get(split_str[0]);

        if (command == null) throw new CommandIsNotExistException("Данной команды не существует");

        if (!command.isHumanBeingRequired()) command.execute(null, split_str);
        else command.execute(humanBeing, split_str);
    }

    @Override
    public HashMap<String, Command> getCommandMap() {
        return commandMap;
    }

    @Override
    public Command getCommandByName(String commandName) {
        return commandMap.get(commandName);
    }
}
