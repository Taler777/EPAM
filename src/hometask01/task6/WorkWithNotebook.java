package hometask01.task6;

import java.util.Scanner;
import java.util.TreeMap;

public class WorkWithNotebook {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        WorkWithNotebook workWithNotebook = new WorkWithNotebook();
        Notebook notebook = new Notebook();
        int sel = 0;
        do {
            workWithNotebook.menu();
            sel = workWithNotebook.scanner.nextInt();
            switch (sel) {
                case 1: {
                    System.out.println("Enter your note:");
                    String note = workWithNotebook.scanner.next();
                    notebook.addNote(note);
                    System.out.println("Your note was added. It has ID = " + Note.counter);
                    break;
                }
                case 2: {
                    System.out.println("Enter the key for the note you want to delete.");
                    int key = workWithNotebook.scanner.nextInt();
                    notebook.deleteNote(key);
                    break;
                }
                case 3: {
                    System.out.println("Enter note's key for update:");
                    int key = workWithNotebook.scanner.nextInt();
                    System.out.println("Enter your new note for update:");
                    String note = new String(workWithNotebook.scanner.next());
                    notebook.updateNote(key, note);
                    break;
                }
                case 4: {
                    TreeMap<Integer, String> notes = notebook.getAllNotes();
                    System.out.println(notes.values());

                    break;
                }
                case 0: {
                    System.out.println("Bye-bye");
                    break;
                }
                default:
                    System.out.println("Wrong selected");
            }
        }
        while (sel != 0);
        workWithNotebook.scanner.close();
    }

    public void menu() {
        System.out.println("1. Add note.");
        System.out.println("2. Delete note.");
        System.out.println("3. Update note.");
        System.out.println("4. Show all notes.");
        System.out.println("0 - exit");
        System.out.println("Make your choice:");
    }
}
