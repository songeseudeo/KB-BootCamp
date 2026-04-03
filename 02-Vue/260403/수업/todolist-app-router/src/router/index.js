import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/Home.vue';
import About from '@/pages/About.vue';
import TodoList from '@/pages/TodoList.vue';
import AddTodo from '@/pages/AddTodo.vue';
import EditTodo from '@/pages/EditTodo.vue';
import NotFound from '@/pages/NotFound.vue';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', name: 'Home', component: Home },
    { path: '/about', name: 'about', component: About },
    { path: '/todos', name: 'todos', component: TodoList },
    { path: '/todos/add', name: 'todos/add', component: AddTodo },
    { path: '/todos/edit/:id', name: 'todos/edit', component: EditTodo },
    { path: '/:paths(.*)*', name: 'notfound', component: NotFound },
  ],
});

export default router;
