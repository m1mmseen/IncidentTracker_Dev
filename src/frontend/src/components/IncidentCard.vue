<template>
  <IncidentDetailsPageTitle title="Incident No. 5" incidenttag="Mail"/>
</template>

<script>

import NavigationBar from "@/components/NavigationBarAdmin.vue";
import IncidentDetailsPageTitle from "@/components/IndicentDetailsPageTitle.vue";

export default {
  name: 'IncidentCard',
  components: {IncidentDetailsPageTitle, NavigationBar}
}
</script>
