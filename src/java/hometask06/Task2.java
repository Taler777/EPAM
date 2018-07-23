package hometask06;
/*
Задание 2. Использование Map

Создать “универсальный” класс, позволяющий получить значение из любого properties-файла.
Физическое чтение файла должно происходить только один раз.
Результаты чтения храните в коллекции типа Map.
Ответьте на вопрос: как ведет себя map-коллекция если в нее добавить элемент с ключом, который уже присутствует?

 */

// ОТВЕТ НА ВОПРОС:

// При добавлении в map-коллекцию элемента с ключом, который уже в ней присутствует,
// старый объект, соответствующий ключу, будет перезаписан новым объектом.


import java.io.*;
import java.util.Properties;
import java.util.TreeMap;

public class Task2 {
    private static final String PROPS_FILE_NAME = "\\props.properties";
    private static Properties properties = new Properties();
    static TreeMap<String, String> treeMap = new TreeMap<>();

    static void setUp(String fileName, String[] keys) {
        try (InputStream in = Task2.class.getResourceAsStream(PROPS_FILE_NAME)) {
            properties.load(in);
            for (String key : keys) {
                treeMap.put(key, properties.getProperty(key));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] keys = {"prop1", "prop2", "prop3", "prop4", "prop5"};
        Task2.setUp(PROPS_FILE_NAME, keys);
        for (String s : treeMap.keySet()) {
            System.out.println(s + " = " + treeMap.get(s));
        }
    }
}