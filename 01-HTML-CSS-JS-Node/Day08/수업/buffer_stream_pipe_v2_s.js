/*
========================================================
Node.js Buffer / Stream 
========================================================

참고 공식 문서

Node.js Buffer
https://nodejs.org/api/buffer.html

Node.js Stream
https://nodejs.org/api/stream.html

Node.js FS
https://nodejs.org/api/fs.html

Node.js Learn - Streams
https://nodejs.org/en/learn/modules/how-to-use-streams

ASCII
https://en.wikipedia.org/wiki/ASCII

Unicode
https://home.unicode.org/
https://developer.mozilla.org/ko/docs/Glossary/Unicode

UTF-8
https://en.wikipedia.org/wiki/UTF-8
*/



/*
========================================================
1. Binary Data (컴퓨터 데이터 저장 방식)
========================================================

컴퓨터는 모든 데이터를 "바이트(byte)" 단위로 저장한다.

즉

문자
이미지
영상
파일
네트워크 데이터

모두 결국은 "binary 데이터"이다.

예

문자 "A"

ASCII 코드
→ 65

Binary
→ 01000001

즉

문자
→ 숫자 코드
→ 바이너리 데이터

형태로 저장된다.
*/



/*
========================================================
2. Encoding / Decoding
========================================================

Encoding
→ 문자를 바이트로 변환

Decoding
→ 바이트를 문자로 변환

예

문자열
"Hello"

Encoding
→ UTF-8
→ binary 데이터

Decoding
→ binary
→ 문자열

Node.js에서

Buffer.from("Hello", "utf8")

→ encoding

buffer.toString("utf8")

→ decoding
*/



/*
========================================================
3. ASCII
========================================================

ASCII는 가장 오래된 문자 인코딩 방식이다.

특징

7bit 문자 집합
총 128개 문자

포함

영문 대문자
영문 소문자
숫자
기본 특수문자

예

"A" → 65
"a" → 97
"0" → 48

하지만 ASCII는

한글
중국어
일본어
이모지

같은 문자를 표현할 수 없다.

그래서 Unicode가 등장한다.
*/



/*
========================================================
4. Unicode
========================================================

Unicode는 전 세계 모든 문자를 표현하기 위한 표준이다.

ASCII 한계를 해결하기 위해 만들어졌다.

Unicode는

문자 → 코드포인트

형태로 관리한다.

예

A → U+0041
가 → U+AC00
😀 → U+1F600

즉

Unicode는

"문자 번호 체계"

이다.

하지만 실제 저장할 때는
Encoding 방식이 필요하다.

대표 Encoding

UTF-8
UTF-16
UTF-32
*/



/*
========================================================
5. UTF-8
========================================================

UTF-8은 Unicode를 저장하는 가장 많이 사용하는 인코딩 방식이다.

특징

가변 길이 인코딩

1 ~ 4 byte 사용

예

A
→ 1 byte

가
→ 3 byte

😀
→ 4 byte

UTF-8이 가장 많이 사용하는 이유

- ASCII와 호환
- 메모리 효율
- 웹 표준

그래서 Node.js 기본 인코딩은

UTF-8
*/



/*
========================================================
6. Buffer
========================================================

Buffer는

바이너리 데이터를 저장하는 객체이다.

Node.js에서

파일
네트워크
이미지
영상

같은 데이터를 처리할 때 사용한다.


참고 )
운영체제(I/O) 관점에서 Buffer는
데이터를 처리하기 전에 임시로 저장하는 메모리 공간을 의미한다.

예를 들어 파일이나 네트워크 데이터를 읽을 때
데이터는 먼저 버퍼에 저장된 후 프로그램으로 전달된다.


*/

const buf = Buffer.from("Hello Node.js");

console.log("Buffer 데이터:", buf);

console.log("문자열 변환:", buf.toString());



/*
========================================================
7. Node.js 파일 읽기 (Buffer 반환)
========================================================

파일을 읽을 때 encoding을 지정하지 않으면

Buffer가 반환된다.

왜?

파일 데이터는 원래 binary이기 때문이다.
*/

const fs = require("node:fs");

if (fs.existsSync("./example.txt")) {

    fs.readFile("./example.txt", (err, data) => {

        if (err) {
            console.error("readFile 에러:", err);
            return;
        }

        console.log("Buffer 데이터:");
        console.log(data);

        console.log("문자열 변환:");
        console.log(data.toString());

    });

}



/*
========================================================
8. Stream
========================================================

Stream은

데이터를 한 번에 처리하지 않고

조각(chunk) 단위로 처리하는 방식이다.

왜 사용하는가?

큰 파일을 한 번에 읽으면

메모리 사용량이 증가한다.

예

1GB 파일

readFile()
→ 메모리 1GB 사용

Stream

1KB
1KB
1KB

처럼 나누어 읽는다.

장점

- 메모리 효율
- 대용량 파일 처리
- 데이터 즉시 처리
*/



/*
========================================================
9. Chunk
========================================================

Stream은 데이터를

chunk

단위로 전달한다.

chunk
→ 데이터 조각

Readable Stream에서

data 이벤트로 전달되는 값은

대부분 Buffer 형태이다.
*/



/*
========================================================
10. Stream 종류
========================================================

Node.js Stream 종류

1. Readable Stream
   데이터를 읽는다

2. Writable Stream
   데이터를 쓴다

3. Duplex Stream
   읽기 + 쓰기

4. Transform Stream
   읽고 변환 후 쓰기
*/



/*
========================================================
11. Readable Stream
========================================================

파일을 chunk 단위로 읽는다
*/

if (fs.existsSync("./readMe.txt")) {

    const rs = fs.createReadStream("./readMe.txt");

    rs.on("data", (chunk) => {

        console.log("새로운 chunk");
        console.log("chunk 길이:", chunk.length);
        console.log(chunk);

    });

    rs.on("end", () => {

        console.log("파일 읽기 완료");

    });

}



/*
========================================================
12. Writable Stream
========================================================

파일을 스트림 방식으로 기록한다
*/

const ws = fs.createWriteStream("./stream-write.txt", { encoding: "utf8" });

ws.write("첫 번째 줄\n");
ws.write("두 번째 줄\n");
ws.write("세 번째 줄\n");

ws.end();



/*
========================================================
13. pipe()
========================================================


pipe()는 Readable Stream과 Writable Stream을 연결한다.


즉

읽기 → 쓰기

자동 연결
*/

if (fs.existsSync("./readMe.txt")) {

    const readStream = fs.createReadStream("./readMe.txt");

    const writeStream = fs.createWriteStream("./writeMe.txt");

    readStream.pipe(writeStream);

}



/*
========================================================
14. readFile vs Stream
========================================================

readFile()

파일 전체 읽기
작은 파일에 적합

Stream

파일을 chunk 단위로 읽기
큰 파일 처리에 적합
*/



/*
========================================================
15. 정리
========================================================

ASCII
→ 초기 문자 인코딩

Unicode
→ 전 세계 문자 코드 체계

UTF-8
→ Unicode 저장 방식

Encoding
→ 문자 → 바이트

Decoding
→ 바이트 → 문자

Buffer
→ 바이너리 데이터를 저장하는 객체

Stream
→ 큰 데이터를 조각(chunk) 단위로 처리하는 방식
*/
