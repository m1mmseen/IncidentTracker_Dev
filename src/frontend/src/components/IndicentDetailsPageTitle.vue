<template>
  <div class="container-fluid d-flex flex-column bg-success-subtle p-4 mb-2">
    <div><h2 class="float-start">{{ title }}</h2></div>
    <div><h4 class="float-start">{{ incidenttag }}</h4></div>
  </div>
</template>

<script>
export default {
  name: 'IncidentDetailsPageTitle',
  props: {
    title: String,
    incidenttag: String
  }
}
</script>

<style scoped>

</style>