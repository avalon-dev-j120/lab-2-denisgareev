package ru.avalon.java.j20.labs.tasks;

import ru.avalon.java.j20.labs.Task;

import java.io.File;
import java.io.IOException;
import java.io.*;

/**
 * Задание №1
 *
 * <p>Тема: "Потоковый ввод-вывод. Чтение и запись данных
 * в двоичном режиме".
 */
public class Task1 implements Task {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() throws IOException {
        File input = new File("assets/countries.txt");
        File output = new File("countries_binary_mode_output.txt");
        String text = read(input);
        System.out.println(text);
        write(output, text);

        /*
         * TODO(Студент): Выполнить задание №1
         *
         * 1. Реализовать метод read.
         *
         *    При чтении файла следует пользоваться типами данных:
         *    InputStream и FileInputStream.
         *
         *    Для сохранениня прочитанных данных следует пользоваться
         *    классом ByteArrayOutputStream.
         *
         * 2. Реализовать метод write.
         *
         *    При реализации метода следует пользоваться типами данных:
         *    OutputStream и FileOutputStream.
         *
         * 3. С использованием отладчика проверить корректность работы программы.
         */
    }

    /**
     * Выполняет чтение указанного файла в двоичном режиме.
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
    
        try (InputStream input = new FileInputStream(file);
             ByteArrayOutputStream output = new ByteArrayOutputStream(16)) {
            
            byte[] buffer = new byte[16];
            int len = 0;
            while ((len = input.read(buffer)) != -1) {
                output.write(buffer, 0, len);
            }

            byte[] bytes = output.toByteArray();
            return new String(bytes);
        }
    }

    /**
     * Выполняет запись текстоых данных в файл в двоичном
     * режиме.
     *
     * @param file файл
     * @param text текст
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private void write(File file, String text) throws IOException {
        //throw new UnsupportedOperationException("Not implemented yet!");
        
        try (OutputStream output = new FileOutputStream(file)) {
            output.write(text.getBytes());
            output.flush();
            output.close();
        }
    }
    
    public static void main(String[] a) throws IOException {
    new Task1().run();
    }
}
