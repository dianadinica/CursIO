package seralizare.serialId;

import seralizare.Job;
import seralizare.Persoana;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("src/dir1/persoane.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        Persoana ana = new Persoana("Ana", 34, new Job("Programator"));

        // am scris cu versiunea 1
        /*try (OutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(ana);
        }*/

        // citim cu vesriunea 2
        try (InputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            Object o = objectInputStream.readObject();
            System.out.println(o);
        }
    }
}
