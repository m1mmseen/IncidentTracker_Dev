<script setup>

import NavigationBar from "@/components/NavigationBar.vue";
import PageTitle from "@/components/PageTitle.vue";


</script>
<template>
  <NavigationBar/>
  <PageTitle msg="Incidents"/>
  <div class="container-sm">
    <h1 class="text-center">Incident List</h1>

    <table class = "table table-striped">
      <thead>
      <tr>
        <th> Incident Id</th>
        <th> Incident Titel</th>

      </tr>

      </thead>
      <tbody>
      <tr v-for="incident in incidents" v-bind:key="incident.id">
        <td> {{incident.id }}</td>
        <td> {{incident.titel }}</td>

      </tr>
      </tbody>
    </table>

  </div>
</template>
<script>
  import IncidentService from "@/services/IncidentService";

  export default {
    name: 'Incidents',
    data(){
      return {
        incidents: []
      }
    },
    methods: {
      getIncidents(){
        IncidentService.getIncidents().then((response) => {
          this.incidents = response.data;
        });
      }
    },
    created() {
      this.getIncidents();
    }
  }

</script>


