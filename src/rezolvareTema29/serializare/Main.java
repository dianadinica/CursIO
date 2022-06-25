package rezolvareTema29.serializare;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = init();
        ex2(file);
        ex3(file);
    }

    private static File init() throws IOException {
        File resourceFolder = new File("resources");
        if (!resourceFolder.exists()) {
            resourceFolder.mkdir();
            System.out.println("Folderul " + resourceFolder.getName() + " a fost creat!");
        }
        File profile = new File("resources/profile.txt");
        if (!profile.exists()) {
            profile.createNewFile();
            System.out.println("Folderul " + profile.getName() + " a fost creat!");
        }
        return profile;
    }

    private static void ex3(File file) throws IOException, ClassNotFoundException {
        char[] pass1 = {'t', 'e', 's', 't', 'p', 'a', 's', 's', '1'};
        FullProfile profile1 = new FullProfile("test1@test.com", "test1", pass1, LocalDate.of(1988, 10, 4));
        System.out.println(profile1);

        char[] pass2 = {'t', 'e', 's', 't', 'p', 'a', 's', 's', '2'};
        FullProfile profile2 = new FullProfile("test2@test.com", "test2", pass2, LocalDate.of(1978, 3, 10));
        System.out.println(profile2);

        // scriem obiectele -> Serializare
        writeObjectsInFile(List.of(profile1, profile2), file);

        // citim obiectele -> Deserializare
        readObjectsFromFile(file, 2);
    }

    private static void ex2(File file) throws IOException, ClassNotFoundException {
        char[] pass1 = {'t', 'e', 's', 't', 'p', 'a', 's', 's', '1'};
        Profile profile1 = new Profile("test1@test.com", "test1", pass1);
        System.out.println(profile1);

        char[] pass2 = {'t', 'e', 's', 't', 'p', 'a', 's', 's', '2'};
        Profile profile2 = new Profile("test2@test.com", "test2", pass2);
        System.out.println(profile2);

        // scriem obiectele -> Serializare
        writeObjectsInFile(List.of(profile1, profile2), file);

        // citim obiectele -> Deserializare
        readObjectsFromFile(file, 2);
    }

    private static void writeObjectsInFile(List<Object> objects, File file) throws IOException {
        try (OutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            for (Object obj : objects) {
                objectOutputStream.writeObject(obj);
            }
        }
    }

    private static void readObjectsFromFile(File file, int nr) throws IOException, ClassNotFoundException {
        // citim obiectele -> Deserializare
        try (InputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            while (nr > 0) {
                Object profile = objectInputStream.readObject();
                System.out.println(profile);
                nr--;
            }
        }
    }
}
