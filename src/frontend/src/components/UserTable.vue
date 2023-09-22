<template>
  <div class="container-sm mt-3 border border-light-subtle rounded shadow p-4">
    <table class="table table-striped">
      <thead>
      <tr>
        <th scope="col" class="clickable text-nowrap" @click="sortById">Id</th>
        <th scope="col" class="clickable text-nowrap" @click="sortByUsername">Username</th>
        <th scope="col" class="clickable text-nowrap" @click="sortByFirst">Firstname</th>
        <th scope="col" class="clickable text-nowrap" @click="sortByLast">Last</th>
        <th scope="col" class="clickable text-nowrap" @click="sortByRole">Role</th>
        <th scope="col" class="clickable text-nowrap" @click="sortByLogin">Last Login</th>
        <th scope="col" class="clickable text-nowrap" @click="sortByIncidents">Assigned Incidents</th>
        <th scope="col" class="clickable text-nowrap" @click="sortByPasswordChanges">Last Password Change</th>
        <th scope="col">Actions</th>
      </tr>
      </thead>
      <tbody>
      <tr
          v-for="user in users"
          :key="user.id">
        <td>{{user.userId}}</td>
        <td>{{user.username}}</td>
        <td>{{user.firstname}}</td>
        <td>{{user.lastname}}</td>
        <td>{{user.highestAuthority}}</td>
        <td>Dummy</td>
        <td>{{ user.assignedIncidents}}</td>
        <td>Dummy</td>
        <td>
          <div class="dropdown">
            <button class="btn btn-close-white dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
            </button>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item bg-info clickable" @click="testMethod">Edit</a></li>
              <li><a class="dropdown-item bg-danger clickable" @click="deleteUser(user.userId)">Delete</a></li>
              <li><a class="dropdown-item bg-warning clickable" @click="testMethod">Change Password</a></li>
            </ul>
          </div>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>
<script>


import axios from "axios";
import {useAuth} from "../stores/auth.js";

const userdata = useAuth();
const config = {
  headers: {
    Authorization: `Bearer ${userdata.token}`
  }
};

export default {
  name: 'UserTable',
  data() {
    return {
      config: config,
      token: userdata.token,
      users: [],
    };
  },
  created() {
    this.fetchUsers();
  },
  methods: {
    async fetchUsers() {

      try {
        const response = await axios.get("/api/users", config);
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users: ", e);
      }
    },
    async sortById() {
      const sorting = "userId";
      try {
        const response = await axios.post("/api/usersCustomSort", {sorting: sorting}, config);
        this.users = response.data;
      } catch (e) {
        console.log(`Error fetching Users with desired sorting method: ${sorting}`, e);
      }
    },
    async sortByUsername() {
      const sorting = "username";
      try {
        const response = await axios.post("/api/usersCustomSort", {sorting: sorting}, config);
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },
    async sortByFirst() {
      const sorting = "firstname";
      try {

        const response = await axios.post("/api/usersCustomSort", {sorting: sorting}, config);
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },
    async sortByLast() {
      const sorting = "lastname";
      try {

        const response = await axios.post("/api/usersCustomSort", {sorting: sorting}, config);
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },
    async sortByRole() {
      const sorting = "role";
      try {

        const response = await axios.post("/api/usersCustomSort", {sorting: "role"}, config);
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },

    async sortByLogin() {
      const sorting = "last login";
      try {

        const response = await axios.post("/api/usersCustomSort", {sorting: "login"}, config);
        this.users = response.data;
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },

    async sortByIncidents() {
      const sorting = "assigned Incidents";
      try {

        const response = await axios.post("/api/usersCustomSort", {sorting: "incidents"}, config);
        this.users = response.data;
      } catch (e) {
        console.log("Error fetching Users with desired sorting method: id", e);
      }
    },

    async sortByPasswordChanges() {
      const sorting = "password change";
      try {

        const response = await axios.post("/api/usersCustomSort", {sorting: "pwchanges"}, config);
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