
import decoding.Decoding;
import encryption.Encryption;
import hackCaesarCipher.HackCaesarCipher;
import constants.Constants;

import java.util.Scanner;

public class Main {
    private static final Scanner console = new Scanner(System.in);
    public static void main(String[] args)  {
        System.out.println(Constants.START_PROGRAM);
        switch (console.nextInt()) {
            case 1 : { new Encryption().encryption();
                       console.close();
                       break;
            }

            case 2 : { new Decoding().decoding();
                       console.close();
                       break;
            }

            case 3 : { new HackCaesarCipher().hackCaesarCipher();
                       console.close();
                       break;
            }
            default: throw new IllegalArgumentException(Constants.ERROR_MESSAGE);
        }
    }
}
