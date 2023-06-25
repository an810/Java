package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
    @Override
    public String toString()
    {
        return  this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector()
                + " - " + this.getLength() + ": " + this.getCost() + "$";
    }

    public boolean isMatch(String title) {
        return this.getTitle().equals(title);
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD Length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }
}
