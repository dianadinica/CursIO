package seralizare;

import java.io.*;

public class SubClassSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("src/dir1/persoane.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        Angajat angajat = new Angajat("Ana", 34, null, "ItSchool");

        try (OutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(angajat);
            System.out.println(angajat);
        }

        try (InputStream inputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {

            Object o = objectInputStream.readObject();
            System.out.println(o);
        }
    }
}
