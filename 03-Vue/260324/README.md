# 📅 2026-03-24 학습 기록

## 1. 📖 배운 내용
- **주제**: 단일 파일 컴포넌트를 이용한 Vue 애플리케이션 개발
- 
- **프로젝트 만들기:**
1. npm init vue : vite 기반으로 프로젝트 구성
2. cd test-vue-add
3. npm install
4. npm run dev
- **컴포넌트 등록:** <script/> <template/> <style/>
- <Kbd>전역 방법</kbd> : 한 번만 등록하면 바로 사용 가능 (사용하지 않는 컴포넌트에서도 포함)
  import { createApp } from 'vue';
  import App from './App.vue';
  import CheckboxItem from './components/CheckboxItem.vue';
  createApp(App)
    .component('CheckboxItem', CheckboxItem)
    .mount('#app');
- <Kbd>지역 방법</kbd> : 사용하는 컴포넌트내에서 매번 등록 (권장)
- **단어**: 핵심 키워드나 개념 요약
- **함수**: 개념 요약
- **중요**: 1. 컴포넌트를 나누는 방법/규칙 2. props 3. emit

## 2. 📝 오늘의 실습 & 과제
- `수업/`: 수업 시간에 함께 작성한 예제 코드들
- `기본 문제/`: (예: 02-02.js ~ 02-20.js) 기초 문법 다지기 문제 풀이
- `심화 문제/`: (예: 계산기 로직 구현) 난이도 있는 과제 수행

## 3. 🚨 오류 및 해결 (Troubleshooting)
- **문제**: (예: 코드 실행 시 'ReferenceError' 발생)
- **원인**: (예: 변수 선언 전 사용 또는 오타)
- **해결**: (예: `let` 선언 위치 수정 및 오타 교정 후 정상 작동 확인)

## 4. 🌱 오늘의 회고
- **알게된 점**:
- **좋았던 점**: 오늘 새롭게 알게 된 유용한 팁이나 성취감
- **아쉬운 점**: 아직 이해가 부족하거나 내일 더 공부해야 할 부분

<Kbd></kbd>
