<template>
  <div class="container-fluid bg-success-subtle p-4 mt-2">
    <h2>{{ msg }}<button class="float-end btn btn-warning text-dark-emphasis shadow-lg"><router-link :to="dynamicRoute" class="nav-link">{{buttonText}}</router-link></button>
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
  },
  data() {
    return {
      dynamicRoute: this.destination
    };
  },
  methods: {
    navigateToDynamicRoute() {
      this.dynamicRoute = this.destination;
    }
  }
}
</script>

<style scoped>

</style>