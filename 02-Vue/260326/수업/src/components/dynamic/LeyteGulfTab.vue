<template>
  <div class="tab">
    <h1>레이테만 해전에 대해</h1>
    <div>{{ new Date().toTimeString() }}</div>
  </div>
</template>
<script>
export default {
  name: "LeyteGulfTab",
  mounted() {
    console.log("LeyteGulfTab 최초 생성 — 한 번만 실행");
  },
  activated() {
    console.log("LeyteGulfTab 다시 탭으로 돌아옴 — 매번 실행");
    // API 호출, 데이터 새로고침 등
  },
  deactivated() {
    console.log("LeyteGulfTab 다른 탭으로 이동 — 캐시에 유지");
    // 타이머 정지, 이벤트 해제 등
  },
  unmounted() {
    console.log("LeyteGulfTab 완전히 제거됨");
  },
};
</script>
