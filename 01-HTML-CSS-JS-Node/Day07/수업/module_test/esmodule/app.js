/*
----------------------------------------
모듈 가져오기
----------------------------------------

import 문법을 사용하여
다른 파일의 export 값을 가져온다.
*/

import { user1, user2 } from './users-1.js';
import hello from './hello.js';
import { user1 as firstUser } from './users-1.js';
import * as users from './users-1.js';

/*
----------------------------------------
Named Import 사용
----------------------------------------
*/

hello(user1);
hello(user2);


/*
----------------------------------------
모든 export 가져오기
----------------------------------------

import * as 객체이름

→ 모든 export가 users 객체에 들어간다.
*/

hello(users.user1);
hello(users.user2);


/*
----------------------------------------
이름 변경해서 가져오기 (Alias)
----------------------------------------

CommonJS
{ 기존이름: 새이름 }

ES Module
{ 기존이름 as 새이름 }
*/

hello(firstUser);



/*
----------------------------------------
Named Export와 Default Export
----------------------------------------

Named Export
- 여러 개 export 가능
- import 할 때 {} 사용
- 이름이 일치해야 한다

예
export { user1, user2 }
import { user1, user2 } from "./users-1.js"


Default Export
- 대표 값 하나 export
- import 할 때 {} 사용하지 않음
- 이름을 자유롭게 정할 수 있다

예
export default hello
import hello from "./hello.js"
*/


/*
주의

같은 모듈을 여러 번 import해도
파일은 한 번만 실행된다.

*/
/*

1. package.json 생성

npm init -y


2. package.json 수정

{
  "type": "module"
}
*/