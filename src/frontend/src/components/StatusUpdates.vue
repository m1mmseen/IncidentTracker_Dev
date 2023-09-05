<template>
  <div class="container-sm mt-3 border border-light-subtle rounded shadow p-4 d-flex flex-column">
    <div class="row">

      <div class="col">
        <button class="btn btn-info float-end" @click="store.add()">Test</button>
        <h3>Recent Updates</h3>
      </div>
    </div>
    <div class="d-flex flex-column mb-3"
          v-for="update in fetchUpdates.updates"
          :key="update.id">
      <div class="card container">
        <div class="card-header row align-items-start">
          <div class="col text-start">
            <strong>{{ update.shortDescription }}</strong>
          </div>
          <div class="col text-center">
            <strong>{{ update.username }}</strong>
          </div>
          <div class="col text-end">
            <strong> {{getDate(update.createdAt)}}</strong>
          </div>
        </div>
        <div class="card-body">
          <p class="card-text">{{update.updateText}}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import {useAuth} from "../stores/auth.js";
import {store} from "../stores/test.js";
import {fetchUpdates} from "../stores/updatesStore.js";
import {useRoute} from "vue-router";

const userData = useAuth();
const route = useRoute();


export default {

  name: 'updatesByIncident',
  props: {
    incidentId: {
      type: [Number, String],
      required: true
    }
  },
  created() {
    fetchUpdates.fetch(this.incidentId);
  },
  computed: {
    fetchUpdates() {
      return fetchUpdates
    },
    store() {
      return store
    }
  },
  data() {
    return {
      token: userData.token
    };
  },


  methods: {

    getDate(unix) {
      const unixTimestamp = unix;

      const milliseconds = Date.now() ;

      const difference = milliseconds - unixTimestamp;

      const days = Math.floor(difference/1000/60/60/24)
      const hours = Math.floor(difference/1000/60/60)
      const minutes = Math.floor(difference/1000/60)
      const seconds = Math.floor(difference/1000)

      if (days === 1) {
        return days + " day ago";
      } else if (days > 0) {
        return days + " days ago";
      } else if (hours === 1) {
        return hours + " hour ago";
      } else if (hours > 1) {
        return hours + " hours ago";
      } else if (minutes === 1) {
        return minutes + " minute ago";
      } else if (minutes > 1) {
        return minutes + " minutes ago";
      } else if (seconds > 0) {
        return seconds + " seconds ago";
      }
      return "now";
    }
  }
}

</script>