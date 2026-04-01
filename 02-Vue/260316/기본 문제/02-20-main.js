// 기존 방식
// import {add} from './modules/02-19-module.js';
// console.log(add(4));
// getBase도 가져오겠다고 선언하지 않으면 아래 코드는 실행되지 않음
// console.log(getBase);

// 대표(default)는 중괄호 없이, 나머지는 필요한 것만 골라서 중괄호 안에!
import getBase, {add} from './modules/02-19-module.js';

console.log(add(4));
console.log(getBase());