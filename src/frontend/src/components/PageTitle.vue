<template>
  <div class="container-fluid bg-success-subtle p-4 m-2">
    <h2>{{ msg }}</h2>
  </div>
</template>

<script>
export default {
  name: 'PageTitle',
  props: {
    msg: String
  }
}
</script>

<style scoped>

</style>