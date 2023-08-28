<template>
  <div v-if="isLoading">Loading...</div>
  <div class="container-sm mt-3 border border-light-subtle rounded shadow p-4">
    <div class="row">
      <h3>
        <span class="badge bg-info-subtle text-dark">{{ incident.id }}</span>
        {{ incident.titel }}
        <div class="btn-group float-end" role="group">
          <button type="button" class="btn btn-outline-dark dropdown-toggle" data-bs-toggle="dropdown"
                  aria-expanded="false">
            Actions
          </button>
          <ul class="dropdown-menu">
            <a class="dropdown-item" href="#" id="edit" @click.stop="editIncident">Edit</a>
<!--            <a class="dropdown-item" href="#" id="delete" @click.stop="deleteIncident">Delete</a>-->
          </ul>
        </div>

      </h3>
    </div>
    <div class="row g-2">
      <div class="col">
        <p>Description: <b>{{ incident.description }}</b></p>
        <p>Reportdate: {{ incident.reportdate }}</p>
        <p>Reporter: {{incident.username}}</p>
        <p v-if="incident.isSolved">
          Status: <b>solved</b>
        </p>

        <p v-else>
          Status: <b>open</b>
        </p>
        <p>Tags: "dummy"</p>
        <p>Priority: "dummy"</p>
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

    const incident = ref({}); // Initial empty object
    const route = useRoute(); // Get access to the current route
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
          console.log("Data fetched:", JSON.stringify(response.data, null, 2));
        }catch (error) {
          console.error('There was an error fetching the data:', error);
        }
      }
    }, {immediate: true});

    // Computed property to check if myObject is still loading
    const isLoading = computed(() => {
      return Object.keys(incident.value).length === 0;
    });

    return {
      incident: incident,
      isLoading,
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