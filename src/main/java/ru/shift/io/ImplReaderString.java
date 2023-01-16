package ru.shift.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ImplReader - реализация чтения входящих файлов
 *
 * @author Ilya Kaltygin
 */
public class ImplReaderString implements Reader<String> {

    /**
     * метод считывает данные из файла и сохраняет в список
     * @param files список файлов
     * @return список с данными
     */
    @Override
    public List<String> readFile(List<String> files) {
        List<String> resultList = new ArrayList<>();
        for (String file : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                    if (checkString(line)) {
                        resultList.add(line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultList;
    }

    /**
     * метод выполняет проверку на то, что строка не пустая и не содержит пробелов
     * если строка состоит не только из чисел, то она не будет добавлена в список
     * @param line строка
     * @return true если строка не пустая и не содердит пробелов, иначе false
     */
    private static boolean checkString(String line) {
        return line.length() != 0 && !line.contains(" ");
    }
}
