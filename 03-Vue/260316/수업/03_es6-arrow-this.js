/*

ES6 화살표 함수와 this

1. Arrow Function (화살표 함수)
2. 일반 함수의 this
3. call / apply / bind
4. 화살표 함수의 this

MDN Arrow Function
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Arrow_functions

MDN this
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/this

MDN bind
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Function/bind

MDN call
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Function/call

MDN apply
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Function/apply

*/


/*
----------------------------------------
1. 화살표 함수 (Arrow Function)
----------------------------------------

ES6에서 추가된 함수 표현식

기본 문법
(매개변수) => { 실행문 }

특징

1. function 키워드 대신 => 사용
2. 코드가 더 간결해진다
3. 실행문이 한 줄이면 return 생략 가능
4. 자신만의 this를 가지지 않는다
5. 주로 콜백 함수나 내부 함수에서 많이 사용된다
*/


/*
----------------------------------------
2. 일반 함수의 this
----------------------------------------

일반 함수의 this는
함수가 선언될 때 결정되는 것이 아니라

"어떻게 호출되었는지"에 따라 결정된다.
*/

let obj1 = {
    result: 0
};

obj1.add = function (x, y) {
    this.result = x + y;
};

obj1.add(3, 4);

console.log("obj1:", obj1);

/*
obj1.add() 처럼
객체의 메서드로 호출했기 때문에

this는 obj1을 가리킨다.
*/

console.log("---------------------------------------");


/*
----------------------------------------
3. this가 바뀌는 경우
----------------------------------------

같은 함수라도
메서드 호출이 아니라

일반 함수 호출로 바뀌면
this가 달라질 수 있다.
*/

let obj2 = {
    result: 0
};

obj2.add = function (x, y) {
    this.result = x + y;
};

let add4 = obj2.add;

console.log(add4 === obj2.add);

add4(3, 4);

/*
add4는 obj2.add와 같은 함수를 참조하지만

add4() 형태로 일반 함수 호출이 되었기 때문에
this는 obj2를 가리키지 않는다.
*/

console.log("obj2:", obj2);

console.log("---------------------------------------");


/*
----------------------------------------
4. call / apply / bind
----------------------------------------

일반 함수의 this를
원하는 객체에 연결할 수 있다.

call()
- this를 지정하고 즉시 실행
- 인수를 개별로 전달

apply()
- this를 지정하고 즉시 실행
- 인수를 배열로 전달

bind()
- this가 고정된 새로운 함수를 반환
- 즉시 실행되지 않는다
*/

let add5 = function (x, y) {
    this.result = x + y;
};


/*
call()
*/

let obj3 = {};

add5.call(obj3, 3, 4);

console.log("call 결과:", obj3);

/*
add5를 실행하는데
this를 obj3로 사용한다.

obj3.result = 3 + 4
*/

console.log("---------------------------------------");


/*
apply()
*/

let obj4 = {};

add5.apply(obj4, [5, 6]);

console.log("apply 결과:", obj4);

/*
this = obj4
함수 즉시 실행
인수는 배열로 전달

obj4.result = 5 + 6
*/

console.log("---------------------------------------");


/*
bind()
*/

let obj5 = {};

let boundAdd = add5.bind(obj5);

boundAdd(10, 20);

console.log("bind 결과:", obj5);

/*
bind는 함수를 즉시 실행하지 않는다.

대신
this가 obj5로 고정된
새로운 함수를 반환한다.


let boundAdd = function(x,y){
   add5.call(obj5,x,y)
}
boundAdd(10,20)
obj5.result = 30
*/


// call / apply → this 바꿔서 즉시 실행
// bind → this 고정된 새 함수 생성

console.log("---------------------------------------");


/*
----------------------------------------
5. 일반 함수 안의 내부 함수와 this
----------------------------------------

일반 함수 안에서 또 일반 함수를 만들면

내부 함수의 this는
바깥 객체를 자동으로 가리키지 않는다.
*/

let obj6 = {
    result: 0
};

obj6.add = function (x, y) {

    function inner() {
        this.result = x + y;
    }

    inner();
};

obj6.add(3, 4);

console.log("obj6:", obj6);

/*
inner는 obj6의 메서드가 아니라
일반 함수로 호출된다.

그래서 this는 obj6가 아니라
전역 객체(또는 undefined)가 될 수 있다.
*/

console.log("---------------------------------------");


/*
----------------------------------------
6. bind로 내부 함수의 this 고정
----------------------------------------

bind(this)를 사용하면

내부 함수의 this를
바깥 함수의 this에 연결할 수 있다.
*/

let obj7 = {
    result: 0
};

obj7.add = function (x, y) {

    function inner() {
        this.result = x + y;
    }

    const boundInner = inner.bind(this);

    boundInner();
};

obj7.add(3, 4);

console.log("obj7:", obj7);

console.log("---------------------------------------");


