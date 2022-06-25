package ioStreams;

import java.io.*;

public class ReaderWriterMain {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/dir1/application.properties");
        File outputFile = new File("src/dir1/application_backup.properties");

        inputFile.createNewFile();
        outputFile.createNewFile();

        // citire & scriere caracter cu caracter
        try (Reader reader = new FileReader(inputFile);
             Writer writer = new FileWriter(outputFile)) {
            int read = reader.read();

            while (read != -1) {
                writer.write(read);
                read = reader.read();
            }
        }

        // citire & scriere cu array de char
        try (Reader reader = new FileReader(inputFile);
            Writer writer = new FileWriter(outputFile)) {

            char[] array = new char[100];
            int nrCaractereCitite = reader.read(array);

            System.out.println(array);
            System.out.println(nrCaractereCitite);
            System.out.println(new String(array));

            writer.write(array);
            writer.write("\nexemplu text scris direct");
        }
    }
}
