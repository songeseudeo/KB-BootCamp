<template>
    <div>
        <li>
            <input type="checkbox" :checked="idol.checked">{{ idol.name }}
        </li>
    </div>
</template>

<script>
    export default {
        name: "CheckboxItem2",
        props: ['idol']
    }
</script>