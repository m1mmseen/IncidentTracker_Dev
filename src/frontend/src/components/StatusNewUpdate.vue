<template>
  <div class="container-sm mt-3 border border-light-subtle rounded shadow p-4 d-flex flex-column">
    <div class="row g-2">
      <h3>Log new Update to Incident No. {{incidentId}}</h3>
      <div class="form-floating">
        <form>
          <label for="shortDescription">Short description</label>
          <textarea class="form-control"
                    placeholder="Describe in short why you update the Incident"
                    id="shortDescription"
                    style="height: 80px"
                    v-model="formdata.shortDescription">
        </textarea>
          <label for="updateText">Updates</label>
          <textarea class="form-control"
                    placeholder="Describe in detail, what you made with incident"
                    id="updateText"
                    style="height: 100px"
                    v-model="formdata.updateText">
        </textarea>
        </form>
      </div>
    </div>
    <div class="row mt-3">

      <div class="col">
        <button class="btn btn-info float-end" @click="submitForm()">Update</button>

      </div>
    </div>
  </div>
</template>

<script>

import axios from "axios";
import {useAuth} from "../stores/auth.js";

import {store} from "../stores/test.js";
import {fetchUpdates} from "../stores/updatesStore.js";

const userData = useAuth();




export default {
  computed: {
    store() {
      return store
    }
  },
  props: {
    incidentId: {
      type: [Number, String],
      required: true
    }
  },
  data() {
    return {
      formdata: {
        shortDescription: '',
        updateText: '',
      },
      token: userData.token,
      userId: userData.userId,
      username: userData.user
    }
  },
  methods: {


    submitForm: async function () {

      const config = {
        headers: {
          Authorization: `Bearer ${this.token}`
        }
      };
      const data = {
        ...this.formdata,
        incidentId: this.incidentId,
        userId: this.userId,
        username: this.username

      };
      try {
        const response = await axios.post('/api/newUpdate', data, config);

        if (response.status === 201) {
          this.formdata.shortDescription = '';
          this.formdata.updateText = '';

          await fetchUpdates.fetch(this.incidentId);


        }
      } catch (e) {
        console.log("Error sending data: ", e);
      }
    }
  }
}

</script>