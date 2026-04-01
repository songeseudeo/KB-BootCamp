const fs = require('fs');

if (!fs.existsSync('text')) {
    fs.mkdirSync('text');
    console.log('text 폴더를 생성함');
} else {
    console.log('이미 존재함');
}