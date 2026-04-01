<template>
  <div class="header">
    <h1 class="headerText">태평양 전쟁의 해전</h1>
    <nav>
      <ul class="nav nav-tabs nav-fill">
        <li v-for="tab in tabs" :key="tab.id" class="nav-item">
          <a style="cursor:pointer;" class="nav-link" :class="{ active: tab.id === currentTab }"
            @click="changeTab(tab.id)">{{ tab.label }}</a>
        </li>
      </ul>
    </nav>
  </div>

  <div>
    <KeepAlive> 
      <Suspense timeout="0">
        <template #default>
          <component :is="currentTab" />
        </template>
        <template #fallback>
          <Loading />
        </template>
      </Suspense>
    </KeepAlive> 
  </div>
</template>

<script>
// markRaw — Vue의 반응형 시스템이 해당 객체를 추적하지 않도록 제외시킨다.
// 컴포넌트 객체처럼 반응형으로 만들 필요가 없는 경우에 사용한다.
import { defineAsyncComponent, markRaw } from 'vue'
import pMinDelay from 'p-min-delay'

// 경로를 async -> dynamic으로 모두 변경했습니다.
import Loading from './components/dynamic/Loading.vue'

const CoralSeaTab = markRaw(defineAsyncComponent(() =>
  pMinDelay(import('./components/dynamic/CoralSeaTab.vue'), 1000)
))
const MidwayTabChart = markRaw(defineAsyncComponent(() =>
  pMinDelay(import('./components/dynamic/MidwayTabChart.vue'), 2000)
))
const LeyteGulfTab = markRaw(defineAsyncComponent(() =>
  pMinDelay(import('./components/dynamic/LeyteGulfTab.vue'), 5000)
))

export default {
  name: 'App',
  components: { Loading },
  data() {
    return {
      currentTab: CoralSeaTab,
      tabs: [
        { id: CoralSeaTab, label: '산호해 해전' },
        { id: MidwayTabChart, label: '미드웨이 해전' },
        { id: LeyteGulfTab, label: '레이테만 해전' },
      ]
    }
  },
  methods: {
    changeTab(tab) {
      this.currentTab = tab
    }
  }
}
</script>