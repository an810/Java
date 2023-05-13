package Week_3.AimsProject.hust.soict.globalict.aims.store;

import Week_3.AimsProject.hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 200;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int qtyInStore = 0;
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore == MAX_ITEMS_IN_STORE) {
            System.out.println("The store is full");
        } else {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
        }
    }
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean check = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                for (int j = i+1; j < qtyInStore; j++) {
                    itemsInStore[j-1] = itemsInStore[j];
                };
                qtyInStore--;
                check = true;
                System.out.println("The disc has been removed");
                break;
            }
        }
        if (!check) {
            System.out.println("The disc has not been found");
        }
    }

    public void print() {
        System.out.println("***********************STORE**********************");
        System.out.println("Items in store:");
        for (int i = 0; i < qtyInStore; i++) {
            System.out.println(itemsInStore[i].toString());
        }
        System.out.println("**************************************************");
    }


}
