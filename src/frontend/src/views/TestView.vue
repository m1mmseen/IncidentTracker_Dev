

<template>
<NavigationBar/>
  <p>{{getDate()}}</p>
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
    },
    getDate() {
      const unixTimestamp = 1691754964 *1000;

      const milliseconds = Date.now() ;

      const difference = milliseconds - unixTimestamp;

      const dateObject = new Date(difference);

      const humanDateFormat = dateObject.getMinutes();
      console.log(difference)

      const days = Math.floor(difference/1000/60/60/24)
      const hours = Math.floor(difference/1000/60/60)
      const minutes = Math.floor(difference/1000/60)
      const seconds = Math.floor(difference/1000)

      if (days > 0) {
        return days + " day(s) ago";
      } else if (minutes > 0) {
        return minutes + " minute(s) ago";
      } else if (seconds > 0) {
        return seconds + " seconds(s) ago";
      }
      return difference;



    }
  }
}
</script>