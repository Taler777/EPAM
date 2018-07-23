package hometask05.task2;

/*
Задание 2. Обработка исключительных ситуаций

Создать “универсальный” класс, позволяющий получить значение из любого properties-файла.
Физическое чтение файла должно происходить только один раз.
Обработайте следующие исключительные ситуации: нет файла *.properties, нет ключа в properties-файле.

 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.TreeMap;

public class ReadPropertiesFileAndException {

    private static Properties properties = new Properties();
    private static TreeMap<String, String> treeMap = new TreeMap<>();

    static TreeMap<String, String> readProperties(String fileName, String[] keys) {
        try (InputStream in = ReadPropertiesFileAndException.class.getResourceAsStream(fileName)) {
            properties.load(in);
            for (String key : keys) {
                if (properties.containsKey(key)) {
                    treeMap.put(key, properties.getProperty(key));
                } else {
                    System.out.println("Key not found: " + key);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("File not found: " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return treeMap;
    }

    public static void main(String[] args) {
        final String PROPS_FILE_NAME = "\\props06.properties";
        String[] keys = {"prop1", "prop2", "prop3", "prop4", "prop5"};
        ReadPropertiesFileAndException.readProperties(PROPS_FILE_NAME, keys);
        for (String s : treeMap.keySet()) {
            System.out.println(s + " = " + treeMap.get(s));
        }
    }
}
