package fileWork;

import java.io.File;

public class XmlFileChecker implements FileChecker {
    @Override
    public boolean checkFile(String filename) {
        File file = new File(filename);
        boolean isFileAndReadableAndWriteable = file.exists() && file.isFile() && file.canRead() && file.canWrite();
        boolean isXml = filename.endsWith(".xml");

        return isFileAndReadableAndWriteable && isXml;
    }
}
