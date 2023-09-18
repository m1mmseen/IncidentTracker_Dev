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
  <div class="accordion" id="accordionExample">
    <div class="accordion-item">
      <h2 class="accordion-header">

        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          More Infos about Notifications
          <span class="badge bg-info ms-3">New Feature planned</span>
        </button>

      </h2>
      <div id="collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">
        <div class="accordion-body">
          <p>This form should be used to fast inform other users about this new incident. Actually it is just a dummy without further functions. It's planned to implement this feature later. </p>
        </div>
      </div>
    </div>
  </div>

  </div>



</template>

<style scoped>

</style>