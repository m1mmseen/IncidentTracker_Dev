<template>
  <div class="home">
    <NavigationBar/>
    <PageTitle msg="Home"/>
  </div>
</template>

<script>

import HelloWorld from '../components/HelloWorld.vue'
import PageTitle from "../components/PageTitle.vue";
import NavigationBar from "../components/NavigationBar.vue";

export default {
  name: 'HomeView',
  components: {
    NavigationBar,
    PageTitle,

    HelloWorld
  }
}
</script>
