package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable{
    private int length;
    private String title;

    public Track(String title, int length){
        this.title = title;
        this.length = length;
    }
    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Track)) {
            return false;
        }
        Track obj = (Track) o;
        return this.title.compareTo(obj.getTitle()) == 0 && this.length == obj.getLength();
    }
}
