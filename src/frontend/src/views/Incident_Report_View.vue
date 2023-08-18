<script setup>

import NavigationBar from "../components/NavigationBar.vue";
import PageTitleWithButton from "../components/PageTitleWithButton.vue";
import CreateIncidentForm from "../components/CreateIncidentForm.vue";
</script>

<template>
  <NavigationBar/>
  <PageTitleWithButton msg="New Incident" destination="/incidents" buttonText="Back to List"/>
  <CreateIncidentForm/>


</template>

<style scoped>

</style>