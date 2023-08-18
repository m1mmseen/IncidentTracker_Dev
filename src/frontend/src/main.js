import { createApp } from 'vue'
import App from './App.vue'
import router from './router/routes.js'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'


createApp(App).use(router).mount('#app')
