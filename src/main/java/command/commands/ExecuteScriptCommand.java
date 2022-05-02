package command.commands;


import command.commandReader.CommandReader;
import exception.CommandIsNotExistException;
import exception.FileIsNotAvailableException;
import exception.InvalidFieldException;
import exception.ScriptException;
import model.HumanBeing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

//todo доделать команду(чтобы читала и исполняла с файла)

public class ExecuteScriptCommand extends Command{

    private final CommandReader commandReader;
    private final HashSet<String> scripts;

    public ExecuteScriptCommand(CommandReader commandReader){
        super("execute_script file_name",
                ": read and execute script from the file. " +
                        "В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме");
        this.commandReader = commandReader;
        scripts = new HashSet<>();
    }

    @Override
    public void execute(HumanBeing humanBeing,String[] args) {
        if (args.length < 2) {
            System.out.println("Inavlid arguments for command");
            return;
        }
        String fileName = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            if (scripts.contains(fileName))
                throw new ScriptException();
            scripts.add(fileName);

            while (reader.ready()) {
                String command = reader.readLine();
                try {
                    commandReader.executeCommand(command.trim().toLowerCase(), null);
                } catch (CommandIsNotExistException e) {
                } catch (FileIsNotAvailableException e) {
                    e.printStackTrace();
                } catch (InvalidFieldException e) {
                    e.printStackTrace();
                }
            }
            removeScript(fileName);
        } catch (IOException e) {
            System.out.println((e.getMessage()));
        }
    }

    public void clearScripts() {
        scripts.clear();
    }

    private void removeScript(String fileName) {
        scripts.remove(fileName);
    }


    @Override
    public boolean isHumanBeingRequired() {
        return super.isHumanBeingRequired();
    }
}
