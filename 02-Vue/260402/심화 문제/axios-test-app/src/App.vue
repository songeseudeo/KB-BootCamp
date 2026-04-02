<template>
  <div>
    <h2>콘솔 확인</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

// 기본 URL 설정
const listUrl = "/api/todos"; // 전체 목록 주소
const todoUrlPrefix = "/api/todos/"; // 개별 항목 조회를 위한 접두사

const requestAPI = () => {
  // 1. 전체 todo 목록 얻기
  axios.get(listUrl)
    .then((response) => {
      const todoList = response.data;
      console.log("# TodoList : ", todoList);
      
      // 2. 목록 중 첫 번째 todo의 id 혹은 특정 id(1)를 사용하여 상세 조회
      // 과제 내용에 따라 id가 1인 데이터를 가져오기 위해 1을 리턴합니다.
      return 1; 
    })
    .then((id) => {
      // 3. id가 1인 todo 얻기
      return axios.get(todoUrlPrefix + id);
    })
    .then((response) => {
      // 4. 상세 결과 출력
      console.log("## id가 1인 Todo : ", response.data);
    })
    .catch((error) => {
      // 에러 핸들링 추가 (네트워크 에러 등 방지)
      console.error("통신 중 에러 발생:", error);
    });
};

requestAPI();
</script>