<template>
  <div style="border: 1px solid silver; padding: 10px;">
    이름: <input type="text" v-model="name" />
    <button @click="nameChangedHandler">이벤트 발신</button>
  </div>
</template>

<script>
export default {
  name: "InputName",
  data() {
    return { name: "" };
  },
  // [문제 조건] 이벤트 유효성 검사 추가
  emits: {
    nameChanged: (name) => {
      if (name && typeof name === "string" && name.trim().length >= 3) {
        return true; // 검사 통과
      } else {
        console.warn("유효성 검사 실패: 이름은 3글자 이상이어야 합니다.");
        return false; // 콘솔에 경고 출력
      }
    },
  },
  methods: {
    nameChangedHandler() {
      // 부모에게 'nameChanged'라는 이름으로 현재 입력된 name을 보냄
      this.$emit("nameChanged", this.name);
    },
  },
};
</script>