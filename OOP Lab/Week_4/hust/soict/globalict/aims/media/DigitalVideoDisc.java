package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
    @Override
    public String toString()
    {
        return  "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector()
                + " - " + this.getLength() + ": " + this.getCost() + "$";
    }

    public boolean isMatch(String title) {
        return this.getTitle().equals(title);
    }

    @Override
    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD Length: " + this.getLength());
    }
}
