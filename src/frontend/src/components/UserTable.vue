<template>
  <div class="container-sm mt-3 border border-light-subtle rounded shadow p-4">
    <table class="table table-striped">
      <thead>
      <tr>
        <th scope="col" class="clickable" @click="sortById">Id</th>
        <th scope="col" class="clickable" @click="sortByUsername">Username</th>
        <th scope="col" class="clickable" @click="sortByFirst">Firstname</th>
        <th scope="col" class="clickable" @click="sortByLast">Last</th>
        <th scope="col" class="clickable" @click="sortByRole">Role</th>
        <th scope="col" class="clickable" @click="sortByLogin">Last Login</th>
        <th scope="col" class="clickable" @click="sortByIncidents">Assigned Incidents</th>
        <th scope="col" class="clickable" @click="sortByPasswordChanges">Last Password Change</th>
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
        <td>
          <button class="btn btn-info me-2" @click.stop="editUser">Edit</button>
          <button class="btn btn-danger" @click.stop="deleteUser(user.id)">Delete</button>
        </td>
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
    },
    async sortByUsername() {
      try {

        const response = await axios.post("/api/usersCustomSort", {sorting: "id"});
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },
    async sortByFirst() {
      try {

        const response = await axios.post("/api/usersCustomSort", {sorting: "first"});
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },
    async sortByLast() {
      try {

        const response = await axios.post("/api/usersCustomSort", {sorting: "last"});
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },
    async sortByRole() {
      try {

        const response = await axios.post("/api/usersCustomSort", {sorting: "role"});
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },

    async sortByLogin() {
      try {

        const response = await axios.post("/api/usersCustomSort", {sorting: "login"});
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },

    async sortByIncidents() {
      try {

        const response = await axios.post("/api/usersCustomSort", {sorting: "incidents"});
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },

    async sortByPasswordChanges() {
      try {

        const response = await axios.post("/api/usersCustomSort", {sorting: "pwchanges"});
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },
    testMethod() {
      alert("Geht");
    },
    deleteUser(id) {
      if (confirm("Do you really want to delete User with id: " + id)) {
        alert("Deleted");
      }
    }
  }
}

</script>

<style>
.clickable{
  cursor: pointer;
}
</style>