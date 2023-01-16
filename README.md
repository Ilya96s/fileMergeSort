# fileMergeSort
# Описание проекта
Программа производит сортировку методом слияния нескольких файлов и записывает результат в выходной файл
# Стек технологий
- Java 17
- Checkstyle-plugin 3.1.2
- Junit 5.9.1 
- AssertJ 3.23.1
# Требования к окружению
- Java 17
- Maven 3.8
# Запуск проекта
- Параметры программы задаются при запуске через аргументы командной строки, по порядку:
    - режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;
    - тип данных (-s или -i), обязательный;
    - имя выходного файла, обязательное(Необоходимо указывать полный путь до файла и имя файла должно содержать в названии "out")
    - остальные параметры – имена входных файлов, не менее одного.(Необходимо указывать полный путь до файлов)

1. Упаковать проект в .jar архив (\fileMergeSort\target\fileMergeSort-1.0-SNAPSHOT.jar)
```shell
mvn package
```
2. Запустить приложение
```shell
java -jar fileMergeSort-1.0-SNAPSHOT.jar (-a/-d) (-s/-i) \out.txt \in1.txt \in2.txt 
```
# Контакты
- Telegram: https://t.me/ilya96s
- GitHub: https://github.com/Ilya96s