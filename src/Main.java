
import decoding.Decoding;
import encryption.Encryption;
import hackCaesarCipher.HackCaesarCipher;
import constants.Constants;
import java.util.Scanner;

public class Main {
    private static final Scanner mainConsole = new Scanner(System.in);
    public static void main(String[] args)  {
        System.out.println(Constants.START_PROGRAM);
        try {
            switch (mainConsole.nextInt()) {
                case 1 : {
                    mainConsole.nextLine();
                    new Encryption(mainConsole).encryption();
                    break;
                }
                case 2 : {
                    mainConsole.nextLine();
                    new Decoding(mainConsole).decoding();
                    break;
                }
                case 3 : {
                    mainConsole.nextLine();
                    new HackCaesarCipher(mainConsole).hackCaesarCipher();
                    break;
                }
                default: {
                    System.out.println(Constants.ERROR_MESSAGE);
                }
            }
        } finally {
            mainConsole.close();
        }
    }
}
