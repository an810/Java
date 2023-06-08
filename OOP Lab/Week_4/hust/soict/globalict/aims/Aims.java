package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

import java.util.Scanner;

public class Aims {
    public static  Store store = new Store();
    public static  Cart cart = new Cart();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    store.showStore();
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    cart.showCart();
                    cartMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
       } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }
    public static void viewStore() {
        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    cart.showCart();
                    cartMenu();
                    break;
                case 0:
                    showMenu();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while(choice != 0);
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

    public static void seeMediaDetails() {
        System.out.println("Please enter the title of the media");
        String title = scanner.nextLine();
        Media media = store.searchMediaByTitle(title);
        if (media != null) {
            int choice;
            do {
                mediaDetailsMenu();
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        cart.addMedia(media);
                        storeMenu();
                        break;
                    case 2:
                        playMedia();
                        storeMenu();
                        break;
                    case 0:
                        storeMenu();
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } while (choice != 0);
        } else {
            System.out.println("The media is not found");
        }
    }

    public static void addMediaToCart() {
        System.out.println("Please enter the title of the media");
        String title = scanner.nextLine();
        Media media = store.searchMediaByTitle(title);
        cart.addMedia(media);
    }

    public static void playMedia() {
        System.out.println("Please enter the title of the media");
        String title = scanner.nextLine();
        Media media = store.searchMediaByTitle(title);
        if (!(media instanceof Book)) {
            System.out.println("Cannot play this media");
        }
        if (media instanceof DigitalVideoDisc) {
            DigitalVideoDisc disc = (DigitalVideoDisc) media;
            if(disc.getLength() < 0) {
                System.out.println("Cannot play this disc");
            } else {
                disc.play();
            }
        }
        if (media instanceof CompactDisc) {
            CompactDisc disc = (CompactDisc) media;
            if (disc.getLength() < 0) {
                System.out.println("Cannot play this disc");
            } else {
                disc.play();
            }
        }
    }
    public static void updateStoreMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void updateStore() {
        int choice;
        do {
            updateStoreMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                case 2:
                case 0:
                    showMenu();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }


}
