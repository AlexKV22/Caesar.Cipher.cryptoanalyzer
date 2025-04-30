package interfaces;

import constants.Constants;
import java.util.Scanner;

public interface Key extends Alphabet {
    private int createKey(Scanner scanner) {
        boolean validInput = true;
        int number = 0;
        System.out.printf("Укажите ключ для шифрования, только целое число от 0 до %s %n", getAlphabet().length - 1);
        while (validInput) {
            if (!scanner.hasNextInt()) {
                System.out.println(Constants.ERROR_MESSAGE);
                scanner.nextLine();
            } else {
                number = scanner.nextInt();
                scanner.nextLine();
                if (number < 0 || number >= getAlphabet().length) {
                    System.out.println(Constants.ERROR_MESSAGE);
                } else {
                    validInput = false;
                }
            }
        }
        return number;
    }

    default int getKey(Scanner scanner)  {
        return createKey(scanner);
    }
}
