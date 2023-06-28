package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    private String author;
    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }
    public Book(String title, String category, float cost, String author) {
        super(title, category, cost);
        this.author = author;
    }
    public void addAuthor(String name) {
        if (authors.contains(name)) {
            System.out.println("The author exists already");
        } else {
            this.authors.add(name);
            System.out.println("The author has been added");
        }
    }

    public void removeAuthor(String name) {
        if (authors.contains(name)) {
            this.authors.remove(name);
            System.out.println("The author has been removed");
        } else {
            System.out.println("The author does not exist");
        }
    }
}
