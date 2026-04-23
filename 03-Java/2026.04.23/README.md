# 📅 2026-04-23 학습 기록

## 1. 📖 배운 내용
- ### 주제 : 예외처리, 익명 객체
  
- ### 단어
- **Unchecked (RuntimeException) - 선택적 처리**
- <Kbd>NullPointerException</kbd> : null인 객체의 메소드나 필드에 접근할 때
- <Kbd>ArrayIndexOutOfBoundsException</kbd> : 배열 인덱스 범위를 초과할 때
- <Kbd>NumberFormatException</kbd> : 숫자로 변환할 수 없는 문자열을 파싱할 때
- <Kbd>ClassCastException</kbd> : 관계 없는 타입으로 강제 캐스팅 할 때
- <Kbd>ArithmeticException</kbd> : 0으로 나누기 등 산술 오류가 발생할 때
- <Kbd>IndexOutOfBoundsException</kbd> : 컬렉션(list 등)의 인덱스 범위를 초과할 때
- <Kbd>IllegalArgumentException</kbd> : 메소드에 부적절한 값(인수)를 전달할 때 -> 직접 throw해서 유효성 검사에 활용
- <Kbd>IllegalStateException</kbd> : 객체의 순서나 상태가 메소드 호툴에 적합하지 않을 때 => 직접 throw해서 상태 검사에 활용
- **Checked (Exception) - 반드시 처리**
- <Kbd>IOException</kbd> : 파일 읽기/ 쓰기 등 입출력 작업 중 오류가 발생할 때
- <Kbd>FileNotFoundException</kbd> : 파일이 존재하지 않을 때
- <Kbd>ClassNotFoundException</kbd> : 클래스 로드에 실패할 때
- <Kbd>SQLException</kbd> : DB 쿼리 실행 중 오류가 발생할 때
- **중첩 객체** : 클래스 안에 클래스를 만들 수 있는 객체
- **중첩 객체** : 이름 없는 객체, 클래스를 별로도 선언하지 않고 즉석에서 만들어 사용함, 인터페이스와 추상클래스를 완벽하게 만들 수 있는 객체
  - **익명 객체 종류**
    - 익명 자식 객체 : 부모 클래스 기반 -> new 부모클래스() {오버라이딩}
    - 익명 구현 객체 : 인터페이스 기반 -> new 인터페이스() {추상 메소드 구현}
- **e.getMessage()** : 예외 메세지만 출력
- **e.printStackTrace()** : 예외 종류 + 메세지 + 발생 위치 출력
- 
- ### 함수
- <Kbd>try-catch</kbd>
```
try {
  //예외가 발생할 수 있는 코드
} catch (예외 클래스 e) {
  //예외 발생 시 실행할 코드
} finally {
  //예외 발생 여부와 관계없이 항상 실행되는 코드(생략 가능)
}
```

- ### 중요 : 롬복

## 2. 📝 오늘의 실습 & 과제
- [`src`](./src)
