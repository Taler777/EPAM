package hometask01.task6;
/**
 * @author Aleksei Sypchenko
 * @version 1.0.0
 * @since 1.8
 */

import java.util.TreeMap;

/**
 * Class Notebook. It consists of notes.
 * @see Note
 */
public class Notebook {
    TreeMap<Integer, String> notes = new TreeMap<>();

    /**
     * Add a new note.
     * @param str note text
     */
    public void addNote(String str) {
        Note note = new Note(str);
        notes.put(note.key, note.singleNote);
    }

    /**
     * Delete a current note.
     * @param key number of note for delete
     */
    public void deleteNote(int key) {
        notes.remove(key);
    }

    /**
     * Update old note with new.
     * @param key number of note for update
     * @param newNote a new note text for change an old note
     */
    public void updateNote(int key, String newNote) {
        notes.put(key, newNote);
    }

    /**
     * Show all notes.
     * @return all notes
     */
    public TreeMap getAllNotes() {
        return notes;
    }
}
