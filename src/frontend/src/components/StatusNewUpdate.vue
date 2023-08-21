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
      <a href="#" class="btn btn-success">Solved</a>
    </div>
    <div class="col">
      <a href="#" class="btn btn-info float-end">Update</a>
    </div>
  </div>
  </div>
</template>

<script>

import axios from "axios";

export default {
  props: {
    incidentId: {
      type: Number,
      required: true
    }
  },
  data() {
    return {
      formdata: {
        shortDescription: '',
        updateText: '',
      }
    }
  },
  methods: {
    async submitForm() {
      console.log(this.incidentId);
      const data = {
        ...this.formdata,
        incidentId: this.incidentId
      };
      await axios.post('/api/newUpdate', data)
          .then((response) => {
            const status = response.status;
            if (status === 201) {
              alert("success");
              this.formdata.shortDescription = '';
              this.formdata.updateText = '';
            }
          })
          .catch(e => {
            console.log("Error sending data: ", e);
          })
    }
  }
}

</script>