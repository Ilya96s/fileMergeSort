package ru.shift.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тесты для сортировки методом слияния данных типа String по возрастанию
 *
 * @author Ilya Kaltygin
 */
class ImplMergeSortStringAscTest {

    /**
     * Метод проверяет сортировку данных типа String по возрастанию
     */
    @Test
    void whenSortMergeAscThenTrue() {
        List<String> list = Arrays.asList("g", "r", "A", "p", "o", "R");
        ImplMergeSortStringAsc sortStringAsc = new ImplMergeSortStringAsc();
        String[] result = sortStringAsc.sortMerge(list);
        assertThat(result).isSortedAccordingTo(Comparator.naturalOrder());
    }
}