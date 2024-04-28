package hust.soict.globalict.test.store;

import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.displayStore();
        System.out.println();
        store.removeMedia(dvd1);
        store.displayStore();
    }
}