package ru.shift.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.*;
import java.nio.file.Path;
import static org.assertj.core.api.Assertions.*;

/**
 * Тесты для записи строк в файл
 *
 * @author Ilya Kaltygin
 */
class ImplWriterStringTest {

    /**
     * Метод проверяет запись данных в выходной файл
     * @param tempDir временый файл
     */
    @Test
    void whenWriteOutToFileThenTrue(@TempDir Path tempDir) throws Exception {
        String source = tempDir.resolve("tempFile.txt").toFile().toString();
        String[] data = {"a", "b", "c", "f", "q", "h"};
        ImplWriterString writerString = new ImplWriterString();
        writerString.writeOutToFile(source, data);
        StringBuilder fromData = new StringBuilder();
        for (String s : data) {
            fromData.append(s);
        }
        StringBuilder fromSource = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            reader.lines().forEach(fromSource::append);
        }
        assertThat(fromData.toString()).isEqualTo(fromSource.toString());
    }
}