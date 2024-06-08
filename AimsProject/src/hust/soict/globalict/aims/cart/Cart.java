package hust.soict.globalict.aims.cart;

//import java.util.ArrayList;
//import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import hust.soict.globalict.aims.media.Media;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    // private List<Media> itemsOrdered = new ArrayList<>();
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media m) {
        if (itemsOrdered.contains(m)) {
            System.out.println("This media is contain");
        } else {
            itemsOrdered.add(m);
        }
    }

    public void removeMedia(Media m) {
        if (itemsOrdered.contains(m)) {
            itemsOrdered.remove(m);
        } else {
            System.out.println("Not contain this media");
        }
    }

    public float totalCost() {
        float totalCost = 0;
        for (Media media : itemsOrdered) {
            totalCost += media.getCost();
        }
        return totalCost;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int i = 1;
        for (Media media : itemsOrdered) {
            System.out.println(i + ".DVD - " + media.toString());
            i++;
        }
        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("***************************************************");
    }

    public void printSearchCartbyID(int id) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.getID() == id) {
                m.toString();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not found");
        }
    }

    public void printSearchCartbyTitle(String title) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (((DigitalVideoDisc) m).isMatch(title)) {
                System.out.println(m.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match is found");
        }
    }

}
