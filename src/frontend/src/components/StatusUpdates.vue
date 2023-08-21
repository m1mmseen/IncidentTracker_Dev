<template>
  <div class="container-sm mt-3 border border-light-subtle rounded shadow p-4 d-flex flex-column">
    <div class="row">
      <div class="col">
        <h3>Recent Updates</h3>
      </div>
    </div>
    <div class="d-flex flex-column"
          v-for="update in updates"
          :key="update.id">
      <div class="card text-start">
        <div class="card-header">
          <strong class="float-start">User</strong>
          <strong class="float-end">2 days ago</strong>
        </div>
        <div class="card-body">
          <h5 class="card-title">{{ updates.shortDescription }}</h5>
          <p class="card-text">{{update.updateText}}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {

  name: 'updatesByIncident',
  data() {
    return {
      updates: []
    };
  },
  props: {
    incidentId: {
      type: Number,
      required: true
    }
  },
  created() {
    this.fetchUpdates();
  },
  watch: {
    updates() {
      this.fetchUpdates()
    }
  },
  methods: {
    async fetchUpdates() {
      try {
        const response = await axios.get(`/api/updates/${this.incidentId}`);
        if (response.status === 200) {
          this.updates = response.data;
        }
      }catch (e) {
        console.log("Error fetching Updates: ", e);
      }
    }
  }

}

</script>