<script setup>

import NavigationBar from "../components/NavigationBar.vue";
import PageTitleWithButton from "../components/PageTitleWithButton.vue";
import CreateIncidentForm from "../components/CreateIncidentForm.vue";
import User_Footer_Menu from "../components/User_Footer_Menu.vue";
</script>

<template>
  <NavigationBar/>
  <PageTitleWithButton msg="New Incident" destination="/incidents" buttonText="Back to List"/>
  <CreateIncidentForm/>
  <User_Footer_Menu/>


</template>

<style scoped>

</style>