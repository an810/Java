package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.Iterator;

public class CompactDisc extends Disc implements Playable{
    private String arttist;
    private ArrayList<Track> tracks;
    private Track track;

    public CompactDisc(String title, String category, String director, int length, float cost, String arttist) {
        super(title, category, director, length, cost);
        this.arttist = arttist;
    }
    public CompactDisc(String title, String category, String director, int length, float cost, String arttist,Track track) {
        super(title, category, director, length, cost);
        this.arttist = arttist;
        this.track = track;
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
//        int sum = 0;
//        for (Track t : tracks) {
//            sum += t.getLength();
//        }
//        return sum;
        return track.getLength();
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()) {
                nextTrack = (Track) iter.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-possitive!");
        }
    }

}
