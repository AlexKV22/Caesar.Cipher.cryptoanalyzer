package encryption;
import interfaces.Alphabet;
import interfaces.Key;
import interfaces.ReadableInterface;
import interfaces.WriteableInterface;
import java.util.Arrays;
import java.util.Scanner;

public class Encryption implements ReadableInterface, Alphabet, WriteableInterface, Key {
    private char[] alphabet;
    private String cleanText;
    private int number;
    private String result;
    private Scanner scanner;

    public Encryption(Scanner scanner)  {
        this.scanner = scanner;
        alphabet = getAlphabet();
        number = getKey(scanner);
        cleanText = getText(scanner);
    }
    public void encryption() {
        char[] encryptionText = cleanText.toCharArray();
        for (int i = 0; i < cleanText.length(); i++) {
            char currentChar = cleanText.toLowerCase().charAt(i);
            int charIndex = Arrays.binarySearch(alphabet,currentChar);
            if (charIndex < 0) {
                encryptionText[i] = currentChar;
                System.out.printf("Символ %s не найден в алфавите и не будет зашифрован.\n", encryptionText[i]);
            }
            else {
                encryptionText[i] = alphabet[(charIndex + number) % alphabet.length];
            }
        }
        result = new String(encryptionText);
        writeText(result, scanner);
    }
}