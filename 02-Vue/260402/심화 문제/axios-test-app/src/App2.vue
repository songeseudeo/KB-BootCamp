<template>
  <div>
    <h2>콘솔 확인 (async/await 버전)</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

const listUrl = "/api/todos";

// async 키워드를 함수 앞에 붙입니다.
const requestAPI = async () => {
  try {
    // await를 붙이면 통신이 끝날 때까지 기다린 후 결과를 변수에 담습니다.
    const response = await axios.get(listUrl);
    
    // 결과 출력
    console.log("# TodoList (async/await) : ", response.data);
  } catch (error) {
    // 에러 발생 시 처리
    console.error("데이터를 불러오는 중 에러 발생:", error);
  }
};

// 함수 실행
requestAPI();
</script>