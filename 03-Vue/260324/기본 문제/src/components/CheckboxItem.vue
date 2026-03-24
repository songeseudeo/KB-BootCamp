<!-- 전역, 지역 함수 예제 -->
<!-- <template>
  <li>
    <input type="checkbox"> 옵션1
  </li>
</template>

<script>
export default {
  name: "CheckboxItem"
}
</script> -->


<!-- 바인딩 예제 -->
<template>
    <li>
        <input type="checkbox" :checked="checked">{{ name }}
    </li>
</template>
<script>
    export default {
        name: 'CheckboxItem',
        props: ["name", "checked"]
    }
</script>