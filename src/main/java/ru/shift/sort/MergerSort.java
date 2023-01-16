package ru.shift.sort;

/**
 * MergerSort - сортировка методом слияния
 * @param <T1> generic - тип данных
 * @param <T2>generic - тип возвращаемых данных
 */
public interface MergerSort<T1, T2> {

    /**
     * Метод выполняет сортировку данных методом слияния
     * @param data данные
     * @return отсортированные данные
     */
    T2 sortMerge(T1 data);
}
