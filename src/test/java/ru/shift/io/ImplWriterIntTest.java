package ru.shift.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import static org.assertj.core.api.Assertions.*;

/**
 * Тесты для записи целых чисел в файл
 *
 * @author Ilya Kaltygin
 */
class ImplWriterIntTest {

    /**
     * Метод проверяет запись данных в выходной файл
     * @param tempDir временый файл
     */
    @Test
    void whenWriteOutToFilThenTrue(@TempDir Path tempDir) throws Exception {
        String source = tempDir.resolve("tempFile.txt").toFile().toString();
        int[] data = {2, 5, 32, 22, 0};

        ImplWriterInt writerInt = new ImplWriterInt();
        writerInt.writeOutToFile(source, data);

        StringBuilder fromData = new StringBuilder();
        for (int i : data) {
            fromData.append(i);
        }

        StringBuilder fromSource = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            reader.lines().forEach(fromSource::append);
        }

        assertThat(fromData.toString()).isEqualTo(fromSource.toString());
    }
}