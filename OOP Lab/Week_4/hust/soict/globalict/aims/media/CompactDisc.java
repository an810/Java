package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String arttist;
    private ArrayList<Track> tracks;

    public CompactDisc(String title, String category, String director, int length, float cost, String arttist) {
        super(title, category, director, length, cost);
        this.arttist = arttist;
    }

    public String getArttist() {
        return arttist;
    }
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("The author exists already");
        } else {
            tracks.add(track);
            System.out.println("The author has been added");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            this.tracks.remove(track);
            System.out.println("The author has been removed");
        } else {
            System.out.println("The author does not exist");
        }
    }
    @Override
    public int getLength() {
        int sum = 0;
        for (Track t : tracks) {
            sum += t.getLength();
        }
        return sum;
    }

    @Override
    public void play() {
        for (Track t : tracks) {
            t.play();
        }
    }

}
