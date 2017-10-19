package team42.cs2340.rattrackingapp.Controller;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.io.OutputStreamWriter;
import android.content.Context;

/**
 * Created by Beatrice on 10/14/17.
 */

public class CSVFileWriter {

    private PrintWriter csvWriter;
    private File file;
    public FileOutputStream stream;

    public CSVFileWriter(File file) {
        this.file = file;

    }

    public void writeHeader(String data) {

        try {
            stream = new FileOutputStream("RatSighting.csv");
            //csvWriter.print(",");
            stream.write(data.getBytes());
            stream.close();

            csvWriter = new PrintWriter(new FileWriter(file, true));
            //csvWriter.print(",dqeincdsvwecndfcewf9ucdnc");
            csvWriter.print(data);
            csvWriter.flush();
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}