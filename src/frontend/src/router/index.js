import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },   {
    path: '/login',
    name: 'login',
    component: () => import(/* webpackChunkName: "about" */ '../views/LoginView.vue')
  },   {
    path: '/dashboard',
    name: 'dashboard',
    component: () => import(/* webpackChunkName: "about" */ '../views/DashboardView.vue')
  },   {
    path: '/dashboard/admin',
    name: 'admin-dashboard',
    component: () => import(/* webpackChunkName: "about" */ '../views/AdminDashboardView.vue')
  },   {
    path: '/dashboard/reporter',
    name: 'reporter-dashboard',
    component: () => import(/* webpackChunkName: "about" */ '../views/ReporterDashboardView.vue')
  },   {
    path: '/dashboard/supporter',
    name: 'supporter-dashboard',
    component: () => import(/* webpackChunkName: "about" */ '../views/SupporterDashboardView.vue')
  },   {
    path: '/incidents',
    name: 'incident-list',
    component: () => import(/* webpackChunkName: "about" */ '../views/IncidentListView.vue')
  },   {
    path: '/incidents/details/:id',
    name: 'incident-details',
    component: () => import(/* webpackChunkName: "about" */ '../views/IncidentDetailView.vue'),
    props: true
  },   {
    path: '/incidents/create',
    name: 'create-incident',
    component: () => import(/* webpackChunkName: "about" */ '../views/CreateIncidentView.vue')
  },   {
    path: '/user',
    name: 'user',
    component: () => import(/* webpackChunkName: "about" */ '../views/UserDetailsView.vue')
  },   {
    path: '/user/create',
    name: 'create-user',
    component: () => import(/* webpackChunkName: "about" */ '../views/CreateUserView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
