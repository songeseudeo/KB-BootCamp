const fs = require('fs');

// exists (존재하는지) Sync (즉시 확인)
if(!fs.existsSync('./text2/text3/text4')) {
    //recursive: true 옵션 -> 경로상에 모든 폴더가 없으면 다 만들어

    // mk (만들다) dir (폴더) Sync (즉시 생성)
    fs.mkdirSync('./text2/text3/text4', {recursive: true});
    console.log('여러 층 폴더 생성!');
} else {
    console.log('폴더 있음!');
}