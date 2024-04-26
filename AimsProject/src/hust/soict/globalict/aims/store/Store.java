package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.media.Media;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Store {
    private static ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("Media already exists!");
        } else {
            itemsInStore.add(media);
            System.out.println("Media added!");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Media removed!");
        } else {
            System.out.println("Media does not exist!");
        }
    }

    public void displayStore() {
        System.out.println("***********************STORE***********************");
        System.out.println("Items in store:");
        int i = 1;
        for (Media item : itemsInStore) {
            System.out.println(i + ". DVD - " + item.getTitle() + " - " + item.getCategory() + " - " + ": "
                    + item.getCost() + "$");
            i++;
        }
        System.out.println("***************************************************");
    }

    public Map<String, Media> getItemsInStore() {
        Map<String, Media> mediaMap = itemsInStore.stream()
                .collect(Collectors.toMap(Media::getTitle, Function.identity()));
        return mediaMap;
    }
}