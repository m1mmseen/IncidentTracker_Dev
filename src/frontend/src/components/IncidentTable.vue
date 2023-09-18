<template>
      <table class = "table table-hover">
        <thead>
        <tr>
          <th> Incident Id</th>
          <th> Incident Titel</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="incident in incidents" v-bind:key="incident.id" @click="goToDetails(incident.incidentId)">
          <td> {{incident.incidentId }}</td>
          <td> {{incident.titel }}</td>
        </tr>
        </tbody>
      </table>


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
        router.push({name: 'incident-details', params: { id: id}})
      }
    },
  };

</script>

<style scoped>
.table-hover tbody tr td,
.table-hover tbody tr th {
  background-color: transparent;
  color: initial;
  transition: background-color 0.3s , color 0.3s ;
}

.table-hover tbody tr:hover td,
.table-hover tbody tr:hover th {
  background-color: #d1e7dd;
}

</style>