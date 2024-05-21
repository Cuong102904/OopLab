package hust.soict.globalict.test.store;

import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store1 = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.5f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store1.addMedia(dvd1);
        store1.addMedia(dvd2);
        store1.addMedia(dvd3);
        store1.viewStore();
        store1.removeMedia(dvd1);
        store1.viewStore();
    }
}
