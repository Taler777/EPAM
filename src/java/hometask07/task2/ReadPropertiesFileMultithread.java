package hometask07.task2;

/*
Задание 2. Синхронизация 2

Создать “универсальный” класс, позволяющий получить значение из любого properties-файла.
Физическое чтение файла должно происходить только один раз.
Учтите ситуацию, когда несколько потоков одновременно обращаются к одному и тому же файлу.

 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.TreeMap;

public class ReadPropertiesFileMultithread {
    private static Properties properties = new Properties();
    static TreeMap<String, String> treeMap = new TreeMap<>();

    private synchronized TreeMap<String, String> readProperties(String fileName, String[] keys) {
        try (InputStream in = ReadPropertiesFileMultithread.class.getResourceAsStream(fileName)) {
            properties.load(in);
            for (String key : keys) {
                treeMap.put(key, properties.getProperty(key));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return treeMap;
    }

    public static void main(String[] args) {
        final String PROPS_FILE_NAME = "\\props07.properties";
        String[] keys = {"prop1", "prop2", "prop3", "prop4", "prop5"};
        ReadPropertiesFileMultithread readProps = new ReadPropertiesFileMultithread();
        Thread t1 = new Thread((Runnable) () -> readProps.readProperties(PROPS_FILE_NAME, keys));
        Thread t2 = new Thread((Runnable) () -> readProps.readProperties(PROPS_FILE_NAME, keys));
        Thread t3 = new Thread((Runnable) () -> readProps.readProperties(PROPS_FILE_NAME, keys));
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (String s : treeMap.keySet()) {
            System.out.println(s + " = " + treeMap.get(s));
        }
    }
}