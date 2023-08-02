<script setup>
defineOptions({
  inheritAttrs: false
})

</script>
<style>
.card:hover {
  -webkit-box-shadow: 5px 5px 12px -3px #878787;
  box-shadow: 5px 5px 12px -3px #878787;
}
.card {
  transition: box-shadow .5s;
}

</style>

<template>
    <div class="card mt-3" @click="greet" id="">
      <div class="card-header">
        <b class="float-start">{{ titel }}</b>
        <span class="float-end" v-bind="$attrs"><b>{{ incidenttag }}</b></span>

      </div>
      <div class="card-body">
        <p class="card-text">{{ text }}</p>
        <div class="btn-group float-end">
          <a href="#" class="btn btn-outline-dark">Edit</a>
          <a href="#" class="btn btn-outline-dark">Delete</a>
        </div>
      </div>
    </div>

</template>
<script>

import router from "@/router";

function greet(event) {
  router.push("/incidents/details/1")
}
export default {
  name: 'Incident',
  props: {
    titel: String,
    text: String,
    incidenttag: String,
  }
}
</script>

