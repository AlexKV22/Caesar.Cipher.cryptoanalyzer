package interfaces;

import constants.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public interface ReadableInterface {
    private String createText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.ASKING_READ_FILE);
        Path path = Path.of(scanner.nextLine());
        if (Files.notExists(path)) {
            throw new RuntimeException(Constants.ERROR_FILE);
        }
        String finalText;
        try(BufferedReader reader = Files.newBufferedReader(path)) {
            List<String> cleanText = reader.lines().toList();
            finalText = String.join("\n", cleanText);
        } catch (IOException e) {
            throw new RuntimeException(Constants.ERROR_READING_FILE);
        }
        return finalText;
    }

     default String getText() {
        return createText();
    }
}
