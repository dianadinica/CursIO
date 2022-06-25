package seralizare;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("src/dir1/config.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        // scriem obiecte -> Serializare
        try (OutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            String obj1 = "Text";
            Integer obj2 = 10;
            objectOutputStream.writeObject(obj1);
            objectOutputStream.writeObject(obj2);
        }

        // citim obiecte -> Deserializare
        try (InputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            String obj1 = (String) objectInputStream.readObject();
            System.out.println(obj1.contains("Text"));
            System.out.println(obj1);

            Integer obj2 = (Integer) objectInputStream.readObject();
            System.out.println(obj2);
        }

    }
}
