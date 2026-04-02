import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
    path: '/',
    name: 'home',
    component: () => import('../App.vue') // 혹은 현재 작업 중인 메인 컴포넌트
  }
  ],
})

export default router
