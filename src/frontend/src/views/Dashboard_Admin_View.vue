<template>
  <div class="admin-dashboard">
    <NavigationBar/>
    <PageTitle msg="Dashboard Admin"/>
  </div>
</template>

<script>

import PageTitle from "../components/PageTitle.vue";
import NavigationBar from "../components/NavigationBar.vue";

export default {
  name: 'admin-dashboard',
  components: {
    PageTitle,
    NavigationBar,
  }
}
</script>
