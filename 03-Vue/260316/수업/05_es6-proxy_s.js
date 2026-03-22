/*

ES6 Proxy (Vue 이해)

출처
MDN Proxy
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Proxy

Vue Reactivity Fundamentals
https://vuejs.org/guide/essentials/reactivity-fundamentals

*/


/*
----------------------------------------
1. Proxy란?
----------------------------------------

Proxy는 객체를 감싸서
객체의 동작을 중간에서 가로채는 기능이다.

즉

객체의

- 값 읽기
- 값 변경

같은 동작을 감시할 수 있다.

기본 문법

new Proxy(target, handler)

target
- 원본 객체

handler
- 동작을 가로채는 규칙
*/


/*
----------------------------------------
2. 기본 예제
----------------------------------------
*/

let obj = {
    count: 0
};

let proxy = new Proxy(obj, {});

console.log(proxy.count);

/*
handler가 비어 있으면
원본 객체처럼 동작한다.
*/


/*
----------------------------------------
3. get (읽기 감시)
----------------------------------------

속성을 읽을 때 실행된다.
*/

let obj1 = {
    name: "홍길동"
};

let proxy1 = new Proxy(obj1, {

    get(target, key) {

        console.log("값 읽기:", key);

        return target[key];

    }

});

console.log(proxy1.name);

/*
설명

proxy1.name 처럼
값을 읽을 때

get이 실행된다.
*/


/*
----------------------------------------
4. set (쓰기 감시)
----------------------------------------

속성을 변경할 때 실행된다.
*/

let obj2 = {
    count: 0
};

let proxy2 = new Proxy(obj2, {

    set(target, key, value) {

        console.log("값 변경:", key, value);

        target[key] = value;

        return true;
    }

});

proxy2.count = 10;

console.log(proxy2.count);

/*
설명

값을 변경하면
set이 실행된다.
*/


/*
Proxy는 객체의 동작을
중간에서 감시하거나 제어할 수 있다.
*/


/*
----------------------------------------
6. Vue3와 Proxy
----------------------------------------

Vue3는 Proxy를 이용해서

데이터의

읽기(get)
쓰기(set)

를 감시한다.

그래서

데이터가 변경되면
화면을 자동으로 업데이트할 수 있다.


즉, Vue3의 반응성 시스템은
Proxy 기반으로 동작한다.
*/


/*
----------------------------------------
7. Vue 반응성 동작 원리 
----------------------------------------

1. Vue는 데이터를 Proxy로 감싼다.

2. 데이터 값을 읽으면
   get이 실행된다.

3. Vue는 어떤 값이 사용되었는지
   기록한다. (의존성 추적)

4. 이후 데이터 값이 변경되면
   set이 실행된다.

5. Vue는 값이 변경된 것을 감지한다.

6. 변경된 데이터와 연결된
   화면을 찾는다.

7. 해당 화면을 다시 렌더링한다.

8. 그래서 개발자가 직접
   DOM을 조작할 필요가 없다.

9. 데이터만 변경하면
   화면이 자동으로 업데이트된다.

10. 이것을 Vue의 반응성(Reactivity)이라고 한다.

### Vue3 반응성 구조
- Proxy → Watcher → Render

*/

