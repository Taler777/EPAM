package hometask04.task1;
/*
Задание 1. Работа с байтовыми потоками ввода-вывода

Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова языка Java это код содержит.
Выведите эти слова и их количество в другой файл. Используйте только байтовые потоки ввода-вывода.

 */

import java.io.*;
import java.util.TreeMap;

public class KeyWordsWithBytes {
    private static final String FILE_NAME = "src\\java\\hometask04\\task1\\SampleClass.java";
    private static final String FILE_NAME_OUT = "src\\java\\hometask04\\task1\\keywordsWithBytes.txt";
    private String[] wordsList = {"abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else",
            "enum", "extends", "false", "final", "finally",
            "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long",
            "native", "new", "null", "package", "private",
            "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "true", "try",
            "void", "volatile", "while"
    };
    TreeMap<String, Integer> wordsAndCount = new TreeMap<>();

    public static void main(String[] args) {
        KeyWordsWithBytes keyWordsWithBytes = new KeyWordsWithBytes();
        keyWordsWithBytes.fillMatrix();
        String str = keyWordsWithBytes.readByte(FILE_NAME);
        keyWordsWithBytes.count(str);
        keyWordsWithBytes.saveWords(FILE_NAME_OUT);
    }

    public void fillMatrix() {
        for (String word : wordsList) {
            wordsAndCount.put(word, 0);
        }
    }

    public String readByte(String fileName) {
        File file = new File(fileName);
        byte[] b = new byte[8192];
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream in = new FileInputStream(file);
            BufferedInputStream input = new BufferedInputStream(in);
            while (input.read(b) != -1) {
                for (byte symbol : b) {
                    sb.append((char) symbol);
                }
            }
            input.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private void count(String str) {
        String[] wordsInFile = str.split("\\W+");
        for (String word : wordsInFile) {
            for (String keyword : wordsList) {
                if (word.equals(keyword)) {
                    wordsAndCount.put(keyword, wordsAndCount.get(keyword) + 1);
                }
            }
        }
    }

    private void saveWords(String fileName) {
        File file = new File(fileName);
        try {
            FileOutputStream out = new FileOutputStream(file);
            BufferedOutputStream output = new BufferedOutputStream(out);
            for (String s : wordsAndCount.keySet()) {
                char[] chars = s.toCharArray();
                byte[] b = new byte[chars.length];
                for (int i = 0; i < chars.length; i++) {
                    b[i] = (byte) chars[i];
                }
                if (wordsAndCount.get(s) != 0) {
                    String stringLine = new String();
                    stringLine += s + " " + wordsAndCount.get(s) + "\r\n";
                    output.write(stringLine.getBytes());
                }
            }
            output.close();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}