<template>
  <div class="container-sm shadow mt-3 p-4 border-top border-5 border-warning">
    <form @submit.prevent="submitForm">
      <div class="mb-3">
        <label for="createIncidentFormTitel" class="form-label">Titel</label>
        <input type="text" class="form-control" id="createIncidentFormTitel" placeholder="Some suspicious event..."
               v-model="formdata.titel">
      </div>
      <div class="mb-3">
        <label for="createIncidentFormDescription" class="form-label">Description</label>
        <textarea class="form-control" id="createIncidentFormDescription" rows="3"
                  placeholder="Describe the event as detailed as possible" v-model="formdata.description"></textarea>
      </div>
        <div class="row mb-3">

          <div class="col-8">
            <label>Incident Categorie</label>
            <select class="form-select me-3">
              <option selected>choose...</option>
              <option>Maleware</option>
              <option>Phishing</option>
              <option>DDoS Attack</option>
              <option>Unauthorised Access</option>
              <option>Data Leakage</option>
              <option>Physical Breach</option>
              <option>Social Engineering</option>
            </select>
          </div>
          <div class="col-4">
            <label>Severity Level</label>
            <select class="form-select">
              <option selected>choose...</option>
              <option class="bg-danger text-white p-4">Critical (P1)</option>
              <option class="bg-danger-subtle">High (P2)</option>
              <option class="bg-warning">Medium (P3)</option>
              <option class="bg-warning-subtle">Low (P4)</option>
            </select>
          </div>
      </div>

      <button class="btn btn-warning pe-lg-4 ps-lg-4" type="submit" @click="submitForm">Report</button>
    </form>
  </div>

</template>

<script>
import axios from 'axios';
import {useAuth} from "../stores/auth.js";

const userdata = useAuth();
const userId = userdata.userId;

export default {
  name: 'IncidentTable',
  data(){
    return {
      token: userdata.token,
      formdata: {
        titel: '',
        description: '',
        reportdate: new Date()
            .toLocaleString('de-DE', {
          timeZone:'Europe/Berlin',
        }),
        isSolved: false,
        user_id: userId,
      }
    };
  },
  methods: {
    async submitForm() {
      const config = {
        headers: {
          Authorization: `Bearer ${this.token}`
        },
      };
      await axios.post('/api/incidents/create', this.formdata, config)
          .then((response) => {
            const status = response.status;
            if (status === 201) {
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