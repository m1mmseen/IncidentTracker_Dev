<script setup>

</script>


<template>
  <div class="col card p-0 m-3">
    <div class="card-header bg-white">
      <h4>{{ cardTitle }}</h4>
    </div>
    <div class="card-title ps-2">
    </div>
    <div class="card-body text-center">
      <component :is="componentName"/>
    </div>

  </div>
</template>

<script>

import UserTableDashboard from "./UserTableDashboardView.vue";
import NotFound from "./NotFound.vue";
import IncidentTable from "./IncidentTable.vue";
import ActiveUsers from "./ActiveUsers.vue";

export default{
  name: 'DashboardCard',
  props: {
    cardTitle: String,
    component: String
  },

  components: {
    UserTableDashboard,
    IncidentTable,
    NotFound,
    ActiveUsers
  },
  computed: {
    componentName() {
      if (this.$props.component === 'users') {
        return 'UserTableDashboard'
      } else if (this.$props.component === 'incidents') {
        return 'IncidentTable'
      } else if (this.$props.component === 'activeUsers') {
        return 'ActiveUsers'
      }

      else {
        return 'NotFound'
      }
    }
  }

}

</script>

<style scoped>

</style>