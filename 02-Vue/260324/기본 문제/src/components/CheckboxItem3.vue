<template>
  <li>
    <input type="checkbox" :checked="checked"> {{ name }} (ID: {{ id }})
  </li>
</template>

<script>
export default {
  name: "CheckboxItem3",
  props: {
    // 1. id는 숫자 또는 문자열만 허용
    id: [Number, String],
    
    // 2. name은 반드시 문자열이어야 함
    name: {
      type: String,
      required: true
    },
    
    // 3. checked는 불리언(T/F), 안 오면 기본값은 false
    checked: {
      type: Boolean,
      default: false
    }
  }
}
</script>