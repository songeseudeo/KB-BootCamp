package lamda;

public class MethodReferenceExample {
    public static void main(String[] args) {
        Person3 person = new Person3();
        person.action((double x, double y) -> x + y);
        person.action(Computer :: staticMethod);
        Computer computer = new Computer();
        person.action(computer :: instanceMethod);
    }
}
