package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        int costCompare = Float.compare(o1.getCost(), o2.getCost());
        if (costCompare == 0) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
        return costCompare;
    }
}
