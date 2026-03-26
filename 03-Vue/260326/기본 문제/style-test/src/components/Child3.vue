<template>
    <div :class="$style.child">
        <h2>Child3</h2>
    </div>
</template>

<script>
export default {
    name: 'Child3',
    created() {
        // 여기는 올바르게 작성하셨네요!
        console.log(this.$style);
    }
};
</script>

<style module>
.child {
  background-color: orange;
  border: solid 1px black;
  margin: 1.5em;
  padding: 1em;
}
</style>