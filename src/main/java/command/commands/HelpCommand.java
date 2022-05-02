package command.commands;

import command.commandReader.CommandReader;
import model.HumanBeing;
import java.util.Formatter;
import java.util.HashMap;


public class HelpCommand extends Command{
    private final HashMap<String,Command> commandMap;

    public HelpCommand(HashMap<String, Command> commandMap){
        super("help", ": display help for available commands");
        this.commandMap = commandMap;
    }

    @Override
    public boolean isHumanBeingRequired() {
        return super.isHumanBeingRequired();
    }

    @Override
    public void execute(HumanBeing humanBeing, String[] args) {
        for (String it : commandMap.keySet()) {
            System.out.println(commandMap.get(it).getName()+commandMap.get(it).getDescription());
        }
    }
}
