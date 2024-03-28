public class Aims {
    public static void main(String[] args) throws Exception {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        // anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        // anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        // anOrder.addDigitalVideoDisc(dvd3);
        anOrder.addDigitalVideoDisc(new DigitalVideoDisc[] { dvd1, dvd2, dvd3 });
        anOrder.removeDIgitalVideoDisc(dvd3);

        System.out.println(String.format("%-5s %-15s %s", dvd1.getId(), dvd1.getTitle(), dvd1.getCost()));
        System.out.println(String.format("%-5s %-15s %s", dvd2.getId(), dvd2.getTitle(), dvd2.getCost()));
        System.out.println(String.format("%-5s %-15s %s", dvd3.getId(), dvd3.getTitle(), dvd3.getCost()));

        System.out.println(String.format("%-5s %-15s %s", "", "Total", anOrder.totalCost()));

    }
}