package team42.cs2340.rattrackingapp.Controller;

import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Beatrice on 10/14/17.
 */

public class CSVFileWriter {

    private PrintWriter csvWriter;
    private File file;

    public CSVFileWriter(File file) {
        this.file = file;

    }

    public void writeHeader(String data) {

        try {

            csvWriter = new PrintWriter(new FileWriter(file, true));
            //csvWriter.print(",");
            csvWriter.print(data);
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}