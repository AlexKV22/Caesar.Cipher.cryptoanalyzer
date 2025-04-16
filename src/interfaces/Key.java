package interfaces;

import constants.Constants;
import java.util.Scanner;

public interface Key extends Alphabet {
    private int createKey() {
        boolean validInput = true;
        int number = 0;
        System.out.printf("Укажите ключ для шифрования, только целое число от 0 до %s %n", getAlphabet().length - 1);
        Scanner console = new Scanner(System.in);
        while (validInput) {
            if (!console.hasNextInt()) {
                System.out.println(Constants.ERROR_MESSAGE);
                console.next();
            } else {
                number = console.nextInt();
                if (number < 0 || number >= getAlphabet().length) {
                    System.out.println(Constants.ERROR_MESSAGE);
                } else {
                    validInput = false;
                }
            }
        }
        return number;
    }

    default int getKey()  {
        return createKey();
    }
}
