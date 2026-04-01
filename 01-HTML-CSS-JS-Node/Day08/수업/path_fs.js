/*


Node.js path / fs 모듈 기본

이 파일에서는 다음 내용을 학습한다.

1. path 모듈
2. __dirname, __filename
3. 파일 목록 읽기
4. 파일 읽기 / 쓰기 / 추가 / 삭제
5. 디렉터리 생성 / 삭제

출처
Node.js Path 모듈
https://nodejs.org/api/path.html

Node.js FS 모듈
https://nodejs.org/api/fs.html


https://nodejs.org/en/learn/asynchronous-work/overview-of-blocking-vs-non-blocking
*/


/*
----------------------------------------
1. path 모듈
----------------------------------------

path 모듈은 파일 경로를 다룰 때 사용하는 Node.js 코어 모듈이다.

운영체제마다 경로 구분자가 다를 수 있기 때문에
문자열을 직접 이어 붙이기보다 path 모듈을 사용하는 것이 안전하다.
*/

// node: 는 Node.js 내장 모듈이라는 것을 명확하게 표시하는 접두어 (생략가능)
// const fs = require("fs");
// const path = require("path");
const path = require("node:path");
const fs = require("node:fs");


/*
----------------------------------------
2. 경로 관련 기본 변수
----------------------------------------

__dirname
현재 파일이 들어 있는 폴더 경로

__filename
현재 파일의 전체 경로

Node 문서에서는 path 모듈과 함께 이런 경로 값을 다루는 예제를 제공한다.
*/
console.log("현재 파일이 있는 폴더:", __dirname);
console.log("현재 파일의 전체 경로:", __filename);


/*
----------------------------------------
3. path.join()
----------------------------------------

여러 경로 조각을 하나의 경로로 연결한다.

운영체제에 맞는 경로 구분자를 자동으로 사용한다.
*/
const fullPath = path.join("some", "work", "ex.txt");
console.log("join 결과:", fullPath);


/*
----------------------------------------
4. path.dirname()
----------------------------------------

경로에서 폴더 경로만 추출한다.
*/
const dir = path.dirname(__filename);
console.log("dirname 결과:", dir);


/*
----------------------------------------
5. path.basename()
----------------------------------------

경로에서 파일 이름만 추출한다.
확장자를 제외하고 가져올 수도 있다.
*/
const fileName = path.basename(__filename);
const fileNameWithoutExt = path.basename(__filename, ".js");

console.log("파일 이름:", fileName);
console.log("확장자 제외 파일 이름:", fileNameWithoutExt);


/*
----------------------------------------
6. path.extname()
----------------------------------------

파일의 확장자만 추출한다.
*/
const ext = path.extname(__filename);
console.log("확장자:", ext);


/*
----------------------------------------
7. path.parse()
----------------------------------------

경로를 객체 형태로 나누어 반환한다.

반환 객체 주요 속성
- root
- dir
- base
- ext
- name
*/
const parsedPath = path.parse(__filename);
console.log("parse 결과:", parsedPath);


/*
----------------------------------------
8. fs 모듈
----------------------------------------

fs(File System) 모듈은 파일과 디렉터리를 다룰 때 사용하는 Node.js 코어 모듈이다.

Node 공식 문서 기준으로 fs 모듈은
- 동기 API
- 콜백 API
- Promise API
를 제공한다.
*/


/*
----------------------------------------
9. 현재 폴더 읽기 - readdirSync()
----------------------------------------

동기 방식
작업이 끝날 때까지 다음 코드가 기다린다.
*/
const fileListSync = fs.readdirSync("./");
console.log("현재 폴더 목록(readdirSync):", fileListSync);


/*
----------------------------------------
10. 현재 폴더 읽기 - readdir()
----------------------------------------

비동기 방식
작업을 요청하고 나중에 콜백 함수로 결과를 받는다.
*/
fs.readdir("./", (err, files) => {
    if (err) {
        return console.error("readdir 에러:", err);
    }

    console.log("현재 폴더 목록(readdir):", files);
});


/*
----------------------------------------
11. 파일 읽기 - readFileSync()
----------------------------------------

동기 방식으로 파일 전체를 읽는다.

주의
example.txt 파일이 현재 폴더에 있어야 한다.
없으면 에러가 발생한다.
*/
if (fs.existsSync("./example.txt")) {
    const data1 = fs.readFileSync("./example.txt", "utf8");
    console.log("readFileSync 결과:");
    console.log(data1);
} else {
    console.log("example.txt 파일이 없어서 readFileSync 예제를 건너뜁니다.");
}


