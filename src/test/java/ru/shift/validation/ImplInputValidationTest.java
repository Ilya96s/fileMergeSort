package ru.shift.validation;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

/**
 * Тесты для валидации аргументов командной строки
 *
 * @author Ilya Kaltygin
 */
class ImplInputValidationTest {

    /**
     * Метод проверяет, что во входящих аргумнетах передан ключ "-i", который указывает, что тип данных - это целые числа
     * если передан ключ "-i", то метод должен вернуть true и тест завершиться успешно
     */
    @Test
    void whenIsIntTypeThenTrue() {
        String[] args = {"-d", "-i", "data/out.txt", "data/in1.txt", "data/in2.txt"};
        InputValidation validation = new ImplInputValidation();
        boolean result = validation.isIntType(args);
        assertThat(result).isTrue();
    }

    /**
     * Метод проверяет, что во входящих аргумнетах не передан ключ "-i"
     * если ключ "-i" не содержится в аргументах, то метод должен вернуть false и тест завершиться успешно
     */
    @Test
    void whenIsNotIntTypeThenFalse() {
        String[] args = {"-d", "-d", "data/out.txt", "data/in1.txt", "data/in2.txt"};
        InputValidation validation = new ImplInputValidation();
        boolean result = validation.isIntType(args);
        assertThat(result).isFalse();
    }

    /**
     * Метод проверяет, что во входящих аргумнетах передан ключ "-s", который указывает, что тип данных - это строки
     * если передан ключ "-s", то метод должен вернуть true и тест завершиться успешно
     */
    @Test
    void whenIsStringTypeThenTrue() {
        String[] args = {"-d", "-s", "data/out.txt", "data/in1.txt", "data/in2.txt"};
        InputValidation validation = new ImplInputValidation();
        boolean result = validation.isStringType(args);
        assertThat(result).isTrue();
    }

    /**
     * Метод проверяет, что во входящих аргумнетах не передан ключ "-s"
     * если ключ "-s" не содержится в аргументах, то метод должен вернуть false и тест завершиться успешно
     */
    @Test
    void whenIsNotStringTypeThenFalse() {
        String[] args = {"-d", "-i", "data/out.txt", "data/in1.txt", "data/in2.txt"};
        InputValidation validation = new ImplInputValidation();
        boolean result = validation.isStringType(args);
        assertThat(result).isFalse();
    }

    /**
     * Метод проверяет, что во входящих аргумнетах передан ключ "-a", который указывает на тип сортировки по возрастанию
     * если ключ "-a" содержится в аргументах, то метод вернет true и тест завершится успешно
     */
    @Test
    void whenIsAscendingSortThenTrue() {
        String[] args = {"-a", "-i", "data/out.txt", "data/in1.txt", "data/in2.txt"};
        InputValidation validation = new ImplInputValidation();
        boolean result = validation.isAscendingSort(args);
        assertThat(result).isTrue();
    }

    /**
     * Метод проверяет, что во входящих аргумнетах передан ключ "-d", который указывает на тип сортировки по убыванию
     * если ключ "-d" содержится в аргументах, то метод вернет true и тест завершится успешно
     */
    @Test
    void whenIsDescendingSortThenTrue() {
        String[] args = {"-d", "-i", "data/out.txt", "data/in1.txt", "data/in2.txt"};
        InputValidation validation = new ImplInputValidation();
        boolean result = validation.isDescendingSort(args);
        assertThat(result).isTrue();
    }

    /**
     * Метод проверяет, что во входящих аргумнетах не передан ключ "-a", который указывает на тип сортировки по возрастанию
     * если ключ "-a" не содержится в аргументах, то метод вернет false и тест завершится успешно
     */
    @Test
    void whenIsNotAscendingSortThenFalse() {
        String[] args = {"-d", "-i", "data/out.txt", "data/in1.txt", "data/in2.txt"};
        InputValidation validation = new ImplInputValidation();
        boolean result = validation.isAscendingSort(args);
        assertThat(result).isFalse();
    }

    /**
     * Метод проверяет, что во входящих аргумнетах не передан ключ "-d", который указывает на тип сортировки по убыванию
     * если ключ "-d" не содержится в аргументах, то метод вернет false и тест завершится успешно
     */
    @Test
    void whenIsNotDescendingSortThenFalse() {
        String[] args = {"-a", "-i", "data/out.txt", "data/in1.txt", "data/in2.txt"};
        InputValidation validation = new ImplInputValidation();
        boolean result = validation.isDescendingSort(args);
        assertThat(result).isFalse();
    }

    /**
     * Метод проверяет, что во входящих аргумнетах передан путь к выходному файлу в который будут записаны данные,
     * если путь содержится в аргументах, то метод вернет true и тест завершится успешно
     */
    @Test
    void whenOutFileIsPresentThenTrue() {
        String[] args = {"-d", "-i", "data/out.txt", "data/in1.txt", "data/in2.txt"};
        InputValidation validation = new ImplInputValidation();
        boolean result = validation.outFileIsPresent(args);
        assertThat(result).isTrue();
    }

    /**
     * Метод проверяет, что во входящих аргумнетах переданЫ пути к входным файлам из которых будут считаны данные,
     * должно быть не менее одного пути, если пути содержатся в аргументах, то метод вернет true и тест завершится успешно
     */
    @Test
    void whenInFileIsPresentThenTrue() {
        String[] args = {"-d", "-i", "data/out.txt", "data/in1.txt", "data/in2.txt"};
        InputValidation validation = new ImplInputValidation();
        boolean result = validation.inFileIsPresent(args);
        assertThat(result).isTrue();
    }

    /**
     * Метод возвращет путь к выходному файлу
     */
    @Test
    void whenGetOutFilePathThenTrue() {
        String[] args = {"-d", "-i", "data/out.txt", "data/in1.txt", "data/in2.txt"};
        InputValidation validation = new ImplInputValidation();
        String outFilePath = validation.getOutFilePath(args);
        assertThat(outFilePath).isEqualTo(args[2]);
    }

    /**
     * Метод возвращает пути к входным файлам
     */
    @Test
    void whenGetInFilePathThenTrue() {
        String[] args = {"-d", "-i", "data/out.txt", "data/in1.txt", "data/in2.txt"};
        InputValidation validation = new ImplInputValidation();
        List<String> inFiles = validation.getInFilePath(args);
        assertThat(inFiles.size()).isEqualTo(2);
        assertThat(inFiles.get(0)).isEqualTo("data/in1.txt");
        assertThat(inFiles.get(1)).isEqualTo("data/in2.txt");
    }
}