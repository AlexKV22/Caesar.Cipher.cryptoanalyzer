package interfaces;

import constants.Constants;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public interface WriteableInterface {
    private Path createPath() {
        Path path = null;
        Scanner writeScanner = new Scanner(System.in);
        System.out.println(Constants.ASKING_FILE);
        try {
            path = Path.of(writeScanner.nextLine());
        } catch (FileSystemNotFoundException e) {
            System.out.println(Constants.ERROR_FILE);
        }
        return path;
    }

    default Path getPath() {
        return createPath();
    }

    default void writeText(String result) {
        Path path = createPath();
        try{
            Files.writeString(path, result);
        } catch (IOException e) {
            throw new RuntimeException(Constants.ERROR_WRITING_FILE);
        }
        System.out.println(Constants.RESULT);
    }
}