/*
----------------------------------------
12. 파일 읽기 - readFile()
----------------------------------------

비동기 방식으로 파일 전체를 읽는다.
콜백 함수의 첫 번째 매개변수는 에러 객체,
두 번째 매개변수는 읽은 데이터이다.
*/
if (fs.existsSync("./example.txt")) {
    fs.readFile("./example.txt", "utf8", (err, data) => {
        if (err) {
            return console.error("readFile 에러:", err);
        }

        console.log("readFile 결과:");
        console.log(data);
    });
} else {
    console.log("example.txt 파일이 없어서 readFile 예제를 건너뜁니다.");
}


/*
----------------------------------------
13. 파일 쓰기 - writeFileSync()
----------------------------------------

동기 방식으로 파일에 내용을 저장한다.
파일이 없으면 새로 만들고,
파일이 있으면 기본적으로 덮어쓴다.
*/
const text1 = "Node.js 파일 쓰기 예제입니다.\n";
fs.writeFileSync("./text-1.txt", text1, "utf8");
console.log("text-1.txt 저장 완료");


/*
----------------------------------------
14. 파일 존재 확인 - existsSync()
----------------------------------------

파일이나 폴더가 존재하는지 확인한다.
*/
if (fs.existsSync("./text-1.txt")) {
    console.log("text-1.txt 파일이 존재합니다.");
} else {
    console.log("text-1.txt 파일이 없습니다.");
}


/*
----------------------------------------
15. 파일 쓰기 - writeFile()
----------------------------------------

비동기 방식으로 파일에 내용을 저장한다.
*/
fs.writeFile("./text-2.txt", "비동기 파일 쓰기 예제입니다.\n", "utf8", (err) => {
    if (err) {
        return console.error("writeFile 에러:", err);
    }

    console.log("text-2.txt 저장 완료");
});


/*
----------------------------------------
16. 파일 내용 추가 - appendFile()
----------------------------------------

기존 파일 끝에 내용을 추가한다.
*/
fs.appendFile("./text-2.txt", "새로운 내용을 추가합니다.\n", "utf8", (err) => {
    if (err) {
        return console.error("appendFile 에러:", err);
    }

    console.log("text-2.txt에 내용 추가 완료");
});


/*
----------------------------------------
17. 파일 내용 추가 - writeFileSync + flag: 'a'
----------------------------------------

append 모드로 파일 끝에 내용을 추가할 수도 있다.
*/
const content = "\n------------------------------\n추가 기록 예제\n------------------------------\n";
fs.writeFileSync("./text-1.txt", content, { encoding: "utf8", flag: "a" });
console.log("text-1.txt에 추가 기록 완료");


/*
----------------------------------------
18. 파일 삭제 - unlinkSync()
----------------------------------------

동기 방식으로 파일을 삭제한다.
파일이 없을 수 있으므로 존재 여부를 먼저 확인한다.
*/
if (fs.existsSync("./delete-me-sync.txt")) {
    fs.unlinkSync("./delete-me-sync.txt");
    console.log("delete-me-sync.txt 삭제 완료");
} else {
    console.log("delete-me-sync.txt 파일이 없어 삭제 예제를 건너뜁니다.");
}


/*
삭제 예제를 위해 파일 하나 생성
*/
fs.writeFileSync("./delete-me-sync.txt", "삭제할 파일", "utf8");
console.log("delete-me-sync.txt 생성 완료");

if (fs.existsSync("./delete-me-sync.txt")) {
    fs.unlinkSync("./delete-me-sync.txt");
    console.log("delete-me-sync.txt 삭제 완료");
}


/*
----------------------------------------
19. 파일 삭제 - unlink()
----------------------------------------

비동기 방식으로 파일을 삭제한다.
*/
fs.writeFileSync("./delete-me-async.txt", "비동기 삭제 파일", "utf8");

if (fs.existsSync("./delete-me-async.txt")) {
    fs.unlink("./delete-me-async.txt", (err) => {
        if (err) {
            return console.error("unlink 에러:", err);
        }

        console.log("delete-me-async.txt 삭제 완료");
    });
} else {
    console.log("delete-me-async.txt 파일이 없습니다.");
}


/*
----------------------------------------
20. 디렉터리 생성 - mkdir() - 비동기
----------------------------------------

폴더를 만든다.
폴더가 이미 존재하면 에러가 날 수 있으므로 먼저 확인하는 습관이 좋다.
*/
if (fs.existsSync("./test")) {
    console.log("test 폴더가 이미 존재합니다.");
} else {
    fs.mkdir("./test", (err) => {
        if (err) {
            return console.error("mkdir 에러:", err);
        }

        console.log("test 폴더 생성 완료");
    });
}


/*
----------------------------------------
21. 중첩 디렉터리 생성 - mkdir({ recursive: true })
----------------------------------------

중간 폴더가 없어도 한 번에 생성할 수 있다.
*/
if (fs.existsSync("./test2/test3/test4")) {
    console.log("test2/test3/test4 폴더가 이미 존재합니다.");
} else {
    fs.mkdir("./test2/test3/test4", { recursive: true }, (err) => {
        if (err) {
            return console.error("recursive mkdir 에러:", err);
        }

        console.log("test2/test3/test4 폴더 생성 완료");
    });
}


