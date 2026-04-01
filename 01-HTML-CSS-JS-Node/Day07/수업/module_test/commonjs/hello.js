const hello = (name) => {
    console.log(`${name}님 안녕하세요`)
}

module.exports = hello; //다른 파일에서 사용할 수 있게 내보내기

/* 템플릿 리터럴
백틱(``) 사용
${변수}
문자열 안에 변수를 삽입할 수 있다.
예
`${name}님` */