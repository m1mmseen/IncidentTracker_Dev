<template>
  <div class="home">
    <NavigationBarNoLogin/>
    <PageTitle msg="Home"/>
    <Welcome/>
  </div>
</template>

<script>

import PageTitle from "../components/PageTitle.vue";
import NavigationBar from "../components/NavigationBar.vue";
import Welcome from "../components/Welcome.vue";
import NavigationBarNoLogin from "../components/NavigationBarNoLogin.vue";

export default {
  name: 'HomeView',
  components: {
    NavigationBarNoLogin,
    Welcome,
    NavigationBar,
    PageTitle,
  }
}
</script>
