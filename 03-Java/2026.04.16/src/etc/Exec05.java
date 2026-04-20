package com.multi.d_etc;
// =========================================
// String 클래스 주요 메소드
// =========================================
// String 클래스는 java.lang 패키지에 포함되어 있으며
// 문자열을 다루기 위한 다양한 메소드를 제공한다.
//
// String 객체는 불변(Immutable) 객체이다.
// 항상 새로운 String 객체를 생성한다.
//
// 공식 문서:
// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html
// =========================================

import java.util.Scanner;

public class Exec05 {
    public static void main(String[] args) {

        // -----------------------------------------
        // 1. length() : 문자열 길이
        // -----------------------------------------
        // length()는 문자열의 문자 개수를 int 값으로 반환한다.
        // 공백도 하나의 문자로 계산된다.

        String ssn = "7306241230123";
        int length = ssn.length();

        if (length == 13) {
            System.out.println("주민번호 자리수가 맞습니다.");
        } else {
            System.out.println("주민번호 자리수가 틀립니다.");
        }

        // -----------------------------------------
        // 2. substring() : 문자열 추출
        // -----------------------------------------
        // substring(beginIndex, endIndex)
        // - beginIndex 포함
        // - endIndex 미포함
        //
        // substring(beginIndex)
        // - beginIndex부터 끝까지 추출

        String firstNum = ssn.substring(0, 6);
        System.out.println(firstNum); // 앞 6자리

        String secondNum = ssn.substring(7);
        System.out.println(secondNum); // 7번 인덱스부터 끝까지

        // -----------------------------------------
        // 3. indexOf() : 문자열 위치 찾기
        // -----------------------------------------
        // indexOf(문자열)
        // - 문자열이 처음 등장하는 위치(인덱스)를 반환
        // - 찾지 못하면 -1 반환

        String subject = "자바 프로그래밍";

        int location = subject.indexOf("프로그래밍");
        System.out.println(location);

        String substring = subject.substring(location);
        System.out.println(substring);

        location = subject.indexOf("자바");

        if (location != -1) {
            System.out.println("자바와 관련된 책이군요");
        } else {
            System.out.println("자바와 관련없는 책이군요");
        }

        // -----------------------------------------
        // 4. contains() : 포함 여부 확인
        // -----------------------------------------
        // contains(문자열)
        // - 해당 문자열이 포함되어 있으면 true
        // - 포함되어 있지 않으면 false
        //
        // indexOf() >= 0 과 같은 의미지만
        // 가독성은 contains()가 더 좋다.

        boolean result = subject.contains("자바");

        if (result) {
            System.out.println("자바와 관련된 책이군요");
        } else {
            System.out.println("자바와 관련없는 책이군요");
        }

        // -----------------------------------------
        // 5. replace() : 문자열 치환
        // -----------------------------------------
        // replace(old, new)
        // - 문자열 내의 특정 문자열을 다른 문자열로 변경
        // - 원본 문자열은 변경되지 않는다.
        // - 변경된 새로운 String 객체를 반환한다.

        String oldStr = "자바 문자열은 불변입니다. 자바 문자열은 String입니다.";
        String newStr = oldStr.replace("자바", "JAVA");

        System.out.println(oldStr); // 원본 그대로
        System.out.println(newStr); // 변경된 새 문자열

        // -----------------------------------------
        // 정리
        // -----------------------------------------
        // length()    : 문자열 길이
        // substring() : 문자열 추출
        // indexOf()   : 위치 검색 (-1 주의)
        // contains()  : 포함 여부 확인
        // replace()   : 문자열 치환 (불변성 주의)




        Scanner sc = new Scanner(System.in);

        // =====================================
        // 문제 1. // 이메일을 입력받아 '@'가 포함되어 있는지 검사하시오.
        // =====================================
        System.out.print("[문제1] 이메일 입력 : ");
        String email = sc.nextLine();

        if (email.contains("@")) {
            System.out.println("올바른 이메일 형식입니다.");
        } else {
            System.out.println("'@'가 포함되지 않은 이메일입니다.");
        }

        System.out.println("--------------------------------");

        // =====================================
        // 문제 2. 파일명에서 확장자 추출
        // 파일명을 입력받아 확장자(.jpg, .png 등)를 출력하시오.
        // =====================================
        System.out.print("[문제2] 파일명 입력 : ");
        String fileName = sc.nextLine();

        int dotIndex = fileName.lastIndexOf('.');

        if (dotIndex != -1 && dotIndex != fileName.length() - 1) {
            String extension = fileName.substring(dotIndex + 1);
            System.out.println("확장자 : " + extension);
        } else {
            System.out.println("확장자가 없는 파일입니다.");
        }

        System.out.println("--------------------------------");

        // =====================================
        // 문제 3. 문자열 앞 3글자 출력
        // 단, 길이가 3 미만이면 안내 메시지 출력
        // =====================================
        System.out.print("[문제3] 문자열 입력 : ");
        String text = sc.nextLine();

        if (text.length() < 3) {
            System.out.println("문자열의 길이가 3보다 작습니다.");
        } else {
            String result1 = text.substring(0, 3);
            System.out.println("앞 3글자 : " + result1);
        }

        sc.close();
    }
}
