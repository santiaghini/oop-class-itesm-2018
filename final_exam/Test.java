public class Test{
    public static void main(String[] args) {
        Date date = new Date(65,11,2018);
        System.out.println(date.toString());

        date.setDay(1);
        System.out.println(date.toString());
        date.add(0, 1, 0);
        System.out.println(date.toString());

        Date date2 = new Date(8,12,2019);
        System.out.println(date2.toString());
        date2.add(0, 12, 0);
        System.out.println(date2.toString());
    }
}
