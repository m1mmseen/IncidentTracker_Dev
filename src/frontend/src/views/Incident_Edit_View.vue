<script setup>

import IncidentDetailsEdit from "../components/IncidentDetailsEdit.vue";
import NavigationBar from "../components/NavigationBar.vue";
import Footer from "../components/Footer.vue";
import PageTitleWithButton from "../components/PageTitleWithButton.vue";
</script>

<template>
  <NavigationBar/>
  <PageTitleWithButton msg="Edit Incident" destination="/incidents" buttonText="Back to List"/>
<IncidentDetailsEdit/>
  <Footer/>
</template>

<style scoped>

</style>