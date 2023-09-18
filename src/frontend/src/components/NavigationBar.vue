<template>
  <nav class="navbar navbar-expand-lg bg-body-tertiary sticky-top clearfix">
    <div class="container-fluid">
      <a class="navbar-brand display-4" href="#">Incident Tracker 1.0</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
           <li class="nav-item">
            <router-link to="/dashboard" class="nav-link">Dashboard</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/incidents" class="nav-link">Incidents</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/user/create" class="nav-link" v-if="isAdmin">Create User</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/dashboard/admin/user-overview" class="nav-link" v-if="isAdmin">Users</router-link>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  name: 'NavigationBar',
  computed: {
    isAdmin() {
      return localStorage.getItem('isAdmin') === 'true';
    }
  }
}
</script>

<style scoped>
.nav-item:hover {
  transform: scale(1.1);
  text-decoration: underline #42b983;
}

</style>