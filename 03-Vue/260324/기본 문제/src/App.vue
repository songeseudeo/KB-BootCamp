<!-- 1. 전역 컴포넌트 -->
<!-- <template>
  <div>
    <h2>App 컴포넌트</h2>
    <hr>
    <ul>
      <CheckboxItem/>
      <CheckboxItem/>
      <CheckboxItem/>
      <CheckboxItem/>
    </ul>
  </div>
</template>

<script>
import CheckboxItem from './components/CheckboxItem.vue';
  export default {
    name: 'app',
    components: {CheckboxItem},
  }
</script> -->

<!-- 2. 지역 컴포넌트 -->
<!-- <template>
  <div>
    <h2>App 컴포넌트</h2>
    <hr>
    <ul>
      <CheckboxItem/>
      <CheckboxItem/>
      <CheckboxItem/>
      <CheckboxItem/>
    </ul>
  </div>
</template>

<script>
import CheckboxItem from './components/CheckboxItem.vue';
  export default {
    name: "App",
    components: {
      CheckboxItem
    }
  }
</script> -->

<!-- 3. 바인딩 -->
 <template>
  <div>
    <h2>관심 있는 K-POP 가수</h2>
    <hr>
    <ul>
      <CheckboxItem
      v-for="idol in idols"
      :key="idol.id"
      :name="idol.name"
      :checked="idol.checked"
      />
    </ul>
  </div>
 </template>
 
 <script>
 import CheckboxItem from './components/CheckboxItem.vue';
  export default {
    name: 'app',
    components: {CheckboxItem},
    data() {
      return {
        idols: [
          {id: 1, name: 'BTS', checked: true},
          {id: 2, name: 'Black Pink', checked: false},
          {id: 3, name: 'EXO', checked: false},
          {id: 4, name: 'BTOB', checked: false}
        ],
      };
    },
  }
 </script>