package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc itemsInStore[];
    private int maxSize;
    private int currentIndex;

    public Store(int maxSize) {
        this.maxSize = maxSize;
        itemsInStore = new DigitalVideoDisc[maxSize];
        currentIndex = 0;
    }

    public void addDVD(DigitalVideoDisc dvd) {
        if (currentIndex < maxSize) {
            itemsInStore[currentIndex] = dvd;
            currentIndex++;
            System.out.println("DVD added to the store.");
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    public void removeDVD(int IDdvd) {
        if (IDdvd >= 0 && IDdvd < currentIndex) {
            itemsInStore[IDdvd] = null;
            for (int i = IDdvd; i < currentIndex - 1; i++) {
                itemsInStore[i] = itemsInStore[i + 1];
            }
            itemsInStore[currentIndex - 1] = null;
            currentIndex--;
            System.out.println("DVD removed from the store.");
        } else {
            System.out.println("Invalid index. No DVD removed.");
        }
    }
}
