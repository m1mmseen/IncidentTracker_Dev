
<template>
  <NavigationBar/>
  <h2>Hello Test Component: {{$route.params.id}}</h2>
  <p>{{data.titel}}</p>




</template>

<script>
import axios from "axios";
import { ref, watch } from 'vue';
import {useRoute} from "vue-router";
import NavigationBar from "../components/NavigationBar.vue";


export default {
  components: {
    NavigationBar
  },
  setup() {
    const route = useRoute();
    const id = ref(route.params.id); // Get id from route parameters
    const data = ref({}); // This will store the data fetched from the API

    const fetchData = async () => {
      try {
        const response = await axios.get(`/api/incident/${id.value}`);
        data.value = response.data;
      } catch (error) {
        console.error('Error fetching data with Axios:', error);
      }

    };


    watch(() => route.params.id, newVal => {
      id.value = newVal;
      fetchData();
      console.log("Fetched Data:", data.value);
    }, { immediate: true });

    return {
      id,
      data,
      fetchData,
    };
  }
}
</script>