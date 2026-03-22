const p1 = {name: 'jhon', age: '20'};
p1.age = 22;
console.log(p1);
// const 경우에 하나씩 수정은 가능하나 2가지는 안 됨
// let 으로 하면 가능
p1 = {name: 'lee', age: 25};