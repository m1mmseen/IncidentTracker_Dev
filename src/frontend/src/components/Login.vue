
<template>
  <div id="login">
    <div class="container border border-2 rounded p-4 mt-3">

      <form action="/">
        <div class="mb-3 row">
          <label for="EMail" class="col-sm-3 col-form-label">Email</label>
          <div class="col-sm-9">
            <input type="email" class="form-control" id="EMail">
          </div>
        </div>

        <div class="mb-3 row">
          <label for="inputPassword" class="col-sm-3 col-form-label">Password</label>
          <div class="col-sm-9">
            <input type="password" class="form-control" id="inputPassword">
          </div>
        </div>
        <button type="submit" class="btn btn-light border-2 border-dark-subtle ps-4 pe-4">Login</button>
      </form>
    </div>
    <img src="../assets/logo.png" alt="vuelogo" class="img-fluid">

  </div>
</template>

<script>
export default {
  name: 'Login',
}
</script>

<style scoped>

</style>