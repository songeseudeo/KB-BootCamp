package com.kb.chap06n.makeclass.f_check.field;

public class Run {
    public static void main(String[] args) {


        FieldTest f1  = new FieldTest();
       FieldTest f2 = new FieldTest();
        f1.test(20);
        System.out.println("=== f1.test(10) ===");
        f1.test(10);

        System.out.println("=== f2.test(20) ===");
        f2.test(20);

        System.out.println("=== f1.test(30) ===");
        f1.test(30);


        System.out.println(FieldTest.count); // static 이기 때문에 클래스명.필드명으로 호출

    }
}
