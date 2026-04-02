<template>
  <div>

  </div>
</template>

<script setup>
import axios from 'axios';

const reqApi =async () => {

  // const url = "/api/todos"
  const url = "/api/todos/2"

  let data = {
    "done": true
  }

  try {
  let response = await axios.delete(url, data);

  console.log(response)
  console.log(response.data)
  console.log(response.data.id)
  console.log(response.status)
  }catch(e) {
    console.log(`### error ### ${e}`)
    console.log(`### error ### ${e.response.data}`) // 상태 데이터
    console.log(`### error ### ${e.response.status}`) //상태코드
    console.log(`### error ### ${e.response?.status}`)
  }
}
reqApi();
</script>