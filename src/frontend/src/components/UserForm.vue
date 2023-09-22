<template>

  <div class="container-sm mt-3 border border-light-subtle rounded shadow p-4" :UserId="UserId">
    <div class="row">
        <form class="card border-0">
          <div class="input-group mb-3">
            <input type="file" class="form-control" id="profile-image">
            <label class="input-group-text" for="profile-image">Profile Image</label>
          </div>
          <div class="input-group flex-nowrap mb-3">
            <span class="input-group-text" id="addon-wrapping">Username</span>
            <input type="text" class="form-control" aria-label="Username" aria-describedby="addon-wrapping">
          </div>
          <div class="input-group flex-nowrap mb-3">
            <span class="input-group-text" id="addon-wrapping">Firstname</span>
            <input type="text" class="form-control" aria-label="Firstname" aria-describedby="addon-wrapping">
            <span class="input-group-text" id="addon-wrapping">Lastname</span>
            <input type="text" class="form-control" aria-label="Lastname" aria-describedby="addon-wrapping">
          </div>
          <div class="input-group flex-nowrap mb-3">
            <span class="input-group-text" id="addon-wrapping">Password</span>
            <input type="password" class="form-control" aria-label="Username" aria-describedby="addon-wrapping">
          </div>
          <div class="input-group flex-nowrap mb-3">
            <span class="input-group-text" id="addon-wrapping">Confirm Password</span>
            <input type="password" class="form-control" aria-label="Username" aria-describedby="addon-wrapping">
          </div>
          <button class="btn btn-outline-success" type="submit">Sign in</button>
        </form>

    </div>
  </div>


</template>

<script setup>
import axios from "axios";
import {ref, onMounted, computed} from "vue";
import {useRoute} from "vue-router";
import router from "../router/routes.js";
import StatusUpdates from "./StatusUpdates.vue";
import StatusNewUpdate from "./StatusNewUpdate.vue";

const route = useRoute();
const UserId = route.params.UserId;
const User = ref({});

onMounted(() => {
  fetchIncidentData();
});

const fetchIncidentData = () => {
  axios
      .get(`/api/user/1`) // Replace with userId
      .then((response) => {
        console.log(User)
        User.value = response.data;
      })
      .catch((error) => {
        console.error("Error fetching details:", error);
      });
};


const editUser = () => {
  alert("Edit User Method");
};
const changePassword = () => {
  alert("Change Password Method");
};

const deleteUser = () => {
  alert("Delete User Method");
};


</script>
<style scoped>
.card:hover {
  box-shadow: none;
}

#delete:hover {
  background-color: #dc3545;
  color: white;
}

#change:hover {
  background-color: #ffda6a;
  color: black;
}

#edit:hover {
  background-color: #6610f2;
  color: white;
}
</style>