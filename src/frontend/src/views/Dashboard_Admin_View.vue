<template>
  <div class="admin-dashboard">
    <NavigationBar/>
    <PageTitle msg="Dashboard Admin"/>
  </div>
  <User_Footer_Menu/>
</template>

<script>

import PageTitle from "../components/PageTitle.vue";
import NavigationBar from "../components/NavigationBar.vue";
import User_Footer_Menu from "../components/User_Footer_Menu.vue";

export default {
  name: 'admin-dashboard',
  components: {
    PageTitle,
    NavigationBar,
    User_Footer_Menu
  }
}
</script>
