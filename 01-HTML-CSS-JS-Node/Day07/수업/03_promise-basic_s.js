/*
03_promise-basic

Promise

비동기 작업을 처리할 때 콜백 함수를 사용할 수 있다.
하지만 콜백 함수가 계속 중첩되면 코드가 복잡해지는 문제가 발생한다.
이를 "Callback Hell"이라고 한다.

이 문제를 해결하기 위해 ES6(ECMAScript 2015)에서
Promise 객체가 도입되었다.

Promise는 비동기 작업의 완료(성공) 또는 실패 결과를 나타내는 객체이다.

출처
MDN Promise
https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Promise
*/


/*
----------------------------------------
1. Promise 기본 개념
----------------------------------------

Promise는 비동기 작업의 완료 또는 실패를 나타낸다.

Promise 상태(state)

1. pending
작업 진행 중

2. fulfilled
작업 성공 (resolve 호출)

3. rejected
작업 실패 (reject 호출)

pending 상태에서
fulfilled 또는 rejected 상태로 변경된다.
*/


/*
----------------------------------------
2. Promise 기본 구조
----------------------------------------

new Promise((resolve, reject) => {

    비동기 작업

    성공하면
    resolve(결과)

    실패하면
    reject(에러)

})

resolve → 작업 성공
reject → 작업 실패


참고

실제 개발에서는 Promise를 직접 생성하는 경우가 많지 않다.

보통은 이미 Promise를 반환하는 API를 사용한다.

예
fetch()  → 서버 API 요청
axios()  → HTTP 요청 라이브러리
database query
파일 읽기

하지만 다음과 같은 경우에는
new Promise()를 직접 만들어 사용할 수 있다.

- 기존 callback 기반 함수를 Promise 방식으로 바꿀 때
- setTimeout 같은 비동기 작업을 Promise로 감쌀 때
- 파일을 비동기로 로드할 때
- 사용자 정의 비동기 작업을 만들 때
*/


/*
----------------------------------------
3. Promise 실행 흐름
----------------------------------------

setTimeout은 비동기 함수이다.

타이머가 끝날 때까지 기다리지 않고
다음 코드가 먼저 실행된다.

그래서 타이머가 끝난 후 실행해야 하는 코드를
콜백 함수나 Promise 등을 통해 작성한다.

Promise를 사용해도 setTimeout 같은 비동기 작업은
바로 끝나지 않기 때문에 실행 순서는 다음과 같다.

A
C
B
*/


console.log("A");

const promiseFlow = new Promise((resolve) => {

    setTimeout(() => {
        resolve("B");
    }, 2000);

});

promiseFlow.then(result => {
    console.log(result);
});

console.log("C");

/*
출력

A
C
(2초 후)
B
*/


/*
----------------------------------------
4. Promise 예제
----------------------------------------

new Promise()가 생성되는 순간
내부 코드는 바로 실행된다.

then()이 Promise를 실행시키는 것이 아니다.
*/

const promise1 = new Promise((resolve, reject) => {

    console.log("작업 시작");

    setTimeout(() => {

        resolve("작업 완료");

    }, 2000);

});

promise1.then(result => {

    console.log(result);

});

/*
실행 결과

작업 시작
(2초 후)
작업 완료
*/


/*
----------------------------------------
5. then() 메소드
----------------------------------------

then()

Promise가 성공(resolve)했을 때 실행되는 함수이다.


then()은 새로운 Promise를 반환하므로
여러 개를 연결해서 사용할 수 있다.
*/

const promise2 = new Promise((resolve, reject) => {

    setTimeout(() => {

        resolve("데이터 조회 완료");

    }, 2000);

});

promise2.then(result => {

    console.log(result);

});

/*
----------------------------------------
5-1. Promise 체이닝 (Chaining)
----------------------------------------

then()은 새로운 Promise를 반환하기 때문에
여러 개를 연결해서 사용할 수 있다.
*/

function orderPizza() {

    return new Promise((resolve) => {

        console.log("피자 주문");

        setTimeout(() => {

            resolve("피자 완성");

        }, 2000);

    });

}

orderPizza()
    .then(result => {

        console.log(result);

        return "배달 시작";

    })
    .then(result => {

        console.log(result);

    });

/*
출력

피자 주문
(2초 후)
피자 완성
배달 시작
*/

/*
----------------------------------------
6. catch() 메소드
----------------------------------------

catch()

Promise가 실패(reject)했을 때 실행된다.
*/

const promise3 = new Promise((resolve, reject) => {

    setTimeout(() => {

        const success = false;

        if (success) {

            resolve("주문 성공");

        } else {

            reject("주문 실패");

        }

    }, 2000);

});

promise3
    .then(result => {

        console.log(result);

    })
    .catch(error => {

        console.log(error);

    });


/*
----------------------------------------
7. Promise 예제
커피 주문 시스템
----------------------------------------
*/

function orderCoffee() {

    return new Promise((resolve, reject) => {

        console.log("커피 주문");

        setTimeout(() => {

            resolve("커피 준비 완료");

        }, 3000);

    });

}

orderCoffee()
    .then(result => {

        console.log(result);

    });

/*
출력

커피 주문
(3초 후)
커피 준비 완료
*/




/*
----------------------------------------
정리
----------------------------------------

1. Promise는 비동기 작업의 완료(성공) 또는 실패 결과를 관리하는 객체이다.

2. resolve()
작업이 성공했을 때 호출된다.

3. reject()
작업이 실패했을 때 호출된다.

4. then()
Promise 성공 시 실행된다.

5. catch()
Promise 실패 시 실행된다.

6. then()을 연결하여 비동기 흐름을 처리할 수 있다.


다음 단계

Promise도 코드가 길어질 수 있기 때문에
ES2017에서 async / await 문법이 도입되었다.
*/


/*


동기 작업에 Promise를 쓰는 것은 문법적으로 가능하다.

예

const p = new Promise((resolve) => {
    const result = 10 + 20;
    resolve(result);
});

p.then(data => console.log(data));

하지만

const result = 10 + 20;
console.log(result);

이렇게 처리할 수 있는 단순한 동기 작업에
굳이 Promise를 사용하는 것은 비효율적이다.
*/



