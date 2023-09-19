
<template>
  <div id="login">
    <div class="container border border-2 rounded p-4 mt-3">

      <form @submit.prevent="onSubmit">
        <div class="mb-3 row">
          <label for="username" class="col-sm-3 col-form-label">Username</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" id="username" v-model="user.username">
          </div>
        </div>

        <div class="mb-3 row">
          <label for="inputPassword" class="col-sm-3 col-form-label">Password</label>
          <div class="col-sm-9">
            <input type="password" class="form-control" id="inputPassword" v-model="user.password">
          </div>
        </div>
        <button type="submit" class="btn btn-light border-2 border-dark-subtle ps-4 pe-4">Login</button>
      </form>
    </div>


  </div>
</template>

<script setup>
import {reactive} from "vue";
import {useAuth} from "../stores/auth.js";

const user = reactive({
  username: '',
  password: ''
});

const onSubmit = () => {

  if (user.username !== '' && user.password !== '') {
      useAuth().login(user.username, user.password);
  } else {
    alert("Bitte alle Felder füllen");
  }
}


</script>

<style scoped>

</style>