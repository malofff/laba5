package fileWork;

import exception.BrokenDataException;
import exception.FileIsNotAvailableException;
import model.HumanBeing;

import java.util.Vector;


public interface FileToHumanBeings {
    Vector<HumanBeing> readFromXml(String filename) throws FileIsNotAvailableException, BrokenDataException;
}
