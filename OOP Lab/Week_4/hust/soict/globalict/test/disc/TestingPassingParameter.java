//package hust.soict.globalict.test.disc;
//
//
//import hust.soict.globalict.aims.media.DigitalVideoDisc;
//
//class  DVDWrapper {
//    DigitalVideoDisc d;
//
//    public DVDWrapper(DigitalVideoDisc d) {
//        this.d = d;
//    }
//}
//
//public class TestingPassingParameter {
//    public static void main(String[] args) {
//        //TO DO Auto-generated method stub
//        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
//        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
//
//        // Testing swap
//        swap(jungleDVD, cinderellaDVD);
//        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
//        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
//
//        // Correct swap
//        DVDWrapper d1 = new DVDWrapper(jungleDVD);
//        DVDWrapper d2 = new DVDWrapper(cinderellaDVD);
//        correctSwap(d1, d2);
//        System.out.println("jungle dvd title: " + d1.d.getTitle());
//        System.out.println("cinderella dvd title: " + d2.d.getTitle());
//
//        changeTitle(jungleDVD, cinderellaDVD.getTitle());
//        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
//    }
//    public static void swap(Object o1, Object o2) {
//        Object tmp = o1;
//        o1 = o2;
//        o2 = tmp;
//    }
//
//    public static void correctSwap(DVDWrapper d1, DVDWrapper d2) {
//        DigitalVideoDisc tmp = d1.d;
//        d1.d = d2.d;
//        d2.d = tmp;
//    }
//
//    public static void changeTitle(DigitalVideoDisc dvd, String title) {
//        String oldTitle = dvd.getTitle();
//        dvd.setTitle(title);
//        dvd = new DigitalVideoDisc(oldTitle);
//    }
//}
