import Application.Application;
import collectionManager.CollectionManager;
import collectionManager.CollectionManagerImpl;
import command.commandReader.CommandReader;
import command.commandReader.CommandReaderImpl;
import fileWork.*;
import validation.HumanBeingBuilder;
import validation.HumanBeingBuilderImpl;
import validation.HumanBeingValidator;
import validation.HumanBeingValidatorImpl;
import Application.IO;

public class Main {
    public static void main(String[] args) {
        CommandReader reader = new CommandReaderImpl();
        CollectionManager manager = new CollectionManagerImpl();
        FileChecker checker = new XmlFileChecker();

        HumanBeingValidator validator = new HumanBeingValidatorImpl();
        HumanBeingBuilder builder = new HumanBeingBuilderImpl(validator,false, IO.getReader());
        FileToHumanBeings fileToHb = new XmlToHumanBeings(checker, builder);
        HumanBeingsToFile hbToFile = new HumanBeingsToXml(checker);
        Application application = new Application(manager, reader, fileToHb, hbToFile, validator, builder);


        application.start("./files/humanBeings.xml");

    }
}
