/*

자바스크립트 비동기 처리 방법

자바스크립트는 기본적으로 단일 스레드(single-thread) 기반으로 동작하며
코드는 기본적으로 동기 방식으로 실행된다.

하지만 네트워크 요청, 타이머, 파일 처리 등 시간이 오래 걸리는 작업은
비동기 방식으로 처리된다.

대표적인 비동기 처리 방법

1. 콜백 함수 (Callback)
2. Promise
3. async / await

이 파일에서는
동기 → 비동기 → 콜백 순서로 개념을 확인한다.
*/


/*
----------------------------------------
1. 동기 처리 (Synchronous)
----------------------------------------

동기 처리란
코드가 작성된 순서대로 실행되는 방식이다.

앞의 작업이 끝나야 다음 작업이 실행된다.

실행 흐름

A → B → C
*/


function displayA() {
    console.log("A");
}

function displayB() {
    console.log("B");
}

function displayC() {
    console.log("C");
}

displayA();
displayB();
displayC();

/*
실행 결과

A
B
C
*/


/*
----------------------------------------
2. 비동기 처리 (Asynchronous)
----------------------------------------

비동기 처리는 시간이 오래 걸리는 작업을
기다리지 않고 다음 코드를 먼저 실행하는 방식이다.

대표적인 비동기 함수

- setTimeout()
- setInterval()


실행 흐름 예

A → C → B
*/


function displayA2() {
    console.log("A");
}

function displayB2() {

    setTimeout(() => {
        console.log("B");
    }, 2000);

}

function displayC2() {
    console.log("C");
}

displayA2();
displayB2();
displayC2();

/*
실행 결과

A
C
B

*/


/*
setTimeout(함수, 시간)

지정한 시간이 지난 후
콜백 함수를 한 번 실행한다.

1초 = 1000ms
*/

function orderCoffee(coffee, callback) {

    console.log(`${coffee} 주문 접수`);

    setTimeout(() => {

        callback(coffee);

    }, 3000);

}

function displayResult(result) {

    console.log(`${result} 준비 완료`);

}

orderCoffee("아메리카노", displayResult);

/*
출력

아메리카노 주문 접수
(3초 후)
아메리카노 준비 완료
*/


/*
----------------------------------------
3. 익명 콜백 함수 (함수의 매개변수로 전달되는 함수)
----------------------------------------
*/

orderCoffee("카페라떼", function (coffee) {

    console.log(`${coffee} 나왔습니다.`);

});


/*
----------------------------------------
4. 화살표 함수 콜백
----------------------------------------
*/

orderCoffee("바닐라라떼", coffee => {

    console.log(`${coffee} 완료`);

});


/*
----------------------------------------
정리
----------------------------------------

1. 동기 처리
코드가 작성된 순서대로 실행된다.

A → B → C


2. 비동기 처리
시간이 걸리는 작업을 뒤에서 실행한다.

A → C → B


3. setTimeout
지정한 시간이 지난 뒤 함수를 실행한다.


4. 콜백 함수
다른 함수에 전달되는 함수이며
비동기 작업의 실행 순서를 제어할 때 사용된다.


다음 단계

콜백 함수가 많아지면
코드가 복잡해지는 문제가 발생한다.

이를 해결하기 위해
Promise와 async/await가 사용된다.
*/