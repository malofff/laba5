package fileWork;

import exception.FileIsNotAvailableException;
import model.HumanBeing;

import java.util.Vector;

public interface HumanBeingsToFile {
    void writeToFile(Vector<HumanBeing> entities, String filename) throws FileIsNotAvailableException;
}
