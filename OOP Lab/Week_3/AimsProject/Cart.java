package Week_3.AimsProject;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
            return;
        }
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("The disc has been added");
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean check = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i+1; j < qtyOrdered; j++) {
                    itemsOrdered[j-1] = itemsOrdered[j];
                };
                qtyOrdered--;
                check = true;
                System.out.println("The disc has been removed");
                break;
            }
        }
        if (!check) {
            System.out.println("The disc has not been found");
        }
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        int dvdListLength = dvdList.length;
        if (qtyOrdered + dvdListLength > MAX_NUMBERS_ORDERED || qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("There is not enough space in cart");
        } else {
            for (int i = 0; i < dvdListLength; i++) {
                itemsOrdered[qtyOrdered] = dvdList[i];
                qtyOrdered++;
            }
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered == MAX_NUMBERS_ORDERED || qtyOrdered + 2 > MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
            return;
        }
        itemsOrdered[qtyOrdered] = dvd1; qtyOrdered++;
        itemsOrdered[qtyOrdered] = dvd2; qtyOrdered++;
        System.out.println("The discs have been added");
    }


}
