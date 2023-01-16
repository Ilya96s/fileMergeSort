package ru.shift.validation;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ImplInputValidation - реализация валидации аргументов командной строки
 *
 * @author Ilya Kaltygin
 */
public class ImplInputValidation implements InputValidation {

    /**
     * метод определяет тип данных
     * @param args массив входных аргументов
     * @return true если тип данных int, иначе false
     */
    @Override
    public boolean isIntType(String[] args) {
        return Arrays.asList(args).contains("-i");
    }

    /**
     * метод определяет тип данных
     * @param args массив входных аргументов
     * @return true если тип данных String, иначе false
     */
    @Override
    public boolean isStringType(String[] args) {
        return Arrays.asList(args).contains("-s");
    }

    /**
     * метод определяет режим сортировки данных
     * @param args массив входных аргументов
     * @return true если режим сортировки по возрастанию, иначе false
     */
    @Override
    public boolean isAscendingSort(String[] args) {
        return Arrays.asList(args).contains("-a");
    }

    /**
     * метод определяет режим сортировки данных
     * @param args массив входных аргументов
     * @return true если режим сортировки по убыванию, иначе false
     */
    @Override
    public boolean isDescendingSort(String[] args) {
        return Arrays.asList(args).contains("-d");
    }

    /**
     * метод проверяет был ли указан выходной файл
     * @param args массив входных аргументов
     * @return true если выходной файл указан, иначе false
     */
    @Override
    public boolean outFileIsPresent(String[] args) {
        boolean result;
        if (!isAscendingSort(args) && !isDescendingSort(args)) {
            result = Files.exists(Path.of(args[1])) && args[1].contains("out");
        } else {
            result = Files.exists(Path.of(args[2])) && args[2].contains("out");
        }
        return result;
    }

    /**
     * метод проверяет был ли указан входной файл
     * @param args массив входных аргументов
     * @return true если входной файл указан, иначе false
     */
    @Override
    public boolean inFileIsPresent(String[] args) {
        boolean result;
        if (!isAscendingSort(args) && !isDescendingSort(args)) {
            result = args.length >= 3;
        } else {
            result = args.length >= 4;
        }
        return result;
    }

    /**
     * метод возвращает путь для выходного файла
     * @param args массив входных аргументов
     * @return путь выходного файла
     */
    @Override
    public String getOutFilePath(String[] args) {
        String outFilePath;
        if (!isAscendingSort(args) && !isDescendingSort(args)) {
            outFilePath = args[1];
        } else {
            outFilePath = args[2];
        }
        return outFilePath;
    }

    /**
     * метод возвращает путь для входного файла
     * @param args массив входных аргументов
     * @return список с путями входных файлов
     */
    @Override
    public List<String> getInFilePath(String[] args) {
        List<String> inFilePath = new ArrayList<>();
        if (!isAscendingSort(args) && !isDescendingSort(args)) {
            inFilePath.addAll(Arrays.asList(args).subList(2, args.length));
        } else {
            inFilePath.addAll(Arrays.asList(args).subList(3, args.length));
        }
        return inFilePath;
    }
}
