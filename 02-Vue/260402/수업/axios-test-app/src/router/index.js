import { createRouter, createWebHistory } from 'vue-router'
// 보통 이곳에서 이동할 컴포넌트들을 import 합니다.
// 예: import HomeView from '../views/HomeView.vue'

const router = createRouter({
  // import.meta.env.BASE_URL은 Vite에서 기본 제공하는 환경 변수입니다.
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // 여기에 경로(path)와 컴포넌트(component) 설정을 추가합니다.
    /* {
      path: '/',
      name: 'home',
      component: () => import('../views/HomeView.vue') 
    }
    */
  ],
})

export default router