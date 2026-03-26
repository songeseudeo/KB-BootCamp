<template>
  <div class="header">
    <h1 class="headerText">태평양 전쟁의 해전</h1>
    <nav>
      <ul class="nav nav-tabs nav-fill">
        <li v-for="tab in tabs" :key="tab.id" class="nav-item">
          <a
            style="cursor: pointer"
            class="nav-link"
            :class="{ active: tab.id === currentTab }"
            @click="changeTab(tab.id)"
            >{{ tab.label }}</a
          >
        </li>
      </ul>
    </nav>
  </div>
  <div>
    <component :is="currentTab" />
  </div>
</template>
<script>
// markRaw — Vue의 반응형 시스템이 해당 객체를 추적하지 않도록 제외시킨다.
// 컴포넌트 객체처럼 반응형으로 만들 필요가 없는 경우에 사용한다.
import { definedynamicComponent, markRaw } from "vue";
import pMinDelay from "p-min-delay";
import Loading from "./components/dynamic/Loading.vue";
import ErrorMessage from "./components/dynamic/ErrorMessage.vue";

// import() → 컴포넌트 비동기 로드
// pMinDelay → 최소 시간 보장
const CoralSeaTab = markRaw(
  definedynamicComponent({
    loader: () =>
      pMinDelay(import("./components/dynamic/CoralSeaTab.vue"), 2000),
    loadingComponent: Loading,
  }),
);

const MidwayTab = markRaw(
  definedynamicComponent({
    loader: () => pMinDelay(import("./components/dynamic/MidwayTab.vue"), 2000),
    loadingComponent: Loading,
    errorComponent: ErrorMessage,
    delay: 200,
    timeout: 1000,
  }),
);
// 실제 로딩은 최소 2초
// timeout은 1초
// 미드웨이 탭 클릭 시 1초 뒤 ErrorMessage가 보여야 정상

const LeyteGulfTab = markRaw(
  definedynamicComponent({
    loader: () =>
      pMinDelay(import("./components/dynamic/LeyteGulfTab.vue"), 2000),
    loadingComponent: Loading,
  }),
);
// 동적 컴포넌트(`<component :is="">`)는 문자열뿐 아니라 컴포넌트 객체도 전달할 수 있다.
// 비동기 컴포넌트는 `definedynamicComponent()`가 컴포넌트 객체를 반환하므로,
// 이 객체를 직접 사용하는 방식이 더 명확하고 안정적이다.
export default {
  name: "App",
  components: { CoralSeaTab, LeyteGulfTab, MidwayTab },
  data() {
    return {
      currentTab: CoralSeaTab,

      tabs: [
        { id: CoralSeaTab, label: "산호해 해전" },
        { id: MidwayTab, label: "미드웨이 해전" },
        { id: LeyteGulfTab, label: "레이테만 해전" },
      ],
    };
  },
  methods: {
    changeTab(tab) {
      this.currentTab = tab;
    },
  },
};
</script>
<style>
.header {
  padding: 20px 0px 0px 20px;
}
.headerText {
  padding: 0px 20px 40px 20px;
}
.tab {
  padding: 30px;
}
</style>
<!-- 앱 시작
비동기 컴포넌트 객체 생성
data() 실행
currentTab = CoralSeaTab
<component :is="currentTab" /> 렌더링
CoralSeaTab 로딩 시작
로딩 화면 표시
2초 후 CoralSeaTab.vue 표시 


미드웨이 탭 클릭
클릭 이벤트 발생
changeTab(MidwayTab) 실행
currentTab이 MidwayTab으로 변경
<component :is="MidwayTab" /> 렌더링 시도
loader 시작
200ms 후 Loading 표시
1000ms 후 timeout 발생
ErrorMessage 표시
-->
