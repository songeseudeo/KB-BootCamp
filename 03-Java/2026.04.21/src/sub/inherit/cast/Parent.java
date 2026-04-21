package sub.inherit.cast;

public class Parent {
    private String field1;

    public String getField1()            { return field1; }
    public void   setField1(String f)    { this.field1 = f; }

    public void method1() { System.out.println("Parent-method1()"); }
    public void method2() { System.out.println("Parent-method2()"); }
}
