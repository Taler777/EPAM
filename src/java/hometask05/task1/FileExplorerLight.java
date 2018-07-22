package hometask05.task1;

import java.io.*;

public class FileExplorerLight {

    public static void createFile(File file) {
        if (file.exists()) {
            System.out.println("File " + file.getName() + " exists.");
        } else {
            try {
                if (file.createNewFile()) {
                    System.out.println("File " + file.getName() + " created.");
                } else {
                    System.out.println("File " + file.getName() + " not created.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getFilesFromDirectory(String directory) {
        File dir = new File(directory);
        if (dir.isDirectory()) {
            System.out.println("\nList of directories and filse:");
            for (File item : dir.listFiles()) {
                if (item.isDirectory()) {
                    System.out.println(item.getName() + "  \tdirectory");
                } else {
                    System.out.println(item.getName() + "\tfile");
                }
            }
        }
    }

    public static void writeToFile(File file, String data) {
        if (file.exists()) {
            try (BufferedWriter outFile = new BufferedWriter(new FileWriter(file, true))) {
                outFile.write(data + " ");
                System.out.println("Data added.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("File does not exist.");
        }
    }

    public static void parseFile(File file) {
        String readedString;
        if (file.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                System.out.println("File's content:");
                while ((readedString = in.readLine()) != null) {
                    System.out.println(readedString);
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("File does not exist.");
        }
    }

    public static void deleteFile(File file) {
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File " + file.getName() + " deleted.");
            } else {
                System.out.println("File " + file.getName() + " not deleted.");
            }
        } else {
            System.out.println("File " + file.getName() + " does not exist.");
        }
    }
}
