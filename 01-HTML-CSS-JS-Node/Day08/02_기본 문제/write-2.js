//파일 존재 여부 확인 후 저장
const fs = require('fs');

const content = fs.readFileSync('example.txt', 'utf-8');

if (fs.existsSync('text-1.txt')) {
    console.log('파일 있는뎅'); 
} else {
    fs.writeFileSync('tetx-1.txt', content);
    console.log('파일 만들었엉');
}