<script setup>

</script>


<template>
  <div class="col card p-0 me-3 ms-3">
    <div class="card-header bg-white"></div>
    <div class="card-title ps-2">
      <h3>{{ cardTitle }}</h3>
    </div>
    <div class="card-body text-center">
      <component :is="componentName"/>
    </div>

  </div>
</template>

<script>

import UserTable from "./UserTable.vue";
import IncidentRow from "./IncidentRow.vue";
import NotFound from "./NotFound.vue";
import IncidentTable from "./IncidentTable.vue";

export default{
  name: 'DashboardCard',
  props: {
    cardTitle: String,
    component: String
  },

  components: {
    UserTable,
    IncidentTable,
    NotFound
  },
  computed: {
    componentName() {
      if (this.$props.component === 'users') {
        return 'UserTable'
      } else if (this.$props.component === 'incidents') {
        return 'IncidentTable'
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