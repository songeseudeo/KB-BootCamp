/*
Node.js 모듈 방식 정리
프로그램이 커지면 코드가 길어지고 관리하기 어려워진다.
그래서 기능별로 파일을 나누어 관리한다.
이렇게 기능별로 나눈 파일을 "모듈(module)"이라고 한다.
Node.js에서는 두 가지 모듈 방식을 사용할 수 있다.

1. CommonJS
2. ES Module

이 두 방식은 모듈을 가져오는 방법과 내보내는 방법이 다르다.

출처
MDN JavaScript Modules
https://developer.mozilla.org/ko/docs/Web/JavaScript/Guide/Modules
*/

const users = require('./user-1.js')
const helloFunc = require('./hello.js')
console.log(users)

helloFunc(users.user1) //객체명.속성명
helloFunc(users.user2)

/*
----------------------------------------
구조 분해 할당 (Destructuring)
----------------------------------------
객체에서 필요한 값만 바로 꺼낼 수 있다.
*/

const {user1, user2} = require('./user-1.js')

console.log(user1)
console.log(user2)

/*
----------------------------------------
이름 변경해서 가져오기
----------------------------------------
구조 분해 할당에서는
변수 이름을 변경해서 사용할 수 있다.
문법
{ 기존이름 : 새이름 }
*/

const { user1: firstUser } = require('./user-1');

helloFunc(firstUser);