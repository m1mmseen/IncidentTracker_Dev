<template>
  <div class="admin-dashboard">
    <NavigationBarAdmin/>
    <PageTitle msg="Dashboard Admin"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import NavigationBar from "@/components/NavigationBar.vue";
import PageTitle from "@/components/PageTitle.vue";
import NavigationBarAdmin from "@/components/NavigationBarAdmin.vue";

export default {
  name: 'admin-dashboard',
  components: {
    PageTitle,
    NavigationBarAdmin,
  }
}
</script>
