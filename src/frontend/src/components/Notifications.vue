<script>
import {defineComponent} from 'vue'

export default defineComponent({
  name: "Notifications"
})
</script>

<template>
  <div class="container-sm shadow mt-3 p-4 border-top border-5 border-info">
  <div class="mb-3">
    <label for="exampleFormControlInput1" class="form-label">Email address</label>
    <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
  </div>
  <div class="mb-3">
    <label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
  </div>
  </div>

  <div class="container-sm shadow mt-3 p-4">

    <div class="accordion" id="Notifications">
      <div class="accordion-item">
        <h2 class="accordion-header">
          <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#PlannedFeature" aria-expanded="false" aria-controls="PlannedFeature">
            Planned Feature
            <span class="badge bg-info ms-3">NOTE!</span>
          </button>
        </h2>
        <div id="PlannedFeature" class="accordion-collapse collapse" data-bs-parent="#Notifications">
          <div class="accordion-body">
            <p>This form should be used to fast inform other users about this new incident. Actually it is just a dummy without further functions. It's planned to implement this feature later. </p>
          </div>
        </div>
      </div>
      <div class="accordion-item">
        <h2 class="accordion-header">
          <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#InternalCom" aria-expanded="false" aria-controls="InternalCom">
            Internal Communication
          </button>
        </h2>
        <div id="InternalCom" class="accordion-collapse collapse" data-bs-parent="#Notifications">
          <div class="accordion-body">
            <p>All users of the app sorted by department and or access rights. It should also be possible to send a circular email to defined departments. All employees in the selected department will then be informed automatically.</p>
          </div>
        </div>
      </div>
      <div class="accordion-item">
        <h2 class="accordion-header">
          <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#ExternalCom" aria-expanded="false" aria-controls="ExternalCom">
            External Communication
          </button>
        </h2>
        <div id="ExternalCom" class="accordion-collapse collapse" data-bs-parent="#Notifications">
          <div class="accordion-body">
           <p>Depending on the user, it may also be necessary to inform customers or suppliers, for example. An extended form should be available for this purpose, with the help of which customer or supplier data can be loaded from the corresponding database and the notification can be sent. This function should only be reserved for certain users (e.g. admin or communications manager).</p>
          </div>
        </div>
      </div>
    </div>

  </div>



</template>

<style scoped>

</style>