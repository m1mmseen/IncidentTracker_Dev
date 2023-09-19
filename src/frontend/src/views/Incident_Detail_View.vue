<script>

import NavigationBar from "../components/NavigationBar.vue";
import IncidentCard from "../components/IncidentCard.vue";
import PageTitleWithButton from "../components/PageTitleWithButton.vue";
import StatusNewUpdate from "../components/StatusNewUpdate.vue";
import StatusUpdates from "../components/StatusUpdates.vue";
import User_Footer_Menu from "../components/User_Footer_Menu.vue";

export default {
  props: {
    id: [Number, String]
  },
  components:{
    NavigationBar,
    PageTitleWithButton,
    IncidentCard,
    StatusNewUpdate,
    StatusUpdates,
    User_Footer_Menu

  }
}

</script>

<template>
  <NavigationBar/>
  <PageTitleWithButton msg="Incident Details" destination="/incidents" buttonText="Back to Incidents"/>
  <IncidentCard/>
  <StatusNewUpdate :incidentId="id"/>
  <StatusUpdates :incidentId="id"/>




  <User_Footer_Menu/>
</template>

