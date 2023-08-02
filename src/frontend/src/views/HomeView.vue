<template>
  <div class="home">
    <NavigationBarNoLogin/>
    <PageTitle msg="Home"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import NavigationBarNoLogin from "@/components/NavigationBarNoLogin.vue";
import PageTitle from "@/components/PageTitle.vue";

export default {
  name: 'HomeView',
  components: {
    PageTitle,
    NavigationBarNoLogin,
    HelloWorld
  }
}
</script>
