<script setup>

import NavigationBar from "../components/NavigationBar.vue";
import IncidentCard from "../components/IncidentCard.vue";
import PageTitleWithButton from "../components/PageTitleWithButton.vue";
import User_Footer_Menu from "../components/User_Footer_Menu.vue";

</script>

<template>
  <NavigationBar/>
  <PageTitleWithButton msg="Incident Details" destination="/incidents" buttonText="Back to list"/>
  <IncidentCard/>
  <User_Footer_Menu/>
</template>

