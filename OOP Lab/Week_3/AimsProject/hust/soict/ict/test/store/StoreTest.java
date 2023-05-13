package Week_3.AimsProject.hust.soict.ict.test.store;

import Week_3.AimsProject.hust.soict.ict.aims.disc.DigitalVideoDisc;
import Week_3.AimsProject.hust.soict.ict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addDVD(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addDVD(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 19.95f);
        store.addDVD(dvd3);
        store.print();
        store.removeDVD(dvd1);
        store.print();
    }
}
