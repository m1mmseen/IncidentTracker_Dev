

<template>
<NavigationBar/>
  <input type="text" v-model="testId">
  <button type="button" @click="goToDetails">Go to test View with id {{testId}} </button>

</template>
<script>

import NavigationBar from "../components/NavigationBar.vue";
import router from "../router/routes.js";

export default {
  components: {
    NavigationBar
  },
  data() {
    return {
      testId: ''
    };
  },
  methods: {
    goToDetails() {
      console.log(this.testId);
      router.push({name: 'test-comp', params: {
          id: this.testId
        }})
    }
  }
}
</script>