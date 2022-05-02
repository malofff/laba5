package Application;

import collectionManager.CollectionManager;
import command.commandReader.CommandReader;
import command.commands.*;
import exception.BrokenDataException;
import exception.FileIsNotAvailableException;
import exception.InvalidFieldException;
import fileWork.FileToHumanBeings;
import fileWork.HumanBeingsToFile;
import model.HumanBeing;
import validation.HumanBeingBuilder;
import validation.HumanBeingBuilderImpl;
import validation.HumanBeingValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;


public class Application {
    private final CollectionManager manager;
    private final CommandReader commandReader;
    private final FileToHumanBeings fileReader;
    private final HumanBeingsToFile fileWriter;
    private final BufferedReader consoleReader;
    private final HumanBeingBuilder builder;
    private boolean isRunning = true;
    private String filename = "";
    private final HumanBeingValidator validator;

    public Application(CollectionManager manager,
                       CommandReader commandReader,
                       FileToHumanBeings fileReader,
                       HumanBeingsToFile fileWriter,
                       HumanBeingValidator validator,
                       HumanBeingBuilder builder) {
        this.manager = manager;
        this.commandReader = commandReader;
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.validator = validator;
        this.builder = builder;
        this.consoleReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start(String file) {
        try {
            this.filename = file;
            Vector<HumanBeing> readEntities = fileReader.readFromXml(filename);
            for (HumanBeing hb : readEntities) {
                manager.addElement(hb);
            }
            initCommands();
            run();
        } catch (FileIsNotAvailableException e) {
            e.printStackTrace();
        } catch (BrokenDataException e) {
            e.printStackTrace();
        } catch (IOException | InvalidFieldException e) {
            e.printStackTrace();
        }
    }


    private void run() throws IOException, FileIsNotAvailableException, InvalidFieldException {
        while (isRunning) {
            String[] inputCommand = consoleReader.readLine().trim().toLowerCase().split("\\s", 2);

            Command command = commandReader.getCommandByName(inputCommand[0]);
            if (command == null) {
                System.out.println("Command does not exist");
                continue;
            }
            HumanBeing hb = null;
            if (command.isHumanBeingRequired()) {
                builder.askHumanBeing();
                hb = builder.getHumanBeing();
            }
            command.execute(hb, inputCommand);
        }
    }

    public void exit() {
        this.isRunning = false;
    }

    public void save() throws FileIsNotAvailableException {
        fileWriter.writeToFile(manager.getHumanBeings(), filename);
    }

    private void initCommands() throws FileIsNotAvailableException {
        commandReader.addCommandToMap("show", new ShowCommand(manager));
        commandReader.addCommandToMap("add",new AddCommand(manager));
        commandReader.addCommandToMap("clear",new ClearCommand(manager));
        commandReader.addCommandToMap("filter_by_car",new FilterByCarCommand(manager));
        commandReader.addCommandToMap("help",new HelpCommand(commandReader.getCommandMap()));
        commandReader.addCommandToMap("info",new InfoCommand(manager));
        commandReader.addCommandToMap("print_field_descending_car",new PrintFieldDescendingCarCommand(manager));
        commandReader.addCommandToMap("remove_all_by_weapon_type",new RemoveAllByWeaponTypeCommand(manager));
        commandReader.addCommandToMap("remove_at",new RemoveAtIndexCommand(manager));
        commandReader.addCommandToMap("remove_by_id",new RemoveByIdCommand(manager));
        commandReader.addCommandToMap("remove_last", new RemoveLastCommand(manager));
        commandReader.addCommandToMap("remove_lower",new RemoveLowerCommand(manager));
        commandReader.addCommandToMap("save", new SaveCommand(this));
        commandReader.addCommandToMap("update",new UpdateCommand(manager));
        commandReader.addCommandToMap("exit",new ExitCommand(this));
        commandReader.addCommandToMap("execute_script",new ExecuteScriptCommand(commandReader));

    }
}
