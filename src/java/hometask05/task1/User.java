package hometask05.task1;

/*
Задание 1. Обработка исключительных ситуаций

Разработать приложение, позволяющее просматривать файлы и каталоги файловой системы,
а также создавать и удалять текстовые файлы.
Для работы с текстовыми файлами необходимо реализовать функциональность записи (дозаписи) в файл.
Требуется определить исключения для каждого слоя приложения и корректно их обработать.

 */

import java.io.File;

public class User {
    private static final String FILE_NAME = "file.txt";
    private static final String FILE_PATH = "src\\java\\hometask05\\task1";
    private static final String DIRECTORY = "src\\java\\hometask05";

    public static void main(String[] args) {
        File file = new File(FILE_PATH, FILE_NAME);
        FileExplorerLight.createFile(file);
        FileExplorerLight.getFilesFromDirectory(DIRECTORY);
        System.out.println();
        FileExplorerLight.writeToFile(file, "New record!!!");
        System.out.println();
        FileExplorerLight.parseFile(file);
        System.out.println();
        FileExplorerLight.deleteFile(file);
    }
}

