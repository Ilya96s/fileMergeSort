package ru.shift.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ImplReaderInt - реализация чтения входящих файлов
 *
 * @author Ilya Kaltygin
 */
public class ImplReaderInt implements Reader<Integer> {

    /**
     * метод считывает данные из файла и сохраняет в список
     * @param files список файлов
     * @return список с данными
     */
    @Override
    public List<Integer> readFile(List<String> files) {
        List<Integer> resultList = new ArrayList<>();
        for (String file : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                    if (checkString(line) && checkStringForNumber(line)) {
                        resultList.add(Integer.parseInt(line));
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
     * если строка пустая или содержит пробелы, то она не будет добавлена в список
     * @param line строка
     * @return true если строка не пустая и не содердит пробелов, иначе false
     */
    private static boolean checkString(String line) {
        return line.length() != 0 && !line.contains(" ");
    }

    /**
     * метод выполняет проверку на то, что строка содержит только целые числа
     * если строка состоит не только из чисел, то она не будет добавлена в список
     * @param line строка
     * @return true если строка представляет собой целое число, иначе false
     */
    private static boolean checkStringForNumber(String line) {
        return line.matches("[0-9]+");
    }
}
