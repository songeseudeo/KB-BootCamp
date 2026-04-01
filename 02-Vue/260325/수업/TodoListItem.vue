<template>
    <!-- list-group-item -> 깔끔한 목록 형태로 디자인 -->
     <!-- todoItem.completed 값이 true면 list-group-item-success 배경색을 초록색으로 바꿔줌 -->
    <li class="list-group-item"
    :class="{'list-group-item-success': todoItem.completed}"
    @click="$emit('toggle-completed', todoItem.id)"
    >
    <span class="pointer" :class="{'todo-done': todoItem.completed}">
        {{ todoItem.todo }} {{ todoItem.completed ? '(완료)' : '' }}
    </span>
    <span class="float-end badge bg-secondary pointer"
    @click.stop="$emit('delete-todo', todoItem.id)"
    >삭제</span>
    </li>
</template>

<script>
    export default {
        name: 'TodoListItem',
        props: {
            // required: true -> todoItem이 없으면 안 돼 무조건 받아야 해
            todoItem: {type: Object, required: true},
        },
        emits: ['delete-todo', 'toggle-completed']
    }
</script>