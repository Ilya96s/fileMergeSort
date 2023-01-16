package ru.shift.sort;

import java.util.List;

/**
 * ImplMergeSortStringDesc - реализация сортировки методом слияния для данных типа String
 * Данные сортируются по убыванию
 *
 * @author Ilya Kaltygin
 */
public class ImplMergeSortStringDesc implements MergerSort<List<String>, String[]> {

    /**
     * Метод выполняет сортировку данных методом слияния
     * @param array список с данными
     * @return результирующий отсортированный массив
     */
    @Override
    public String[] sortMerge(List<String> array) {
        return sort(array.toArray(new String[0]), 0, array.size() - 1);
    }

    /**
     * Метод рекурсивно делит массив на две части до тех пор пока массив не будет содержать 1 элемент
     * @param array массив
     * @param from индекс начала
     * @param to индекс конца
     * @return результирующий отсортированный массив
     */
    private static String[] sort(String[] array, int from, int to) {
        if (from == to) {
            return new String[]{array[from]};
        }
        int mid = (from + to) / 2;
        return merge(
                sort(array, from, mid),
                sort(array, mid + 1, to)
        );
    }

    /**
     * Метод в котором находится логика сортировки слиянием
     *
     * @param left  левый массив
     * @param right правый массив
     * @return результирующий отсортированный массив
     */
    private static String[] merge(String[] left, String[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        String[] result = new String[left.length + right.length];
        while (resultIndex != result.length) {
            if (leftIndex == left.length) {
                result[resultIndex++] = right[rightIndex++];
            } else if (rightIndex == right.length) {
                result[resultIndex++] = left[leftIndex++];
            } else if (left[leftIndex].compareTo(right[rightIndex]) >= 0) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }
        return result;
    }
}
