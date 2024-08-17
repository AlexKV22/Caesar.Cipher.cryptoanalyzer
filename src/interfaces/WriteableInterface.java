package interfaces;

import constants.Constants;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public interface WriteableInterface {
    private Path createPath() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.ASKING_FILE);
        Path path = Path.of(scanner.nextLine());
        if (Files.notExists(path)) {
            throw new RuntimeException(Constants.ERROR_FILE);
        }
        return path;
    }

    default Path getPath() {
        return createPath();
    }

    default void writeText(String result) {
        try(BufferedWriter writer = Files.newBufferedWriter(createPath())) {
            writer.write(result);
            Files.writeString(createPath(), result);
        } catch (IOException e) {
            throw new RuntimeException(Constants.ERROR_WRITING_FILE);
        }
        System.out.println(Constants.RESULT);
    }
}
