<template>
  <div class="container">
    <Header />
    <router-view />
  </div>
</template>
<script setup>
import { reactive, computed, provide } from 'vue';
import Header from '@/components/Header.vue';
import axios from 'axios';
const states = reactive({
  todoList: [],
  page:1, // 현재페이지 번호
  perPage:5, // 한페이지에 보여줄 데이터수
  totalcount :0, // 전체 데이터수
    keyword: ''
});

const BASEURI = '/api/todos'

const fetchTodoList = async (page = 1, keyword = '') => {

  try {
    // const response = await axios.get(BASEURI,{
    //     params:{
    //       _page: page,
    //       _per_page: states.perPage,
    //       _sort:'-done,-id'
    //       // _order:'desc,asc'
    //     }


    // });

    //2. 키워드 추가후
    const params = {
      _page: page,
      _per_page: states.perPage,
      _sort: '-done,-id'
    }

    // 검색어가 있을 때만 추가
    if (keyword.trim()) {
      // json-server 버전에 따라 검색 방식이 다를 수 있음
      //npm list -g --depth=0  버전확인 //   0.17.4 버전  params['todo_like'] = keyword.trim()
      params['todo:contains'] = keyword.trim()
    }
     const response = await axios.get(BASEURI, { params })

    console.log(response.data);

    states.todoList = response.data.data
    states.totalcount = response.data.items
    states.page = page

    // 0.17.4
  // const response = await axios.get(BASEURI, {
  //       params: {
  //         _page: page,
  //         _limit: states.perPage,
  //         _sort: 'done,id',
  //         _order: 'asc,desc',
  //       },
  //     });
  // states.todoList = response.data;
  // states.totalcount = parseInt(response.headers['x-total-count'], 10);
  //states.page = page

  } catch (e) {
    alert('error'+ e)
  }
}
fetchTodoList();


const addTodo = async ({ todo, desc }) => {
  let payload = {
      id: new Date().getTime(),//유일한키   
      todo,
      desc,
      done: false,
    };
  try {
    const response = await axios.post(BASEURI, payload);

    await fetchTodoList();

  } catch (error) {
     alert('에러발생 :' + error);
  }
};
const updateTodo = async ({ id, todo, desc, done }) => {
  let payload = {
       id, todo, desc, done
    };
  try {
    const response = await axios.put(BASEURI+'/'+ id, payload);

    await fetchTodoList();

  } catch (error) {
     alert('에러발생 :' + error);
  }
};
const deleteTodo = async (id) => {
 try {
    const response = await axios.delete(BASEURI+'/'+ id);

    await fetchTodoList();

  } catch (error) {
     alert('에러발생 :' + error);
  }
};
const toggleDone = async (id) => {
  try {
    const todo = states.todoList.find((todo) => todo.id === id);
    console.log(todo)
    const response = await axios.put(BASEURI+'/'+ id , { ...todo, done: !todo.done })
    await fetchTodoList();

  } catch (error) {
     alert('에러발생 :' + error);
  }

};
// totalPages 계산 - 한 곳에서만 관리
// 전체 데이터 개수(totalCount) ÷ 페이지당 개수(perPage)를 올림하여 총 페이지 수 계산
// ex) totalCount=23, perPage=5 → 23/5=4.6 → 올림 → 5페이지
// 데이터가 하나도 없을 경우(0/5=0) 화면상 최소 1페이지는 유지하기 위해 || 1 처리

const totalPages = computed(()=> Math.ceil(states.totalcount / states.perPage) || 1)



provide(
  'todoList', 
  computed(() => states.todoList),
);
provide('actions', { addTodo, deleteTodo, toggleDone, updateTodo , fetchTodoList});

provide('paging', computed(()=>({

  page: states.page,
  perPage: states.perPage,
  totalcount: states.totalcount,
  totalPages: totalPages.value
})))
</script>
