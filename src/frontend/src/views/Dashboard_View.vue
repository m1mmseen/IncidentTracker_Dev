<template>
  <NavigationBar/>
  <PageTitleWithButton msg="Dashboard" destination="/incidents/create" buttonText="Report new Incident"/>
  <h1 class="text-bg-light">Hello {{user}}</h1>
  <User_Footer_Menu/>
</template>

<script setup>

import NavigationBar from "../components/NavigationBar.vue";
import User_Footer_Menu from "../components/User_Footer_Menu.vue";
import PageTitleWithButton from "../components/PageTitleWithButton.vue";
import {useAuth} from "../stores/auth.js";
import {computed, onMounted, ref} from "vue";
import axios from "axios";

const auth = useAuth();
const token = auth.token;
const userId = auth.userId;
const user = auth.user;
const data = ref('');

onMounted(async () => {
  const response = axios.request({
    headers: {
      Authorization: `Bearer ${token}`
    },
    method: "GET",
    url: `/api/user/${userId}`
  }).then(response => {
    console.log(response.data);
  });
  data.value = response.data;
})


</script>



<style scoped>

</style>