package hust.soict.globalict.aims.media;

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
    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
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
