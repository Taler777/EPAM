package hometask06.task2;
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

public class ReadPropertiesFile {
    private static Properties properties = new Properties();
    static TreeMap<String, String> treeMap = new TreeMap<>();

    static void readProperties(String fileName, String[] keys) {
        try (InputStream in = ReadPropertiesFile.class.getResourceAsStream(fileName)) {
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
        final String PROPS_FILE_NAME = "\\props.properties";
        String[] keys = {"prop1", "prop2", "prop3", "prop4", "prop5"};
        ReadPropertiesFile.readProperties(PROPS_FILE_NAME, keys);
        for (String s : treeMap.keySet()) {
            System.out.println(s + " = " + treeMap.get(s));
        }
    }
}