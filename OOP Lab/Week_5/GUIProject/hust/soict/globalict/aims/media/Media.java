package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Media {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;
    public static int nbMedia = 0;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Media(String title, String category, float cost) {
        this.id = ++nbMedia;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        try {
            if (!(o instanceof Media)) {
                return false;
            }
            Media obj = (Media) o;
            return this.title.compareTo(obj.getTitle()) == 0;
        } catch (NullPointerException | ClassCastException e) {
            throw e;
        }

    }

    @Override
    public String toString() {
        return this.id + " - " + this.title + " - " + this.category + " - " + this.cost + "$\n";
    }


//    public void play(Media media) throws PlayerException {
//        if (media instanceof DigitalVideoDisc) {
//            DigitalVideoDisc disc = (DigitalVideoDisc) media;
//            if(disc.getLength() < 0) {
//                System.out.println("Cannot play this disc");
//            } else {
//                disc.play();
//            }
//        }
//        if (media instanceof CompactDisc) {
//            CompactDisc disc = (CompactDisc) media;
//            if (disc.getLength() < 0) {
//                System.out.println("Cannot play this disc");
//            } else {
//                disc.play();
//            }
//        }
//    }
}
