package decoding;
import interfaces.*;

import java.util.Arrays;

    public class Decoding implements Alphabet, ReadableInterface, WriteableInterface, Key {
        private char[] alphabet;
        private String codeText;
        private int number;
        private String result;

        public Decoding()  {
            alphabet = getAlphabet();
            codeText = getText();
            number = getKey();
        }

        public void decoding() {
            char[] decodingText = new char[codeText.length()];
            for (int i = 0; i < codeText.length(); i++) {
                char currentChar = codeText.toLowerCase().charAt(i);
                int charIndex = Arrays.binarySearch(alphabet,currentChar);
                if (charIndex < 0) {
                    decodingText[i] = currentChar;
                    System.out.printf("Символ %s не найден в алфавите и не будет расшифрован.", decodingText[i]);
                }
                else {
                    decodingText[i] = alphabet[(charIndex - number + alphabet.length) % alphabet.length];
                }
            }
            result = new String(decodingText);
            writeText(result);
        }
    }