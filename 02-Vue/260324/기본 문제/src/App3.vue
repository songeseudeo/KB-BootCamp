<template>
  <div style="border: 1px solid gray; padding: 15px; width: 400px;">
    <h2>관심 있는 K-POP 가수</h2>
    <hr>
    <ul>
      <CheckboxItem3
        v-for="idol in idols"
        :key="idol.id"
        :id="idol.id"
        :name="idol.name"
        :checked="idol.checked"
      />
    </ul>
  </div>
</template>

<script>
import CheckboxItem3 from './components/CheckboxItem3.vue';

export default {
  name: "App3",
  components: { CheckboxItem3 },
  data() {
    return {
      idols: [
        { id: 1, name: 'BTS', checked: true },
        { id: 2, name: 'Black Pink', checked: false },
        { id: 3, name: 'EXO', checked: false },
        { id: 4, name: 'BTOB', checked: false }
      ]
    };
  }
}
</script>