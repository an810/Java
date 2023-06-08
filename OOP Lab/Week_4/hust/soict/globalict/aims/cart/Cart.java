package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();
    private float totalCost = 0;

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }

    public void addMedia(Media media) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            if (itemsOrdered.contains(media)) {
                System.out.println("The media exists already");
            } else {
                this.itemsOrdered.add(media); qtyOrdered++;
                System.out.println("The media has been added");
            }
        } else {
            System.out.println("Cart is full");
        }

    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            this.itemsOrdered.remove(media); qtyOrdered--;
            System.out.println("The media has been removed");
        } else {
            System.out.println("The media does not exist");
        }
    }

    public void showCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println("ID: " + (i+1) + " - " + itemsOrdered.get(i).toString());
        }
        this.totalCost = totalCost();
        System.out.println("Total cost: " + this.totalCost);
        System.out.println("**************************************************");
    }

    public void searchID(int id)
    {
        for (int i = 0; i < qtyOrdered; i++)
        {
            if (itemsOrdered.get(i).getId() == id)
            {
                System.out.println(itemsOrdered.get(i).toString());
                return;
            }
        }
        System.out.println("Not found");
    }

    public void sortByTitleCost() {
        this.itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }
    public void sortByCostTitle() {
        this.itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }

    public void placeOrder() {
        System.out.println("--------------------------------");
        System.out.println("Thanks for ");
        System.out.println("--------------------------------");
    }
}
