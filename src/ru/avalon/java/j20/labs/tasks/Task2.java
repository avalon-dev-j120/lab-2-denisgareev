package ru.avalon.java.j20.labs.tasks;

import ru.avalon.java.j20.labs.Task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * Задание №2
 *
 * <p>Тема: "Потоковый ввод-вывод. Чтение и запись данных
 * в текстовом режиме".
 */
public class Task2 implements Task {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() throws IOException {
        File input = new File("assets/countries.txt");
        File output = new File("countries_text_mode_output.txt");
        String text = read(input);
        write(output, text);

        /*
         * TODO(Студент): Выполнить задание №2
         *
         * 1. Реализовать метод read.
         *
         *    При чтении файла следует пользоваться типами данных:
         *    Reader, FileReader.
         *
         *    Для сохранения прочитанных данных следует пользоваться
         *    классом StringBuilder.
         *
         * 2. Реализовать метод write.
         *
         *    При реализации метода следует пользоваться типами данных:
         *    Writer и FileWriter.
         *
         * 3. С использованием отладчика проверить корректность работы программы.
         */
    }

    /**
     * Выполняет чтение указанного файла в текстовом режиме.
     *
     * <p>Весь текст файла возвращается в виде одного
     * экземпляра типа {@link String}.
     *
     * @param file файл
     * @return содержимое файла в виде текста.
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private String read(File file) throws IOException {
        //throw new UnsupportedOperationException("Not implement yet!");
        
        try (Reader reader = new FileReader(file); ) {

            StringBuilder sb = new StringBuilder();
            char[] buffer = new char[16];
            int len = 0;
            while ((len = reader.read(buffer)) != -1) {
                sb.append(buffer);
            }
            return sb.toString();
        }
    }

    /**
     * Выполняет запись текстоых данных в файл в текстовом
     * режиме.
     *
     * @param file файл
     * @param text текст
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private void write(File file, String text) throws IOException {
        try (Writer output = new FileWriter(file)) {
            output.write(text);
            //output.flush();
            output.close();
        }
    }
    public static void main(String[] a) throws IOException {
        new Task2().run();
    }
}
