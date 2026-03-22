/*

ES6 데이터 처리 문법
1. Destructuring (구조 분해 할당)
2. Spread Operator (전개 연산자)
3. Template Literal (템플릿 리터럴)


Destructuring
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Destructuring_assignment

Spread Operator
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Spread_syntax

Template Literal
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Template_literals
*/


/*
----------------------------------------
1. Destructuring (구조 분해 할당)
----------------------------------------

배열이나 객체의 값을 쉽게 꺼내서
변수에 할당하는 문법

배열은 "순서", 객체는 "속성 이름" 기준으로 값이 할당된다.
*/


/*
배열 구조 분해

배열의 요소를 순서대로 변수에 할당한다.
배열의 길이보다 변수가 많으면
남는 변수는 undefined가 된다.
*/

let arr = [10, 20, 30, 40];

let [a1, a2, a3] = arr;

console.log(a1, a2, a3);
let [b1, b2, b3, b4, b5] = arr;
console.log(b1, b2, b3, b4, b5);// 10 20 30 40 undefined

console.log("---------------------------------------");

/*
Spread Operator(전개연산자) + 구조 분해

...변수명

배열의 모든 요소를 펼쳐서
새로운 배열로 만든다.
*/
let [...arg] = arr; //let arg = [...arr];  와같은것

console.log(arg);

/*
Spread를 사용하면 새로운 배열이 생성된다.
따라서 arg를 수정해도 원본 배열 arr은 변경되지 않는다.
*/

arg[0] = 999;

console.log(arg); // [999, 20, 30, 40]
console.log(arr); // [10, 20, 30, 40]

console.log("---------------------------------------");

/*
필요한 값만 가져오기 가능
필요 없는 위치는 콤마(,)로 건너뛸 수 있다.
*/

let [x, , z] = arr;

console.log(x, z);

console.log("---------------------------------------");

/*
----------------------------------------
2. 객체 구조 분해
----------------------------------------

객체의 속성값을 변수로 꺼내는 문법



1. 객체의 속성 이름과 같은 이름의 변수로 값을 꺼낸다.
2. 필요한 속성만 선택해서 받을 수 있다.
3. 변수 이름을 다른 이름으로 변경해서 받을 수도 있다.
*/

let person = {
    name: "홍길동",
    age: 20,
    gender: "M"
};

let { name, age, gender } = person;

console.log(name, age, gender);


/*
변수 이름 변경
객체 속성명 : 새 변수명
*/

let { name: userName, age: userAge } = person;

console.log(userName, userAge);

console.log("---------------------------------------");

/*
----------------------------------------
3. 함수 매개변수 구조 분해
----------------------------------------

객체를 함수의 인수로 전달할 때
매개변수 자리에서 바로 구조 분해 할당을 사용할 수 있다.

1. 필요한 값만 바로 사용할 수 있다.
2. 코드가 간결해진다.
3. 기본값도 함께 설정할 수 있다.
*/


// 기존
function printUserOld(user) { //객체를 그대로 매개변수로 받고 내부에서 속성에 접근

    let name = user.name;
    let phone = user.phone;

    // 기본값 처리
    let email = user.email || "이메일 없음";
    let age = user.age ?? 0;

    console.log(name, phone, email, age);
}

printUserOld({
    name: "이몽룡",
    phone: "010-3333-4444"
});
console.log("---------------------------------------");
/*
구조 분해를 사용하지 않으면
객체를 매개변수로 받고

user.name
user.phone

처럼 객체 속성으로 접근해야 한다.

구조 분해를 사용하면
매개변수에서 바로 변수로 사용할 수 있다.
*/
function printUser({ name, phone, email = "이메일 없음", age = 0 }) { //구조 분해 사용

    console.log(name, phone, email, age);
}

printUser({
    name: "이몽룡",
    phone: "010-3333-4444"
});

console.log("---------------------------------------");

/*
----------------------------------------
4. Spread Operator (...) 전개연산자
----------------------------------------

배열이나 객체의 값을 펼쳐서 사용

주요 사용

1. 배열 복사
2. 객체 복사
3. 데이터 합치기
*/


/*
배열 복사
*/

let arr1 = [100, 200, 300];

let arr2 = [...arr1];

console.log(arr1);
console.log(arr2);

console.log("---------------------------------------");

/*
배열 합치기
*/

let arr3 = ["hello", ...arr1, "world"];

console.log(arr3);

console.log("---------------------------------------");

/*
----------------------------------------
5. 객체 복사
----------------------------------------
*/

let obj1 = {
    name: "박문수",
    age: 29
};

/*
단순 참조 복사(reference copy)

obj1과 obj2는 같은 객체를 참조한다.
따라서 obj2를 변경하면 obj1도 함께 바뀐다.
*/

