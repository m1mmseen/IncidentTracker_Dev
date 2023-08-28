<template>
  <div class="container-sm mt-3 border border-light-subtle rounded shadow p-4">
    <div class="row">
      <div class="col"><span class="badge bg-info-subtle text-dark">In progress</span></div>
      <h3 class="mt-3">Welcome to the Incident Tracker</h3>
    </div>
    <div class="row">
        <p class="mt-3">This is a work sample app. It shows the basic understanding on how to setup a fullstack application with database access</p>
    </div>
  </div>
  <div class="container-sm mt-3 border border-light-subtle rounded shadow p-4">
    <div class="row">
      <div class="col"><span class="badge bg-success-subtle text-dark">Techstack</span></div>
    </div>
    <div class="row mt-3">
      <div class="list-group">
        <div  class="list-group-item" aria-current="true">
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">Java Spring Boot Web</h5>
            <small><span class="badge bg-dark">Backend</span></small>
          </div>
          <p class="mb-1">REST API</p>
          <small>In MVC</small>
        </div>
        <div class="list-group-item">
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">Spring Boot Starter Security</h5>
            <small><span class="badge bg-dark">Backend</span></small>
          </div>
          <p class="mb-1">Authorisation and Authorization</p>
          <small class="text-body-secondary">incl. JWT</small>
        </div>
        <div  class="list-group-item">
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">Spring Data JPA</h5>
            <small><span class="badge bg-dark">Backend</span></small>
          </div>
          <p class="mb-1">JPA Repository Architecture</p>
          <small class="text-body-secondary"></small>
        </div>
        <div  class="list-group-item">
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">MySQL</h5>
            <small><span class="badge bg-primary">Database</span></small>
          </div>
          <p class="mb-1">No additional Securing</p>
          <small class="text-body-secondary">new features planed</small>
        </div>
        <div  class="list-group-item">
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">Vue</h5>
            <small><span class="badge bg-success">Frontend</span></small>
          </div>
          <p class="mb-1">Composition API</p>
          <small class="text-body-secondary">Advanced Fetaures planned</small>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: "Welcome"

}

</script>