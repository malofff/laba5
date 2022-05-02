package Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine() throws IOException {
        String line = reader.readLine();
        line = line != null ? line.trim() : null;
        return line;
    }



    public static BufferedReader getReader() {
        return reader;
    }

}
