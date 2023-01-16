package ru.shift.io;

import java.util.List;

/**
 * Reader - чтение входящих файлов
 *
 * @author Ilya Kaltygin
 */
public interface Reader<T> {

    /**
     * Метод считывает данные из файла и сохраняет в список
     * @param files список файлов
     * @return список с данными
     */
    List<T> readFile(List<String> files);
}
