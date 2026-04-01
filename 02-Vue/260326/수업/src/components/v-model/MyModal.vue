<template>
    <div v-if="visible" class="modal-backdrop">
        <div class="modal-box">
            <slot></slot>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'MyModal',
        props: {
            visible: {
                type: Boolean,
                default: false
            }
        },
        emits: ['update:visible'],
        methods: {
            closeModal() {
                this.$emit('update:visible', false)
            }
        }
    }
</script>

<style scoped>
.modal-backdrop {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0,0,0,0.5);
}
.modal-box {
  width: 300px;
  margin: 100px auto;
  padding: 20px;
  background: white;
  border-radius: 8px;
}
</style>