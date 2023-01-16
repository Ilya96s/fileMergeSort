package ru.shift.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тесты для сортировки методом слияния данных типа String по убыванию
 *
 * @author Ilya Kaltygin
 */
class ImplMergeSortStringDescTest {

    /**
     * Метод проверяет сортировку данных типа String по убыванию
     */
    @Test
    void whenSortMergeDescThenTrue() {
        List<String> list = Arrays.asList("g", "r", "a", "p", "o", "r");
        ImplMergeSortStringDesc sortStringDesc = new ImplMergeSortStringDesc();
        String[] result = sortStringDesc.sortMerge(list);
        assertThat(result).isSortedAccordingTo(Comparator.reverseOrder());
    }
}