package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class Book extends Media {

    private ArrayList<String> authors = new ArrayList<String>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(String title, String category, float cost, ArrayList<String> authors) {
        super(title, category, cost);
        for (String author : authors) {
            this.authors.add(author);
        }
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author is already in the list");
        } else {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Author is not in the list");
        }
    }
}
