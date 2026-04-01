/*

ES6 기본 문법

3. Default Parameter (기본 매개변수)
4. Rest Parameter (가변 매개변수)


Default Parameter
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Default_parameters

Rest Parameter
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/rest_parameters
*/



/*
----------------------------------------
 Default Parameter
----------------------------------------

함수 매개변수에 기본값(Default value)을 설정하는 문법

1. 함수 호출 시 해당 인수를 전달하지 않으면
   지정한 기본값이 자동으로 사용된다.

2. ES6 이전에는 함수 내부에서
   if 또는 || 연산자를 이용해 처리했지만
   ES6에서는 매개변수 선언 시 바로 설정 가능하다.

3. 기본값은 함수 선언부에서
   매개변수 = 값 형태로 지정한다.

예)
function func(a = 10)

4. 인수를 전달하면 기본값은 무시되고
   전달된 값이 사용된다.

*/

function addContact(name, mobile, home = "없음", address = "없음") {

    let result =
        `name=${name}, mobile=${mobile}, home=${home}, address=${address}`;

    console.log(result);
}
/*
함수 호출 시 home, address 인수를 전달하지 않았으므로
기본값 "없음"이 사용된다.
*/
addContact("홍길동", "010-1111-2222");


/*
모든 인수를 전달했으므로
기본값 대신 전달된 값이 사용된다.
*/
addContact(
    "이몽룡",
    "010-2222-3333",
    "02-1234-5678",
    "서울"
);


/*
----------------------------------------
 Rest Parameter
----------------------------------------

여러 개의 인수를 하나의 배열로 받아 처리하는
가변 매개변수 문법


...변수명

예)
function func(...args)


1. 전달된 인수들을 배열(Array) 형태로 저장한다.

2. 함수에 전달되는 인수 개수가
   고정되지 않을 때 사용한다.

3. Rest Parameter는
   반드시 매개변수의 마지막에 위치해야 한다.

예)
function test(a, b, ...rest)

4. Rest Parameter는 실제 배열이므로
   배열 메서드(map, forEach 등)를 사용할 수 있다.

*/
function foodReport(name, age, ...favoriteFoods) {

    console.log(name, age);

    console.log("좋아하는 음식 목록:");

    console.log(favoriteFoods); // 배열형태
}


foodReport(
    "이몽룡",
    20,
    "짜장면",
    "냉면",
    "불고기"
);

foodReport(
    "홍길동",
    18,
    "초밥"
);



function printNumbers(...numbers) {
    console.log("전달된 값:", numbers);
}

printNumbers(10, 20, 30);
printNumbers(1, 2, 3, 4, 5);


function sumAll(...numbers) {
    let sum = 0;

    for (let n of numbers) {
        sum += n;
    }

    console.log(`합계: ${sum}`);
}

sumAll(10, 20, 30);      // 합계: 60
sumAll(1, 2, 3, 4, 5);   // 합계: 15



function scoreReport(...scores) {
    /*
    reduce() : 배열의 모든 값을 하나의 값으로 계산하는 배열 메서드

    array.reduce((누적값, 현재값) => 계산식, 초기값)

    acc   : 이전 계산 결과(누적값)
    score : 현재 배열 요소
    */
    //     let total = 0;

    //     for (let score of scores) {
    //         total += score;
    //     }
    let total = scores.reduce((acc, score) => acc + score, 0);
    let average = total / scores.length;

    let max = scores.reduce((acc, score) => Math.max(acc, score));

    console.log(`점수 목록: ${scores}`);
    console.log(`최대값: ${max}`);


    console.log(`총점: ${total}`);
    console.log(`평균: ${average}`);
    console.log(`최대값: ${max}`);

}

scoreReport(80, 90, 100);
scoreReport(70, 85, 90, 95);