<template>
  <div style="padding: 20px;">
    <InputName @nameChanged="parentHandler" />
    <br />
    <h3>App 데이터 : {{ parentName }}</h3>
  </div>
</template>

<script>
import InputName from "./components/InputName.vue";

export default {
  name: "App4",
  components: { InputName },
  data() {
    return {
      parentName: "", // 자식에게 받은 데이터를 저장할 변수
    };
  },
  methods: {
    parentHandler(name) {
      this.parentName = name;
    },
  },
};
</script>