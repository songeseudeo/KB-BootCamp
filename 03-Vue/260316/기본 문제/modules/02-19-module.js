// 옛날 방식
// let base = 100;

// const add = (x) => base*x;
// const multiply = () => base*x;
// const getBase = () => base;

// export {add, multiply};
// export default getBase;


// 간단하게
let base = 100;
// 따로 정의하지 않고 'export'를 앞에 붙인다.
export const add = (x) => base*x;
export const multiply = (x) => base*x;
// 'const getBase = ' 부분을 아예 삭제
// 이름 없이 바로 함수 모양만 내보냄 (익명 함수)
export default () => base;