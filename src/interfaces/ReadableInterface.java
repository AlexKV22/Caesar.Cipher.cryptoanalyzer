package interfaces;

import constants.Constants;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public interface ReadableInterface {
    private String createText(Scanner scanner) {
        System.out.println(Constants.ASKING_READ_FILE);
        Path path = Path.of(scanner.nextLine());
        while (!Files.exists(path)) {
            System.out.println(Constants.ASKING_READ_FILE);
            path = Path.of(scanner.nextLine());
        }
        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(Constants.ERROR_READING_FILE);
        }
    }

     default String getText(Scanner scanner) {
        return createText(scanner);
    }
}
