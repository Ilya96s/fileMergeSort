package ru.shift.sort;

import ru.shift.io.*;
import ru.shift.validation.ImplInputValidation;
import ru.shift.validation.InputValidation;
import java.util.List;

/**
 * StartMergeSort - класс производит валидацию и запуск сортировки данных
 *
 * @author Ilya Kaltygin
 */
public class StartMergeSort {

    /**
     * Объект тиа Writer для записи чисел
     */
    private static final Writer<int[]> INT_WRITER = new ImplWriterInt();

    /**
     * Объект типа Write для записи строк
     */
    private static final Writer<String[]> STRING_WRITER = new ImplWriterString();

    /**
     * Объект типа Reader для чтения строк
     */
    private static final Reader<String> STRING_READER = new ImplReaderString();

    /**
     * Объект типа Reader для чтения чисел
     */
    private static final Reader<Integer> INTEGER_READER = new ImplReaderInt();

    /**
     * Объект типа MergerSort для сортировки чисел по возрастанию
     */
    private static final MergerSort<List<Integer>, int[]> INT_MERGE_SORT_ASC = new ImplMergeSortIntAsc();

    /**
     * Объект типа MergerSort для сортировки чисел по убыванию
     */
    private static final MergerSort<List<Integer>, int[]> INT_MERGE_SORT_DESC = new ImplMergeSortIntDesc();

    /**
     * Объекти тпа MergerSort для сортировки строк по возрастанию
     */
    private static final MergerSort<List<String>, String[]> STRING_MERGE_SORT_ASC = new ImplMergeSortStringAsc();

    /**
     * Объект типа MergerSort для сортировки строк по убыванию
     */
    private static final MergerSort<List<String>, String[]> STRING_MERGE_SORT_DESC = new ImplMergeSortStringDesc();

    /**
     * Объект типа InputValidation для валидации входных аргументов
     */
    private static final InputValidation VALIDATION = new ImplInputValidation();

    /**
     * Метод выполняет сортировку в зависимости от входных аргументов
     * @param args массив аргументов
     */
    public static void startMergeSort(String[] args) {
        if (args.length == 0) {
            throw new IllegalStateException("Входные аргументы не заданы. Пример:  -d -s C:\\Users\\Desktop\\out.txt C:\\Users\\Desktop\\Desktop\\in1.txt C:\\Users\\Desktop\\Desktop\\in2.txt");
        }
        if (!VALIDATION.outFileIsPresent(args)) {
            throw new IllegalStateException("Не задан аргумент выходной файл. Пример: -d -s C:\\Users\\Desktop\\out.txt C:\\Users\\Desktop\\Desktop\\in1.txt C:\\Users\\Desktop\\Desktop\\in2.txt");
        }
        if (!VALIDATION.inFileIsPresent(args)) {
            throw new IllegalStateException("Не задан аргумент входыне файлы, файлов должно быть не менее 1. Пример: -d -s C:\\Users\\Desktop\\out.txt C:\\Users\\Desktop\\Desktop\\in1.txt C:\\Users\\Desktop\\Desktop\\in2.txt");
        }
        if (!VALIDATION.isIntType(args) && !VALIDATION.isStringType(args)) {
            throw new IllegalStateException("Не задан аргумент тип данных. Пример: -d -s C:\\Users\\Desktop\\Desktop\\out.txt C:\\Users\\Desktop\\Desktop\\in1.txt C:\\Users\\Desktop\\Desktop\\in2.txt");
        }
        if (VALIDATION.isIntType(args)) {
            if (VALIDATION.isAscendingSort(args)) {
                INT_WRITER.writeOutToFile(VALIDATION.getOutFilePath(args), INT_MERGE_SORT_ASC.sortMerge(INTEGER_READER.readFile(VALIDATION.getInFilePath(args))));
            } else if (VALIDATION.isDescendingSort(args)) {
                INT_WRITER.writeOutToFile(VALIDATION.getOutFilePath(args), INT_MERGE_SORT_DESC.sortMerge(INTEGER_READER.readFile(VALIDATION.getInFilePath(args))));
            } else {
                INT_WRITER.writeOutToFile(VALIDATION.getOutFilePath(args), INT_MERGE_SORT_ASC.sortMerge(INTEGER_READER.readFile(VALIDATION.getInFilePath(args))));
            }
        }
        if (VALIDATION.isStringType(args)) {
            if (VALIDATION.isAscendingSort(args)) {
                STRING_WRITER.writeOutToFile(VALIDATION.getOutFilePath(args), STRING_MERGE_SORT_ASC.sortMerge(STRING_READER.readFile(VALIDATION.getInFilePath(args))));
            } else if (VALIDATION.isDescendingSort(args)) {
                STRING_WRITER.writeOutToFile(VALIDATION.getOutFilePath(args), STRING_MERGE_SORT_DESC.sortMerge(STRING_READER.readFile(VALIDATION.getInFilePath(args))));
            } else {
                STRING_WRITER.writeOutToFile(VALIDATION.getOutFilePath(args), STRING_MERGE_SORT_ASC.sortMerge(STRING_READER.readFile(VALIDATION.getInFilePath(args))));
            }
        }
    }
}
