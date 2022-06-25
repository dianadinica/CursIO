package ioStreams;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/dir1/Java-Logo.png");
        File outputFile = new File("src/dir1/Java-Logo-Copy.png");

        if (!inputFile.exists()) {
            inputFile.getParentFile().mkdirs();
            inputFile.createNewFile();
        }
        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }

        try (InputStream inputStream = new FileInputStream(inputFile);
             OutputStream outputStream = new FileOutputStream(outputFile)) {

            byte[] continutImg = inputStream.readAllBytes(); // citim imaginea
            outputStream.write(continutImg); // scriem continutul in Java-Logo-Copy
        }
    }
}