/*
----------------------------------------
7. 화살표 함수의 this
----------------------------------------

화살표 함수는 자신만의 this를 만들지 않는다.

대신
화살표 함수가 만들어질 당시의
바깥 스코프의 this를 그대로 사용한다.
*/

let obj8 = {
    result: 0
};

obj8.add = function (x, y) {

    const inner = () => {
        this.result = x + y;
    };

    inner();
};

obj8.add(3, 4);

console.log("obj8:", obj8);

/*
inner는 화살표 함수이므로
자신만의 this가 없다.

따라서 바깥 함수 obj8.add의
this를 그대로 사용한다.
*/

console.log("---------------------------------------");


/*
----------------------------------------
8. 객체 메서드와 화살표 함수
----------------------------------------

주의

객체 메서드를 화살표 함수로 작성하면
원하는 this가 나오지 않을 수 있다.

이유
화살표 함수는 자신만의 this가 없기 때문이다.
*/

let obj9 = {
    result: 0,
    add: (x, y) => {

        /*
        여기서 this는 obj9가 아니라
        바깥 스코프의 this이다.
        */

        console.log("화살표 메서드의 this:", this);
    }
};

obj9.add(1, 2);

console.log("---------------------------------------");


/*
----------------------------------------
9. 일반 함수와 화살표 함수 비교
----------------------------------------
*/

let obj10 = {
    value: 100,

    normalFunc: function () {
        console.log("일반 함수 this.value:", this.value);
    },

    arrowFunc: () => {

        /*
        화살표 함수는 자신의 this가 없기 때문에
        obj10을 자동으로 가리키지 않는다.
        */

        console.log("화살표 함수 this.value:", this.value);
    }
};

obj10.normalFunc();
obj10.arrowFunc();

console.log("---------------------------------------");


/*
----------------------------------------
10. 자주 쓰는 패턴
----------------------------------------

객체 메서드는 일반 함수로 작성하고
내부 콜백은 화살표 함수로 작성하면 편리하다.
*/

let counter = {
    num: 0,

    increase: function () {

        [1, 2, 3].forEach(() => {
            this.num++;
        });

    }
};

counter.increase();

console.log("counter:", counter);

/*
forEach 콜백을 화살표 함수로 작성했기 때문에

바깥 메서드 increase의 this를
그대로 사용한다.
*/


console.log("---------------------------------------");


/*
----------------------------------------
정리
----------------------------------------

1. 화살표 함수
- function 대신 => 사용
- 코드가 짧다
- 한 줄이면 return 생략 가능
- 자신만의 this가 없다

2. 일반 함수의 this
- 호출 방식에 따라 결정된다

obj.method() → this = obj
function()   → this = 전역 객체
call/apply   → this = 지정 객체

3. call / apply / bind
- this를 원하는 객체에 연결할 수 있다

4. 화살표 함수의 this
- 자신의 this가 없다
- 바깥 this를 그대로 사용한다


정리

일반 함수 this
→ 호출 방식에 따라 달라진다

화살표 함수 this
→ 바깥 this를 그대로 사용한다
*/



/*
----------------------------------------
Vue에서 this (참고)
----------------------------------------

Vue Options API에서

this → Vue 컴포넌트 객체

왜냐하면

Vue가 methods를 실행할 때
this를 Vue 컴포넌트 인스턴스에 연결(bind)하기 때문이다.

예
----------------------------------------------------------
*/

// export default {
// // data는 Vue 컴포넌트에서 사용하는
// //     "상태 데이터(변수)"를 정의
//   data() {
//     return {
//       count: 0
//     }
//   },

//   methods: {

//     increase() {

//       /*
//       increase()는 Vue가 실행하는 메서드이기 때문에
//       this는 Vue 컴포넌트를 가리킨다.

//       따라서

//       this.count

//       는

//       Vue 컴포넌트에 있는
//       data의 count 변수에 접근하는 것이다.
//       */

//       this.count++;
//     }
//   }
// }
// //콜백에서 화살표 함수를 쓰는 이유
// methods: {

//   increase() {

//     setTimeout(function () {

//       console.log(this);

//     }, 1000);

//   }

// }

// // 문제

// // setTimeout 안의 function은
// // 일반 함수로 호출된다

// // 그래서

// // this = window (또는 undefined)
// // 해결 방법
// methods: {

//   increase1() {

//     setTimeout(() => {

//       this.count++;


//         // 화살표 함수 this (바깥 메서드의 this사용)
//         // =
//         // increase 메서드의 this
//         // =
//         // Vue 컴포넌트

//     }, 1000);

//   }

// }



/*----------------------------------------------------------------------
이유

화살표 함수는
자신만의 this를 만들지 않는다.

따라서
바깥 메서드의 this를 그대로 사용한다.

즉

this = Vue 컴포넌트
Vue에서의 규칙 (중요)
methods → 일반 함수 사용
콜백 → 화살표 함수 사용


*/


