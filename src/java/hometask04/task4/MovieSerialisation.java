package hometask04.task4;

/*
Задание 4. Сериализация

Дана коллекция фильмов, содержащая информацию об актерах, снимавшихся в главных ролях
(один актер мог сниматься и в нескольких фильмах).
Необходимо написать приложение, позволяющее при запуске восстанавливать коллекцию фильмов,
позволять ее модифицировать, а по завершении работы приложения – сохранять (в файл).
Для восстановления/сохранения коллекции использовать  сериализацию/десериализацию.
*/

import java.io.*;
import java.util.ArrayList;

public class MovieSerialisation {
    private static ArrayList<Movie> movies = new ArrayList<>();

    public static void readFile(String fileName) {

        try (ObjectInputStream inputObject = new ObjectInputStream(new FileInputStream(fileName))) {
            movies = (ArrayList<Movie>) inputObject.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found: " + fileName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            e.printStackTrace();
            System.out.println("File is empty: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException is coming )))");
        }
    }

    public static void addMovie(String name, String[] actors) {
        Movie movie = new Movie(name, actors);
        movies.add(movie);
    }

    public static void deleteMovie(String name) {
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                movies.remove(movie);
                System.out.println("Movie \'" + name + "\' " + "deleted");
                break;
            }
        }
        System.out.println("Movie does not exist: " + name);
    }

    public static void editMovieName(String oldName, String newName) {
        for (Movie movie : movies) {
            if (movie.getName().equals(oldName)) {
                movie.setName(newName);
            }
        }
    }

    public static void writeMovies(String fileName) {
        try (ObjectOutputStream outputObject = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputObject.writeObject(movies);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("IOException is coming )))");
        }
    }

    public static void main(String[] args) {
        final String FILE_NAME = "src\\java\\hometask04\\task3\\movieCollection.txt";

        addMovie("Terminator", new String[]{"Arnold", "Arnold-double"});
        addMovie("It", new String[]{"Donald", "Ronald", " Arnold"});
        MovieSerialisation.writeMovies(FILE_NAME);
        //MovieSerialisation.deleteMovie("Terminator");
        MovieSerialisation.readFile(FILE_NAME);
    }
}