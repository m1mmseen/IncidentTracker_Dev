<template>
    <p>Incidents: {{incidents.length}}</p>

    <div class="card container text-start mt-2 m-3  border-1 border-dark"
         v-for="incident in incidents"
         :key="incident.incidentId"
         @click="goToDetails(incident.incidentId)">
      <div class="card-header row justify-content-between bg-light-subtle">
        <b class="col text-start">{{ incident.titel }}</b>
        <b class="col text-center ">assigned to: <span class="text-uppercase text-dark-emphasis">{{ incident.username }}</span></b>
        <span class="col text-end" v-bind="$attrs"><b>
          <p v-if="incident.isSolved">
          Status: <b>solved</b>
          </p>
          <p v-else>
          Status: <b class="badge bg-danger-subtle text-dark-emphasis">open</b>
          </p></b>
        </span>

      </div>
      <div class="card-body pt-1">
        <p class="card-text m-0 p-0">{{ incident.description }}</p>
        <p>Test</p>
        <div class="btn-group float-end">
          <button class="btn btn-outline-success" v-on:click.stop="solved">Solved</button>
          <button class="btn btn-outline-danger" v-on:click.stop="deleteIncident(incident.incidentId)" v-if="isAdmin">Delete</button>
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
  computed() {
    this.isAdmin();
  },
  methods: {
    isAdmin() {
      return localStorage.getItem('isAdmin') === 'true';
    },
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

      router.push({
        name: 'incident-details',
        params: {
          id: id
        }
      });
    },
    async deleteIncident(incidentId) {
      const config = {
        headers: {
          Authorization: `Bearer ${this.token}`
        }
      }
      try {
        await axios.delete(`/api/incident/${incidentId}`, config);
        await this.fetchIncidents();
        await alert("deleted");
      } catch (error) {
        console.error('Error occurred deleting incidents:', error)
      }
    },
    solved() {
      alert("Edited");
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
