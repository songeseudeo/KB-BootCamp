<template>
    <div>id에 따른 개인정보 화면</div>
    <img :src="member.photo"/>
    <h4>{{ member.name }} / {{ member.role }}</h4>
    <p>{{ member.desc }}</p>
</template>

<script setup>
import members from '@/members.json';
import { useRoute } from 'vue-router';

const route = useRoute();
const id = parseInt(route.params.id);
const member = members.find(m => m.id === id)

</script>