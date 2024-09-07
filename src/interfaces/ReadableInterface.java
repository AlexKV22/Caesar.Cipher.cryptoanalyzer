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
        if (Files.notExists(path)) {
            throw new RuntimeException(Constants.ERROR_FILE);
        }
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException(Constants.ERROR_READING_FILE, e);
        }
        String finalText = new String(bytes, StandardCharsets.UTF_8);

//        try (RandomAccessFile randomAccessFile = new RandomAccessFile(path.toFile(), "r")) {
//            FileChannel fileChannel = randomAccessFile.getChannel();
//            ByteBuffer buffer = ByteBuffer.allocate(1024);
//            int bytesRead = fileChannel.read(buffer);
//            buffer.flip();
//            finalText = new String(buffer.array(), 0, bytesRead, StandardCharsets.UTF_8);
//            System.out.println(finalText);
//        } catch (IOException e) {
//            throw new RuntimeException(Constants.ERROR_READING_FILE);
//        }

//        try(BufferedReader reader = Files.newBufferedReader(path)) {
//            List<String> cleanText = reader.lines().toList();
//            finalText = String.join("\n", cleanText);
//        } catch (IOException e) {
//            throw new RuntimeException(Constants.ERROR_READING_FILE);
//        }

        System.out.println(finalText);
        return finalText;
    }

     default String getText() {
        return createText();
    }
}
