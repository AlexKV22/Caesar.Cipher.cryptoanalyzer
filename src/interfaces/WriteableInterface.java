package interfaces;

import constants.Constants;

import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public interface WriteableInterface {
    private Path createPath(Scanner scanner) {
        Path path = null;
        System.out.println(Constants.ASKING_FILE);
        try {
            path = Path.of(scanner.nextLine());
        } catch (FileSystemNotFoundException e) {
            System.out.println(Constants.ERROR_FILE);
        }
        return path;
    }

    default Path getPath(Scanner scanner) {
        return createPath(scanner);
    }

    default void writeText(String result, Scanner scanner) {
        Path path = createPath(scanner);
        try{
            Files.writeString(path, result);
        } catch (IOException e) {
            throw new RuntimeException(Constants.ERROR_WRITING_FILE);
        }
        System.out.println(Constants.RESULT);
    }
}
