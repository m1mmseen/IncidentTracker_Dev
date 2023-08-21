
<template>
  <NavigationBar/>
  <PageTitleWithButton msg="Incidents" destination="/incidents/create" buttonText="Report new Incident"/>
  <div class="container-sm">
    <IncidentRow/>
  </div>
  <User_Footer_Menu/>

</template>
<script>

import NavigationBar from "../components/NavigationBar.vue";
import PageTitleWithButton from "../components/PageTitleWithButton.vue";
import IncidentRow from "../components/IncidentRow.vue";

import User_Footer_Menu from "../components/User_Footer_Menu.vue";

export default {
  components: {
    NavigationBar,
    PageTitleWithButton,
    IncidentRow,
    User_Footer_Menu
  }
}
</script>

