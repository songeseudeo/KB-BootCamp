function wait3초(콜백) {

  setTimeout(() => {
    콜백("완료!");
  }, 3000);
  // setTimeout(x, y)
  // x = 익명함수() => {콜백('완료!);}
  // y = 3000
}
console.log("시작");

wait3초((결과) => {
  console.log(결과);
  console.log("다음 코드");   // ← 여기로 이동
})
