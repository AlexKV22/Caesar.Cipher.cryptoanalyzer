package interfaces;

import constants.Constants;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public interface ReadableInterface {
    private String createText() {
        Scanner readScanner = new Scanner(System.in);
        System.out.println(Constants.ASKING_READ_FILE);
        Path path = Path.of(readScanner.nextLine());
        while (!Files.exists(path)) {
            System.out.println(Constants.ASKING_READ_FILE);
            path = Path.of(readScanner.nextLine());
        }
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException(Constants.ERROR_READING_FILE, e);
        }
        String finalText = new String(bytes, StandardCharsets.UTF_8);
        return finalText;
    }
     default String getText() {
        return createText();
    }
}
