<template>
  <div class="container-sm shadow mt-3 p-4 border-top border-5 border-warning">

      <form @submit.prevent="submitForm">
        <div class="mb-3">
          <label for="createIncidentFormTitel" class="form-label">Titel</label>
          <input type="text" class="form-control" id="createIncidentFormTitel" placeholder="Some suspicious event..." v-model="formdata.titel">
        </div>
        <div class="mb-3">
          <label for="createIncidentFormDescription" class="form-label">Description</label>
          <textarea class="form-control" id="createIncidentFormDescription" rows="3" placeholder="Describe the event as detailed as possible" v-model="formdata.description"></textarea>
        </div>
        <button class="btn btn-warning pe-lg-4 ps-lg-4" type="submit" >Report</button>
      </form>
  </div>

</template>

<script>
import axios from 'axios';

export default {
  name: 'IncidentTable',
  data(){
    return {
      formdata: {
        titel: '',
        description: '',
        isSolved: false,
        reportdate: new Date()
            .toLocaleString('de-DE', {
          timeZone:'Europe/Berlin',
        })
      }
    };
  },
  methods: {
    async submitForm() {
      await axios.post('/api/incidents/create', this.formdata)
          .then((response) => {
            const status = response.status;
            if (status === 200) {
              alert("success");
              this.formdata.titel = '';
              this.formdata.description = '';
            }
          })
            .catch(error => {
            console.error("An error occurred ", error)
          });

    },
  },
};

</script>


<style scoped>

</style>