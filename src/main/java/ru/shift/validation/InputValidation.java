package ru.shift.validation;

import java.util.List;

/**
 * InputValidation - валидация аргументов командной строки
 *
 * @author Ilya Kaltygin
 */
public interface InputValidation {

    /**
     * метод определяет тип данных
     * @param args массив аргументов
     * @return true если тип данных int, иначе false
     */
    boolean isIntType(String[] args);

    /**
     * метод определяет тип данных
     * @param args массив аргументов
     * @return true если тип данных String, иначе false
     */
    boolean isStringType(String[] args);

    /**
     * метод определяет режим сортировки данных
     * @param args массив аргументов
     * @return true если режим сортировки по возрастанию, иначе false
     */
    boolean isAscendingSort(String[] args);

    /**
     * метод определяет режим сортировки данных
     * @param args массив аргументов
     * @return true если режим сортировки по убыванию, иначе false
     */
    boolean isDescendingSort(String[] args);

    /**
     * метод проверяет был ли указан выходной файл
     * @param args массив аргументов
     * @return true если выходной файл указан, иначе false
     */
    boolean outFileIsPresent(String[] args);

    /**
     * метод проверяет был ли указан входной файл
     * @param args массив аргументов
     * @return true если входной файл указан, иначе false
     */
    boolean inFileIsPresent(String[] args);

    /**
     * метод возвращает путь для выходного файла
     * @param args массив аргументов
     * @return путь
     */
    String getOutFilePath(String[] args);

    /**
     * метод возвращает путь для входного файла
     * @param args массив аргументов
     * @return список с путями входных файлов
     */
    List<String> getInFilePath(String[] args);
}
