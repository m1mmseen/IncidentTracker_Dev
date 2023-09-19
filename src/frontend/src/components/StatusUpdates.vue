<template>
  <div class="container-sm border border-light-subtle rounded shadow d-flex flex-column p-4 mt-3  mb-5">
    <h3>Recent Updates</h3>
<!--    <table class="table">
      <thead class="">
      <th scope="col">title</th>
      <th scope="col">user</th>
      <th scope="col"></th>
      <th scope="col">created</th>
      </thead>
      <tbody>
      <tr class="" v-for="update in fetchUpdates.updates"
          :key="update.id">
        <td>{{update.shortDescription}}</td>
        <td>{{update.username}}</td>
        <td>{{getDate(update.createdAt)}}</td>
      </tr>


      </tbody>
    </table>-->

    <div class="accordion" id="updates">
      <div class="accordion-item" v-for="(update, index) in fetchUpdates.updates" :key="update.id">
        <h2 class="accordion-header">
          <button class="accordion-button" type="button" data-bs-toggle="collapse" :data-bs-target="'#collapse' + index" :aria-expanded="{true : index > 0, false : index === 0}" :aria-controls="'collapse' + index">
            <div class="container">
              <div class="row">
              <div class="col">
                {{ update.shortDescription }}
              </div>
              <div class="col text-center">
                <span class="badge bg-success-subtle text-dark me-3">{{ update.username }}</span>
                <strong class="">{{getDate(update.createdAt)}}</strong>
              </div>
            </div>
            </div>
          </button>
        </h2>
        <div :id="'collapse' + index" class="accordion-collapse collapse" :class="{'show': index === 0 }" :aria-labelledby="'heading' + index" data-bs-parent="#updates">
          <div class="accordion-body bg-success-subtle">
            {{ update.updateText }}
          </div>
        </div>
      </div>
    </div>



  </div>
</template>

<script>
import {useAuth} from "../stores/auth.js";
import {store} from "../stores/test.js";
import {fetchUpdates} from "../stores/updatesStore.js";


const userData = useAuth();



export default {

  name: 'updatesByIncident',
  props: {
    incidentId: {
      type: [Number, String],
      required: true
    }
  },
  mounted() {
    fetchUpdates.fetch(this.incidentId);
    this.intervalId = setInterval(() => {
      this.fetchUpdates.fetch(this.incidentId);
    }, 60000);
  },

  beforeUnmount() {
    clearInterval(this.intervalId);
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
      token: userData.token,
      intervalId: null
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


<style scoped>
.accordion-button:not(.collapsed) {
  color: black  !important;
  background-color: white !important;
}


</style>