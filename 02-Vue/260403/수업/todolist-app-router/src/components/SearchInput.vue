<template>
    <input type="text" v-model="keyword" placeholder="검색어 입력" />
</template>

<script setup>
// defineModel이 modelValue props + update:modelValue emit을 자동으로 처리
const keyword = defineModel()
</script>

