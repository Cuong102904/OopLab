package hust.soict.globalict.aims.disc;

import hust.soict.globalict.aims.media.Media;

public class Disc extends Media {
    private String director;
    private int length;

    public Disc(String title) {
        super(title);
    }

    public Disc(String category, String title, float cost) {
        super(title, category, cost);
    }

    public Disc(String director, String category, String title, float cost) {
        super(title, category, cost);
        this.director = director;
    }

    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }
}
