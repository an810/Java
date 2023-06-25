package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    // Collections.sort(media, Comparator.comparing(Media::getCost).thenComparing(Media::getTitle));
    @Override
    public int compare(Media media1, Media media2) {
        int result = Float.compare(media1.getCost(), media2.getCost());
        if (result == 0) {
            return media1.getTitle().compareTo(media2.getTitle());
        }
        return result;
    }
}
