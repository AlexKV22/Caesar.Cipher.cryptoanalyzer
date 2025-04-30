package hackCaesarCipher;
import constants.Constants;
import interfaces.ReadableInterface;
import interfaces.WriteableInterface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

public class HackCaesarCipher implements interfaces.Alphabet, ReadableInterface, WriteableInterface {
    private char[] alphabet;
    private String codeText;
    private String result;
    private Path path;
    private Scanner scanner;
    private FileChannel fileChannel;

    public HackCaesarCipher(Scanner scanner) {
        this.scanner = scanner;
        alphabet = getAlphabet();
        codeText = getText(scanner);
    }

    public void hackCaesarCipher() {
        path = getPath(scanner);
        try {
            fileChannel = FileChannel.open(path, StandardOpenOption.WRITE);
            ByteBuffer byteBuffer = ByteBuffer.allocate(20480);
            char[] decodingText = new char[codeText.length()];
            for (int i = 0; i < alphabet.length; i++) {
                for (int j = 0; j < codeText.length(); j++) {
                    char currentChar = codeText.toLowerCase().charAt(j);
                    int charIndex = Arrays.binarySearch(alphabet, currentChar);
                    if (charIndex < 0) {
                        decodingText[j] = currentChar;
                        System.out.printf("Символ %s не найден в алфавите и не будет подобран.", decodingText[j]);
                    } else {
                        decodingText[j] = alphabet[(charIndex - i + alphabet.length) % alphabet.length];
                    }
                }
                result = new String(decodingText);
                byteBuffer.put(result.getBytes());
                byteBuffer.put(Character.getDirectionality('\n'));
            }
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
        } catch (IOException e) {
            throw new RuntimeException(Constants.ERROR_WRITING_FILE);
        } finally {
            try {
                fileChannel.close();
            } catch (IOException e) {
                throw new RuntimeException("Error closing file");
            }
        }
        System.out.println(Constants.RESULT);
    }
}









//try {
//        Files.writeString(path, result + '\n', StandardOpenOption.APPEND);
//            } catch (IOException e) {
//        throw new RuntimeException(Constants.ERROR_WRITING_FILE);
//            }
