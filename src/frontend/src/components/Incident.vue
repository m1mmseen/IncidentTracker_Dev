<script setup>

</script>

<template>
  <div class="container-sm  border border-light-subtle rounded shadow p-4">
    <div class="row g-2">
      <div class="col">
        <p>Description:</p>
        <p>Reportdate:</p>
        <p>Reporter:</p>
        <p>Status:</p>
      </div>
      <div class="col">
        <div class="btn-group float-end" role="group">
          <button type="button" class="btn btn-outline-dark dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            Actions
          </button>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Edit</a></li>
            <li><a class="dropdown-item" href="#">Delete</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="row g-2">
      <div class="form-floating">
        <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"></textarea>
        <label for="floatingTextarea2">Updates</label>
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
  <div class="container-sm mt-3 border border-light-subtle rounded shadow p-4 d-flex flex-column">
    <div class="row">
      <div class="col">
        <h2>Recent Updates</h2>
      </div>
    </div>

    <div class="d-flex flex-column">
      <div class="card text-start">
        <div class="card-header">
          <strong class="float-start">User</strong>
          <strong class="float-end">2 days ago</strong>
        </div>
        <div class="card-body">
          <h5 class="card-title">Short description of update</h5>
          <p class="card-text">Explanation of Update</p>
        </div>
      </div>
      <div class="card text-start">
        <div class="card-header">
          <strong class="float-start">User</strong>
          <strong class="float-end">2 days ago</strong>
        </div>
        <div class="card-body">
          <h5 class="card-title">Short description of update</h5>
          <p class="card-text">Explanation of Update</p>
        </div>
      </div>
    </div>
  </div>

</template>

<style scoped>

</style>