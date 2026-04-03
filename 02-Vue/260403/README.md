# 📅 2026-04-03 학습 기록

## 1. 📖 배운 내용
- **주제**: axios 복습, axios 사용한 vue-router 예제
- **함수**
- <Kbd>async-await</kbd>: try-catch 사용
 - async -> 이 함수 안에는 기다려야 할 작업이 있어
 - await -> 기다려야 할 작업 앞에 적으면 작업이 끝날 때까지 넘어가지 않고 기다려줌
  ```
  async function getData() {
  try {
    // 1. 여기서 실행을 시도(try)합니다.
    const data = await fetchData(); 
    console.log("성공!", data);
  } catch (error) {
    // 2. 위에서 에러가 나면 즉시 이쪽(catch)으로 점프합니다.
    console.log("에러 발생!", error);
  }
}
```
- <Kbd>.then</kbd> : catch 사용
  - 포스트잇 방식, 다음 행동을 정의하는 것

## 2. 📝 오늘의 실습 & 과제
- [`수업`](./수업)

## 3. 🌱 오늘의 회고
전에 배웠던 내용이지만 조금 이해가 어려웠는데 오늘 다시 배우면서 async-await는 기다려야 할 작업이 있을 때 쓰고 try-catch로 에러를 잡고 .then은 다음 행동을 포스트잇처럼 붙여서 정의하는 방식이라는 걸 새롭게 알게 됐다.
