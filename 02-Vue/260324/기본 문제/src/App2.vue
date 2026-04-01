<template>
    <div>
        <h2>관심있는 K-POP 가수</h2>
        <hr>
        <ul>
            <CheckboxItem2
            v-for="idol in idols"
            :key="idol.id"
            :idol="idol"
            />
        </ul>
    </div>
</template>

<script>
import CheckboxItem2 from './components/CheckboxItem2.vue';

    export default {
        name: "app",
        components: {CheckboxItem2},
        data() {
            return {
                idols: [
                    {id: 1, name: 'BTS', checked: true},
                    {id: 2, name: 'Black Pink', checked: false},
                    {id: 3, name: 'EXO', checked: false},
                    {id: 4, name: 'BTOB', checked: false}
                ]
            }
        }
    }
</script>