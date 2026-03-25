<template>
    <!-- row: 가로 줄을 하나 만들겠다 -->
  <div class="row mb-3">
    <!-- col: 그 줄 안에서 칸을 나눈다 -->
    <div class="col">
        <!-- input과 butten을 하나의 덩어리로 묶어주겠다 -->
      <div class="input-group">
        <!-- form-control: 입력창을 스타일링 해준다 -->
         <!-- 
        v-model="todo": todo와 실시간으로 동기화
        @keyup.enter="addTodoHandler": 엔터치면 등록(단축키)
        @click="addTodoHandler": 추가 버튼 하면 addTodoHandler 실핼
          -->
        <input
          type="text"
          class="form-control"
          placeholder="할일을여기에입력!"
          v-model.trim="todo"
          @keyup.enter="addTodoHandler"
        />
         <!-- btn btn-primary: 버튼을 파란색으로 디자인 -->
         <!-- input-group-addon: 버튼을 입력창 오른쪽 끝에 붙이겠다 -->
        <span class="btn btn-primary input-group-addon" @click="addTodoHandler"
          >추가</span
        >
      </div>
    </div>
  </div>
</template>

<script>
export default {
    name: "InputTodo",
    data() {
        return {todo: ''}
    },
    emits : ["add-todo"],
    methods: {
        addTodoHandler() {
            if (this.todo.length >=3) {
                this.$emit('add-todo', this.todo);
                // emit 했으니까 빈칸으로 만들어
                this.todo = "";
            }
        }
    },
};
</script>