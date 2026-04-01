//비동기 함수 호출
const fs = require('fs');

fs.readdir('.', (err, files) => {
    if(err) {
        console.error(err);
    return; 
    }
    console.log(files);
});