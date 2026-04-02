<template>
  <div>
    <h2>콘솔 확인 (에러 처리 - Error Handling)</h2>
    <p>존재하지 않는 주소로 요청을 보냅니다.</p>
  </div>
</template>

<script setup>
import axios from 'axios';

// 고의로 틀린 주소를 설정합니다.
const url = "/api/todos2";

const requestAPI = async () => {
  try {
    const response = await axios.get(url);
    console.log("# 성공 결과 : ", response.data);
  } catch (error) {
    // 에러 발생 시 이 블록이 실행됩니다.
    console.log("--- 에러 발생 상세 정보 ---");
    
    if (error.response) {
      // 1. 서버가 응답을 보냈으나 4xx, 5xx 상태 코드인 경우
      console.log("상태 코드:", error.response.status); // 404가 찍힐 거예요.
      console.log("응답 데이터:", error.response.data);
    } else if (error.request) {
      // 2. 요청은 보냈으나 응답을 전혀 받지 못한 경우 (네트워크 끊김 등)
      console.log("서버로부터 응답이 없습니다.");
    } else {
      // 3. 요청 설정 과정에서 에러가 발생한 경우
      console.log("요청 설정 중 에러:", error.message);
    }
    
    console.log("에러 전체 정보:", error.toJSON());
  }
};

requestAPI();
</script>