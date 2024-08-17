package constants;

import interfaces.Alphabet;

public class Constants implements Alphabet {
    public static final String START_PROGRAM = "Выберите цифру функции программы:\n 1 - Шифрование.\n 2 - Дешифрование. \n 3 - Взлом с помощью Brute Force.";
    public static final String ERROR_MESSAGE = "Ошибка. Введите корректное число";
    public static final String ERROR_FILE = "Ошибка. Файл не найден.";
    public static final String ASKING_READ_FILE = "Укажите путь файла с текстом:";
    public static final String ASKING_FILE = "Укажите путь файла для записи результата:";
    public static final String RESULT = "Готово. Проверьте файл.";
    public static final String ERROR_WRITING_FILE = "Запись не прошла, проверьте доступ и наличие файла";
    public static final String ERROR_READING_FILE = "Не удалось прочитать файл";
}
