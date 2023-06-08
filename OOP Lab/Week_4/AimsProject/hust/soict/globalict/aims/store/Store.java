package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 200;
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    private int qtyInStore = 0;
    public void addMedia(Media media) {
        if (itemsInStore.size() < MAX_ITEMS_IN_STORE) {
            if (itemsInStore.contains(media)) {
                System.out.println("The media exists already");
                return;
            } else {
                this.itemsInStore.add(media); qtyInStore++;
                System.out.println("The media has been added");
            }
        } else {
            System.out.println("Store is full");
        }

    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            this.itemsInStore.remove(media); qtyInStore--;
            System.out.println("The media has been removed");
            return;
        } else {
            System.out.println("The media does not exist");
        }
    }
    public void showStore() {
        System.out.println("***********************STORE**********************");
        System.out.println("Items in store:");
        for (int i = 0; i < qtyInStore; i++) {
            System.out.println("ID: " + (i+1) + " - " + itemsInStore.get(i).toString());
        }
        System.out.println("**************************************************");
    }


}
