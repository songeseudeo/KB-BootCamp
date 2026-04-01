const user1 = "kim";
const user2 = "kim";
const user3 = "kim";

module.exports = {user1, user2}

// module.exports에 객체를 할당하면
// 여러 값을 한 번에 내보낼 수 있다.
// 객체 축약 문법 (ES6)
// { user1, user2 }
// 은 다음과 동일하다.
// { user1: user1, user2: user2 }
// 주의
// user3는 export하지 않았기 때문에
// 다른 파일에서 접근할 수 없다.