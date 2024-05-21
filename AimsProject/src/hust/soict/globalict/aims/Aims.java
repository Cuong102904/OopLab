package hust.soict.globalict.aims;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.disc.Playable;
import hust.soict.globalict.aims.disc.Track;
import hust.soict.globalict.aims.disc.CompactDisc;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.*;

public class Aims {
    private static Scanner scanner = new Scanner(System.in);
    public static Store store = new Store();
    public static Cart cart = new Cart();

    public static void main(String[] args) throws Exception {

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        showMenu();
    }

    public static void showMenu() {
        while (true) {
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");

            int i = scanner.nextInt();
            scanner.nextLine();
            switch (i) {
                case 1:
                    store.viewStore();
                    storeMenu();
                    break;
                case 2:
                    updateStoreMenu();
                    break;
                case 3:
                    cart.print();
                    cartMenu();
                    break;
                case 0:
                    System.out.println("You're exited");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    public static void storeMenu() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            int i = scanner.nextInt();
            scanner.nextLine();
            switch (i) {
                case 0:
                    return;
                case 1:
                    System.out.println("Enter the title of media: ");
                    boolean isinCart = false;
                    String title = scanner.nextLine();
                    for (var item : store.takeItemsInStore()) {
                        if (item.getTitle().equalsIgnoreCase(title)) {
                            System.out.println(item.toString());
                            isinCart = true;
                            while (true) {
                                mediaDetailsMenu();
                                int choiceDetailsMenu = scanner.nextInt();
                                scanner.nextLine();
                                switch (choiceDetailsMenu) {
                                    case 1:
                                        cart.addMedia(item);
                                        break;
                                    case 2:
                                        if (item instanceof Playable) {
                                            ((Playable) item).play();
                                        } else {
                                            System.out.println("This media is not playable");
                                        }
                                        break;
                                    case 0:
                                        return;
                                    default:
                                        System.out.println("Invalid choice. Please choose again.");
                                }
                            }
                        }
                    }
                    if (!isinCart) {
                        System.out.println("Not found the media");
                    }
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playAMedia();
                    break;
                case 4:
                    cart.print();
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    public static void updateStoreMenu() {
        while (true) {
            System.out.println("Options:");
            System.out.println("------------------------------------------------------------------");
            System.out.println("1. Add a media to store");
            System.out.println("2. Remove a media from store");
            System.out.println("0. Back");
            System.out.println("------------------------------------------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            int choiceOfUpdateStore = scanner.nextInt();
            scanner.nextLine();
            switch (choiceOfUpdateStore) {
                case 1:
                    UpdateStore.addAMedia();
                    break;
                case 2:
                    UpdateStore.removeMedia();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter media in cart");
            System.out.println("2. Sort media in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");
            int CarChoice = scanner.nextInt();
            scanner.nextLine();
            switch (CarChoice) {
                case 1:
                    System.out.println("Enter type of filter: (1.Title, 2.ID)");
                    int choiceFilter = scanner.nextInt();
                    scanner.nextLine();
                    if (choiceFilter == 1) {
                        System.out.println("Enter the title:");
                        String title = scanner.nextLine();
                        cart.printSearchCartbyTitle(title);
                    } else if (choiceFilter == 2) {
                        System.out.println("Enter the id:");
                        int id = scanner.nextInt();
                        cart.printSearchCartbyID(id);
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 2:
                    System.out.println("Enter type of sort: (1.Title, 2.Cost)");
                    int choiceSort = scanner.nextInt();
                    scanner.nextLine();
                    if (choiceSort == 1) {
                        Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
                    } else if (choiceSort == 2) {
                        Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 3:
                    System.out.println("Enter the id of media int cart to remove");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    boolean isincart = false;
                    for (var items : cart.getItemsOrdered()) {
                        if (items.getID() == id) {
                            cart.removeMedia(items);
                            isincart = true;
                        }
                    }
                    if (!isincart) {
                        System.out.println("Can not find media with ID =" + id);
                    }
                    break;
                case 4:
                    System.out.println("Enter the id of media");
                    int mediaID = scanner.nextInt();
                    scanner.nextLine();
                    for (var items : cart.getItemsOrdered()) {
                        if (items.getID() == mediaID) {
                            if (items instanceof Playable) {
                                ((Playable) items).play();
                            } else {
                                System.out.println("This media is not playable");
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("Your order is prepared.");
                    cart = new Cart();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    public static void addMediaToCart() {
        System.out.println("Enter the title of media:");
        String title = scanner.nextLine();
        for (var items : store.takeItemsInStore()) {
            if (items.getTitle().equalsIgnoreCase(title)) {
                cart.addMedia(items);
                System.out.println("Added to cart: " + items.getTitle());
                return;
            }
        }
        System.out.println("Media not found in store.");
    }

    public static void playAMedia() {
        System.out.println("Enter the title of media:");
        String title = scanner.nextLine();
        for (var items : store.takeItemsInStore()) {
            if (items.getTitle().equalsIgnoreCase(title)) {
                if (items instanceof Playable) {
                    ((Playable) items).play();
                } else {
                    System.out.println("The media can't play");
                }
                return;
            }
        }
        System.out.println("Media not found in store.");
    }

    private static class UpdateStore {
        public static void addAMedia() {
            System.out.println("1. Book\t 2. Dis\t 3.CD\n");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter the title of book: ");
                    String Booktitle = scanner.nextLine();

                    System.out.println("Enter the title of category: ");
                    String Bookcategory = scanner.nextLine();

                    System.out.println("Enter the cost of book: ");
                    float Bookcost = scanner.nextFloat();
                    scanner.nextLine();

                    System.out.println("Enter the author(s) of the book (separate with semicolon if more than two):");
                    String Bookauthor = scanner.nextLine();

                    ArrayList<String> Bookaurthor = new ArrayList<>(List.of(Bookauthor.split(";")));
                    Book book = new Book(Booktitle, Bookcategory, Bookcost, Bookaurthor);
                    store.addMedia(book);
                    break;
                case 2:
                    System.out.println("Enter the title of DVD:");
                    String DVDTitle = scanner.nextLine();

                    System.out.println("Enter the category of DVD:");
                    String DVDCategory = scanner.nextLine();

                    System.out.println("Enter the director of DVD:");
                    String DVDDirector = scanner.nextLine();

                    System.out.println("Enter the cost of DVD:");
                    float DVDCost = scanner.nextFloat();
                    scanner.nextLine();

                    System.out.println("Enter the length of DVD:");
                    int DVDlength = scanner.nextInt();
                    scanner.nextLine();

                    DigitalVideoDisc dvd = new DigitalVideoDisc(DVDTitle, DVDCategory, DVDDirector, DVDlength, DVDCost);
                    store.addMedia(dvd);
                    break;
                case 3:
                    System.out.println("Enter the title of CD:");
                    String CDtitle = scanner.nextLine();

                    System.out.println("Enter the category of CD:");
                    String CDcategory = scanner.nextLine();

                    System.out.println("Enter the artist of CD:");
                    String CDartist = scanner.nextLine();

                    System.out.println("Enter the cost of CD: ");
                    float CDcost = scanner.nextFloat();
                    scanner.nextLine();
                    CompactDisc cd = new CompactDisc(CDtitle, CDcategory, CDartist, CDcost);
                    System.out.println("Enter the number of tracks in CD:");
                    int numTrack = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < numTrack; i++) {
                        System.out.println("Enter the title of track:");
                        String TrackTitle = scanner.nextLine();
                        System.out.println("Enter the length of track");
                        int Tracklength = scanner.nextInt();
                        scanner.nextLine();
                        Track track = new Track(TrackTitle, Tracklength, CDartist);
                        cd.addTrack(track);
                    }
                    store.addMedia(cd);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }

        public static void removeMedia() {
            System.out.println("Enter the title of media that you want to remove:");
            String MediaTitle = scanner.nextLine();
            for (var items : store.takeItemsInStore()) {
                if (items.getTitle().equalsIgnoreCase(MediaTitle)) {
                    store.removeMedia(items);
                    System.out.println("Removed from store: " + items.getTitle());
                    return;
                }
            }
            System.out.println("Media not found in store.");
        }
    }
}
