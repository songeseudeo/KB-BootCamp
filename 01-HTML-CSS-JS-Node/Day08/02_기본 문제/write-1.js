const fs = require('fs');

const data = fs.readFileSync('example.txt', 'utf8');

fs.writeFileSync('text-1.txt', data);
console.log('동기 방식으로 파일 저장 완료..');

const fs = require('fs');

fs.readFile('example.txt', 'utf-8', (err, data) => {
    if(err) return console.error(err);

    fs.writeFile('text-1.txt', data, (err) => {
        if(err) return console.error(err);
        console.log('비동기 방식으로 파일 저장 완료!');
    })
})