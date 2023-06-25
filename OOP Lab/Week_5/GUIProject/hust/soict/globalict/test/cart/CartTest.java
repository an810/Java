package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

import javax.naming.LimitExceededException;

public class CartTest {
    public static void main(String[] args) throws LimitExceededException {
        // Create a new cart
        Cart cart = new Cart();
        Media media1 = new Book("An", "truyen", 12);
        Media media2 = new DigitalVideoDisc("spider", "phim", "mv", 120,12);
        Media media3 = new Book("Anh", "truyen", 102);

        cart.addMedia(media1);
        cart.addMedia(media2);
        cart.addMedia(media3);

        cart.sortByTitleCost();
        cart.showCart();
        cart.sortByCostTitle();
        cart.showCart();
    }
}
