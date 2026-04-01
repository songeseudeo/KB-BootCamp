<!-- src/pages/Home.vue -->
<template>
  <div class="card card-body">
    <h2>Home</h2>
    <div class="mt-3">
      <!-- push: 히스토리 추가 → 뒤로가기 가능 -->
      <button class="btn btn-primary m-1"
        @click="router.push({ name: 'about' })">
        push - about으로 이동
      </button>
      <!-- replace: 히스토리 교체 → 뒤로가기 불가 -->
      <button class="btn btn-warning m-1"
        @click="router.replace({ name: 'members' })">
        replace - members로 이동
      </button>
      <!-- go(-1): 뒤로가기 -->
      <button class="btn btn-secondary m-1"
        @click="router.go(-1)">
        go(-1) - 뒤로
      </button>
      <!-- back(): go(-1)과 동일 -->
      <button class="btn btn-secondary m-1"
        @click="router.back()">
        back() - 뒤로
      </button>
      <!-- forward(): 앞으로가기 -->
      <button class="btn btn-secondary m-1"
        @click="router.forward()">
        forward() - 앞으로
      </button>
    </div>
  </div>
</template>
<script setup>
import { useRouter } from 'vue-router'
const router = useRouter()
</script>
