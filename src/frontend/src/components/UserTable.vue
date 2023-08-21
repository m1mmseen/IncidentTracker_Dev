<template>
  <div class="container-sm mt-3 border border-light-subtle rounded shadow p-4">
    <table class="table">
      <thead>
      <tr>
        <th scope="col"><button @click.stop="sortById">Id</button></th>
        <th scope="col">Username</th>
        <th scope="col">First</th>
        <th scope="col">Last</th>
        <th scope="col">Role</th>
        <th scope="col">Last Login</th>
        <th scope="col">Assigned Incidents</th>
        <th scope="col">Last password Change</th>
        <th scope="col">Actions</th>
      </tr>
      </thead>
      <tbody>
      <tr
          v-for="user in users"
          :key="user.id">
        <td>{{user.id}}</td>
        <td>{{user.username}}</td>
        <td>{{user.firstname}}</td>
        <td>{{user.lastname}}</td>
        <td>{{user.role}}</td>
        <td>Dummy</td>
        <td>Dummy</td>
        <td>Dummy</td>
        <td><button class="btn btn-info me-2">Edit</button><button class="btn btn-danger">Delete</button> </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>
<script>


import axios from "axios";

export default {
  name: 'UserTable',
  data() {
    return {
      users: [],
    };
  },
  created() {
    this.fetchUsers();
  },
  methods: {
    async fetchUsers() {
      try {
        const response = await axios.get("/api/users");
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users: ", e);
      }
    },
    async sortById() {
      try {

        const response = await axios.post("/api/usersCustomSort", {sorting: "id"});
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    }
  }
}

</script>