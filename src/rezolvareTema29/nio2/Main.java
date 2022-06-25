package rezolvareTema29.nio2;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        System.out.println("==== Exercitiul 1 a ====");
        Path path = Path.of("resources/nio2");
        System.out.println(path);

        System.out.println("==== Exercitiul 1 b ====");
        System.out.println(path.toAbsolutePath());

        System.out.println("==== Exercitiul 1 c ====");
        System.out.println(path.toAbsolutePath().getRoot());

        System.out.println("==== Exercitiul 1 d ====");
        System.out.println(path.getParent());

        System.out.println("==== Exercitiul 1 e ====");
        System.out.println(path.getFileName());

        System.out.println("==== Exercitiul 1 f ====");
        System.out.println(path.toAbsolutePath().getNameCount());

        System.out.println("==== Exercitiul 1 g ====");
        System.out.println(path.toAbsolutePath().subpath(0, 1));


        System.out.println("==== Exercitiul 2 a ====");
        Path path1 = Path.of("A/B/C/D");
        Path path2 = Path.of("A/B/X/Y");
        System.out.println(path1);
        System.out.println(path2);

        System.out.println("==== Exercitiul 3 ====");
        Path relativizePath = path1.relativize(path2);
        System.out.println(relativizePath);

        System.out.println("==== Exercitiul 4 ====");
        System.out.println(relativizePath.toAbsolutePath());
        System.out.println(relativizePath.toAbsolutePath().normalize());
    }
}
