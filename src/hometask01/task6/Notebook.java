package hometask01.task6;

import java.util.TreeMap;

public class Notebook {
    TreeMap<Integer, String> notes = new TreeMap<>();

    public void addNote(String str) {
        Note note = new Note(str);
        notes.put(note.key, note.singleNote);
    }

    public void deleteNote(int key) {
        notes.remove(key);
    }

    public void updateNote(int key, String newNote) {
        notes.put(key, newNote);
    }

    public TreeMap getAllNotes() {
        return notes;
    }
}
