<template>
    <div class="visually-hidden bg-info z-3 position-absolute bottom-0 end-0 p-5 rounded-3 " id="info"><h1>:)</h1></div>
    <div class="card mt-2"
         v-for="incident in incidents"
         :key="incident.incidentId"
         @click="goToDetails(incident.incidentId)">
      <div class="card-header m-0 pt-1 pb-0">
        <b class="float-start"><span class="badge bg-warning-subtle text-dark me-3">{{ incident.incidentId }}</span>{{ incident.titel }}</b>
        <b class=""><span class="badge bg-warning-subtle text-dark me-3">{{ incident.user}}</span></b>
        <span class="float-end" v-bind="$attrs"><b>
          <p v-if="incident.isSolved">
          Status: <b>solved</b>
          </p>
          <p v-else>
          Status: <b>open</b>
          </p></b>
        </span>

      </div>
      <div class="card-body pt-1">
        <p class="card-text m-0 p-0">{{ incident.description }}</p>
        <p>Test</p>
        <div class="btn-group float-end">
          <button class="btn btn-outline-dark" v-on:click.stop="edit">Edit</button>
          <button class="btn btn-outline-dark" v-on:click.stop="deleteIncident(incident.id)">Delete</button>
        </div>
      </div>
    </div>
</template>

<script>
import axios from "axios";
import router from "../router/routes.js";
import {useAuth} from "../stores/auth.js";

const userdata = useAuth();

export default {
  name: 'IncidentTable',
  data(){
    return {
      token: userdata.token,
      incidents: [],
    };
  },
  created() {
    this.fetchIncidents();

  },
  methods: {
    async fetchIncidents() {
      const config = {
        headers: {
          Authorization: `Bearer ${this.token}`
        },
      };
      try {
        const response = await axios.get('api/incidents', config);
        this.incidents = response.data;
        } catch (error) {
        console.error('Error occurred fetching incidents:', error)
      }
    },
    goToDetails(id) {
      console.log(id);
      router.push({
        name: 'incident-details',
        params: {
          id: id
        }
      });
    },
    async deleteIncident(incidentId) {
      try {
        await axios.delete(`/api/incident/${incidentId}`);
        await this.fetchIncidents();
        await alert("deleted");
      } catch (error) {
        console.error('Error occurred deleting incidents:', error)
      }
    },
    edit() {
  },

  }

};

</script>

<style>
.card:hover {
  -webkit-box-shadow: 5px 5px 12px -3px #878787;
  box-shadow: 5px 5px 12px -3px #878787;
}
.card {
  transition: box-shadow .5s;
}

</style>
