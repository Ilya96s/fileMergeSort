package ru.shift.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тесты для сортировки методом слияния данных типа Integer по убыванию
 *
 * @author Ilya Kaltygin
 */
class ImplMergeSortIntDescTest {

    /**
     * Метод проверяет сортировку данных типа Integer по убыванию
     */
    @Test
    void whenSortMergeDescThenTrue() {
        List<Integer> list = Arrays.asList(1, 5, 90, 0, 56, 8);
        ImplMergeSortIntDesc sortIntDesc = new ImplMergeSortIntDesc();
        int[] result = sortIntDesc.sortMerge(list);
        assertThat(result).isSortedAccordingTo(Comparator.reverseOrder());
    }
}