/*
----------------------------------------
22. 디렉터리 삭제 - rmdir()
----------------------------------------

빈 폴더를 삭제할 때 사용한다.

mkdir이 비동기여서 실행시점에 폴더가 생성되지 않았을수 있다 
그래서 24 번처럼 해결 
*/
if (fs.existsSync("./test")) {
    fs.rmdir("./test", (err) => {
        if (err) {
            return console.error("rmdir 에러:", err);
        }

        console.log("test 폴더 삭제 완료");
    });
} else {
    console.log("test 폴더가 없어 삭제 예제를 건너뜁니다.");
}


/*
----------------------------------------
23. 디렉터리 삭제 - rm()
----------------------------------------

recursive 옵션을 사용하면 하위 폴더까지 함께 삭제할 수 있다.
*/
if (fs.existsSync("./test2")) {
    fs.rm("./test2", { recursive: true, force: true }, (err) => {
        if (err) {
            return console.error("rm 에러:", err);
        }

        console.log("test2 폴더와 하위 폴더 삭제 완료");
    });
} else {
    console.log("test2 폴더가 없어 rm 예제를 건너뜁니다.");
}



const fsp = require("node:fs/promises");




/*
--------------------------------------------------
 Blocking (블로킹)
--------------------------------------------------

현재 작업이 끝날 때까지 다음 코드가 실행되지 않는 방식

즉 프로그램이 "기다리는 상태"

특징
- 코드 실행 순서 보장
- 다음 작업이 대기 상태
- 이벤트 루프가 멈출 수 있음

Node.js에서는 주로 Sync API가 Blocking 방식이다.
*/


/*
예시: Blocking 코드
*/


// 파일 읽기 (Blocking)
const data = fs.readFileSync("example.txt", "utf8");

console.log("파일 내용:", data);
console.log("다음 코드 실행");

/*
실행 흐름

1. 파일 읽기 시작
2. 파일 읽기 완료될 때까지 대기
3. console.log 실행
4. 다음 코드 실행
*/


/*
--------------------------------------------------
 Non-Blocking (논블로킹)
--------------------------------------------------

작업을 요청만 하고 다음 코드가 바로 실행되는 방식

결과는 나중에 Callback / Promise로 처리한다.

특징
- 프로그램이 멈추지 않는다
- 여러 작업을 동시에 처리 가능
- Node.js 서버에서 중요
*/


/*
예시: Non-Blocking 코드
*/

fs.readFile("example.txt", "utf8", (err, data) => {

    if (err) {
        console.error(err);
        return;
    }

    console.log("파일 내용:", data);

});

console.log("다음 코드 실행");

/*
실행 흐름

1. 파일 읽기 요청
2. 다음 코드 먼저 실행
3. 파일 읽기 완료
4. 콜백 함수 실행
*/


/*
--------------------------------------------------
3. Sync vs Async
--------------------------------------------------

Sync (동기)
- 작업이 끝날 때까지 기다림
- Blocking 방식

Async (비동기)
- 작업 요청 후 다음 코드 실행
- Non-Blocking 방식


Blocking  → Sync API (예: readFileSync)
NonBlocking → Async API (예: readFile)
*/




/*
----------------------------------------
24. Promise API + async/await 예제
----------------------------------------
*/
async function run() {
    try {
        await fsp.mkdir("./test-async", { recursive: true });
        console.log("test-async 폴더 생성 완료");

        await fsp.rmdir("./test-async");
        console.log("test-async 폴더 삭제 완료");

        await fsp.mkdir("./test2-async/test3/test4", { recursive: true });
        console.log("test2-async/test3/test4 폴더 생성 완료");

        await fsp.rm("./test2-async", { recursive: true, force: true });
        console.log("test2-async 폴더와 하위 폴더 삭제 완료");
    } catch (err) {
        console.error("에러:", err);
    }
}

run();



/*
----------------------------------------
정리
----------------------------------------

1. path 모듈
- 경로를 안전하게 다룰 때 사용
- join, dirname, basename, extname, parse

2. fs 모듈
- 파일과 폴더를 다룰 때 사용
- 동기 / 비동기 / Promise 방식 제공

3. 파일 작업
- readdirSync, readdir
- readFileSync, readFile
- writeFileSync, writeFile
- appendFile
- unlinkSync, unlink

4. 디렉터리 작업
- mkdir
- rmdir
- rm


*/


/*
ES Module(import)로 변경할 때

1. package.json
"type": "module"

2. require -> import
import path from "node:path";
import fs from "node:fs";

3. __dirname, __filename 직접 생성
import { fileURLToPath } from "node:url";
const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);
*/