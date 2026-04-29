package sub.lambda;

public class Run {
    public static void main(String[] args) {
        new A_Lambda().method1();

        Calculable calc = new Calculable() {
            @Override
            public void calculate(int x, int y) {
                System.out.println("익명객체결과:" + x + y);
            }
        };
        calc.calculate(10, 3);

        Calculable calc2 = (x, y) -> {
            System.out.println("람다 결과:" + x + y);
        };
        calc2.calculate(10, 3);

        action(new Calculable() {
            @Override
            public void calculate(int x, int y) {
                int result = x - y;
                System.out.println("익명 전달:" + result);
            }
        });

        action((x, y) -> {
            int result = x - y;
            System.out.println("람다 전달:" + result);
        });

        Person person = new Person();
        person.workAction(() -> {
            System.out.println("출근");
            System.out.println("코딩");
        });
        person.workAction(() -> System.out.println("출근"));

        person.speakAction(word -> {
            System.out.println(word);
            System.out.println("라고 말함");
        });
        person.speakAction(word -> System.out.println("\"" + word + "\"라고 말함."));

        person.calcAction((x, y) -> {
            double result = x + y;
            return result;
        });

        person.calcAction((x, y) -> x * y);

        person.calcAction((x, y) -> sum(x, y));

        //람다식은 자체가 타입을 가지는 게 아니고 타겟 타입에 의해서 의미가 결정된다
        //매개변수 시그니처, 반환타입이 같으면 함수형 인터페이스 어디든 대입 가능
        Workable workable = () -> System.out.println("hi");
        Runnable runnable = () -> System.out.println("hi");

        workable.work();
        runnable.run();
    }

    private static void action(Calculable calculable) {
        calculable.calculate(10, 4);
    }

    public static double sum(double x, double y) {
        return x + y;
    }
}