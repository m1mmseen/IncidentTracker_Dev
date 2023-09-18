<template>
  <NavigationBar/>
  <PageTitleWithButton msg="Dashboard" destination="/incidents/create" buttonText="Report new Incident"/>
  <h3 class="bg-success-subtle text-dark text-center mt-2 mb-2 rounded-4">Welcome <strong>{{user}}</strong>, let's check some incidents today</h3>
  <DashboardGrid/>
  <User_Footer_Menu/>
</template>

<script setup>

import NavigationBar from "../components/NavigationBar.vue";
import User_Footer_Menu from "../components/User_Footer_Menu.vue";
import PageTitleWithButton from "../components/PageTitleWithButton.vue";
import {useAuth} from "../stores/auth.js";
import {computed, onMounted, ref} from "vue";
import axios from "axios";
import DashboardGrid from "../components/DashboarsGrid.vue";

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