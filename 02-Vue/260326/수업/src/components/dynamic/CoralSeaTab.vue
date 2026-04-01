<template>
  <div class="tab">
    <h1>산호해 해전에 대해</h1>
    <div>{{ new Date().toTimeString() }}</div>
  </div>
</template>
<script>
export default {
    name: "CoralSeaTab",
    mounted() {
        console.log("CoralSeaTab 최초 생성 — 한 번만 실행");
    },
    activated() {
        console.log("CoralSeaTab 다시 탭으로 돌아옴 — 매번 실행");
        // API 호출, 데이터 새로고침 등
    },
    deactivated() {
        console.log("CoralSeaTab 다른 탭으로 이동 — 캐시에 유지");
        // 타이머 정지, 이벤트 해제 등
    },
    unmounted() {
        console.log("CoralSeaTab 완전히 제거됨");
    },
};
</script>
