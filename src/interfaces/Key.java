package interfaces;

import constants.Constants;

import java.util.Scanner;

public interface Key extends Alphabet {
    private int createKey() {
        int number;
        System.out.printf("Укажите ключ для шифрования, только целое число от 0 до %s %n", getAlphabet().length - 1);
        Scanner console = new Scanner(System.in);
        if (!console.hasNextInt()) {
            throw new IllegalArgumentException(Constants.ERROR_MESSAGE);
        }
        else {
            number = console.nextInt();
        }

        if(number < 0 || number > getAlphabet().length -1) {
            throw new IllegalArgumentException(Constants.ERROR_MESSAGE);
        }
        else {
            return number;
        }
    }

    default int getKey()  {
        return createKey();
    }
}
