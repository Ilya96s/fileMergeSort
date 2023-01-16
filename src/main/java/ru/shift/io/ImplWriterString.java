package ru.shift.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * ImplWriterString - реализация записи данных в файл
 *
 * @author Ilya Kaltygin
 */
public class ImplWriterString implements Writer<String[]> {

    /**
     * Метод записывает данные в файл
     * @param filePath файл в который нужно записать данные
     * @param data объект типа String[] из которого берутся данные для записи
     */
    @Override
    public void writeOutToFile(String filePath, String[] data) {
        try (PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(filePath)))) {
            for (String s : data) {
                writer.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
