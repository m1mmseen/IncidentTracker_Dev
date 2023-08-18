<script setup>

import NavigationBar from "../components/NavigationBar.vue";
import PageTitle from "../components/PageTitle.vue";
import User_Footer_Menu from "../components/User_Footer_Menu.vue";
import PageTitleWithButton from "../components/PageTitleWithButton.vue";
</script>

<template>
  <NavigationBar/>
  <PageTitleWithButton msg="Dashboard" destination="/incidents/create" buttonText="Report new Incident"/>

  <User_Footer_Menu/>
</template>

<style scoped>

</style>