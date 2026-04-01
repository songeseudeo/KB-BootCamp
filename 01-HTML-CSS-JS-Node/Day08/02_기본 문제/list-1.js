// 동기 함수 호출
const fs = require('fs');

const files = fs.readdirSync('.');
console.log(files);