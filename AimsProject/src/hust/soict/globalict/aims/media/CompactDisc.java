
package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.disc.Disc;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<track> tracks = new ArrayList<track>();
    private int length = 0;

    public String getArtist() {
        return artist;
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist,
            List<track> tracks) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String artist, List<track> tracks) {
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id2, String title2, String category2, float cost2, String artist2) {
    }

    public void addTrack(track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }

    public void removeTrack(track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        }
    }

    public int getLength() {
        for (track track : tracks) {
            length += track.getLength();
        }
        return length;
    }

    public String toString() {
        return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getArtist() + " - "
                + this.getLength() + " - " + this.getCost();
    }

    @Override
    public void play() {
        for (track track : tracks) {
            track.play();
        }
    }
}