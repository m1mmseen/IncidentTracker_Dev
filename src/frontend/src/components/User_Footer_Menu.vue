<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "Footer"
})
</script>

<template>
  <div class="dropdown fixed-bottom mb-3 ms-3">
    <button class="btn btn-outline-light text-dark border-dark-subtle shadow p-3 me-2" type="button" data-bs-toggle="dropdown" aria-expanded="false">
      User Menu
    </button>
    <ul class="dropdown-menu dropdown-menu-end">
      <li><a class="dropdown-item" href="#">Settings</a></li>
      <li><a class="dropdown-item"><router-link to="/user" class="nav-link">User Details</router-link></a></li>
      <li><a class="dropdown-item" href="#">Password</a></li>
      <li><hr class="dropdown-divider"></li>
      <li><a class="dropdown-item" href="#">Log out</a></li>
    </ul>
  </div>
</template>

<style scoped>
.dropdown{
  right: unset;
}
</style>