let obj2 = obj1;


obj2.age = 19;

console.log(obj1);

console.log(obj2);
console.log("---------------------------------------");

/*
Spread를 사용하면 새로운 객체를 만든다.
이것은 얕은 복사(shallow copy)이다.

주의:
중첩 객체가 있을 경우 내부 객체까지 완전히 복사되지는 않는다.
*/

let obj3 = { ...obj1 };
obj3.age = 39;
console.log(obj1);
console.log(obj3);

console.log("---------------------------------------");

/*
객체 확장
기존 객체의 속성을 복사하면서
새로운 속성을 추가할 수 있다.
*/


let obj4 = {
    ...obj1,
    email: "mspark@gmail.com"
};

console.log(obj4);

console.log("---------------------------------------");



/*
----------------------------------------
정리
----------------------------------------

Destructuring
배열이나 객체의 값을 분해하여 변수에 할당하는 문법

Spread Operator
배열이나 객체의 요소를 펼쳐 사용하는 연산자

*/










/*
----------------------------------------
Nullish Coalescing Operator (??)널 병합 연산자
----------------------------------------

값이 null 또는 undefined일 때
기본값(default value)을 사용하는 연산자

문법

값 ?? 기본값

의미

왼쪽 값이
null 또는 undefined이면 → 기본값 사용
그 외 값이면 → 원래 값 사용

MDN
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Nullish_coalescing
*/





/*
----------------------------------------
|| 와 ?? 차이
----------------------------------------

|| (논리 OR)

왼쪽 값이 falsy이면 기본값 사용

falsy 값
0
""
false
null
undefined
NaN


?? (Nullish Coalescing)

왼쪽 값이
null 또는 undefined일 때만
기본값 사용
*/


/*
|| 사용 예
*/

let age1 = 0;

let result1 = age1 || 100;

console.log(result1);
// 100

/*
0은 falsy 값이기 때문에
기본값 100이 사용된다.
*/

console.log("---------------------------------------");

/*
?? 사용 예
*/

let age2 = 0;

let result2 = age2 ?? 100;

console.log(result2);
// 0

/*
0은 정상 값이므로
기본값이 사용되지 않는다.
*/

console.log("---------------------------------------");

/*
----------------------------------------
객체 데이터 처리 예제
----------------------------------------
*/

let user = {
    name: "홍길동",
    age: 0,
    email: null
};

/*
기본값 설정
*/

let name3 = user.name ?? "이름 없음";
let age3 = user.age ?? 20;
let email3 = user.email || "이메일 없음";

console.log(name3);
console.log(age3);
console.log(email3);
console.log("---------------------------------------");

/*
----------------------------------------
Optional Chaining Operator (?.)  옵셔널 체이닝
----------------------------------------

객체의 속성에 접근할 때
중간 객체가 존재하지 않으면
오류를 발생시키지 않고 undefined를 반환하는 연산자

문법

객체?.속성

MDN
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Optional_chaining
*/


/*

객체 안에 또 다른 객체가 있을 때
중간 객체가 없으면 오류가 발생한다.
*/

let user3 = {
    name: "홍길동"
};

// console.log(user.address.city);
// TypeError 발생 (address가 없음)


/*
address가 존재하면 city 접근
없으면 undefined 반환
→ 오류가 발생하지 않는다.
*/



let person3 = {
    name: "이몽룡",
    contact: {
        email: "test@test.com"
    }
};

console.log(person3.contact?.email);
// test@test.com

console.log(person3.address?.city);
// undefined
console.log("---------------------------------------");



/*
----------------------------------------
배열에서 사용
----------------------------------------
*/

let arr4 = null;

console.log(arr4?.[0]);
// undefined
console.log("---------------------------------------");



/*
----------------------------------------
함수 호출에서 사용
----------------------------------------
*/

let obj = {
    sayHello() {
        console.log("hello");
    }
};

obj.sayHello?.(); // 함수 존재 → 실행
obj.print?.();    // 함수 없음 → 아무 일도 안함
console.log("---------------------------------------");



/*
----------------------------------------
?? 와 함께 사용
----------------------------------------
*/

let user2 = {};

let email = user2.contact?.email ?? "이메일 없음";

console.log(email);

/*
contact가 존재하면 email 사용
없으면 undefined

?? 연산자가 기본값 사용
*/



// ??  → 값이 존재하는지 확인 (null / undefined만 검사) ,기본값 설정
// ||  → 값이 "비어있는지" 검사 (falsy 검사) ,falsy 값 기본값 처리

// ?.  → 오류를 발생시키지 않고 undefined를 반환안전하게 접근

