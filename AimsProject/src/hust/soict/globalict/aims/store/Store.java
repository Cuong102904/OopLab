package hust.soict.globalict.aims.store;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public ArrayList<Media> takeItemsInStore() {
        return itemsInStore;
    }

    public void addMedia(Media m) {
        if (itemsInStore.contains(m)) {
            System.out.println("This media is contain");
        } else {
            itemsInStore.add(m);
        }
    }

    public void removeMedia(Media m) {
        if (itemsInStore.contains(m)) {
            itemsInStore.remove(m);
        } else {
            System.out.println("Not contain this media");
        }
    }

    public void viewStore() {
        System.out.println("Item in store:");
        System.out.println("------------------------------------------------------------------");
        for (Media dvd : itemsInStore) {
            System.out.println(dvd.toString());
        }
        System.out.println("------------------------------------------------------------------");
    }
}
