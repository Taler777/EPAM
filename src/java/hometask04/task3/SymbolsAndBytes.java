package hometask04.task3;

/*
Задание 3. Работа с байтовыми и символьными потоками ввода-вывода

Дан файл, содержащий буквы текст на кириллице. Кодировка файла utf-8.
Прочитайте информацию из файла и перепишите ее в файл в кодировкой utf-16.

 */

import java.io.*;

public class SymbolsAndBytes {
    private static final String FILE_NAME = "src\\java\\hometask04\\task3\\utf8_text.txt";
    private static final String FILE_NAME_OUT = "src\\java\\hometask04\\task3\\output_utf16.txt";


    public static void main(String[] args) {
        SymbolsAndBytes symbolsAndBytes = new SymbolsAndBytes();
        String str = new String(symbolsAndBytes.readByte(FILE_NAME));
        symbolsAndBytes.saveWordsUTF16(FILE_NAME_OUT, str);
    }

    public String readByte(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(FILE_NAME))) {
            byte[] b = new byte[8192];
            while (input.read(b) != -1) {
                sb.append(new String(b, "utf-8"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private void saveWordsUTF16(String fileName, String str) {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(FILE_NAME_OUT), "UTF16"))) {
            out.write(str);
            out.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
