
import decoding.Decoding;
import encryption.Encryption;
import hackCaesarCipher.HackCaesarCipher;
import constants.Constants;

import java.util.Scanner;

public class Main {
    private static final Scanner mainConsole = new Scanner(System.in);
    public static void main(String[] args)  {
        System.out.println(Constants.START_PROGRAM);
        switch (mainConsole.nextInt()) {
            case 1 : { new Encryption().encryption();
                       mainConsole.close();
                       break;
            }

            case 2 : { new Decoding().decoding();
                       mainConsole.close();
                       break;
            }

            case 3 : { new HackCaesarCipher().hackCaesarCipher();
                       mainConsole.close();
                       break;
            }
            default: throw new IllegalArgumentException(Constants.ERROR_MESSAGE);
        }
    }
}
