package encryption;
import constants.Constants;
import interfaces.*;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class Encryption implements ReadableInterface, Alphabet, WriteableInterface, Key {
    private char[] alphabet;
    private String cleanText;
    private int number;
    private String result;

    public Encryption()  {
        alphabet = getAlphabet();
        number = getKey();
        cleanText = getText();
    }
    public void encryption() {
        char[] encryptionText = cleanText.toCharArray();
        for (int i = 0; i < cleanText.length(); i++) {
            char currentChar = cleanText.toLowerCase().charAt(i);
            int charIndex = Arrays.binarySearch(alphabet,currentChar);
            if (charIndex < 0) {
                encryptionText[i] = currentChar;
                System.out.printf("Символ %s не найден в алфавите и не будет зашифрован.", encryptionText[i]);
            }
            else {
                encryptionText[i] = alphabet[(charIndex + number) % alphabet.length];
            }
        }
        result = new String(encryptionText);
        writeText(result);
    }
}














//    char[] encryptionText = new char[cleanList.length()];
//        for (int i = 0; i < cleanList.length(); i++) {
//        char currentChar = cleanList.toLowerCase().charAt(i);
//        int charIndex = Arrays.binarySearch(alphabet,currentChar);
//        if (charIndex < 0) {
//        encryptionText[i] = currentChar;
//        System.out.print(encryptionText[i]);
//        }
//        else {
//        encryptionText[i] = alphabet[(charIndex + number) % alphabet.length];
//        System.out.print(encryptionText[i]);
//        }
//        }
//        String result = new String(encryptionText);
//        GetResultText.getResultText(result);
//        System.out.println(RESULT);
//        }