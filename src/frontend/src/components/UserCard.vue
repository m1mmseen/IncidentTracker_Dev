<template>

  <div class="container-sm mt-3 border border-light-subtle rounded shadow p-4" :UserId="UserId">
    <div class="row">
      <h3>
        <span class="badge bg-info-subtle text-dark">{{ User.id }}</span>
        {{ User.username }}
        <div class="btn-group float-end" role="group">
          <button type="button" class="btn btn-outline-dark dropdown-toggle" data-bs-toggle="dropdown"
                  aria-expanded="false">
            Actions
          </button>
          <ul class="dropdown-menu">
            <a class="dropdown-item" href="#" id="edit" @click.stop="">Edit</a>
            <!-- <a class="dropdown-item" href="#" id="delete" @click.stop="deleteIncident">Delete</a>-->
          </ul>
        </div>
      </h3>
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
      .get(`/api/user/1`)
      .then((response) => {
        console.log(User)
        User.value = response.data;
      })
      .catch((error) => {
        console.error("Error fetching details:", error);
      });
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

#edit:hover {
  background-color: #6610f2;
  color: white;
}
</style>