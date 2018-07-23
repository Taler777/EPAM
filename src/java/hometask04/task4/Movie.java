package hometask04.task4;

import java.io.Serializable;
import java.util.Arrays;

public class Movie implements Serializable {
    private String name;
    private String[] actors;

    public Movie(String name, String[] actors) {
        this.name = name;
        this.actors = actors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Movie \"");
        sb.append(name);
        sb.append("\"");
        sb.append(". Actors: ");
        sb.append(Arrays.toString(actors));
        return sb.toString();
    }

    public void getInfo() {
        System.out.println(this.toString());
    }
}
