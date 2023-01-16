package ru.shift.sort;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

/**
 * Тесты для сортировки методом слияния данных типа Integer по возрастанию
 *
 * @author Ilya Kaltygin
 */
class ImplMergeSortIntAscTest {

    /**
     * Метод проверяет сортировку данных типа Integer по возрастанию
     */
    @Test
    void whenSortMergeAscThenTrue() {
        List<Integer> list = Arrays.asList(1, 5, 90, 0, 56, 8);
        ImplMergeSortIntAsc sortIntAsc = new ImplMergeSortIntAsc();
        int[] result = sortIntAsc.sortMerge(list);
        assertThat(result).isSortedAccordingTo(Comparator.naturalOrder());
    }
}