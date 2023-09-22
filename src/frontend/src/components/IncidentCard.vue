<template>
  <div v-if="isLoading">Loading...</div>
  <div class="container-sm mt-3 border border-light-subtle rounded shadow p-4">
    <div class="row">
      <h3 class="col">
        <span class="badge bg-info-subtle text-dark">{{ incident.id }}</span>
        {{ incident.titel }}

      </h3>
      <div class="col text-end" >
        <div class="btn-group float-end" role="group"  v-if="isAdmin">
          <button type="button" class="btn btn-outline-dark dropdown-toggle" data-bs-toggle="dropdown"
                  aria-expanded="false">
            Actions
          </button>
          <ul class="dropdown-menu">
            <a class="dropdown-item" href="#" id="edit" @click.stop="editIncident">Edit</a>
            <a class="dropdown-item" href="#" id="delete" @click.stop="deleteIncident" >Delete</a>
          </ul>
        </div>
        <button class="btn btn-success me-2">Solved</button>
      </div>
    </div>
    <div class="row g-2">
      <div class="col">
        <p>Description: {{ incident.description }}</p>
        <p>Reportdate: {{ incident.reportdate }}</p>
        <p>Reporter: {{incident.username}}</p>
        <p v-if="incident.isSolved">
          Status: <b>solved</b>
        </p>

        <p v-else>
          Status: <b>open</b>
        </p>
        <p>Category: {{incident.categoryId}}</p>
        <p >Severity: {{incident.severityName}}</p>
      </div>
      <div class="col">
      </div>
    </div>
  </div>
  <StatusNewUpdate v-if="incident && incident.id" :incidentId="Number(incident.id)"/>
  <StatusUpdates v-if="incident && incident.id" :incidentId="Number(incident.id)"/>
</template>

<script>
import { watch, ref, computed } from 'vue';
import { useRoute } from 'vue-router';
import axios from 'axios';
import StatusNewUpdate from "./StatusNewUpdate.vue";
import StatusUpdates from "./StatusUpdates.vue";
import {useAuth} from "../stores/auth.js";

export default {
  name: 'IncidentCard',
  components: {
    StatusNewUpdate,
    StatusUpdates
  },

  setup() {

    const incident = ref({});
    const route = useRoute();
    const userData = useAuth();
    const token = userData.token;

    watch(() => route.params.id, async (newParams) => {


      if (newParams) {
        const config = {
          headers: {
            Authorization: `Bearer ${token}`
          },
        };
        try {
          const response = await axios.get(`/api/incident/${newParams}`, config);
          incident.value = response.data;
          console.log(response.data);
        }catch (error) {
          console.error('There was an error fetching the data:', error);
        }
      }
    }, {immediate: true});


    const isAdmin = computed(() => {
      return localStorage.getItem('isAdmin') === 'true';
    });

    // Computed property to check if myObject is still loading
    const isLoading = computed(() => {
      return Object.keys(incident.value).length === 0;
    });


    return {
      incident: incident,
      isLoading,
      isAdmin
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

#edit:hover {
  background-color: #6610f2;
  color: white;
}
</style>