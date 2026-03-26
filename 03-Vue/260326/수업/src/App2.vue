<template>
  <div>
    <InputName v-model:name="searchName"/>

    <button @click="openModal">모달 열기</button>

    <MyModal v-model:visible="isModalOpen">
      <h2>검색 확인</h2>
      <p>현재 검색어는 {{ searchName }} 입니다.</p>
    </MyModal>

  </div>
</template>

<script>
import InputName from './components/v-model/InputName.vue';

export default {
  name: 'App',
  components: { InputName },
  data() {
    return {
      searchName: 'John',
      isModalOpen: false,
    }
  },
  methods: {
    openModal() {
      this.isModalOpen = true
    },
  }
  
};
</script>

<style></style>
