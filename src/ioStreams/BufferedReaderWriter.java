package ioStreams;

import java.io.*;

public class BufferedReaderWriter {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/dir1/prezenta.txt");
        File outputFile = new File("src/dir1/prezenta_backup.txt");

        inputFile.createNewFile();
        outputFile.createNewFile();

        try (Reader fileReader = new FileReader(inputFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = bufferedReader.readLine();
            while (line != null) {
                if (line.contains("false")) {
                    System.out.println(line);
                }
                line = bufferedReader.readLine();
            }
        }

        try (Reader fileReader = new FileReader(inputFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            long count = bufferedReader.lines()
                    .filter(el -> el.contains("false"))
                    .count();
            System.out.println(count);
        }
    }
}
