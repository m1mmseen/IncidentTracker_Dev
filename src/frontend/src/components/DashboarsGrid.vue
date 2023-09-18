
<template>
  <div class="container text-center">
    <div class="row">
      <DashboardCard card-title="Latest Incidents" component="incidents"/>
      <DashboardCard card-title="Recent Activities" component="notfound"/>
    </div>
    <div class="row mt-3" v-if="isAdmin">
      <DashboardCard card-title="Active Users" component="activeUsers"/>
      <DashboardCard card-title="Failed Logins" component="notfound"/>
    </div>
  </div>
</template>

<script>

  import DashboardCard from "./DashboardCard.vue";

  export default {
    name: 'DashboardGrid',
    components: {DashboardCard},
    computed: {
      isAdmin() {
        return localStorage.getItem('isAdmin') === 'true';
      }
    }
  }

</script>