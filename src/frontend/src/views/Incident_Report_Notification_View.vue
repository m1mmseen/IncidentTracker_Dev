<script setup>

import NavigationBar from "../components/NavigationBar.vue";
import PageTitleWithButton from "../components/PageTitleWithButton.vue";
import Notifications from "../components/Notifications.vue";
import User_Footer_Menu from "../components/User_Footer_Menu.vue";
import IncidentReportMenu from "../components/IncidentReportMenu.vue";
</script>

<template>
  <NavigationBar/>
  <PageTitleWithButton msg="New Incident" destination="/incidents" buttonText="Back to List"/>
  <IncidentReportMenu active-tab="notifications"/>
  <Notifications/>
  <User_Footer_Menu/>


</template>

<style scoped>

</style>