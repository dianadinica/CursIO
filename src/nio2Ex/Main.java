package nio2Ex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/dir3/dir2/config.txt");
        System.out.println(path);

        System.out.println(path.isAbsolute());
        System.out.println(path.getNameCount());
        System.out.println(path.subpath(1,3));

        Path pathPersoane = Path.of("src/di1/persoane.txt");
        Path path1 = pathPersoane.relativize(path);

        System.out.println(path1); // ../../dir3/dir2/config.txt

        Path path2 = Path.of("src/dir1/dir0/dir4");
        Files.createDirectories(path2);
        //Files.createFile(path);

        Path path3 = Path.of("src/dir1/Java-Logo-COPY-2.png");
        Files.copy(Path.of("src/dir1/Java-Logo.png"), path3);
    }
}
