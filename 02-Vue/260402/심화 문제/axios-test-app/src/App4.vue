<template>
  <div>
    <h2>콘솔 확인 (데이터 추가 - POST)</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

const listUrl = "/api/todos";

const requestAPI = async () => {
  // 1. 추가할 데이터 정의
  let data = { 
    todo: "윗몸일으키기 3세트", 
    desc: "너무 빠르지 않게..." 
  };

  try {
    // 2. axios.post를 이용해 데이터 전송
    // 첫 번째 인자는 주소, 두 번째 인자는 보낼 데이터 객체입니다.
    const response = await axios.post(listUrl, data);

    // 3. 결과 확인 (성공하면 서버가 생성된 데이터를 응답으로 줍니다)
    console.log("# 데이터 추가 성공 : ", response.data);
  } catch (error) {
    console.error("데이터 추가 중 에러 발생:", error);
  }
};

requestAPI();
</script>