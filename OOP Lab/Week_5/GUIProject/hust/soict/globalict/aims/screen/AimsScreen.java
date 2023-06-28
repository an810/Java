package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;

import java.util.ArrayList;

public class AimsScreen {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation"
                , "Roger Allers", 87, 19.95f);


        Book book = new Book("Doraemon", "Comics", (float) 12.00);
        book.addAuthor("Mai Duc An");


        store.addMedia(dvd);
        store.addMedia(book);

        new StoreScreen(store, cart);
    }
}
