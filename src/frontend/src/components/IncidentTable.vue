<template>
    <div class="container-sm p-4 mt-3 shadow">
      <h3 class="text-center">Incidents for User </h3>

      <table class = "table table-hover">
        <thead>
        <tr>
          <th> Incident Id</th>
          <th> Incident Titel</th>

        </tr>

        </thead>
        <tbody>
        <tr v-for="incident in incidents" v-bind:key="incident.id" v-on:click="goToDetails(incident.id)">
          <td> {{incident.id }}</td>
          <td> {{incident.titel }}</td>
        </tr>
        </tbody>
      </table>

    </div>
</template>

<script>
  import axios from "axios";
  import router from "../router/routes.js";


  export default {
    name: 'IncidentTable',
    data(){
      return {
        incidents: [],
      };
    },
    created() {
      this.fetchIncidents();
      },
    methods: {
      async fetchIncidents() {
        try {
          const response = await axios.get('api/incidents');
          this.incidents = response.data;
        } catch (error) {
          console.error('Error occurred fetching incidents:', error)
        }
      },
      goToDetails(id) {
        router.push({name: 'incident-details', params: { incidentId: id}})
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
  background-color: #26c97d;
  color: white;
}

</style>