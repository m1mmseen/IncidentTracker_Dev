<script setup>

import NavigationBar from "@/components/NavigationBar.vue";
import PageTitle from "@/components/PageTitle.vue";
import IncidentRow from "@/components/IncidentRow.vue";
</script>

<template>
  <NavigationBar/>
  <PageTitle msg="Incidents"/>
  <div class="container-sm">
    <IncidentRow titel="Incident 3" text="Mail from 02.07.2023" class="text-bg-info ps-4 pe-4 rounded text-light" incidenttag="Mail"/>

    <IncidentRow titel="Incident 5" text="Network crashing after update" class="text-bg-danger ps-4 pe-4 rounded text-light" incidenttag="Network"/>
  </div>
</template>

<style scoped>

</style>