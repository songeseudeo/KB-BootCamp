<template>
  <div class="container">
    <div class="card card-body bg-light">
      <div class="title">:: Todolist App</div>
    </div>
    <div class="card card-default card-borderless">
      <div class="card-body">
        <div>키워드검색1 <SearchInput @search="onSearch" /></div>

        <InputTodo @add-todo="addTodo" />
        <TodoList
          :todoList="filteredList"
          @delete-todo="deleteTodo"
          @toggle-completed="toggleCompleted"
        />
      </div>
    </div>
  </div>
</template>

<script setup>
import { reactive, ref, computed } from 'vue';
import TodoList from './components/TodoList.vue';
import InputTodo from './components/InputTodo.vue';
import SearchInput from './components/SearchInput.vue';

let ts = new Date().getTime();

const todoList = reactive([
  { id: ts, todo: '자전거 타기', completed: false },
  { id: ts + 1, todo: '딸과 공원 산책', completed: true },
  { id: ts + 2, todo: '일요일 애견 카페', completed: false },
  { id: ts + 3, todo: 'Vue 원고 집필', completed: false },
]);

// 2. 검색 버튼을 눌렀을 때만 업데이트될 검색어 변수
const searchKeyword = ref('');

// 3. 자식(SearchInput)이 보낸 검색어를 수신하여 변수 업데이트
const onSearch = (value) => {
  searchKeyword.value = value;
};

// 4. 필터링 로직은 이제 searchKeyword가 바뀔 때만 다시 계산됩니다
const filteredList = computed(() => {
  return todoList.filter((item) => item.todo.includes(searchKeyword.value));
});

// ... addTodo, deleteTodo, toggleCompleted 로직은 그대로 유지
const addTodo = (todo) => {
  if (todo.length >= 3) {
    todoList.push({ id: new Date().getTime(), todo: todo, completed: false });
  }
};

const deleteTodo = (id) => {
  let index = todoList.findIndex((item) => id === item.id);
  if (index !== -1) todoList.splice(index, 1);
};

const toggleCompleted = (id) => {
  let index = todoList.findIndex((item) => id === item.id);
  if (index !== -1) todoList[index].completed = !todoList[index].completed;
};
</script>