<template>
  <div class="row">
    <div class="col p-3">
      <div>키워드검색1 <SearchInput v-model="keyword" /></div>
      <router-link class="btn btn-primary" to="/todos/add">
        할일 추가
      </router-link>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <TodoItem
          v-for="todoItem in todoList"
          :key="todoItem.id"
          :todoItem="todoItem"
        />
      </ul>
    </div>
    <div class="d-flex justify-content-center align-items-center gap-2 mt-3">
        <button
          class="btn btn-outline-primary"
          :disabled="paging.page <= 1"
          @click="changePage(paging.page - 1)"
        >
          &lt;
        </button>
        <span>{{ paging.page }} / {{ paging.totalPages }}</span>
        <button
          class="btn btn-outline-primary"
          :disabled="paging.page >= paging.totalPages"
          @click="changePage(paging.page + 1)"
        >
          &gt;
        </button>
      </div>
    </div>
</template>

<script setup>
import { ref, inject, watch, onBeforeUnmount } from 'vue'
import TodoItem from '@/pages/TodoItem.vue';
import SearchInput from '@/components/SearchInput.vue'

const todoList = inject('todoList');
const { fetchTodoList } = inject('actions');

const paging = inject('paging');
const keyword = ref('') // 키워드 추가
const changePage = (page) => {

  fetchTodoList(page)
}
let timer = null
watch(keyword, (newValue) => {
  clearTimeout(timer)
  timer = setTimeout(() => {
    const value = newValue.trim()
    fetchTodoList(1, value)
  }, 300)
})
onBeforeUnmount(() => {
  clearTimeout(timer)
})
</script>
