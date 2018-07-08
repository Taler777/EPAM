package hometask01.task6;

/**
 * @author Aleksei Sypchenko
 * @version 1.0.0
 * @since 1.8
 *
 *
 */

/**
 * Class Note. It's a part of notebook.
 */
public class Note {
    String singleNote;
    int key;
    static int counter = 0;

    /**
     * @param singleNote note text from user
     */
    public Note(String singleNote) {
        this.singleNote = singleNote;
        counter++;
        key = counter;
    }
}
