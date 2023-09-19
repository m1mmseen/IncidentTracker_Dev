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
            <select class="form-select me-3" id="category" v-model="formdata.category" @change="setCategory($event)">
              <option value="0" selected>choose...</option>
              <option v-for="option in categories" :value="option.categoryId" >
                {{option.categoryName}}
              </option>
            </select>
          </div>
          <div class="col-4">
            <label>Severity Level</label>
            <select class="form-select" id="severity" v-model="formdata.severity" @change="setSeverity($event)">
              <option value="0" selected>choose...</option>
              <option :value="severity.severityId" v-for="(severity, index) in severities"  :class="{
                'bg-danger':severity.severityId === 1,
                'bg-danger-subtle': severity.severityId === 2,
                'bg-warning': severity.severityId === 3,
                'bg-warning-subtle': severity.severityId === 4}"
              >
                {{severity.severityName}}
              </option>
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
const token = userdata.token;

const config = {
  headers: {
    Authorization: `Bearer ${token}`
  },
};

export default {
  name: 'IncidentTable',
  data(){
    return {
      categories: [],
      severities: [],
      formdata: {
        titel: '',
        description: '',
        reportdate: new Date()
            .toLocaleString('de-DE', {
          timeZone:'Europe/Berlin',
        }),
        isSolved: false,
        user_id: userId,
        category: '',
        severity: ''
      },
    };
  },
  created() {
    this.getCategories();
    this.getSeverities();
  },
  methods: {
    setCategory(event) {
      this.category = event.target.value;
      console.log("severity:" + this.severity + " _ category:" + this.category);
    },
    setSeverity(event) {
      this.severity = event.target.value;
      console.log("severity:" + this.severity + " _ category:" + this.category);
    },
    async getCategories() {
      try {
        await axios.get('/api/categories', config)
            .then((response) => {
              if (response.status === 200) {
                this.categories = response.data;
              }
            })
      } catch(e) {
        console.log("Error fetching categories: " + e);
      }
    },
    async getSeverities() {
      try {
        await axios.get('/api/severities', config)
            .then((response) => {
              if (response.status === 200) {
                this.severities = response.data;
              }
            })
      } catch(e) {
        console.log("Error fetching severities: " + e);
      }
    },

    async submitForm() {
      console.log(this.formdata);
      await axios.post('/api/incidents/create', this.formdata, config)
          .then((response) => {
            const status = response.status;
            if (status === 201) {
              alert("success");
              this.formdata.titel = '';
              this.formdata.description = '';
              this.formdata.severity = '';
              this.formdata.category = ''
            }
          })
            .catch(error => {
            console.error("An error occurred ", error)
          });
    }
  },
};

</script>


<style scoped>

</style>