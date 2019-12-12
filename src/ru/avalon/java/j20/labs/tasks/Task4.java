package ru.avalon.java.j20.labs.tasks;

import ru.avalon.java.j20.labs.Task;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Задание №4
 *
 * <p>Тема: "Потоковый ввод-вывод. Чтение файлов конфигурации".
 */
public class Task4 implements Task {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() throws IOException {
        Properties properties = read("resources/database");

        /*
         * TODO(Студент): Выполнить задание №4
         *
         * 1. Реализовать метод read.
         *
         * 2. С использованием отладчика проверить корректность работы программы.
         */
    }

    /**
     * Выполняет чтение файла конфигураций описанного
     * параметром {@code path}.
     *
     * @param path путь к конфигурации
     * @return новый экземпляр типа {@link Properties}
     */
    private Properties read(String path) throws IOException{
        //throw new UnsupportedOperationException("Not implement yet!");
        
        Properties properties = new Properties();
        try (InputStream stream = ClassLoader.getSystemResourceAsStream("resources/database.properties")) { //получить ссылку на интересующий ресурс
            properties.load(stream);
        }
        
        String txt = properties.getProperty("db.postgres.url");
        
        System.out.println(txt);
        
        return properties;
    }
    
    public static void main(String[] a) throws IOException {
    new Task4().run();
    }
}
