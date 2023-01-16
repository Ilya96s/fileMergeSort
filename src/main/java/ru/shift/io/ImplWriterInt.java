package ru.shift.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * ImplWriterInt - реализация записи данных в файл
 *
 * @author Ilya Kaltygin
 */
public class ImplWriterInt implements Writer<int[]> {

    /**
     * Метод записывает данные в файл
     * @param filePath файл в который нужно записать данные
     * @param data объект типа int[] из которого берутся данные для записи
     */
    @Override
    public void writeOutToFile(String filePath, int[] data) {
        try (PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(filePath)))) {
            for (int d : data) {
                writer.println(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
