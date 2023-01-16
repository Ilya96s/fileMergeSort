package ru.shift.sort;

import java.util.List;

/**
 * ImplMergeSortIntAsc - реализация сортировки методом слияния для данных типа Integer
 * Данные сортируются по возрастанию
 *
 * @author Ilya Kaltygin
 */
public class ImplMergeSortIntAsc implements MergerSort<List<Integer>, int[]> {

    /**
     * Метод выполняет сортировку данных методом слияния
     * @param array список с данными
     * @return результирующий отсортированный массив
     */
    @Override
    public  int[] sortMerge(List<Integer> array) {
        return sort(array.stream().mapToInt(i -> i).toArray(), 0, array.size() - 1);
    }

    /**
     * Метод рекурсивно делит массив на две части до тех пор пока массив не будет содержать 1 элемент
     * @param array массив
     * @param from индекс начала
     * @param to индекс конца
     * @return результирующий отсортированный массив
     */
    private static int[] sort(int[] array, int from, int to) {
        if (from == to) {
            return new int[]{array[from]};
        }
        int mid = (from + to) / 2;
        return mergeAsc(
                sort(array, from, mid),
                sort(array, mid + 1, to)
        );
    }

    /**
     * Метод в котором находится логика сортировки слиянием
     * @param left левый массив
     * @param right правый массив
     * @return результирующий отсортированный массив
     */
    private static int[] mergeAsc(int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        int[] resultArray = new int[left.length + right.length];
        while (resultIndex != resultArray.length) {
            if (leftIndex == left.length) {
                resultArray[resultIndex++] = right[rightIndex++];
            } else if (rightIndex == right.length) {
                resultArray[resultIndex++] = left[leftIndex++];
            } else if (left[leftIndex] <= right[rightIndex]) {
                resultArray[resultIndex++] = left[leftIndex++];
            } else {
                resultArray[resultIndex++] = right[rightIndex++];
            }
        }
        return resultArray;
    }
}
