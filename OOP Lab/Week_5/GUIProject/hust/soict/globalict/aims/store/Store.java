package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 200;
    public static Scanner scanner = new Scanner(System.in);
    private final ArrayList<Media> itemsInStore = new ArrayList<>();
    private int qtyInStore = 0;
    public void addMedia(Media media) {
        if (itemsInStore.size() < MAX_ITEMS_IN_STORE) {
            if (itemsInStore.contains(media)) {
                System.out.println("The media exists already");
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
        } else {
            System.out.println("The media does not exist");
        }
    }

    public Media searchMediaById(int id) {
        for (Media media : itemsInStore) {
            if (media.getId() == id)
                return media;
        }
        return null;
    }
    public Media searchMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title))
                return media;
        }
        return null;
    }

    public void addBook() {
        System.out.println("----Add Book----");
        System.out.println("Title of the book: ");
        String title = scanner.nextLine().trim();
        System.out.println("Category of the book: ");
        String category = scanner.nextLine().trim();
        System.out.println("Cost of the book: ");
        float cost = scanner.nextFloat();
        scanner.nextLine();
        Book book = new Book(title, category, cost);
        addMedia(book);
    }
    public void addDvd() {
        System.out.println("----Add DVD----");
        System.out.println("Title of the DVD: ");
        String title = scanner.nextLine().trim();
        System.out.println("Category of the DVD: ");
        String category = scanner.nextLine().trim();
        System.out.println("Director of the DVD: ");
        String director = scanner.nextLine().trim();
        System.out.println("Length of the DVD: ");
        int length = scanner.nextInt();scanner.nextLine();
        System.out.println("Cost of the DVD: ");
        float cost = scanner.nextFloat();
        scanner.nextLine();
        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
        addMedia(dvd);
    }
    public void addCd() {
        System.out.println("----Add CD----");
        System.out.println("Title of the CD: ");
        String title = scanner.nextLine().trim();
        System.out.println("Category of the CD: ");
        String category = scanner.nextLine().trim();
        System.out.println("Director of the CD: ");
        String director = scanner.nextLine().trim();
        System.out.println("Length of the CD: ");
        int length = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Cost of the CD: ");
        float cost = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Artist of the CD: ");
        String artist = scanner.nextLine().trim();
        CompactDisc cd = new CompactDisc(title, category, director, length, cost, artist);
        addMedia(cd);
    }
    public void showStore() {
        System.out.println("***********************STORE**********************");
        System.out.println("Items in store:");
        for (int i = 0; i < qtyInStore; i++) {
            System.out.println("ID: " + itemsInStore.get(i).toString());
        }
        System.out.println("**************************************************");
    }


    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
