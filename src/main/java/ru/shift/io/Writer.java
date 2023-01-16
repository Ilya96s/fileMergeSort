package ru.shift.io;

/**
 * Writer - запись данных в выходной файл
 *
 * @author Ilya Kaltygin
 */
public interface Writer<T> {

    /**
     * Метод записывает данные в файл
     * @param filePath файл в который нужно записать данные
     * @param data объект типа Т из которого берутся данные для записи
     */
    void writeOutToFile(String filePath, T data);
}
