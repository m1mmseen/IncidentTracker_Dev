<template>

  <div class="container-sm mt-3 border border-light-subtle rounded shadow p-4" :UserId="UserId">
    <div class="row">
      <h3>
        <span class="badge bg-info-subtle text-dark">{{ User.userId }}</span>
        {{ User.username }}
        <div class="btn-group float-end" role="group">
          <button type="button" class="btn btn-outline-dark dropdown-toggle" data-bs-toggle="dropdown"
                  aria-expanded="false">
            Actions
          </button>
          <ul class="dropdown-menu">
            <a class="dropdown-item" href="#" id="edit" @click.stop="editUser">Edit</a>
            <a class="dropdown-item" href="#" id="change" @click.stop="changePassword">Change Password</a>
            <a class="dropdown-item" href="#" id="delete" @click.stop="deleteUser">Delete</a>
          </ul>
        </div>
      </h3>
      <div class="card">
        <img src="../assets/vue.svg" class="card-img-top w-25">

        <ul class="list-group list-group-flush">
          <li class="list-group-item"> <span>Firstname: </span><span class="float-end">{{ User.firstname}}</span></li>
          <li class="list-group-item"><span>Lastname: </span><span class="float-end">{{ User.lastname}}</span></li>
          <li class="list-group-item"> <span>Userrole:</span><span class="float-end">{{authorities}}</span></li>
          <li class="list-group-item"><span>Assigned incidents: </span><span class="float-end">{{User.assignedIncidents}}</span></li>
          <li class="list-group-item"><span>Actual open incidents: </span><span class="float-end"></span></li>
        </ul>
      </div>
    </div>
  </div>


</template>

<script>
import axios from "axios";
import {ref, onMounted, computed} from "vue";
import {useRoute} from "vue-router";
import {useAuth} from "../stores/auth.js";

export default {
  setup() {
    const route = useRoute();
    const UserId = route.params.UserId;
    const User = ref({});
    const userdata = useAuth();
    const token = userdata.token;
    const userId = userdata.userId;
    const roles = ref([]);

    const fetchIncidentData = () => {
      const config = {
        headers: {
          Authorization: `Bearer ${token}`
        },
      };
      axios
          .get(`/api/user/${userId}`, config)
          .then((response) => {

            User.value = response.data;
            roles.value = User.value.roles;
          })
          .catch((error) => {
            console.error("Error fetching details:", error);
          });
    };

    onMounted(() => {
      fetchIncidentData();
    });
    const authorities = computed(() => {
      if (Array.isArray(roles.value)) {
        return roles.value.map(role => role.authority).join(', ');
      }
      return '';
    });

    return {
      authorities,
      User,
      roles
    };


  }
}



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