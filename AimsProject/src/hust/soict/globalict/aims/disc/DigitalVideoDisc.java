package hust.soict.globalict.aims.disc;

public class DigitalVideoDisc extends Disc implements Playable {

    private String director;
    private int length;

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        super(category, title, cost);

    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(director, category, title, cost);

    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    public boolean isMatch(String title) {
        return getTitle().equalsIgnoreCase(title);
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("DVD - ")
                .append(getTitle())
                .append(" - ")
                .append(getCategory())
                .append(" - ")
                .append(director != null ? director : "Unknown")
                .append(" - ")
                .append(length != 0 ? length + " min" : "Unknown")
                .append(" : ")
                .append(getCost())
                .append("$");
        return str.toString();
    }

    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
