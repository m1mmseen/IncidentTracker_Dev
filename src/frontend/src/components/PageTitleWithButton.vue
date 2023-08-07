<template>
  <div class="container-fluid bg-success-subtle p-4 m-2">
    <h2>{{ msg }}    <button class="float-end btn btn-warning text-light shadow-lg"><router-link to={{destination}} class="nav-link">{{buttonText}}</router-link></button>
    </h2>
  </div>
</template>

<script>
export default {
  name: 'PageTitleWithButton',
  props: {
    msg: String,
    destination: String,
    buttonText: String
  }
}
</script>

<style scoped>

</style>