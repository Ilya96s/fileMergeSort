package ru.shift.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тесты для чтения данных(целых чисел) из файла
 *
 * @author Ilya Kaltygin
 */
class ImplReaderIntTest {

    /**
     * Метод проверяет чтение данных(целых чисел) из входного файла
     * @param tempDir временый файл
     */
    @Test
    void whenReadFileThenTrue(@TempDir Path tempDir) throws Exception {
        File source = tempDir.resolve("tempFile.txt").toFile();
        try (PrintWriter writer = new PrintWriter(source)) {
            for (int i = 0; i < 10; i++) {
                writer.println(i);
            }
        }
        ImplReaderInt readerInt = new ImplReaderInt();
        StringBuilder builder = new StringBuilder();
        List<Integer> resultList = readerInt.readFile(List.of(source.toString()));
        for (Integer i : resultList) {
            builder.append(i);
        }
        assertThat("0123456789").isEqualTo(builder.toString());
    }

    /**
     * Метод проверяет чтение данных(целых чисел) из входного файла в котором так же содержаться строки и данные с пробелами
     * в результате в список должны попасть только целые числа
     * @param tempDir временый файл
     */
    @Test
    void whenFileContainsDataStringType(@TempDir Path tempDir) throws Exception {
        File source = tempDir.resolve("tempFile.txt").toFile();
        try (PrintWriter writer = new PrintWriter(source)) {
            for (int i = 0; i < 10; i++) {
                writer.println(i);
                writer.println(String.format("%d!", i));
                writer.println(String.format("String type %d!", i));
            }
        }
        ImplReaderInt readerInt = new ImplReaderInt();
        StringBuilder builder = new StringBuilder();
        List<Integer> resultList = readerInt.readFile(List.of(source.toString()));
        for (Integer i : resultList) {
            builder.append(i);
        }
        assertThat("0123456789").isEqualTo(builder.toString());
    }
}