<template>
  <div>

  </div>
</template>

<script setup>
import axios from 'axios';

const reqApi =async () => {

  // const url = "http://localhost:3000/todos"

  // const url = "/api/todos"

  const url = "/api/todos?_sort=-id"

  let response = await axios.get(url);

  console.log(response);
  console.log(response.data);
  // console.log(response.data[1].id);
}
reqApi();
</script>