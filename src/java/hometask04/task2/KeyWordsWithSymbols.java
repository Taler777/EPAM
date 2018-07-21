package hometask04.task2;
/*
Задание 2. Работа с символьными потоками ввода-вывода

Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова языка Java это код содержит.
Выведите эти слова и их количество в другой файл. Используйте только символьные потоки ввода-вывода.

 */

import java.io.*;
import java.util.TreeMap;

public class KeyWordsWithSymbols {
    private static final String FILE_NAME = "src\\java\\hometask04\\task2\\KeyWordsWithSymbols.java";
    private static final String FILE_NAME_OUT = "src\\java\\hometask04\\task2\\keywordsWithSymbols.txt";
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
        KeyWordsWithSymbols keyWordsWithSymbols = new KeyWordsWithSymbols();
        keyWordsWithSymbols.fillMatrix();
        String str = keyWordsWithSymbols.readSymbols(FILE_NAME);
        keyWordsWithSymbols.count(str);
        keyWordsWithSymbols.saveWords(FILE_NAME_OUT);
    }

    public void fillMatrix() {
        for (String word : wordsList) {
            wordsAndCount.put(word, 0);
        }
    }

    public String readSymbols(String fileName) {
        File file = new File(fileName);
        String strLine;
        StringBuilder sb = new StringBuilder();
        try {
            FileReader in = new FileReader(fileName);
            BufferedReader input = new BufferedReader(in);
            while ((strLine = input.readLine()) != null) {
                sb.append(strLine);
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
            FileWriter out = new FileWriter(file);
            BufferedWriter output = new BufferedWriter(out);
            for (String s : wordsAndCount.keySet()) {
                if (wordsAndCount.get(s) != 0) {
                    String stringLine = new String();
                    stringLine += s + " " + wordsAndCount.get(s) + "\r\n";
                    output.write(stringLine);
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