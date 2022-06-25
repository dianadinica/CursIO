package seralizare;

import java.io.*;

public class ReadWriteCustomClassWithJob {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("src/dir1/persoane.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        Job job = new Job("Programator");
        Persoana persoana = new Persoana("Ana", 34, job);
        System.out.println(persoana);
        // scriem obiecte -> Serializare
        try (OutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(persoana);
        }

        // citim obiecte -> Deserializare
        try (InputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            Object p1 = objectInputStream.readObject();
            System.out.println(p1);

            System.out.println(p1 == persoana); // false
            System.out.println(p1.equals(persoana)); // true
        }
    }
}
