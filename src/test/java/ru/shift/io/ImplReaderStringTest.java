package ru.shift.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

/**
 * Тесты для чтения данных(строк) чисел из файла
 *
 * @author Ilya Kaltygin
 */
class ImplReaderStringTest {

    /**
     * Метод проверяет чтение данных(строк) из входного файла
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
        ImplReaderString readerString = new ImplReaderString();
        StringBuilder builder = new StringBuilder();
        List<String> resultList = readerString.readFile(List.of(source.toString()));
        for (String s : resultList) {
            builder.append(s);
        }
        assertThat("0123456789").isEqualTo(builder.toString());
    }
}