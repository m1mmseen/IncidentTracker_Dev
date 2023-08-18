<script setup>

import NavigationBar from "../components/NavigationBar.vue";
import PageTitleWithButton from "../components/PageTitleWithButton.vue";
import IncidentRow from "../components/IncidentRow.vue";



</script>
<template>
  <NavigationBar/>
  <PageTitleWithButton msg="Incidents" destination="/incidents/create" buttonText="Report new Incident"/>
  <div class="container-sm">
    <IncidentRow/>
  </div>

</template>
<script>


</script>


