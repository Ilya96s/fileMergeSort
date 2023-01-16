package ru.shift.sort;

import java.util.List;

/**
 * ImplMergeSortIntDesc - реализация сортировки методом слияния для данных типа Integer
 * Данные сортируются по убыванию
 *
 * @author Ilya Kaltygin
 */
public class ImplMergeSortIntDesc implements MergerSort<List<Integer>, int[]> {

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
        return merge(
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
    private static int[] merge(int[] left, int[] right) {
        int li = 0;
        int ri = 0;
        int resI = 0;
        int[] result = new int[left.length + right.length];
        while (resI != result.length) {
            if (li == left.length) {
                result[resI++] = right[ri++];
            } else if (ri == right.length) {
                result[resI++] = left[li++];
            } else if (left[li] >= right[ri]) {
                result[resI++] = left[li++];
            } else {
                result[resI++] = right[ri++];
            }
        }
        return result;
    }
}
