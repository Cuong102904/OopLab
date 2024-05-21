package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.disc.*;
import hust.soict.globalict.aims.cart.*;

public class CartTest {
        public static void main(String[] args) {
                Cart cart = new Cart();

                DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
                DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.5f);
                DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
                cart.addMedia(dvd1);
                cart.addMedia(dvd2);
                cart.addMedia(dvd3);
                cart.print();
                cart.printSearchCartbyID(1);
                cart.printSearchCartbyTitle("The Lion King");

        }

}
