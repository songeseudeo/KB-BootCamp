package 과제;

public class MultiplicationTableExample {
    public static void main(String[] args) {
        for (int dan = 2; dan <= 9; dan++) {
            System.out.println("*** " + dan + "단 ***");
            for (int su = 1; su <= 9; su++) {
                System.out.println(dan + " x " + su + " = " + (dan * su));
            }
        }
    }
}