<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "IncidentReportMenu",
  props: {
    activeTab: String
  }

})
</script>

<template>
  <ul class="nav nav-tabs">
    <li class="nav-item">
      <router-link to="/incidents/create" class="nav-link text-dark" :class="{'active' : activeTab === 'basic'}" aria-current="page">Basic</router-link>
    </li>
    <li class="nav-item">
      <router-link to="/incidents/notifications" class="nav-link text-dark" :class="{'active' : activeTab === 'notifications'}" href="#">Notifications (Optional)</router-link>
    </li>
  </ul>
</template>

<style scoped>

</style>