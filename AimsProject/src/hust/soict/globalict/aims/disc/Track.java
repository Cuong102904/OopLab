package hust.soict.globalict.aims.disc;

import java.util.ArrayList;

public class Track implements Playable {
    private String title;
    private int length;
    private String artist;
    private ArrayList<String> tracks = new ArrayList<String>();

    public Track(String title, int length, String artist) {
        this.length = length;
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getLength() {
        return length;
    }

    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public boolean equals(Object o) {
        Track track = (Track) o;
        return title == track.getTitle() && length == track.getLength();
    }
}
